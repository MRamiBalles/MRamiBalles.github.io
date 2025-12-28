# FAA - Boletín 1: Complejidad y Notación Asintótica

## 🧠 Contexto Teórico
El objetivo es simplificar funciones de tiempo $T(n)$ eliminando constantes y términos de menor orden para obtener la cota asintótica.

*   **Definición de O (Cota superior):** $f(n) \le c \cdot g(n)$ para toda $n > n_0$.
*   **Ranking de crecimiento:** $1 \ll \log n \ll n \ll n \log n \ll n^2 \ll a^n \ll n!$.

## 📝 Ejercicios
1.  **Simplificación:** Halla el orden de $T(n) = 3n^2 + 10n + 5 \log n$.
    *   *Resolución:* El término dominante es $n^2$. Respuesta: $\Theta(n^2)$.
2.  **Límites:** Demuestra que $n \log n = O(n^2)$.
    *   *Resolución:* $\lim_{n \to \infty} \frac{n \log n}{n^2} = \lim_{n \to \infty} \frac{\log n}{n} = 0$. Al ser el límite 0, se cumple la cota.
3.  **Comparativa:** Determina qué algoritmo es mejor: $f(n) = 2^n$ o $g(n) = n^{100}$.
    *   *Resolución:* Aunque para valores pequeños la potencia parece mayor, la exponencial siempre ganará a largo plazo. $g(n) = O(2^n)$.
