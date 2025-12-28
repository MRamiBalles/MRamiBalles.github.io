# MP - Relación 1: Abstracción de Datos. Objetos y Clases (Oficial UHU)

## 🧠 Contexto Teórico
La Programación Orientada a Objetos (POO) busca modelar el mundo real mediante clases (moldes) y objetos (instancias).

*   **Encapsulamiento**: Ocultar el estado interno (atributos `private`) y ofrecer una interfaz pública (métodos `public`).
*   **Constructor**: Método especial para inicializar el objeto. Puede haber varios (sobrecarga).
*   **Destructor**: Se encarga de liberar recursos (especialmente memoria dinámica).

## 📝 Ejercicios de la Relación
1.  **Diseño de Clase**: Define una clase `Rectangulo` con atributos privados `ancho` y `alto`.
    *   *Resolución:*
        ```cpp
        class Rectangulo {
        private:
            double ancho, alto;
        public:
            Rectangulo(double a, double l) : ancho(a), alto(l) {}
            double area() const { return ancho * alto; }
            void setAncho(double a) { if(a>0) ancho = a; }
        };
        ```
2.  **Constructor de Copia**: ¿Por qué es necesario si hay punteros en la clase?
    *   *Resolución:* Para evitar que dos objetos compartan el mismo puntero. Si uno muere, el otro apunta a memoria liberada (*Dangling Pointer*). El constructor de copia debe realizar una **Copia Profunda**.
3.  **Encapsulamiento**: Explica la diferencia entre `public`, `private` y `protected`.
    *   *Resolución:* `public` es accesible desde fuera. `private` solo desde la misma clase. `protected` es accesible también por las clases hijas (herencia).
