# FAA - Relación 3: Análisis de Algoritmos Recursivos (Oficial UHU)

## 🧠 Contexto Teórico (Ecuaciones de Recurrencia)
Un algoritmo recursivo expresa su tiempo de ejecución en función de llamadas a tamaños menores.

*   **Teorema Maestro**: $T(n) = aT(n/b) + f(n)$.
    1.  Si $f(n) < n^{\log_b a} \implies T(n) = \Theta(n^{\log_b a})$.
    2.  Si $f(n) = n^{\log_b a} \implies T(n) = \Theta(n^{\log_b a} \log n)$.
    3.  Si $f(n) > n^{\log_b a} \implies T(n) = \Theta(f(n))$.

## 📝 Ejercicios de la Relación
1.  **Aplicación Directa**: Resuelve $T(n) = 4T(n/2) + n$.
    *   *Resolución:* $a=4, b=2, n^{\log_2 4} = n^2$. Como $n < n^2$ (Caso 1), $T(n) = \Theta(n^2)$.
2.  **Recurrencia Lineal (Sustitución)**: Resuelve $T(n) = T(n-1) + n$, $T(1)=1$.
    *   *Resolución:* Es la suma de los $n$ primeros naturales. $T(n) = n + (n-1) + ... + 1 = \frac{n(n+1)}{2}$. $\Theta(n^2)$.
3.  **Búsqueda Binaria**: Analiza $T(n) = T(n/2) + c$.
    *   *Resolución:* $a=1, b=2, n^{\log_2 1} = n^0 = 1$. Como $f(n)=c=\Theta(1)$, estamos en el Caso 2. $T(n) = \Theta(n^0 \log n) = \Theta(\log n)$.
