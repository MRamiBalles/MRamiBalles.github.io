# ED I - Relación 3: Árboles Binarios (Oficial UHU)

## 🧠 Contexto Teórico
Estructuras jerárquicas fundamentales para búsqueda eficiente.

*   **Recorridos**: 
    *   **Preorden**: Raíz-Izquierda-Derecha.
    *   **Inorden**: Izquierda-Raíz-Derecha.
    *   **Postorden**: Izquierda-Derecha-Raíz.
*   **BST**: Árbol Binario de Búsqueda.

## 📝 Ejercicios de la Relación
1.  **Reconstrucción**: ¿Es posible reconstruir un árbol binario solo con el Inorden y el Preorden?
    *   *Resolución:* Sí. El primer elemento del Preorden es la raíz. Buscamos ese elemento en el Inorden para dividir en subárbol izquierdo y derecho. Repetimos recursivamente.
2.  **Contar Hojas**: Escribe una función recursiva para contar el número de hojas de un árbol.
    *   *Resolución:* 
      ```cpp
      int contarHojas(Nodo* r) {
          if (!r) return 0;
          if (!r->izq && !r->der) return 1;
          return contarHojas(r->izq) + contarHojas(r->der);
      }
      ```
3.  **Búsqueda en BST**: Dado un BST, halla el valor mínimo.
    *   *Resolución:* Desplazarse siempre al hijo izquierdo hasta llegar a un nodo sin hijo izquierdo.
    *   *Coste:* $O(h)$, donde $h$ es la altura.
