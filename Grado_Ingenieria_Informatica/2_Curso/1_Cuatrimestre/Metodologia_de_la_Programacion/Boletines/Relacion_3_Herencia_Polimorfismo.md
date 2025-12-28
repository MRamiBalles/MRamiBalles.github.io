# MP - Relación 3: Herencia y Polimorfismo (Oficial UHU)

## 🧠 Contexto Teórico
Permite reutilizar código creando nuevas clases a partir de otras existentes.

*   **Herencia**: Relación "es-un". La clase hija hereda atributos y métodos de la madre.
*   **Métodos Virtuales (`virtual`)**: Permiten que una función pueda ser sobrescrita en la clase hija.
*   **Polimorfismo**: Capacidad de un puntero a la clase base de apuntar a objetos de clases derivadas y ejecutar el método correcto (`ligadura dinámica`).
*   **Clases Abstractas**: Tienen al menos un método virtual puro (`= 0`). No se pueden instanciar.

## 📝 Ejercicios de la Relación
1.  **Jerarquía de Clases**: Define una clase `Figura` (abstracta) y sus hijas `Circulo` y `Cuadrado`.
    *   *Resolución:*
        ```cpp
        class Figura {
        public:
            virtual double area() const = 0; // Virtual puro
        };
        class Circulo : public Figura {
            double r;
        public:
            double area() const override { return 3.14 * r * r; }
        };
        ```
2.  **Ligadura Dinámica**: Explica qué pasa si llamamos a `area()` a través de un `Figura*`.
    *   *Resolución:* Gracias a la palabra `virtual`, C++ buscará en la tabla de métodos virtuales (vtable) y ejecutará la versión del objeto real (Circulo o Cuadrado), no la de la base.
3.  **Destructor Virtual**: ¿Por qué es obligatorio en herencia?
    *   *Resolución:* Para asegurar que al borrar un objeto mediante un puntero de la clase base, se llame al destructor de la clase hija y se libere toda la memoria.
