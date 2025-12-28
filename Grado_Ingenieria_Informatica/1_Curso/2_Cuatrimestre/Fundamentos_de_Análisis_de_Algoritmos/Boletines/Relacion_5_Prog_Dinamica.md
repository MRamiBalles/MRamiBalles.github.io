# FAA - Relación 5: Programación Dinámica (Oficial UHU)

## 🧠 De qué va esto
Si Greedy falla o no es óptimo, tiramos de Dinámica. La clave es: "No calcules dos veces lo mismo". Guardamos resultados en una tabla.

*   **Principio de Optimalidad de Bellman**: Una solución óptima contiene subsoluciones óptimas.
*   **Bottom-up**: Empezamos por los casos base y rellenamos la tabla hacia arriba.

## 📝 Ejercicios Típicos
1.  **Mochila (0/1)**: El mismo de antes, pero NO puedes partir los objetos. O los coges o no.
    *   *La tabla (V[i][j])*: 
        - Filas: Objetos.
        - Columnas: Capacidad de la mochila (de 0 a W).
    *   *Fórmula que hay que saberse*: $V[i][j] = \max(V[i-1][j], \text{valor}[i] + V[i-1][j-\text{peso}[i]])$.
    *   Básicamente: "Mejor me quedo como estaba (arriba) o meto el nuevo objeto y le sumo lo que podía meter con el hueco que queda".

2.  **Cambio de monedas (Mínimo)**: Para que sea siempre óptimo.
    *   *Ecuación*: $C[v] = 1 + \min(C[v - \text{moneda}_i])$.
    *   Rellenas un array de 0 hasta el valor deseado. El último elemento es tu respuesta. Es mucho más lento que el Greedy pero este no falla nunca.

3.  **Multiplicación de Matrices**: Hallar el orden de paréntesis que minimiza las operaciones.
    *   *Tip para el examen*: La tabla es triangular. Rellena las diagonales poco a poco. Es un coñazo de calcular a mano, así que no te equivoques con las sumas.
