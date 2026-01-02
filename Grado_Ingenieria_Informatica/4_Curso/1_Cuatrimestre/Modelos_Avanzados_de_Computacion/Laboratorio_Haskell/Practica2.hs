-- Practica 2: Definiciones y Recursividad
-- Objetivos: Patrones, Guardas, Recursividad pura.

module Practica2 where

-- 2.1. Fibonacci (versión recursiva ineficiente pero didáctica)
fib :: Int -> Int
fib 0 = 0
fib 1 = 1
fib n = fib (n-1) + fib (n-2)

-- 2.2. Longitud de una lista (implementación propia de length)
miLength :: [a] -> Int
miLength [] = 0
miLength (_:xs) = 1 + miLength xs

-- 2.3. Máximo de una lista (con guardas y patrones)
miMax :: (Ord a) => [a] -> a
miMax [] = error "Lista vacía"
miMax [x] = x
miMax (x:xs)
    | x > maxResto = x
    | otherwise = maxResto
    where maxResto = miMax xs

-- 2.4. Invertir una lista (reverse)
miReverse :: [a] -> [a]
miReverse [] = []
miReverse (x:xs) = miReverse xs ++ [x]
-- Nota: Esta implementación es O(n^2), poco eficiente, pero ilustrativa.

-- 2.5. Insertar ordenado (para Insertion Sort)
insertar :: (Ord a) => a -> [a] -> [a]
insertar x [] = [x]
insertar x (y:ys)
    | x <= y    = x : y : ys
    | otherwise = y : insertar x ys

-- 2.6. Ordenación por inserción
insertionSort :: (Ord a) => [a] -> [a]
insertionSort [] = []
insertionSort (x:xs) = insertar x (insertionSort xs)
