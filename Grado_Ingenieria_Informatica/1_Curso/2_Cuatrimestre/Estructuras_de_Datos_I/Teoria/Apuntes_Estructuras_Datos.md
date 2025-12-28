# Estructuras de Datos I (Resumen ETSI)

*Guía para el diseño de Tipos Abstractos de Datos (TADs) en C++.*

## 1. El Concepto de TAD
Un TAD es un modelo matemático con un conjunto de operaciones. Lo importante es el **qué hace**, no el **cómo lo hace** (encapsulamiento).

## 2. Estructuras Lineales
1.  **Listas:** Secuencias de elementos. Pueden ser contiguas (arrays) o enlazadas (nodos).
2.  **Pilas (Stacks):** LIFO (*Last In, First Out*). Operaciones: `push`, `pop`, `top`.
3.  **Colas (Queues):** FIFO (*First In, First Out*). Operaciones: `enqueue`, `dequeue`, `front`.

## 3. Estructuras No Lineales: Árboles
*   **Árbol Binario:** Cada nodo tiene como máximo 2 hijos.
*   **Árbol Binario de Búsqueda (BST):** Los elementos menores van a la izquierda y los mayores a la derecha. 
    *   *Coste búsqueda:* $O(\log n)$ si está balanceado, $O(n)$ si es degenerado.

## 4. Eficiencia en Estructuras
ED I es la base para FAA. La mayoría de las operaciones en estructuras lineales son $O(1)$ o $O(n)$, mientras que en árboles balanceados buscamos el $O(\log n)$.

---
> [!NOTE]
> **C++:** En esta asignatura es vital el uso de **Templates** (plantillas) para que nuestras estructuras funcionen con cualquier tipo de dato (int, float, Alumno...).
