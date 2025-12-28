sumar n = foldr (+) 0 [0..n]

--Main> (\x y -> 2*x + y) 1 (foldr (\x y -> 2*x + y) 4 (2:3:[]))
--16
--Main>  foldr1 (/) [2,4]
--0.5
--Main>  foldl1 (/) [2,4]
--0.5
--Main>  foldl1 (/) [2,4, 8]
--0.0625
--Main>  foldr1 (/) [2,4, 8]
--4.0
--Main>  scanl1 (-) [2,3]
--[2,-1] :: Integer
--Main>  scanr1 (-) [2,3]
--[-1,3] :: Integer

-- Ejercicios : 
--devolver [a] = if a>=50 && a<=100 [10, 20 ..]

--takeWhile(80>) (reverse (drop 5 (take (10) [10,20..])))


------------------------------------------------

--filter any (\y -> mod x y == 0) [1..100] 

--cambia_primero :: Integer a -> [a] -> [a]
cambia_primero a [] = [a]
cambia_primero a [c : r] = [a : r]