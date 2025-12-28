# FAA - Relación 2: Análisis de Algoritmos Iterativos (Oficial UHU)

## 🧠 Contexto Teórico (Análisis de Bucles)
El coste de un algoritmo iterativo se obtiene sumando las operaciones elementales de cada instrucción.

*   **Regla de la secuencia**: $T(S_1; S_2) = T(S_1) + T(S_2)$.
*   **Regla de la selección**: $T(\text{if } B \text{ then } S_1 \text{ else } S_2) = T(B) + \max(T(S_1), T(S_2))$.
*   **Regla de la iteración**: $\sum_{i=1}^{n} \text{coste}(Cuerpo)$.

## 📝 Ejercicios de la Relación
1.  **Suma de Naturales**: Analiza el coste de un bucle que suma los elementos de un array de tamaño n.
    *   *Resolución:* $\sum_{i=0}^{n-1} c = c \cdot n = \Theta(n)$.
2.  **Bucles Anidados Independientes**:
    ```cpp
    for (int i=0; i < n; i++)
        for (int j=0; j < m; j++)
            count++;
    ```
    *   *Resolución:* $\sum_{i=0}^{n-1} \sum_{j=0}^{m-1} 1 = n \cdot m$. Si $n=m$, $\Theta(n^2)$.
3.  **Bucle con Paso Logarítmico**:
    ```cpp
    int i = n;
    while (i > 0) {
        // O(1)
        i = i / 2;
    }
    ```
    *   *Resolución:* El número de iteraciones es la potencia $k$ tal que $2^k \approx n$. Es decir, $k = \log_2 n$. Resultado $\Theta(\log n)$.
