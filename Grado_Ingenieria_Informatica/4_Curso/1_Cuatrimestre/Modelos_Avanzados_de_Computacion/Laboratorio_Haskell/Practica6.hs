-- Practica 6: Clases de Tipos (Typeclasses)
-- Objetivos: Implementar instancias de Eq y Show.

module Practica6 where

import Practica5 (Arbol(..)) -- Importamos nuestra definición de Árbol

-- 6.1. Definición de un tipo Cesta
data Cesta = Manzana | Pera | Platano
-- No derivamos Eq ni Show para implementarlos a mano

-- 6.2. Instancia de Eq (Igualdad)
instance Eq Cesta where
    Manzana == Manzana = True
    Pera == Pera = True
    Platano == Platano = True
    _ == _ = False

-- 6.3. Instancia de Show (Representación textual)
instance Show Cesta where
    show Manzana = "🍎"
    show Pera = "🍐"
    show Platano = "🍌"

-- 6.4. Clase propia: Medible (cosas que tienen tamaño)
class Medible a where
    tamano :: a -> Int

instance Medible [a] where
    tamano = length

instance Medible (Arbol a) where
    tamano Vacio = 0
    tamano (Nodo _ izq der) = 1 + tamano izq + tamano der

-- 6.5. Probando polimorfismo ad-hoc
-- sumaTamanos :: (Medible a, Medible b) => a -> b -> Int
sumaTamanos x y = tamano x + tamano y
