funFibo :: (Integral a, Integral b) => b -> a
funFibo 1 = 1
funFibo 2 = 1
funFibo x = funFibo(x-1) + funFibo(x-2)


----------------------------------------------

----------------------------------------------------------
--Ejercicios comunes:
cambia_el_primero :: a -> [a] -> [a]
cambia_el_primero a [] = [a]
cambia_el_primero a (c : r) = (a : r)

cambia_el_n :: Num a => b -> a -> [b] -> [b]
cambia_el_n a 1 b = cambia_el_primero a b
cambia_el_n a n (c : r) = (c : cambia_el_n a (n-1) r) 

get_mayor_abs :: (Ord a, Num a) => [a] -> a
get_mayor_abs [] = 0
get_mayor_abs a = maximum(map abs a)

num_veces :: (Eq a, Num b) => a -> [a] -> b
num_veces a [] = 0
num_veces a (c : r) = if a == c then 1 + num_veces a r else num_veces a r

palabras_mayores_n :: [a] -> [[b]] -> [[b]]
palabras_mayores_n [] a = []
palabras_mayores_n n [] = []
palabras_mayores_n n (c : r) = if length(n) < length(c) then (c : palabras_mayores_n n r) else palabras_mayores_n n r

esPrimo 0 = False
esPrimo 1 = False
esPrimo 2 = True
esPrimo a = not (any(\y -> mod a y == 0) [2..a-1])

unico [] = []
unico (c:r) = c : (unico (filter (\y -> y /= c) r))

-- funciones nuevas_
-- fst, snd, splitAt, span, break, zip, unzip, zip3. zipWith, unzip3

-- splitAt 4 (zip [1,2,3,4,5] [6,7,8])
-- ([(1,6),(2,7),(3,8)],[])

-- break (==3) [1,2,3,4,5,6,7]
-- ([1,2],[3,4,5,6,7])