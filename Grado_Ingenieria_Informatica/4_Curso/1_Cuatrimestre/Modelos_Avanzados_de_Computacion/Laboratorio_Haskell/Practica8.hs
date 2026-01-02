-- Practica 8: Functor y Aplicativo
-- Objetivos: fmap, <*>, instancias para tipos propios.

module Practica8 where

-- 8.1. Functor: fmap (aplicar función dentro del contexto)
-- fmap (+1) (Just 5) => Just 6
-- fmap (+1) Nothing  => Nothing
-- fmap (+1) [1,2,3]  => [2,3,4]

data Caja a = Caja a deriving Show

instance Functor Caja where
    fmap f (Caja x) = Caja (f x)

ejemploCaja :: Caja Int
ejemploCaja = fmap (*2) (Caja 21) -- Caja 42

-- 8.2. Applicative: <*> (aplicar función en contexto a valor en contexto)
-- Just (+1) <*> Just 5 => Just 6
-- [(+1), (*2)] <*> [1,2] => [2,3, 2,4]

instance Applicative Caja where
    pure = Caja
    (Caja f) <*> (Caja x) = Caja (f x)

ejemploApp :: Caja Int
ejemploApp = pure (+) <*> Caja 3 <*> Caja 5 -- Caja 8

-- 8.3. Uso práctico: validación simple
-- Si tenemos Maybe String y queremos concatenarlos solo si ambos existen
concatenar :: Maybe String -> Maybe String -> Maybe String
concatenar m1 m2 = (++) <$> m1 <*> m2
