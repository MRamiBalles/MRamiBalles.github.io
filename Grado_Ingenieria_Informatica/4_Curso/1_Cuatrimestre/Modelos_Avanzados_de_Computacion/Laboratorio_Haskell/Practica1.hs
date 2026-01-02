-- Practica 1: Introducción a Haskell
-- Objetivos: Estructuras básicas, Listas por comprensión, Tuplas.

module Practica1 where

-- 1.1. Función que calcula el área de un círculo
areaCirculo :: Float -> Float
areaCirculo r = pi * r^2

-- 1.2. Función que determina si un año es bisiesto
bisiesto :: Int -> Bool
bisiesto x = (x `mod` 4 == 0 && x `mod` 100 /= 0) || (x `mod` 400 == 0)

-- 1.3. Listas por comprensión: Cuadrados de los primeros n números pares
cuadradosPares :: Int -> [Int]
cuadradosPares n = [x^2 | x <- [0..n*2], even x]

-- 1.4. Tuplas: Función que devuelve cociente y resto (sin usar divMod)
cocienteResto :: Int -> Int -> (Int, Int)
cocienteResto x y = (x `div` y, x `mod` y)

-- 1.5. Manipulación de listas: Obtener los elementos en posiciones impares
posicionesImpares :: [a] -> [a]
posicionesImpares [] = []
posicionesImpares [_] = []
posicionesImpares (x:y:zs) = y : posicionesImpares zs

-- 1.6. Cálculo de combinaciones (n sobre k) usando factoriales
factorial :: Integer -> Integer
factorial 0 = 1
factorial n = n * factorial (n-1)

combinaciones :: Integer -> Integer -> Integer
combinaciones n k = factorial n `div` (factorial k * factorial (n-k))
