# Matemáticas II: Matemática Discreta (Resumen ETSI)

*Apuntes sobre lógica, grafos y algoritmos discretos para computación.*

## 1. Lógica Matemática
Es la base conceptual de la programación y la inteligencia artificial.

### 1.1. Lógica Proposicional
*   **Conectivas:** $\neg, \wedge, \vee, \implies, \iff$.
*   **Tablas de Verdad:** Sirven para comprobar si una fórmula es una *Tautología* (siempre 1), *Contradicción* (siempre 0) o *Contingencia*.

### 1.2. Lógica de Predicados
Introduce los cuantificadores:
*   **Universal ($\forall$):** "Para todo".
*   **Existencial ($\exists$):** "Existe al menos uno".

## 2. Teoría de Grafos
Fundamentales para redes, bases de datos y algoritmos de búsqueda.

*   **Grafo $G = (V, E)$:** Conjunto de vértices y aristas.
*   **Caminos Mínimos:** Algoritmo de **Dijkstra** (pesos positivos).
*   **Árboles de Expansión Mínima:** Algoritmos de **Prim** y **Kruskal**.
*   **Conectividad:** Componentes conexas y grafos fuertemente conexos.

## 3. Combinatoria y Recurrencias
*   **Principio del Palomar:** Si tienes más palomas que huecos, al menos un hueco tiene dos palomas.
*   **Recurrencias Lineales:** Resolución de ecuaciones tipo Fibonacci.

---
> [!TIP]
> **Dijkstra:** Es un algoritmo "ávido" (Greedy). En cada paso, elige el nodo no visitado con la distancia más corta acumulada.
