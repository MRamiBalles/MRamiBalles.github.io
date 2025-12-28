# IA - Relación 1: Búsqueda en Espacios de Estados (Oficial UHU)

## 🧠 ¿Qué es buscar en IA?
No es buscar un archivo. Es encontrar una secuencia de acciones (el camino) que nos lleve desde un estado inicial (ej. robot en la puerta) a un estado meta (ej. robot cargando el móvil).

1.  **Búsqueda no informada (a ciegas)**: 
    *   **Anchura (BFS)**: Capa por capa. Encuentra el camino más corto pero come mucha RAM.
    *   **Profundidad (DFS)**: Hasta el fondo y luego vuelve. Gasta poca RAM pero puede entrar en bucles infinitos.
2.  **Búsqueda informada (Heurística)**:
    *   **A***: El rey de la IA. Usa $f(n) = g(n) + h(n)$. Donde $g$ es lo que llevas gastado y $h$ es una estimación de lo que te queda.

## 📝 El "clásico" de la UHU: El Puzzle del 8
Tienes una rejilla 3x3 con números del 1 al 8 y un hueco. Tienes que ordenarlos.
*   **Estado**: La posición de todos los números.
*   **Heurística típica**: Distancia de Manhattan (cuántos pasos le faltan a cada número para llegar a su sitio). 
*   *Ojo*: Una heurística es **admisible** si nunca sobreestima el coste real. Si miente y dice que falta menos de lo que falta, siempre encontrará el óptimo.

## 📝 Ejercicio de Examen
Dibuja el árbol de búsqueda para un grafo dado usando A* y explica por qué se elige cada nodo.
*   *Tip*: Ten siempre a mano la lista de nodos "Abiertos" (los que has visto pero no explorado) y "Cerrados" (los que ya has procesado). El camino se reconstruye siguiendo los punteros al padre.
