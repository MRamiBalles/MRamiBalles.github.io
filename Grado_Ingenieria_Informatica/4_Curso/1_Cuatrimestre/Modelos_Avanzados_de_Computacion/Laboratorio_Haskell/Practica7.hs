-- Practica 7: Entrada/Salida (Mónada IO)
-- Objetivos: do notation, getLine, putStrLn.

module Practica7 where

import System.IO

-- 7.1. Saludo simple
saludo :: IO ()
saludo = do
    putStrLn "Hola, ¿cómo te llamas?"
    nombre <- getLine
    putStrLn ("Encantado de conocerte, " ++ nombre)

-- 7.2. Lectura de números (conversión String -> Int)
sumaDosNumeros :: IO ()
sumaDosNumeros = do
    putStrLn "Introduce el primer número:"
    n1Str <- getLine
    putStrLn "Introduce el segundo número:"
    n2Str <- getLine
    let n1 = read n1Str :: Int
    let n2 = read n2Str :: Int
    putStrLn ("La suma es: " ++ show (n1 + n2))

-- 7.3. Menú interactivo (Recursividad en IO)
menu :: IO ()
menu = do
    putStrLn "\n--- MENU ---"
    putStrLn "1. Opción A"
    putStrLn "2. Opción B"
    putStrLn "0. Salir"
    opcion <- getLine
    case opcion of
        "1" -> do
            putStrLn "Elegiste A"
            menu -- Llamada recursiva
        "2" -> do
            putStrLn "Elegiste B"
            menu
        "0" -> putStrLn "Adiós!"
        _   -> do
            putStrLn "Opción inválida"
            menu

-- 7.4. Leer archivo (básico)
leerArchivo :: FilePath -> IO ()
leerArchivo path = do
    contenido <- readFile path
    putStrLn "Contenido del archivo:"
    putStrLn contenido
