# Fundamentos de Programación: Conceptos de Lenguaje C

*Guía esencial para dominar la programación estructurada en la ETSI.*

## 1. Estructura de un Programa en C
C es un lenguaje compilado y estructurado. Todo empieza en la función `main`.

```c
#include <stdio.h>

int main() {
    printf("Hola UHU\n");
    return 0;
}
```

## 2. Punteros y Paso por Referencia
Es el concepto más "duro" de 1º. Un puntero guarda una **dirección de memoria**.
*   `int *p;` -> Declaración de puntero a entero.
*   `&x` -> Dirección de la variable x.
*   `*p` -> Contenido de la dirección apuntada por p.

*Uso típico:* Modificar variables dentro de una función (paso por referencia).

## 3. Estructuras de Datos Estáticas
*   **Arrays:** Colecciones de elementos del mismo tipo en posiciones contiguas.
*   **Structs:** Permiten agrupar datos de distintos tipos (ej. un Alumno con nombre, edad y nota).

## 4. Gestión de Archivos
C permite leer y escribir en discos usando `FILE*`.
*   `fopen`, `fclose`.
*   `fprintf` (escribir texto), `fwrite` (escribir binario).

---
> [!IMPORTANT]
> **Memoria Dinámica:** Aunque se ve por encima, recuerda `malloc` y `free`. Por cada `malloc` que hagas, DEBES hacer un `free` para evitar fugas de memoria (*Memory Leaks*).
