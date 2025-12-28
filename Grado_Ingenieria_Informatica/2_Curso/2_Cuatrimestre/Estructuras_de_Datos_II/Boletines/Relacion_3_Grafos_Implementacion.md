# ED II - Relación 3: Grafos e Implementación (Oficial UHU)

## 🧠 Grafos: La estructura total
Casi todo se puede modelar como un grafo: mapas de Google, relaciones en redes sociales, o incluso dependencias de paquetes en Linux.

*   **Implementación**:
    - **Matriz de Adyacencia**: Una tabla $V \times V$. Rápida para saber si hay arista ($O(1)$), pero gasta mucha RAM ($O(V^2)$).
    - **Lista de Adyacencia**: Un array de listas. Ahorra espacio ($O(V+E)$), ideal para grafos con pocas flechas (dispersos).
*   **Recorridos**: 
    - **BFS (Anchura)**: Usa una cola. Para encontrar el camino más corto en grafos sin pesos.
    - **DFS (Profundidad)**: Usa una pila o recursividad. Para detectar ciclos o ver si todo está conectado.

## 📝 Ejercicios Prácticos
1.  **¿Matriz o Lista?**: Si tienes 10.000 nodos y solo 50.000 aristas, ¿qué usas?
    *   *Respuesta*: Lista de Adyacencia. La matriz ocuparía 100 millones de celdas, ¡un desperdicio!
2.  **Detección de Ciclos**: ¿Cómo sabes si un grafo tiene un bucle?
    *   *Organic Tip*: Lanzas un DFS. Si durante el recorrido encuentras un nodo que ya estaba "en gris" (visitándose pero no terminado), ¡tienes un ciclo!
3.  **Grafo Transpuesto**: Invierte todas las flechas. Muy útil para algoritmos de componentes fuertemente conexas (Tarjan o Kosaraju).
