module Main 
( main
) where

import Busqueda
import Auxiliar
import System.Info
import System.Process

main :: IO()
main = do
	putStrLn ""
	putStrLn "Alumno : Manuel Ramirez Ballesteros"
	putStrLn "-------------------------------------"
	putStrLn ""
	putStrLn "Piensa un numero.."
	putStrLn ".."
	putStrLn ".."
	putStrLn "¿Entre que numeros lo pensaste?"
	putStrLn "Limite inferior  = "
	li <- getLine
	let a = read li :: Int
	putStrLn "Limite superior  = "
	ls <- getLine
	let b = read ls :: Int
	if a > b then do
			putStrLn "Rango incorrecto: Limite inferior mayor que el superior"
			main
	else if a == b then do 
			putStrLn "¿Solo escogio un numero? Pongalo mas dificil.."
			main
	else do
			putStrLn "-------------------------------------"
			putStrLn ""
			putStrLn "Escoja el tipo de busqueda : "
			putStrLn "1 - Busqueda secuencial"
			putStrLn "2 - Busqueda binaria"
			putStrLn "3 - Busqueda por interpolacion"
			putStrLn "4 - Salir"
			t <- getLine
			putStrLn ""
			case t of	
				"1" -> do
					busqueda_secuencial a
					cls
					main
				"2" -> do
					busqueda_binaria a
					cls
					main
				"3" -> do
					busqueda_interpolacion a
					cls
					main
				"4" -> do 
					putStrLn "¡Fin del juego!"
					putStrLn ""
					return ()
				_ -> do
					putStrLn "Opcion no disponible.."
					main
		
	-- ghc -o nombre fich.hs
	-- Para borrar pantalla cls -> Importar modulo System.Info y  System.Process -> cls = putStr "\ESC[J"
	-- :q para salir de ghci
	-- Procedimiento : Abrir directorio con ficheros, ghci, :l main, menu