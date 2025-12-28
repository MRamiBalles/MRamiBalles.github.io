# ED I - Relación 1: Análisis de Algoritmos y Recursividad (Oficial UHU)

## 🧠 Contexto Teórico
Fundamentos matemáticos para evaluar la eficiencia de las estructuras de datos.

*   **Análisis Asintótico**: Uso de la notación $O$ para el peor caso en operaciones de inserción, borrado y búsqueda.
*   **Recursividad**: Definición de un problema en términos de versiones más pequeñas de sí mismo.
*   **Backtracking**: Técnica de búsqueda exhaustiva que explora todas las posibilidades retirando pasos fallidos.

## 📝 Ejercicios de la Relación
1.  **Recursivo vs Iterativo**: Implementa el cálculo del factorial de ambas formas y analiza su coste.
    *   *Resolución:* Ambos son $\Theta(n)$. Sin embargo, el recursivo consume $O(n)$ de memoria en la pila de llamadas, frente al $O(1)$ del iterativo.
2.  **Análisis de TAD**: Calcula el coste de buscar un elemento en una lista enlazada no ordenada.
    *   *Resolución:* En el peor caso hay que recorrer los $n$ elementos. Coste: $\Theta(n)$.
3.  **Torres de Hanoi**: Resuelve la recurrencia $T(n) = 2T(n-1) + 1$.
    *   *Resolución:* Por sustitución, $T(n) = 2^n - 1$. Coste exponencial $\Theta(2^n)$.
