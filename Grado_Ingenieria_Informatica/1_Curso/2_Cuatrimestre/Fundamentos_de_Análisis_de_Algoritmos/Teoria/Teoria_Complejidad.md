# Fundamentos de Análisis de Algoritmos (FAA) - Teoría de Complejidad

Este documento sirve como base teórica maestra para el análisis de algoritmos, fundamental para la Mención en Computación.

## 1. Notación Asintótica
Para medir la eficiencia de un algoritmo, nos enfocamos en el crecimiento del tiempo de ejecución respecto al tamaño de la entrada ($n$).

*   **O Grande (Cota Superior)**: $f(n) = O(g(n))$ si el tiempo no crece más rápido que $g(n)$.
*   **Omega (Cota Inferior)**: $f(n) = \Omega(g(n))$ si el tiempo crece al menos tan rápido que $g(n)$.
*   **Theta (Cota Ajustada)**: $f(n) = \Theta(g(n))$ si el tiempo crece exactamente como $g(n)$.

### Jerarquía de Complejidad (de mejor a peor)
1.  **Constante**: $O(1)$
2.  **Logarítmica**: $O(\log n)$
3.  **Lineal**: $O(n)$
4.  **Cuasi-lineal**: $O(n \log n)$ (Ej: Mergesort, Quicksort promedio)
5.  **Cuadrática**: $O(n^2)$ (Ej: Bubble sort, Selection sort)
6.  **Cúbica**: $O(n^3)$
7.  **Exponencial**: $O(2^n)$
8.  **Factorial**: $O(n!)$

## 2. Análisis de Recursividad: Teorema Maestro
Para recurrencias de la forma $T(n) = aT(n/b) + f(n)$, comparamos $f(n)$ con $n^{\log_b a}$.

| Caso | Relación | Resultado $T(n)$ |
| :--- | :--- | :--- |
| **Caso 1** | $f(n) < n^{\log_b a}$ | $\Theta(n^{\log_b a})$ |
| **Caso 2** | $f(n) = n^{\log_b a}$ | $\Theta(n^{\log_b a} \log n)$ |
| **Caso 3** | $f(n) > n^{\log_b a}$ | $\Theta(f(n))$ |

## 3. Técnicas de Diseño
*   **Divide y Vencerás**: Dividir el problema en subproblemas menores, resolverlos y combinar (Ej: Mergesort).
*   **Algoritmos Ávidos (Greedy)**: Tomar la mejor decisión local en cada paso con la esperanza de llegar al óptimo global.
*   **Programación Dinámica**: Almacenar resultados de subproblemas ya resueltos para evitar cálculos redundantes.

---
> [!IMPORTANT]
> En la UHU, el análisis de bucles anidados suele requerir el cálculo de sumatorios para obtener la cota exacta. No te limites solo a la inspección visual.
