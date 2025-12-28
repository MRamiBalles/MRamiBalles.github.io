funFibo :: (Integral a, Integral b) => b -> a
funFibo 1 = 1
funFibo 2 = 1
funFibo x = funFibo(x-1) + funFibo(x-2)


----------------------------------------------

-- esPrimo :: Integral a => a -> Bool
-- esPrimo x = if any (\y -> mod x y == 0) [2..x - 1] then False else True-- 
-- esPrimo :: Integral a => a -> Bool
-- esPrimo x = all (\y -> mod x y /= 0) [2..x - 1] show True-- 

----------------------------------------------------------
--Ejercicios comunes:
cambia_el_primero :: a -> [a] -> [a]
cambia_el_primero a [] = [a]
cambia_el_primero a (c : r) = (a : r)

cambia_el_n :: Num a => b -> a -> [b] -> [b]
cambia_el_n a 1 b = cambia_el_primero a b
cambia_el_n a n (c : r)  -- = all (\y -> n >= length y) (c : cambia_el_n a (n-1) r) 
			| n > length (c : r) = error "El índice está fuera del rango."
			| otherwise = all (\y -> n >= length y) (c : cambia_el_n a (n-1) r)

get_mayor_abs :: (Ord a, Num a) => [a] -> a
get_mayor_abs [] = 0
get_mayor_abs a = maximum(map abs a)

-- num_veces :: (Eq a, Num b) => a -> [a] -> b
-- num_veces a [] = 0
-- num_veces a (c : r) = if a == c then 1 + num_veces a r else num_veces a r
num_veces :: (Eq a, Num b) => a -> [a] -> b
num_veces a xs = sum $ map (\x -> 1) $ filter (\x -> x == a) xs


palabras_mayores_n :: [a] -> [[b]] -> [[b]]
palabras_mayores_n [] a = []
palabras_mayores_n n [] = []
palabras_mayores_n n (c : r) = if length(n) < length(c) then (c : palabras_mayores_n n r) else palabras_mayores_n n r