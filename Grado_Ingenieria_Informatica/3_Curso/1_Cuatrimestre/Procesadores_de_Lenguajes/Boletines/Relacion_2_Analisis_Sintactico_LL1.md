# PL - Relación 2: Análisis Sintáctico Descendente LL(1) (Oficial UHU)

El analizador sintáctico comprueba que el flujo de tokens cumple las reglas de la gramática libre de contexto (GLC) definida para el lenguaje.

## 1. Gramáticas LL(1)
Para que una gramática sea analizable mediante un predictor descendente (sin backtracking), debe cumplir:
1. No ser ambigua.
2. No tener recursividad a la izquierda.
3. Estar factorizada por la izquierda.

## 2. Cálculo de Conjuntos Directores
- **FIRST($\alpha$)**: Terminales que pueden iniciar derivaciones de $\alpha$.
- **FOLLOW($A$)**: Terminales que pueden aparecer inmediatamente después de $A$.
- **Tabla de Análisis**: M[A, a] indica la producción a aplicar cuando el no terminal A ve el token 'a'.

## 📝 Ejercicio Técnico: Construcción de Tabla LL(1)
Dada la gramática:
1. $E \to T E'$
2. $E' \to + T E' \mid \epsilon$
3. $T \to id$

### Paso 1: Conjuntos Primeros y Siguientes
- **FIRST(E)** = {id}
- **FIRST(E')** = {+, $\epsilon$}
- **FIRST(T)** = {id}
- **FOLLOW(E)** = {$}
- **FOLLOW(E')** = {$}
- **FOLLOW(T)** = {+, $}

### Paso 2: Tabla de Análisis M
| No Terminal | `id` | `+` | `$` |
| :--- | :--- | :--- | :--- |
| **E** | $E \to T E'$ (1) | | |
| **E'** | | $E' \to + T E'$ (2) | $E' \to \epsilon$ (3) |
| **T** | $T \to id$ (4) | | |

## 3. Analizadores de Descenso Recíproco
Implementación manual mediante funciones que se llaman recursivamente siguiendo las reglas de producción. Crítico para gramáticas sencillas y rápidas.
