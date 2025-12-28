# MP - Relación 2: Relaciones entre Objetos (Oficial UHU)

## 🧠 Contexto Teórico
Los objetos rara vez trabajan solos. Se relacionan de diversas formas:

*   **Asociación**: Relación débil. Un objeto usa a otro.
*   **Agregación**: Relación "todo-parte" débil. La parte puede existir sin el todo.
*   **Composición**: Relación "todo-parte" fuerte. Si el todo muere, las partes también.
*   **Multiplicidad**: Indica cuántos objetos participan (1..1, 1..*, etc.).

## 📝 Ejercicios de la Relación
1.  **Composición**: Implementa una clase `Coche` que contiene un objeto de clase `Motor`.
    *   *Resolución:*
        ```cpp
        class Motor { ... };
        class Coche {
        private:
            Motor motor; // Composición: Motor vive y muere con el Coche
        public:
            Coche() { ... }
        };
        ```
2.  **Agregación**: Implementa una clase `Universidad` que tiene una lista de `Alumno`.
    *   *Resolución:* Usamos punteros. Si la universidad cierra, los alumnos siguen existiendo en el sistema.
        ```cpp
        class Universidad {
        private:
            vector<Alumno*> alumnos; // Agregación
        };
        ```
3.  **Navegabilidad**: ¿Qué significa que una relación sea unidireccional?
    *   *Resolución:* Que el objeto A conoce al objeto B, pero B no sabe nada de A. Se implementa poniendo un atributo de B en A, pero no al revés.
