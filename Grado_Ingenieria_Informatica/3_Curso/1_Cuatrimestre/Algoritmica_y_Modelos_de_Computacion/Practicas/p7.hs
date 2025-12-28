doInv = do 
	cadena <- getLine
	putStrLn cadena
	putStrLn $ unwords (map reverse (words cadena))

	
busqSec = do
	putStrLn "Piensa un numero del 1 al 100.."
	busca_numero 1 100
	putStrLn "Fin del juego!"
	
	
busca_numero a b = 
	putStrLn $ "¿Su numero es : " ++ [a] 
	respuesta <- getLine
	if respuesta == "NO" then 
		do
			if a+1 > b then
				error "Numero pensado fuera de rango.."
			else 
				busca_numero (a+1) b
	else if respuesta == "SI" then return ()
	else error "Respuesta incorrecta : SI o NO"
	
-- ghc -o nombre fich.hs
-- Para borrar pantalla cls -> Importar modulo System.Info y  System.Process -> cls = putStr "\ESC[2J"
