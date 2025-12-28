# Mat II - Boletín 2: Teoría de Grafos

## 🧠 Contexto Teórico
Modelado de relaciones entre objetos.

*   **Grafo Conexo:** Hay un camino entre cualquier par de vértices.
*   **Grado de un vértice:** Número de aristas que inciden en él.
*   **Handshaking Lemma:** $\sum deg(v) = 2|E|$.

## 📝 Ejercicios
1.  **Existencia:** ¿Existe un grafo con 5 vértices de grados {1, 2, 3, 4, 5}?
    *   *Resolución:* No. La suma de grados debe ser par. $1+2+3+4+5=15$ (impar).
2.  **Árboles:** Un árbol tiene 10 vértices. ¿Cuántas aristas tiene?
    *   *Resolución:* En un árbol, $|E| = |V| - 1$. Por tanto, 9 aristas.
3.  **Dijkstra:** ¿Se puede usar Dijkstra con pesos negativos?
    *   *Resolución:* No, porque es un algoritmo ávido y podría no encontrar la ruta mínima al "cerrar" nodos prematuramente. Se usaría Bellman-Ford.
