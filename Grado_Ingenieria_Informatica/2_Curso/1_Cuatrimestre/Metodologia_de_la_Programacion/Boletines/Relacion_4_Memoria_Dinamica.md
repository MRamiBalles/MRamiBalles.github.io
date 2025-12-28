# MP - Relación 4: Gestión Dinámica de Memoria (Oficial UHU)

## 🧠 Contexto Teórico
El control total sobre cuándo se reserva y libera la memoria en el `Heap`.

*   **`new` y `delete`**: Operadores para reservar y liberar memoria.
*   **Fugas de Memoria**: Ocurren cuando perdemos el puntero a una zona de memoria dinámica sin haberla liberado.
*   **Regla de los Tres**: Si tu clase necesita un destructor manual, probablemente también necesite un **Constructor de Copia** y un **Operador de Asignación** (`operator=`).

## 📝 Ejercicios de la Relación
1.  **Aritmética de Punteros**: ¿Cuál es la diferencia entre `p++` y `(*p)++`?
    *   *Resolución:* `p++` mueve el puntero a la siguiente dirección de memoria. `(*p)++` incrementa el valor almacenado en la dirección actual.
2.  **Matrices Dinámicas**: Crea una matriz de $10 \times 10$ dinámicamente.
    *   *Resolución:*
        ```cpp
        int** matriz = new int*[10];
        for(int i=0; i<10; i++) matriz[i] = new int[10];
        // Para liberar, orden inverso
        for(int i=0; i<10; i++) delete[] matriz[i];
        delete[] matriz;
        ```
3.  **Operador de Asignación**: Implementa `operator=` evitando la auto-asignación.
    *   *Resolución:*
        ```cpp
        MiClase& operator=(const MiClase& otro) {
            if (this != &otro) { // Evita auto-asignación
                delete[] datos;  // Libera actual
                // Copia profunda de otro.datos
            }
            return *this;
        }
        ```
---
> [!WARNING]
> En la UHU se penaliza duramente no liberar la memoria en el destructor o dejar punteros colgantes. Usa herramientas como `Valgrind` si puedes.
