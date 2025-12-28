# FAA - Boletín 4: Algoritmos de Ordenación

## 🧠 Contexto Teórico
El análisis empírico y teórico de cómo organizar datos.

*   **Estabilidad:** Un algoritmo es estable si mantiene el orden relativo de elementos iguales.
*   **In-place:** Si usa una cantidad constante de memoria extra $O(1)$.
*   **Divide y Vencerás:** Mergesort (división perfecta) vs Quicksort (depende del pivote).

## 📝 Ejercicios
1.  **Traza de Mergesort:** Ordena $\{5, 2, 8, 1\}$.
    *   *Resolución:* Dividir $\{5,2\}$ y $\{8,1\}$. Luego $\{5\},\{2\}$ y $\{8\},\{1\}$. Fusionar $\{2,5\}$ y $\{1,8\}$. Fusionar final $\{1,2,5,8\}$.
2.  **Peor Caso Quicksort:** ¿Cuándo ocurre $\Theta(n^2)$?
    *   *Resolución:* Cuando el array ya está ordenado (o en orden inverso) y elegimos siempre el primer o último elemento como pivote. El árbol se vuelve lineal.
3.  **Comparativa:** ¿Por qué Mergesort es mejor para listas enlazadas que Quicksort?
    *   *Resolución:* Mergesort accede de forma secuencial, lo cual es ideal para punteros. Quicksort requiere acceso aleatorio para las particiones.
