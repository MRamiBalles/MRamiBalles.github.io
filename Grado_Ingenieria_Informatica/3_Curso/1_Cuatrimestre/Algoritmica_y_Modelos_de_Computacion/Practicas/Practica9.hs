import IO
main = do
	x <- readFile "F:\\Cuarto\\MAC\\ficheroPruebas.txt"
	convertir 1 x
	
convertir 1 [] = do putStrLn ""
convertir n x = do	
	a <- hIsEOF x
	if a then return()
	else do	
		y <- hGetLine x
		putStrLn $ (n ++ ": ") ++ y
		convertir (n+1) x
	