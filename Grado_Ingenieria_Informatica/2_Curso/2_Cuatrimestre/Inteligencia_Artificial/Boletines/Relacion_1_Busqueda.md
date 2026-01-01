# Inteligencia Artificial - Relación 1: Búsqueda en Espacios de Estados y Heurísticas

La Inteligencia Artificial fundamenta la resolución de problemas complejos en la definición formal de estados y la aplicación de algoritmos de búsqueda guiados por conocimiento del dominio.

## 1. Formalización de Problemas de Búsqueda
Un problema se define mediante:
- **Estado Inicial**: Punto de partida.
- **Acciones / Operadores**: Transiciones entre estados.
- **Test de Objetivo**: Condición de parada.
- **Función de Coste**: Coste $g(n)$ acumulado desde el inicio.

## 2. Algoritmos de Búsqueda
- **No Informada**: BFS (amplitud), DFS (profundidad), UCS (coste uniforme).
- **Informada**: Voraz (solo mira $h(n)$), **A*** (mira $f(n) = g(n) + h(n)$).

## 📝 Ejercicio Técnico: Trazado de A*
**Enunciado**: Dado un mapa donde el origen es S y el objetivo es G. Las distancias reales son las aristas y las heurísticas $h(n)$ son S:10, A:7, B:6, G:0. 
Aristas: (S,A)=3, (S,B)=5, (A,G)=9, (B,G)=6.
Halle el camino óptimo usando A*.

**Resolución**:
1. **Paso 1**: Expandir S.
   - Hijos: A ($f=3+7=10$), B ($f=5+6=11$).
   - Frontera: {A(10), B(11)}. Elegimos A.
2. **Paso 2**: Expandir A.
   - Hijo: G ($f=(3+9)+0=12$).
   - Frontera: {B(11), G(12)}. Elegimos B.
3. **Paso 3**: Expandir B.
   - Hijo: G ($f=(5+6)+0=11$).
   - Frontera: {G(11), G(12)}. Elegimos G(11).
**Resultado**: El camino óptimo es **S -> B -> G** con coste total 11.

---
## 📝 Ejercicio Técnico: El Problema del 8-Puzzle
Proponga dos funciones heurísticas para el 8-puzzle y analice su admisibilidad.
1. $h_1(n)$: Número de piezas mal colocadas. Es admisible porque cada pieza mal colocada requiere al menos un movimiento.
2. $h_2(n)$: Suma de las distancias de Manhattan de cada pieza a su posición objetivo. Es admisible y más informada que $h_1(n)$.
