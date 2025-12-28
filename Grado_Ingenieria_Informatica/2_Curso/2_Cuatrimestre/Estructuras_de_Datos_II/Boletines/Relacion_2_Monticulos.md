# ED II - Relación 2: Montículos (Heaps) y Colas de Prioridad (Oficial UHU)

## 🧠 El Montículo (Heap)
No es lo mismo que el montón de memoria (heap segment). Es un árbol binario casi completo que cumple la **propiedad de montículo**: el padre es siempre mayor (en Max-Heap) o menor (en Min-Heap) que sus hijos.

*   **Almacenamiento**: Se guarda en un vector (array). Si el padre está en la posición `i`, los hijos están en `2i` y `2i+1`. ¡Es super eficiente!
*   **Flotar (Swim)**: Cuando metes a alguien nuevo por abajo y "sube" hasta su sitio.
*   **Hundir (Sink)**: Cuando sacas al jefe y pones a un novato arriba, el novato tiene que "bajar" hasta su sitio.

## 📝 Ejercicios de Examen
1.  **Construir un Heap**: Tienes el vector [4, 1, 3, 2, 16, 9, 10, 14, 8, 7]. Transfórmalo en un Max-Heap.
    *   *Método Floyd*: Empiezas desde el último padre y vas hundiendo. Es más rápido que insertar uno a uno ($O(n)$ vs $O(n \log n)$).
2.  **Colas de Prioridad**: Imagina que en el hospital (ETSIdades) los pacientes tienen una urgencia.
    *   *Dato*: Usamos un Min-Heap para que el paciente con urgencia 1 salga el primero.
3.  **HeapSort**: ¿Cómo funciona?
    *   *Organic Tip*: Sacas el máximo, lo pones al final del array, y reajustas el heap con lo que queda. Repites hasta que no quede nada. Es $O(n \log n)$ y no gasta memoria extra.
