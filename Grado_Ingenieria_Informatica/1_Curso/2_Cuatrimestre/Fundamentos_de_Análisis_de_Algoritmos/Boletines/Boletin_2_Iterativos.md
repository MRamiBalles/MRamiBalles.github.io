# FAA - Boletín 2: Análisis de Bucles (Iterativos)

## 🧠 Contexto Teórico
El análisis de bucles se basa en resolver sumatorios ($\sum$). 

*   **Regla del Producto:** Bucles anidados independientes multiplican sus iteraciones.
*   **Regla de la Suma:** Bloques secuenciales se suman (domina el mayor).

## 📝 Ejercicios
1.  **Bucle Lineal:**
    ```cpp
    for (int i = 0; i < n; i += 2) { ... }
    ```
    *   *Resolución:* El bucle hace $n/2$ pasos. $\Theta(n)$.
2.  **Bucle de Cuarto de Vuelta:**
    ```cpp
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= i; j++)
            operacion();
    ```
    *   *Resolución:* $\sum_{i=1}^{n} \sum_{j=1}^{i} 1 = \sum_{i=1}^{n} i = \frac{n(n+1)}{2}$. $\Theta(n^2)$.
3.  **Bucle Logarítmico:**
    ```cpp
    for (int i = n; i > 1; i /= 3) { ... }
    ```
    *   *Resolución:* Dividimos entre 3 sucesivamente hasta llegar a 1. $\log_3 n$ iteraciones. $\Theta(\log n)$.
