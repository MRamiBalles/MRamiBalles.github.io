# MP - Relación 6: Flujos de Datos y Ficheros (Oficial UHU)

## 🧠 Contexto Teórico
Persistencia de la información mediante archivos de texto y binarios en C++.

*   **Librería `fstream`**: `ifstream` (lectura), `ofstream` (escritura), `fstream` (ambos).
*   **Ficheros de Texto**: Formato legible por humanos. Se usa `<<` y `>>`.
*   **Ficheros Binarios**: Copia exacta de los bits en memoria. Se usa `write()` y `read()`.

## 📝 Ejercicios de la Relación
1.  **Escritura de Texto**: Guarda una lista de números en un archivo llamado `datos.txt`.
    *   *Resolución:*
        ```cpp
        ofstream f("datos.txt");
        if (f.is_open()) {
            for(int n : lista) f << n << " ";
            f.close();
        }
        ```
2.  **Lectura de Objetos (Binario)**: Lee un objeto de clase `Alumno` desde un archivo binario.
    *   *Resolución:*
        ```cpp
        Alumno a;
        ifstream f("alumnos.bin", ios::binary);
        f.read((char*)&a, sizeof(Alumno));
        ```
3.  **Gestión de Errores**: ¿Qué indica el flag `eof()`?
    *   *Resolución:* *End Of File*. Indica que se ha intentado leer más allá del final del archivo. Se suele usar en bucles `while(!f.eof())`.
---
> [!TIP]
> **Check Always**: Nunca olvides cerrar el fichero con `close()` para asegurar que se vacíen los búferes a disco.
