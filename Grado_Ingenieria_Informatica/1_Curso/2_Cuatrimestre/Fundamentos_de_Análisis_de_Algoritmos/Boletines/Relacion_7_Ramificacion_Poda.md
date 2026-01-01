# FAA - Relación 7: Ramificación y Poda (Oficial UHU)

Ramificación y Poda (Branch & Bound) es una optimización del Backtracking para problemas de optimización, utilizando una búsqueda en anchura (BFS) o por prioridad (Best-First) en lugar de profundidad (DFS).

## 🧠 Conceptos Clave
- **Nodo Vivo**: Nodo generado cuyo espacio de búsqueda no ha sido explorado completamente.
- **Cotas (Bounds)**:
  - **Cota Inferior (CI)**: Valor mínimo que puede tomar la función objetivo en ese subárbol.
  - **Cota Superior (CS)**: Valor máximo (o una solución real ya encontrada).
- **Estrategia de Selección**:
  - **FIFO**: Cola normal.
  - **LIFO**: Pila.
  - **Menor Coste (Best-First)**: Cola de prioridad (la más eficiente).

## 📝 Ejercicios de la Relación

1. **La Mochila 0/1 con Branch & Bound**
   *Cálculo de Cota*: Usamos el valor del problema de la mochila fraccionaria (Greedy) como cota superior para decidir si exploramos un nodo.
   - Si $V_{nodo\_actual} + V_{fraccionario\_restante} < Best\_V\_Encontrado$, podamos el nodo.

2. **Problema del Viajante de Comercio (TSP)**
   *Estrategia*: Usamos una matriz de costes reducida para calcular la cota inferior del camino. Ramificamos eligiendo la arista que menos penalice el coste total.

3. **Asignación de Tareas**
   *Enunciado*: Asignar $n$ tareas a $n$ trabajadores con coste mínimo.
   *Resolución*: Usamos una cola de prioridad basada en el coste estimado. El primero en llegar al nivel final con el coste mínimo es la solución óptima.

## 📝 Comparativa: Backtracking vs B&B
| Característica | Backtracking | Branch & Bound |
| :--- | :--- | :--- |
| **Búsqueda** | DFS (Profundidad) | BFS / Best-First |
| **Estructura** | Pila (Implícita) | Cola de Prioridad |
| **Objetivo** | Cualquiera / Todas | Optimización |
| **Podas** | Basadas en viabilidad | Basadas en cotas (promesa) |

---
> [!TIP]
> En los exámenes de la UHU, se suele pedir dibujar el árbol de exploración indicando el orden de generación de nodos y quién poda a quién.
