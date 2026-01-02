-- Practica 9: Introducción a Mónadas
-- Objetivos: bind (>>=), return, notación do.

module Practica9 where

-- 9.1. La Mónada Maybe (Computaciones que pueden fallar)
divisionSegura :: Float -> Float -> Maybe Float
divisionSegura _ 0 = Nothing
divisionSegura x y = Just (x / y)

operacionCadena :: Float -> Maybe Float
operacionCadena x = do
    r1 <- divisionSegura x 2
    r2 <- divisionSegura r1 0 -- Esto fallará y propagará Nothing
    return (r2 + 1)

-- Versión con >>= (bind)
operacionBind :: Float -> Maybe Float
operacionBind x = divisionSegura x 2 >>= \r1 ->
                  divisionSegura r1 0 >>= \r2 ->
                  return (r2 + 1)


-- 9.2. La Mónada Lista (No determinismo)
-- Generar todos los pares posibles (x,y) donde x+y sea par
paresSumanPar :: [Int] -> [Int] -> [(Int, Int)]
paresSumanPar xs ys = do
    x <- xs
    y <- ys
    if even (x+y) then return (x,y) else []

-- 9.3. Simulación de Estado (State Monad - simplificado conceptualmente)
-- Encadenar operaciones que pasan un "log" implícito
type Log a = (a, String)

sumarConLog :: Int -> Int -> Log Int
sumarConLog x y = (x + y, "Sumado " ++ show x ++ " con " ++ show y ++ ". ")

multConLog :: Int -> Int -> Log Int
multConLog x y = (x * y, "Multiplicado " ++ show x ++ " por " ++ show y ++ ". ")

-- Nota: Para usar la mónada State real necesitaríamos 'import Control.Monad.State'
