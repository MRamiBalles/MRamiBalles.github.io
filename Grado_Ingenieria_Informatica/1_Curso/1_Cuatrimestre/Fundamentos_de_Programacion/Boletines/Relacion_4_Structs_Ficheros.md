# FP - Relación 4: Tipos de Datos Estructurados y Gestión de Ficheros (C)

La fase final de la programación procedural se centra en la creación de tipos de datos personalizados y la persistencia de la información en el sistema de archivos.

## 1. Estructuras (`struct`)
Permiten agrupar variables de diferentes tipos bajo un mismo nombre.
- **Acceso**: Operador punto (`.`) para variables y flecha (`->`) para punteros a estructuras.
- **`typedef`**: Permite crear alias para tipos complejos, mejorando la legibilidad.

## 2. Gestión de Ficheros (`stdio.h`)
- **`fopen`**: Abre un flujo de datos hacia un archivo (modos: "r", "w", "a", "rb", "wb").
- **`fprintf` / `fscanf`**: Lectura/Escritura en formato texto.
- **`fwrite` / `fread`**: Lectura/Escritura binaria (volcado directo de memoria).
- **`fclose`**: Imprescindible para liberar el descriptor de archivo y asegurar el volcado del buffer.

## 📝 Caso Práctico: Sistema de Gestión de Alumnos
Defina una estructura `Alumno` y escriba una función que guarde un array de dichas estructuras en un fichero binario.
```c
typedef struct {
    char nombre[50];
    int edad;
    float nota;
} Alumno;

void guardarAlumnos(Alumno lista[], int n, char* filename) {
    FILE *f = fopen(filename, "wb");
    if (f != NULL) {
        fwrite(lista, sizeof(Alumno), n, f);
        fclose(f);
    }
}
```

## 3. Robustez del Código
- Comprobación de errores en apertura de ficheros.
- Limpieza del buffer del teclado (`fflush(stdin)` o similar) para evitar saltos en la lectura de caracteres.
- Validación de rangos en los atributos de las estructuras.
