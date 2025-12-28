# FAA - Boletín 3: Análisis de Recurrencias (Recursivos)

## 🧠 Contexto Teórico
Se analizan algoritmos que se llaman a sí mismos.

*   **Teorema Maestro:** $T(n) = aT(n/b) + f(n)$. Atajo para casos estándar.
*   **Método de Sustitución:** Hipótesis e inducción.
*   **Árbol de Recurrencia:** Visualización de la división del trabajo.

## 📝 Ejercicios
1.  **Teorema Maestro:** $T(n) = 8T(n/2) + n^2$.
    *   *Resolución:* $a=8, b=2 \implies a = 2^3$. Valor crítico $n^3$. Como $n^2 < n^3$, estamos en el **Caso 1**. Resultado: $\Theta(n^3)$.
2.  **Sustitución:** $T(n) = T(n-1) + 1$, con $T(0)=0$.
    *   *Resolución:* Desplegando: $1 + 1 + ... + 1$ (n veces). $\Theta(n)$.
3.  **Árbol de Recurrencia:** $T(n) = 2T(n/2) + n$ (Mergesort).
    *   *Resolución:* En cada nivel hay trabajo $n$. Hay $\log n$ niveles. $n \cdot \log n$. $\Theta(n \log n)$.
