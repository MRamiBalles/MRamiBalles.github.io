-- PRACTICA 2 

-- Problema 1 : Combinacional

factorialConIf :: (Num a, Ord a) => a -> a
factorialConIf n = 
		if n < 0 then error "No se calculan factoriales negativos"
		else if n == 0 then 1
			 else n*factorialConIf(n-1)
				
factorialConGuardas :: (Num a, Ord a) => a -> a			
factorialConGuardas n
			| n == 0 = 1
			| n < 0 = error "No se calculan factoriales negativos"
			| otherwise = n*factorialConGuardas(n-1)

factorialConCase :: (Num a, Ord a) => a -> a
factorialConCase n = case n of
		0 -> 1
		_ | n < 0 -> error "No se calculan factoriales negativos"
		  | otherwise -> n*factorialConCase (n-1)

nsobrek :: Integral a => a -> a -> a
nsobrek n k = div (factorialConIf n) (factorialConGuardas k * factorialConCase(n-k))

nsobrekConWhere :: Integral a => a -> a -> a
nsobrekConWhere n k = combinatorio
		where combinatorio =  div (factorialConGuardas n) (factorialConIf k * factorialConCase(n-k))


-- Problema 2 : Raices de a*x^2 + b*x + c = 0
discriminante :: Floating a => a -> a -> a -> a
discriminante a b c = b**2 - 4*a*c

raicesConGuardas :: (Ord a, Floating a) => a -> a -> a -> [a]
raicesConGuardas a b c 
		| a == 0 = error "Division por cero"
		| discriminante a b c < 0 = error "Solucion no real : Discriminante negativo"
		| otherwise = [positivo, negativo]
				where positivo = (-b + sqrt(discriminante a b c)) / (2*a)
				      negativo = (-b - sqrt(discriminante a b c)) / (2*a)
					  
raicesConIf :: (Ord a, Floating a) => a -> a -> a -> [a]		
raicesConIf a b c = 
		if a == 0 then error "Division por cero"
		else if discriminante a b c < 0 then error "Solucion no real : Discriminante negativo"
		else [(-b + sqrt (discriminante a b c)) / (2*a), (-b - sqrt (discriminante a b c)) / (2*a)]
		


--Ejercicio 3 : Fibonacci
fibonacci :: (Num a, Num b) => b -> a
fibonacci 0 = 1
fibonacci 1 = 1
fibonacci x = fibonacci (x-1) + fibonacci (x-2)

fibonacciConCaseYGuardas :: (Num a, Num b, Ord b) => b -> a
fibonacciConCaseYGuardas x = case x of
		0 -> 1
		1 -> 1
		_ | x < 0 -> error "La funcion solo admite numeros positivos"
		  | otherwise -> fibonacciConCaseYGuardas(x-1) + fibonacciConCaseYGuardas(x-2)

fibonacciConIf :: (Num a, Num b, Ord b) => b -> a
fibonacciConIf x = 
		if x == 1 || x == 0 then 1
		else if x < 0 then error "La funcion solo admite numeros positivos"
		else fibonacciConIf(x-1) + fibonacciConIf(x-2)
		
		
--Ejercicio 4 : Pertenece
pertenece :: Eq a => a -> [a] -> Bool
pertenece _ [] = False
pertenece a (c:r) = a == c || pertenece a r

perteneceConIf :: Eq a => a -> [a] -> Bool
perteneceConIf _ [] = False
perteneceConIf a (c : r) = 
		if a == c then True
		else perteneceConIf a r

perteneceConCaseYGuardas :: Eq a => a -> [a] -> Bool
perteneceConCaseYGuardas a b = case b of
		[] -> False
		(c:r) | c == a -> True
		      | otherwise -> perteneceConCaseYGuardas a r


--                     Problemas Escogidos : 
-- Problema 251 : Trillizos de Cardano
-- sonTrillizos :: (Integral a, Integral b, Integral c) => a -> c -> b -> Bool
-- sonTrillizos a b c = ((fromIntegral a) + (fromIntegral b) * sqrt(fromIntegral c)) ** (1/3) + ((fromIntegral a) - (fromIntegral b) * sqrt(fromIntegral c)) ** (1/3) == 1
-- Abandono este problema porque Haskell no sabe calcular raíces cúbicas de números negativos..........	
  
--cantidadTrillizos n = length (filter (\a b c -> a+b+c <= n && sonTrillizos a b c)) [1..n]


-- Problema 104 : Final pandigital en Fibonacci

digitos :: Int -> [Int]
digitos n =
		if n < 10 then [n]
		else digitos (div n 10) ++ [mod n 10]

comparaCreciente [_] = True
comparaCreciente (c1:c2:r) = c1 <= c2 && comparaCreciente (c2:r)

comparaDecreciente [_] = True
comparaDecreciente (c1:c2:r) = c1 >= c2 && comparaDecreciente (c2:r)
	
esRebotanteIf n = 
		if length(digitos n) < 3 then False
		else not (comparaCreciente (digitos n) || comparaDecreciente (digitos n))

esRebotanteGuardas n 
		| n < 100 = False
		| otherwise = not (comparaCreciente (digitos n) || comparaDecreciente (digitos n))

porcentajeRebotantes n = if n < 100 then 0
		else (fromIntegral rebotantes/fromIntegral n) * 100
			where rebotantes = length(filter esRebotanteIf [1..n])

porcentajeRebotantesGuardas n
		| n < 100 = 0
		| otherwise = (fromIntegral rebotantes/fromIntegral n) * 100
			where rebotantes = length(filter esRebotanteGuardas [1..n])

--Problema 612 : Numeros amigos

-- Función para comprobar si dos números son amigos
sonAmigos :: Int -> Int -> Bool
sonAmigos a b = any (`elem` (digitos a)) (digitos b)

-- Función para generar todos los pares de números (p, q) con 1 <= p < q < n
paresIf :: (Ord a, Num a, Enum a) => a -> [(a,a)]
paresIf n = 
		if n <= 2 then error "No hay pares suficientes"
		else [(p, q) | p <- [1..n-1], q <- [p+1..n-1]]
		
paresGuardas :: (Num a, Ord a) => a -> [(a,a)]
paresGuardas n 
		| n <= 2 = error "No hay pares suficientes"
		| otherwise = generarPares 1
			where 
			generarPares a
				| a >= n-1 = []
				| otherwise = generarPares2 a (a+1)
			generarPares2 a b
				| b >= n = generarPares (a+1)
				| otherwise = (a,b) : generarPares2 a (b+1)
	
paresIf2 n = 
		if n <= 2 then error "No hay pares suficientes"
		else generarPares 1
			where 
			generarPares a =
				if a >= n-1 then []
				else generarPares2 a (a+1)
			generarPares2 a b =
				if b >= n then generarPares (a+1)
				else (a,b) : generarPares2 a (b+1)	

-- Función cantidadAmigos(n)
cantidadAmigos :: Int -> Int
cantidadAmigos n = length (filter (\(p, q) -> sonAmigos p q) (paresGuardas n))



--Problema 46 : Conjetura de Goldbach
getPrimos :: Integral a => a -> [a]
getPrimos n = filter (\y -> null (filter (\x -> mod y x == 0) [2..(div y 2)])) [2..n]

getCuadrados :: Int -> [Int]
getCuadrados n = [1..floor(sqrt(fromIntegral(div n 2)))]

conjeturaGoldbach :: Int -> [Int]
conjeturaGoldbach minimo = filter (\n -> not (any (\primo -> elem (n - primo) (map (\x -> 2*x^2) (getCuadrados n))) (getPrimos n))) [minimo,minimo+2..]

--conjGoldbach minimo = filter (\n -> not (any (\primo -> (n - primo) `elem` map (\x -> 2*x^2) [1..floor(sqrt(fromIntegral n))]) (getPrimos n))) [minimo,minimo+2..]
--5777