# FAA - Relación 1: Conceptos Básicos y Notación Asintótica (Oficial UHU)

## 🧠 Contexto Teórico (Dpto. Ingeniería de Sistemas y Automática)
El análisis asintótico permite clasificar las funciones de tiempo de ejecución en conjuntos de funciones con un crecimiento similar.

*   **Definición de $O(g(n))$**: Conjunto de funciones $f(n)$ tales que existen constantes $c > 0$ y $n_0 \ge 1$ con $f(n) \le c \cdot g(n)$ para toda $n \ge n_0$.
*   **Definición de $\Omega(g(n))$**: Cota inferior. $f(n) \ge c \cdot g(n)$.
*   **Definición de $\Theta(g(n))$**: Cota ajustada. Intersección de $O$ y $\Omega$.

## 📝 Ejercicios de la Relación
1.  **Comparación por Límites**: Determina la relación asintótica entre $f(n) = n^2 \log n$ y $g(n) = n^3$.
    *   *Resolución:* $\lim_{n \to \infty} \frac{n^2 \log n}{n^3} = \lim_{n \to \infty} \frac{\log n}{n} = 0$. Portanto, $f(n) = O(g(n))$ pero $f(n) \neq \Omega(g(n))$.
2.  **Clasificación**: Ordena de menor a mayor coste: $2^n, n!, n^3, n \log n, 10^{10}, \log n$.
    *   *Resolución:* $10^{10} \ll \log n \ll n \log n \ll n^3 \ll 2^n \ll n!$.
3.  **Propiedades**: Demuestra que si $f(n) = O(g(n))$ y $g(n) = O(h(n))$, entonces $f(n) = O(h(n))$. (Transitividad).
    *   *Resolución:* Por definición, $f(n) \le c_1 g(n)$ y $g(n) \le c_2 h(n)$. Sustituyendo, $f(n) \le (c_1 c_2) h(n)$. Se cumple con $c = c_1 c_2$.
