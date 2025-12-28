{-# LANGUAGE OverloadedStrings #-}
module EscrowWithCollateral where

import Language.Marlowe.Core.V1.Semantics.Types.Address (testnet)
import Language.Marlowe.Extended.V1
import qualified Plutus.V1.Ledger.Address as P
import qualified Plutus.V1.Ledger.Credential as P

main :: IO ()
main = printJSON escrowC

-- We can set explicitRefunds True to run Close refund analysis
-- but we get a shorter contract if we set it to False
explicitRefunds :: Bool
explicitRefunds = False

seller, buyer, burnAddress, arbitro :: Party
arbitro = Role "Arbitro"
buyer = Role "Buyer"
seller = Role "Seller"
burnAddress = Address testnet (P.Address (P.PubKeyCredential "0000000000000000000000000000000000000000000000000000000000000000") Nothing)

price, collateral :: Value
price = ConstantParam "Price"
collateral = ConstantParam "Collateral amount"

sellerCollateralTimeout, buyerCollateralTimeout, depositTimeout, disputeTimeout, answerTimeout, answerArbitroTimeout :: Timeout
answerArbitroTimeout = TimeParam "Tiempo maximo para el arbitraje"
sellerCollateralTimeout = TimeParam "Collateral deposit by seller timeout"
buyerCollateralTimeout = TimeParam "Deposit of collateral by buyer timeout"
depositTimeout = TimeParam "Deposit of price by buyer timeout"
disputeTimeout = TimeParam "Dispute by buyer timeout"
answerTimeout = TimeParam "Complaint deadline"

depositCollateral :: Party -> Timeout -> Contract -> Contract -> Contract
depositCollateral party timeout timeoutContinuation continuation =
    When [Case (Deposit party party ada collateral) continuation]
         timeout
         timeoutContinuation

burnCollateral :: Party -> Contract
burnCollateral party = Pay party (Party burnAddress) ada collateral Close

burnCollaterals :: Contract -> Contract
burnCollaterals =
    Pay seller (Party burnAddress) ada collateral
    . Pay buyer (Party burnAddress) ada collateral

deposit :: Timeout -> Contract -> Contract -> Contract
deposit timeout timeoutContinuation continuation =
    When [Case (Deposit seller buyer ada price) continuation]
         timeout
         timeoutContinuation

choice :: ChoiceName -> Party -> Integer -> Contract -> Case
choice choiceName chooser choiceValue = Case (Choice (ChoiceId choiceName chooser)
                                                     [Bound choiceValue choiceValue])

choices :: Timeout -> Party -> Contract -> [(Integer, ChoiceName, Contract)] -> Contract
choices timeout chooser timeoutContinuation list =
    When [choice choiceName chooser choiceValue continuation
          | (choiceValue, choiceName, continuation) <- list]
         timeout
         timeoutContinuation

sellerToBuyer :: Contract -> Contract
sellerToBuyer = Pay seller (Account buyer) ada price

refundSellerCollateral :: Contract -> Contract
refundSellerCollateral
  | explicitRefunds = Pay seller (Party seller) ada collateral
  | otherwise = id

refundBuyerCollateral :: Contract -> Contract
refundBuyerCollateral
  | explicitRefunds = Pay buyer (Party buyer) ada collateral
  | otherwise = id

refundCollaterals :: Contract -> Contract
refundCollaterals = refundSellerCollateral . refundBuyerCollateral

refundBuyer :: Contract
refundBuyer
 | explicitRefunds = Pay buyer (Party buyer) ada price Close
 | otherwise = Close

refundSeller :: Contract
refundSeller
 | explicitRefunds = Pay seller (Party seller) ada price Close
 | otherwise = Close

escrowC :: Contract
escrowC = depositCollateral seller sellerCollateralTimeout Close $
           depositCollateral buyer buyerCollateralTimeout (refundSellerCollateral Close) $
           deposit depositTimeout (refundCollaterals Close) $
           choices disputeTimeout buyer (refundCollaterals refundSeller)
              [ (0, "Everything is alright"
                , refundCollaterals refundSeller
                )
              , (1, "Report problem"
                , sellerToBuyer $
                  choices answerTimeout seller (refundCollaterals refundBuyer)
                     [ (1, "Confirm problem"
                       , refundCollaterals refundBuyer
                       )
                     , (0, "Dispute problem"
                       , choices answerArbitroTimeout arbitro (burnCollaterals refundBuyer)
                           [ (1, "Resolver la disputa en favor del comprador"
                             , burnCollateral seller
                             )
                           , (2, "Resolver la disputa en favor del vendedor"
                             , burnCollateral buyer
                             )
                           ]
                       )
                     ]
                )
              ]
  where
    arbitratorChoice = ChoiceValue (ChoiceId "Eleccion del arbitro" arbitro)
----------------------------------------------------------------------------------------------------------------------------------------
-- Swap 
{-# LANGUAGE OverloadedStrings #-}
module Intercambio where

import Language.Marlowe.Extended.V1

main :: IO ()
main = printJSON intercambio

-- Puedes establecer explicitRefunds en True para ejecutar el analisis de reembolso con Close,
-- pero obtenemos un contrato mas corto si lo establecemos en False.
explicitRefunds :: Bool
explicitRefunds = False

lovelacePorAda, cantidadDeAda, cantidadDeLovelace, cantidadDeDollars :: Value
lovelacePorAda = Constant 1000000
cantidadDeAda = ConstantParam "Cantidad de Ada"
cantidadDeLovelace = MulValue lovelacePorAda cantidadDeAda
cantidadDeDollars = ConstantParam "Cantidad de dolares"

tiempoFinDepositoAda, tiempoFinDepositoDollars :: Timeout
tiempoFinDepositoAda = TimeParam "Tiempo maximo para el deposito de Ada"
tiempoFinDepositoDollars = TimeParam "Tiempo maximo para el deposito de dolares"

dolares :: Token
dolares = Token "85bb65" "dolares"

data SwapParty = SwapParty { participante :: Party, moneda :: Token, cantidad :: Value }

proveedorAda, proveedordolares :: SwapParty
proveedorAda = SwapParty { participante = Role "Proveedor de Ada", moneda = ada, cantidad = cantidadDeLovelace }
proveedordolares = SwapParty { participante = Role "Proveedor de dolares", moneda = dolares, cantidad = cantidadDeDollars }

--cantidadDeAdaInsuficiente = ConstantParam "Cantidad de Ada Insuficiente"
--cantidadDeDollarsInsuficiente = ConstantParam "Cantidad de dolares Insuficiente"

realizarDepositoADA :: SwapParty -> Timeout -> Contract -> Contract -> Contract
realizarDepositoADA origen timeout continuation timeoutContinuation =
  When [ Case (Deposit (participante origen) (participante origen) (moneda origen) (cantidad origen))
              continuation
       ] timeout
         timeoutContinuation

realizarDepositoDollars :: SwapParty -> Timeout -> Contract -> Contract -> Contract
realizarDepositoDollars origen timeout continuation timeoutContinuation =
  When [ Case (Deposit (participante origen) (participante origen) (moneda origen) (cantidad origen))
              (If (ValueGE (cantidad origen) (Constant 10))
                  continuation
                  (reembolsarParticipante origen))
       ] timeout
         timeoutContinuation


reembolsarParticipante :: SwapParty -> Contract
reembolsarParticipante swapParty
  | explicitRefunds = Pay (participante swapParty) (Party (participante swapParty)) (moneda swapParty) (cantidad swapParty) Close
  | otherwise = Close

realizarPago :: SwapParty -> SwapParty  -> Contract -> Contract
realizarPago origen destino =
  Pay (participante origen) (Party $ participante destino) (moneda origen) (cantidad origen)

intercambio :: Contract
intercambio = realizarDepositoADA proveedorAda tiempoFinDepositoAda (
                    realizarDepositoDollars proveedordolares tiempoFinDepositoDollars (
                    realizarPago proveedorAda proveedordolares
                    (realizarPago proveedordolares proveedorAda
                    (reembolsarParticipante proveedorAda))) Close) Close


---------------------------------------------------------------------
	
{-# LANGUAGE OverloadedStrings #-}
module ZeroCouponBond where

import Language.Marlowe.Extended.V1

main :: IO ()
main = printJSON zcb

precioDescontado, precioNominal, aumentoDePrecio :: Value
precioDescontado = ConstantParam "Cantidad"
aumentoDePrecio = ConstantParam "Aumento de Precio"
precioNominal = AddValue (ConstantParam "Interes") $ MulValue precioDescontado aumentoDePrecio  -- Aumento aplicado al precio nominal

inversor, deudor :: Party
inversor = Role "Prestamista"
deudor = Role "Deudor"

intercambioInicial, tiempoFinIntercambio :: Timeout
intercambioInicial = TimeParam "Fecha limite del prestamo"
tiempoFinIntercambio = TimeParam "Fecha limite de devolucion"

transferir :: Timeout -> Party -> Party -> Value -> Contract -> Contract
transferir tiempoFin de a cantidad continuacion =
    When [ Case (Deposit de de ada cantidad)
                (Pay de (Party a) ada cantidad continuacion) ]  -- Precio incrementado
         tiempoFin
         Close

elecciones :: Timeout -> Party -> [(ChoiceId, [Bound], Contract)] -> Contract
elecciones tiempoFin participante elec =
    When (map (\(cId, b, cont) -> Case (Choice cId b) cont) elec) tiempoFin Close

zcb :: Contract
zcb = transferir intercambioInicial inversor deudor precioDescontado
         $ elecciones tiempoFinIntercambio inversor
           [ (ChoiceId "continuar" inversor, [Bound 0 1], 
              transferir tiempoFinIntercambio deudor inversor precioNominal Close)
           , (ChoiceId "Rechazar" inversor, [Bound 0 1],
              transferir tiempoFinIntercambio deudor inversor precioDescontado  Close)
           ]
-----------------------------------------------------------------------------------
{-# LANGUAGE OverloadedStrings #-}
module ZeroCouponBond where

import Language.Marlowe.Extended.V1

main :: IO ()
main = printJSON zcb

precioDescontado, precioNominal, aumentoDePrecio :: Value
precioDescontado = ConstantParam "Cantidad"
aumentoDePrecio = ConstantParam "Aumento de Precio"
precioNominal = AddValue (ConstantParam "Interes") $ MulValue precioDescontado aumentoDePrecio  -- Aumento aplicado

inversor, deudor :: Party
inversor = Role "Prestamista"
deudor = Role "Deudor"

intercambioInicial, tiempoFinIntercambio :: Timeout
intercambioInicial = TimeParam "Fecha limite del prestamo"
tiempoFinIntercambio = TimeParam "Fecha limite de devolucion"

transferir :: Timeout -> Party -> Party -> Value -> Contract -> Contract
transferir tiempoFin de a cantidad continuacion =
    When [ Case (Deposit de de ada cantidad)
                (Pay de (Party a) ada cantidad continuacion) ]
         tiempoFin
         Close

zcb :: Contract
zcb = transferir intercambioInicial inversor deudor precioDescontado 
         (When [ Case (Choice (ChoiceId "1 para Continuar, 0 para Rechazar" inversor) [Bound 0 1])
                (If (ValueEQ (ChoiceValue (ChoiceId "1 para Continuar, 0 para Rechazar" inversor)) (Constant 1))
                    (transferir tiempoFinIntercambio deudor inversor precioNominal Close)
                    (transferir tiempoFinIntercambio deudor inversor precioDescontado Close)) ]
            tiempoFinIntercambio Close)

-------------------------------------------------------------------------------

{-# LANGUAGE OverloadedStrings #-}
module Prueba where

import Language.Marlowe.Extended.V1

main :: IO ()
main = printJSON example

valor :: Value
valor = ConstantParam "Euros"

participante1, participante2 :: Party
participante1 = Role "Comprador"
participante2 = Role "Vendedor"

tiempoFin :: Timeout
tiempoFin = TimeParam "Fin del tiempo para pagar"

pago :: Timeout -> Party -> Party -> Value -> Contract -> Contract 
pago tf p1 p2 v cont =
    When [Case (Deposit p1 p1 ada v)
         (Pay p1 (Party p2) ada v cont)
         ] tf
         Close

example :: Contract
example = pago tiempoFin participante1 participante2 valor Close
