-- Practica 4: Orden Superior Avanzado
-- Objetivos: Currificación, composición, lambdas, zipWith.

module Practica4 where

-- 4.1. Currificación: Entender que f x y = (f x) y
sumaTres :: Int -> Int -> Int -> Int
sumaTres x y z = x + y + z

-- sumaDos = sumaTres 1 (Aplicación parcial)

-- 4.2. Función zipWith: Combinar dos listas con una operación
 -- miZipWith (+) [1,2] [3,4] => [4,6]
miZipWith :: (a -> b -> c) -> [a] -> [b] -> [c]
miZipWith _ [] _ = []
miZipWith _ _ [] = []
miZipWith f (x:xs) (y:ys) = f x y : miZipWith f xs ys

-- 4.3. Producto escalar usando zipWith y sum
productoEscalar :: [Int] -> [Int] -> Int
productoEscalar xs ys = sum (zipWith (*) xs ys)

-- 4.4. Expresiones Lambda y Composición (.)
-- Elevar al cuadrado los pares mayores que 10
procesarLista :: [Int] -> [Int]
procesarLista xs = map (\x -> x^2) (filter (>10) (filter even xs))

-- Usando composición (.)
procesarListaComp :: [Int] -> [Int]
procesarListaComp = map (^2) . filter (>10) . filter even

-- 4.5. Plegado a la izquierda (foldl)
-- Invertir lista usando foldl
invertirFold :: [a] -> [a]
invertirFold = foldl (\acc x -> x : acc) []
