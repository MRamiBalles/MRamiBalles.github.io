# ED I - Relación 2: TADs Lineales (Oficial UHU)

## 🧠 Contexto Teórico
Implementación y uso de estructuras de datos donde los elementos se organizan de forma secuencial.

*   **Pilas (Stacks)**: LIFO.
*   **Colas (Queues)**: FIFO.
*   **Listas**: Acceso por posición o puntero.

## 📝 Ejercicios de la Relación
1.  **Equilibrado de Paréntesis**: Diseña un algoritmo usando una Pila para verificar si una expresión matemática tiene paréntesis bien cerrados.
    *   *Resolución:* Apilar cada '('. Desapilar al encontrar ')'. Si la pila está vacía al final y nunca se intentó desapilar una pila vacía, está correcto.
2.  **Simulación de Cola**: Implementa una Cola usando dos Pilas.
    *   *Resolución:* Pila 1 para entrada. Al extraer, si Pila 2 está vacía, mover todo de Pila 1 a Pila 2 (invirtiendo el orden). Extraer de Pila 2.
3.  **Lista Enlazada**: Invierte una lista enlazada simple de forma iterativa.
    *   *Resolución:* Mantener tres punteros: anterior, actual y siguiente. En cada paso: `siguiente = actual->next; actual->next = anterior; anterior = actual; actual = siguiente;`.
