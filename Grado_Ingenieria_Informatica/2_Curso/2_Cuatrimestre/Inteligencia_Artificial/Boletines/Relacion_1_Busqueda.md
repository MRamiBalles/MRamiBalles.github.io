# Inteligencia Artificial - Relación 1: Búsqueda en Espacios de Estados y Heurísticas

La Inteligencia Artificial fundamenta la resolución de problemas complejos en la definición formal de estados y la aplicación de algoritmos de búsqueda guiados por conocimiento del dominio.

## 1. Formalización de Problemas de Búsqueda
Un problema se define mediante:
- **Estado Inicial**: Punto de partida del agente.
- **Acciones / Operadores**: Transiciones entre estados.
- **Test de Objetivo**: Condición para finalizar la búsqueda.
- **Función de Coste**: Peso asociado a cada transición.

## 2. Búsqueda No Informada
- **Búsqueda en Anchura (BFS)**: Garantiza la solución óptima en coste uniforme. Complejidad espacial $O(b^d)$.
- **Búsqueda en Profundidad (DFS)**: Baja memoria, pero no garantiza optimalidad ni terminación en grafos infinitos.

## 3. Búsqueda Informada (Heurística)
Utiliza una función de estimación $h(n)$ para guiar la búsqueda hacia el objetivo.
- **Algoritmo A***: Minimiza $f(n) = g(n) + h(n)$. Es óptimo si $h(n)$ es admisible (nunca sobrestima el coste real).
- **Propiedades de las Heurísticas**: Una heurística es más "potente" cuanto más se aproxime al coste real sin excederlo.

## 📝 Ejercicio Técnico: El Problema del 8-Puzzle
Proponga dos funciones heurísticas para el 8-puzzle y analice su admisibilidad.
*Respuesta*:
1. $h_1(n)$: Número de piezas mal colocadas. Es admisible porque cada pieza mal colocada requiere al menos un movimiento.
2. $h_2(n)$: Suma de las distancias de Manhattan de cada pieza a su posición objetivo. Es admisible y más informada que $h_1(n)$, ya que proporciona una cota inferior más ajustada del coste real.
