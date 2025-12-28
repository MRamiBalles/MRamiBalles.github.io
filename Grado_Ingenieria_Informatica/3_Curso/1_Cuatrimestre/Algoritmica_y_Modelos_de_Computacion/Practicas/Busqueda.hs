module Busqueda 
( busqueda_secuencial
, busqueda_binaria
, busqueda_interpolacion
) where

busqueda_secuencial :: Int -> Int -> IO ()
busqueda_secuencial a b = do
	putStrLn $ "¿Su numero es : " ++ show a ++ "?"
	res <- getLine
	if res == "NO" then 
		do
			if a+1 > b then do
				putStrLn $ "Numero pensado fuera de rango.. Pruebe a jugar de nuevo.."
			else 
				busqueda_secuencial (a+1) b
	else if res == "SI" then do 
		putStrLn "¡Numero acertado!"
		putStrLn ""
	else do 
		putStrLn "Respuesta incorrecta : SI o NO"
		putStrLn ""
		busqueda_secuencial a b
	
busqueda_binaria :: Int -> Int -> IO ()
busqueda_binaria a b = do
	let media = div (a + b) 2
	putStrLn $ "¿Su numero es : " ++ show media ++ "?"
	respuesta <- getLine
	if respuesta == "NO" then 
		do
			putStrLn $ "¿Su numero es mayor que " ++ show media ++ "?"
			res <- getLine
			if res == "SI" then
				busqueda_binaria (media + 1) b
			else if res == "NO" then
				busqueda_binaria a (media - 1) 
			else do 
				putStrLn "La respuesta debe ser: SI o NO"
				busqueda_binaria a b
	else if respuesta == "SI" then do
		putStrLn "¡Numero acertado!" 
		putStrLn ""
	else do 
		putStrLn $ "Respuesta incorrecta : SI o NO"
		putStrLn ""
		busqueda_binaria a b
		
busqueda_interpolacion :: Int -> Int -> IO ()
busqueda_interpolacion a b = do
	let media = div (a + b) 2
	putStrLn $ "¿Su numero es : " ++ show media ++ "?"
	respuesta <- getLine
	if respuesta == "NO" then do
			putStrLn $ "¿Su numero es mayor que " ++ show media ++ "?"
			res <- getLine
			if res == "SI" then do
					putStrLn "Indique del 1 al 5 como de cercano esta su numero : "
					putStrLn "1 si es cercano al pensado y 5 si esta muy alejado entre los mayores" 
					res2 <- getLine
					let res2Int = read res2 :: Int
					if res2Int < 6 && res2Int > 0 then do
							--let media2 = div (media + 1 + b) 2
							let ri = (media + 1) + (div (b - media) 5) * (res2Int - 1)
							if res2Int == 5 then do
									putStrLn $ "Interpolando entre " ++ show ri ++ " y " ++ show b
									busqueda_interpolacion ri b
							else do
									let rd = (media + 1) + (div (b - media) 5) * res2Int
									putStrLn $ "Interpolando entre " ++ show ri ++ " y " ++ show rd
									busqueda_interpolacion ri rd
					else do
							putStrLn "¡Rango incorrecto! Entre 1 y 5.."
							busqueda_interpolacion (media + 1) b
			else if res == "NO" then do
					putStrLn "Indique del 1 al 5 como de cercano esta su numero : "
					putStrLn "1 si es cercano al pensado y 5 si esta muy alejado entre los menores"
					res2 <- getLine
					let res2Int = read res2 :: Int
					if res2Int < 6 && res2Int > 0 then do
							let rd = a + (div (media - a) 5) * (6 - res2Int)
							if res2Int == 5 then do
									putStrLn $ "Interpolando entre " ++ show a ++ " y " ++ show rd
									busqueda_interpolacion a rd
							else do
									let ri = a + (div (media - a) 5) * (5 - res2Int)
									putStrLn $ "Interpolando entre " ++ show ri ++ " y " ++ show rd
									busqueda_interpolacion ri rd
					else do
							putStrLn "¡Rango incorrecto! Entre 1 y 5.."
							busqueda_interpolacion a (media - 1)
			else do 
					putStrLn "La respuesta debe ser: SI o NO"
					busqueda_interpolacion a b
	else if respuesta == "SI" then do
			putStrLn "¡Numero acertado!" 
			putStrLn ""
	else do 
			putStrLn "Respuesta incorrecta : SI o NO"
			putStrLn ""
			busqueda_interpolacion a b