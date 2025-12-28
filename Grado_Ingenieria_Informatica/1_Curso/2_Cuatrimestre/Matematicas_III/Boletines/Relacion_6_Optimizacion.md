# Mat III - Relación 6: Optimización y Programación Matemática (Oficial UHU)

## 🧠 El final del camino
Busca los valores que maximizan beneficios o minimizan costes en ingeniería.

*   **Programación Lineal**: El método del **Símplex** (aunque en la UHU a veces basta con el método gráfico para 2 variables).
*   **Región Factible**: Zona donde se cumplen todas las restricciones (inecuaciones).
*   **Solución Óptima**: Siempre está en un **vértice** de la región factible.

## 📝 Ejercicios de la Relación
1.  **Método Gráfico**: Maximiza $Z = 3x + 2y$ sujeto a $x+y \le 4, x \le 2$.
    *   *Puntos*:
        - Vértice A (0,0) -> Z=0
        - Vértice B (2,0) -> Z=6
        - Vértice C (2,2) -> Z=10
        - Vértice D (0,4) -> Z=8
    *   *Resultado*: El máximo es 10 en el punto (2,2).
2.  **Problema de la Dieta**: El clásico de mezclar alimentos para cumplir mínimos de vitaminas al menor coste.
    *   *Truco*: Plantea bien las inecuaciones. Si dice "al menos", es $\ge$. Si dice "como mucho", es $\le$.
3.  **Interpretación del Dual**: ¿Qué significa el precio sombra?
    *   *Resolución*: Es cuánto mejoraría el valor de la función objetivo si aumentamos en una unidad un recurso limitado (una restricción). Muy útil en economía.
