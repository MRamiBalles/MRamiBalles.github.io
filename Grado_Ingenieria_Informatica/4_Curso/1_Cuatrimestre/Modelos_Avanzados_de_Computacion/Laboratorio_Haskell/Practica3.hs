-- Practica 3: Recursividad y Listas (Orden Superior)
-- Objetivos: map, filter, foldr, foldl.

module Practica3 where

-- 3.1. Implementación propia de map
miMap :: (a -> b) -> [a] -> [b]
miMap _ [] = []
miMap f (x:xs) = f x : miMap f xs

-- 3.2. Implementación propia de filter
miFilter :: (a -> Bool) -> [a] -> [a]
miFilter _ [] = []
miFilter p (x:xs)
    | p x       = x : miFilter p xs
    | otherwise = miFilter p xs

-- 3.3. Suma de cuadrados de impares (usando map y filter)
sumaCuadImpares :: [Int] -> Int
sumaCuadImpares xs = sum (map (^2) (filter odd xs))

-- 3.4. Plegado (Fold): Implementar producto de una lista
productoLista :: [Int] -> Int
productoLista = foldr (*) 1

-- 3.5. Any y All usando foldr
miAny :: (a -> Bool) -> [a] -> Bool
miAny p = foldr (\x acc -> p x || acc) False

miAll :: (a -> Bool) -> [a] -> Bool
miAll p = foldr (\x acc -> p x && acc) True

-- 3.6. Criba de Erastótenes (Primos infinitos)
primos :: [Int]
primos = criba [2..]
    where criba (p:xs) = p : criba [x | x <- xs, x `mod` p /= 0]

-- Obtener los primeros n primos: take n primos
