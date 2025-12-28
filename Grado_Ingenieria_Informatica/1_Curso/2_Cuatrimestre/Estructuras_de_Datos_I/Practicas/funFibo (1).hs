funFibo :: (Integral a, Integral b) => b -> a
funFibo 1 = 1
funFibo 2 = 1
funFibo x = funFibo(x-1) + funFibo(x-2)


----------------------------------------------



----------------------------------------------------------------------
--Ejercicios comunes:
cambia_el_primero :: a -> [a] -> [a]
cambia_el_primero a [] = [a]
-- cambia_el_primero a (c : r) = (a : r)
cambia_el_primero a b = a : drop 1 b



cambia_el_n :: a -> Int -> [a] -> [a]
cambia_el_n a 0 b = b
cambia_el_n a n [] = [a]
cambia_el_n a 1 b = cambia_el_primero a b
cambia_el_n a n b = init (take (n) b) ++ [a] ++ drop n b
-- Descartes :
-- cambia_el_n a n b = init b ++ [c]
-- cambia_el_n a n (c : r) = (c : cambia_el_n a (n-1) r) 



get_mayor_abs :: (Ord a, Num a) => [a] -> a
get_mayor_abs [] = 0
get_mayor_abs a = maximum(map abs a)




num_veces :: Eq a => a -> [a] -> Int
num_veces a [] = 0
num_veces a b = length (filter (==a) b)
--num_veces a (c : r) = if a == c then 1 + num_veces a r else num_veces a r




palabras_mayores_n :: Int -> [[a]] -> [[a]]
palabras_mayores_n n [] = []
palabras_mayores_n n b = filter (\x -> length x > n) b
----------------------------------------------------------------------------

-- getPrimos x = if any (\y -> mod x y == 0) [2..x - 1] then False else True
esPrimo :: Integral a => a -> Bool
esPrimo 0 = False
esPrimo 1 = False
esPrimo 2 = True
esPrimo x = any (\y -> mod x y /= 0) [2..x-1] --Preguntar rango x/2
--esPrimo x = not (any (\y -> mod x y == 0) [2..x-1])

-- getPrimos [] = []
-- getPrimos (c : r) = 

ordenada :: Ord a => [a] -> Bool
ordenada [] = True
ordenada [a] = True
ordenada (x:y:xs) = (x <= y) && ordenada (y:xs)



inserta_ordenado a [] = [a]
inserta_ordenado a (c : r) = 
-- filter (min a c) (c:r) ++ a ++ drop (length (filter (min a c) (c:r))) (c:r) -- min a c : inserta_ordenado (max a c) r)
