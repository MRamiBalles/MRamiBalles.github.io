# FAA - Relación 2: Análisis de Algoritmos Iterativos (Oficial UHU)

## 🧠 ¿Cuánto tarda este bucle?
En los exámenes de la UHU les encanta poner bucles raros. La regla de oro es: si es un bucle simple, es el número de vueltas. Si están anidados, multiplicas.

*   **Secuencia**: Es una suma ($T_1 + T_2$). No pierdas tiempo, quédate con el más gordo.
*   **If-Then-Else**: Quédate con la rama que más tarde. Siempre nos ponemos en lo peor (Peor Caso).

## 📝 Ejercicios de la Relación
1.  **El bucle tonto**: Recorrer un array de cabo a rabo.
    *   Damos $n$ vueltas haciendo una operación constante. Pues $\Theta(n)$. Sin misterios.
2.  **Bucles dependientes**: 
    ```cpp
    for (int i=0; i<n; i++)
        for (int j=0; j<i; j++) // Ojo aquí, j depende de i
            count++;
    ```
    *   *Truco*: Esto es la mitad de un cuadrado. Es la suma $1+2+3 \dots + n = \frac{n(n+1)}{2}$. Por tanto, $\Theta(n^2)$.
3.  **El que divide**: `while (i > 0) { i /= 2; }`
    *   Esto es logarítmico. Siempre que el avance sea multiplicando o dividiendo, el coste es $\log n$.
