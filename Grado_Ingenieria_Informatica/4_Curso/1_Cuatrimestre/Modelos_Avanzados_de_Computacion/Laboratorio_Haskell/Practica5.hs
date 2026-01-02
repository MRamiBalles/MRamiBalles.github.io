-- Practica 5: Tipos de Datos Algebraicos
-- Objetivos: data, polimorfismo, Árboles.

module Practica5 where

-- 5.1. Definición de tipos enumerados
data Dia = Lunes | Martes | Miercoles | Jueves | Viernes | Sabado | Domingo
    deriving (Show, Eq, Ord)

esFinde :: Dia -> Bool
esFinde Sabado = True
esFinde Domingo = True
esFinde _ = False

-- 5.2. Tipos recursivos: Árbol Binario de Búsqueda (BST)
data Arbol a = Vacio | Nodo a (Arbol a) (Arbol a)
    deriving (Show, Eq)

-- 5.3. Insertar e un Árbol (manteniendo propiedad de orden)
insertarArbol :: (Ord a) => a -> Arbol a -> Arbol a
insertarArbol x Vacio = Nodo x Vacio Vacio
insertarArbol x (Nodo raiz izq der)
    | x == raiz = Nodo raiz izq der -- No duplicados
    | x < raiz  = Nodo raiz (insertarArbol x izq) der
    | otherwise = Nodo raiz izq (insertarArbol x der)

-- 5.4. Convertir lista a árbol
crearArbol :: (Ord a) => [a] -> Arbol a
crearArbol = foldr insertarArbol Vacio

-- 5.5. Recorridos
enOrden :: Arbol a -> [a]
enOrden Vacio = []
enOrden (Nodo x izq der) = enOrden izq ++ [x] ++ enOrden der

-- 5.6. Tipos con registro (Records)
data Persona = Persona {
    nombre :: String,
    edad :: Int,
    telefono :: String
} deriving (Show)

cumpleanos :: Persona -> Persona
cumpleanos p = p { edad = edad p + 1 }
