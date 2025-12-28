# DESO - Relación 4: Gestión de Memoria (Oficial UHU)

## 🧠 Contexto Teórico
El SO debe gestionar el espacio de memoria para que varios procesos coexistan.

*   **Paginación**: Dividir memoria en marcos fijos. Evita la fragmentación externa.
*   **Fallo de Página**: Ocurre cuando se accede a una página que no está en RAM (está en disco/SWAP).
*   **Algoritmos de Reemplazo**: FIFO, Óptimo (el que tardará más en usarse) y LRU (*Least Recently Used*).

## 📝 Ejercicios de la Relación
1.  **Traducción de Direcciones**: Dirección lógica (página, offset). Si la página 2 está en el marco 5 y el tamaño de página es 1KB, ¿cuál es la dirección física de la dirección lógica 2100?
    *   *Resolución:* $2100 / 1024 = 2$ con resto $52$. Página 2, offset 52. Dirección física = $5 \cdot 1024 + 52 = 5120 + 52 = 5172$.
2.  **LRU**: Secuencia de páginas 1, 2, 3, 2, 1, 4. 3 marcos de memoria. Halla fallos de página.
    *   *Resolución:* (1), (1,2), (1,2,3) -> 3 fallos. (1,2,3) -> 2 ya está (Acierto). (1,2,3) -> 1 ya está (Acierto). (4,2,1) -> 4 entra por 3 (LRU). Total fallos: 4.
3.  **Thrashing (Hiperpaginación)**: ¿Por qué ocurre?
    *   *Resolución:* Cuando el SO dedica más tiempo a cambiar páginas entre disco y RAM que a ejecutar procesos. Suele pasar al aumentar demasiado el grado de multiprogramación.
