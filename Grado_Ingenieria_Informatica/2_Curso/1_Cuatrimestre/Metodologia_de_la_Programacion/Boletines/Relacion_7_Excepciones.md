# MP - Relación 7: Gestión de Excepciones y Robustez (Oficial UHU)

## 🧠 El truco de las Excepciones
Hacer un programa que funcione es fácil; hacer uno que no "pete" cuando el usuario mete la pata es lo difícil. C++ usa el bloque `try-catch`.

*   **`throw`**: Lanzas la patata caliente (el error).
*   **`try`**: Código "peligroso" donde vigilamos si alguien lanza algo.
*   **`catch`**: El guante para recoger la patata y que el programa no muera.
*   **Jerarquía**: Trata de capturar siempre por referencia (`const exception &e`) para evitar copias lentas y el "object slicing" (recorte de objetos).

## 📝 Ejercicios de la Relación
1.  **División por cero**: Lanza una excepción si intentas dividir por 0.
    *   *Resolución*:
        ```cpp
        double division(double a, double b) {
            if (b == 0) throw runtime_error("Ojo, que has intentado dividir por cero!");
            return a / b;
        }
        ```
2.  **Excepciones Propias**: Crea una clase `ErrorDeFichero` que herede de `std::exception`.
    *   *Resolución*:
        ```cpp
        class ErrorDeFichero : public exception {
        public:
            const char* what() const noexcept override {
                return "Error: No se ha podido abrir el archivo en la ETSI.";
            }
        };
        ```
3.  **Captura Múltiple**: ¿Qué pasa si pones primero un `catch(...)` y luego uno específico?
    *   *Resolución*: Pues que el `catch(...)` se lo come todo y el específico no sirve para nada. El compilador te dará un warning. **Consejo UHU**: Pon siempre los errores más específicos arriba y los generales abajo.
