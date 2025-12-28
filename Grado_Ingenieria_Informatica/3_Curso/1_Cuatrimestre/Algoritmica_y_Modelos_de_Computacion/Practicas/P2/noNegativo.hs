noNegativo::(Num a, Ord a) => a -> Bool
noNegativo x = x >= 0

noNegativo2 :: Integer -> Bool
noNegativo2 x = x >= 0

negate :: (Num a) => a -> a
negate x = (-x)

negate2 :: Integer -> Integer
negate2 x = (-x)

suma x y = x + y

--Main> suma 2.0 3.0
--5.0
--Main> suma 2.0 3.2
--5.2
--Main> suma(mod 5 3) 1
--3

iguales :: Eq a => a -> a -> a-> Bool
iguales x y z = x == y && y == z

divide :: Fractional a => a -> a -> a
divide x y = x / y

--identidad :: a -> a
--identidad :: (Num a) => a -> a
--identidad x = x
--suma2 :: Num a => a -> a -> a -> a 
--suma2 1 y z = 1 + y + z
--Main> suma2 2 2 3 
--Program error: pattern match failure: suma2 instNum_v32 2 (Num_fromInt instNum_v32 2) (Num_fromInt instNum_v32 3)
--Main> suma2 1 2 3 
--6


--Main> maxBound ::Integer
--ERROR - Cannot infer instance
-- Instance   : Bounded Integer
-- Expression : maxBound
--Main> maxBound ::Int
--2147483647


--Main> :info **
--infixr 8 **
--(**) :: Floating a => a -> a -> a  -- class member

Main> :info not
not :: Bool -> Bool

Main> :info ^^
infixr 8 ^^
(^^) :: (Fractional a, Integral b) => a -> b -> a