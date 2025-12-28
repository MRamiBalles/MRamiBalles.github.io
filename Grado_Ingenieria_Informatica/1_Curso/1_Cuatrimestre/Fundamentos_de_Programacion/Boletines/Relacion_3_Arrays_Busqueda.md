# FP - Relación 3: Estructuras Multidimensionales y Algoritmos de Búsqueda (C)

El manejo eficiente de colecciones de datos en C requiere el dominio de arrays bidimensionales y la aplicación de algoritmos de búsqueda y ordenación.

## 1. Matrices (Arrays Bidimensionales)
Se declaran como `tipo nombre[FILAS][COLUMNAS]`. En memoria, C almacena las matrices por filas (*row-major order*).
- **Acceso**: `matriz[i][j]` lee el elemento en la fila `i` y columna `j`.

## 2. Algoritmos de Ordenación Básica
- **Burbuja (Bubble Sort)**: Intercambia elementos adyacentes si están desordenados. Complejidad $O(n^2)$.
- **Selección (Selection Sort)**: Busca el mínimo en cada pasada y lo coloca en su posición. Complejidad $O(n^2)$.

## 📝 Ejercicio Técnico: Búsqueda Binaria
Implemente una función en C que realice una búsqueda binaria en un array **previamente ordenado**.
```c
int busquedaBinaria(int arr[], int n, int clave) {
    int bajo = 0, alto = n - 1;
    while (bajo <= alto) {
        int medio = bajo + (alto - bajo) / 2;
        if (arr[medio] == clave) return medio;
        if (arr[medio] < clave) bajo = medio + 1;
        else alto = medio - 1;
    }
    return -1; // No encontrado
}
```

## 3. Complejidad Espacial vs Temporal
- **Espacial**: Memoria adicional requerida (ej. arrays auxiliares).
- **Temporal**: Número de operaciones en función del tamaño de la entrada ($n$).
- *Importante*: La búsqueda binaria reduce la complejidad de $O(n)$ a $O(\log n)$, lo cual es crítico para grandes volúmenes de datos.
