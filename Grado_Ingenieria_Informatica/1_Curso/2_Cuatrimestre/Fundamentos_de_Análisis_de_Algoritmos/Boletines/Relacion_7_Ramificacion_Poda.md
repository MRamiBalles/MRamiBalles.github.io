# FAA - Relación 7: Ramificación y Poda / Branch & Bound (Oficial UHU)

## 🧠 La versión Pro del Backtracking
A diferencia de Backtracking (que va en profundidad), Branch & Bound suele ir en anchura o, mejor aún, por **Mejor Estimación** (Best-First).

*   **Poda por Cota**: Si la mejor solución que espero sacar de una rama es peor que el récord que ya tengo guardado, podo la rama entera.
    1.  **Cota Superior (CS)**: Lo máximo que espero sacar (optimista).
    2.  **Cota Inferior (CI)**: Lo mínimo que ya tengo asegurado (pesimista).

## 📝 Ejercicios para no morir
1.  **Mochila 0/1 (de nuevo)**: Se resuelve con B&B usando una cola de prioridad.
    *   *Paso clave*: Ordenar los objetos por valor/peso para que las estimaciones sean buenas.
    *   En cada nodo calculas una estimación (relajando el problema a mochila fraccionaria). Si esa estimación es menor que tu mejor solución actual, matas el nodo.

2.  **Viajante de Comercio (TSP)**: Visitar todas las ciudades al menor coste.
    *   Es el más difícil. Se suele usar una matriz de costes reducida para sacar las cotas.
    *   *Truco de la ETSI*: Resta el mínimo de cada fila y columna para sacar el "coste de arrepentimiento".

3.  **Asignación de Tareas**: N personas y N tareas con distintos costes.
    *   Similar al TSP pero más simple. Quieres minimizar la suma total asignando una tarea a cada uno.
---
> [!NOTE]
> **Diferencia técnica**: Backtracking = Pila (Recursividad). Branch & Bound = Cola de Prioridad (Montículo). Este último gasta mucha más memoria pero corta ramas antes.
