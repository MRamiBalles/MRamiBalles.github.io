#include <stdio.h>
#include <string.h>

/**
 * @file Ejercicios_Basicos.c
 * @brief Ejercicios resueltos de Fundamentos de Programación (FP).
 * Cubre structs, punteros y lógica básica.
 */

// Estructura típica de examen
typedef struct {
    char nombre[50];
    int edad;
    float nota;
} Alumno;

// Función que usa punteros para intercambiar valores (Clásico)
void intercambiar(int *a, int *b) {
    int aux = *a;
    *a = *b;
    *b = aux;
}

// Función que procesa un array de structs
void mostrarMejorAlumno(Alumno clase[], int tam) {
    int indiceMejor = 0;
    for (int i = 1; i < tam; i++) {
        if (clase[i].nota > clase[indiceMejor].nota) {
            indiceMejor = i;
        }
    }
    printf("Mejor Alumno: %s con un %.2f\n", clase[indiceMejor].nombre, clase[indiceMejor].nota);
}

int main() {
    // 1. Prueba de punteros
    int x = 10, y = 20;
    printf("Antes: x=%d, y=%d\n", x, y);
    intercambiar(&x, &y);
    printf("Despues: x=%d, y=%d\n", x, y);

    // 2. Prueba de structs
    Alumno misAlumnos[2] = {
        {"Manu", 20, 9.5},
        {"Pepe", 21, 8.0}
    };
    mostrarMejorAlumno(misAlumnos, 2);

    return 0;
}
