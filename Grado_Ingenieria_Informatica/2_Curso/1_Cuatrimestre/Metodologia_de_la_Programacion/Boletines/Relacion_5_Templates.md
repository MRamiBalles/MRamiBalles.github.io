# MP - Relación 5: Genericidad y Plantillas (Oficial UHU)

## 🧠 Contexto Teórico
Las plantillas (`templates`) permiten escribir código independiente del tipo de dato, favoreciendo la reutilización.

*   **Plantillas de Función**: `template <typename T> T max(T a, T b)`.
*   **Plantillas de Clase**: `template <class T> class Lista { ... }`.
*   **Especialización**: Permite definir un comportamiento distinto para un tipo concreto (ej. `char*`).

## 📝 Ejercicios de la Relación
1.  **Función Genérica**: Escribe una función que intercambie el valor de dos variables de cualquier tipo.
    *   *Resolución:*
        ```cpp
        template <typename T>
        void intercambiar(T &a, T &b) {
            T aux = a;
            a = b;
            b = aux;
        }
        ```
2.  **Clase Contenedora**: Implementa la estructura de una clase `Contenedor<T>` que guarde un objeto y tenga métodos `get` y `set`.
    *   *Resolución:*
        ```cpp
        template <typename T>
        class Contenedor {
            T objeto;
        public:
            void set(T o) { objeto = o; }
            T get() const { return objeto; }
        };
        ```
3.  **Compilación**: ¿Por qué no se suelen separar las plantillas en `.h` y `.cpp`?
    *   *Resolución:* Porque el compilador necesita ver la definición completa para "instanciar" el código cuando se usa con un tipo concreto. Se suelen poner en archivos `.hpp` o directamente en el `.h`.
