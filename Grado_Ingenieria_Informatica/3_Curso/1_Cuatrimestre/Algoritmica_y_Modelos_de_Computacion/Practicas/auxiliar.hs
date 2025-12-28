module Auxiliar
( cls
, quicksort
, convertirVector
) where

cls :: IO()
cls = putStr "\ESC[H"

quicksort :: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort [x] = [x]
quicksort (c : r) = quicksort (filter (\y -> y <= c) r) 
					++ [c] 
					++ quicksort (filter (\y -> y > c) r)
	
convertirVector :: String -> [Int]
convertirVector = convertirElem . dropWhile (== ' ')

convertirElem :: String -> [Int]
convertirElem "" = []
convertirElem x = 
	case reads (takeWhile (/= ' ') x) of
		[(c, r)] -> c : convertirElem(dropWhile (== ' ') r)
		_ 	-> []