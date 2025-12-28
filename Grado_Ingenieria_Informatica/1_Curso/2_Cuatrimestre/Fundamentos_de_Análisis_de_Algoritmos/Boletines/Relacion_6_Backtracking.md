# FAA - Relación 6: Vuelta Atrás / Backtracking (Oficial UHU)

## 🧠 La idea "fuerza bruta inteligente"
Es una búsqueda en profundidad (DFS) en un árbol de estados. Si una rama no sirve, "cortas" (poda) y vuelves atrás.

*   **Espacio de búsqueda**: Árbol con todas las combinaciones.
*   **Funciones**:
    1.  `Solucion(n)`: ¿Hemos llegado al final?
    2.  `Criterio(n)`: ¿Esta rama sigue siendo prometedora?

## 📝 Problemas de examen
1.  **Las N Reinas**: Colocar N reinas en un tablero $N \times N$ sin que se amenacen.
    *   *Cómo se resuelve*: Pones una reina en la fila 1. Miras dónde puedes poner la de la fila 2. Si no hay hueco, vuelves a la 1 y la mueves.
    *   *Vector solución*: $V = [c_1, c_2, ..., c_n]$ donde $c_i$ es la columna de la reina en la fila $i$.

2.  **Suma de Subconjuntos**: Tienes $\{2, 4, 6, 8\}$ y buscas que sumen 10.
    *   *Árbol binario*: En cada nodo decides "meto el 2" o "no meto el 2".
    *   *Poda*: Si la suma actual ya se pasa de 10, dejas de bajar por ahí. Ahorras mil millones de cálculos.

3.  **Coloreado de Grafos**: Colorear con $m$ colores sin que dos nodos adyacentes tengan el mismo.
    *   Asignas color 1 al nodo A. Al nodo B le intentas dar el 1, si falla, el 2... y así.
---
> [!TIP]
> **Diferencia con P. Dinámica**: Backtracking busca "caminos" o "soluciones concretas" (todas o una), Dinámica busca "el mejor valor" optimizando.
