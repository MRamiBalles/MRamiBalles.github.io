busqueda_interpolacion :: Double -> Double -> Double -> IO ()
busqueda_interpolacion x low high = do
    putStrLn $ "Buscando " ++ show x ++ " en el rango [" ++ show low ++ ", " ++ show high ++ "]"
    busquedaInterpolacionRec x low high

busquedaInterpolacionRec :: Double -> Double -> Double -> IO ()
busquedaInterpolacionRec x low high
    | low > high = putStrLn "Elemento no encontrado."
    | otherwise = do
        let interpolation = low + ((x - low) / (high - low)) * (high - low)
        let estimation = floor interpolation
        putStrLn $ "Estimación actual: " ++ show estimation

        if fromIntegral estimation == x
            then putStrLn $ "Elemento " ++ show x ++ " encontrado en la posición " ++ show estimation ++ "."
            else if fromIntegral estimation < x
                then busquedaInterpolacionRec x (fromIntegral (estimation + 1)) high
                else busquedaInterpolacionRec x low (fromIntegral (estimation - 1))

main :: IO ()
main = do
    putStrLn "Ingresa el número que deseas buscar:"
    input <- getLine
    let numberToSearch = read input :: Double
    busqueda_interpolacion numberToSearch 1 100
