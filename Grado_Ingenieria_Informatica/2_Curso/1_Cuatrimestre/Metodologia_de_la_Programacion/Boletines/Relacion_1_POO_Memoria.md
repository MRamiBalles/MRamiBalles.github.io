# Metodología de la Programación - Relación 1: Programación Orientada a Objetos y Gestión de Memoria

La Metodología de la Programación (MP) en C++ requiere una transición del paradigma procedural al orientado a objetos, enfatizando la encapsulación y la gestión eficiente de recursos dinámicos.

## 1. Pilares de la Orientación a Objetos
- **Encapsulación**: Ocultación de los detalles de implementación mediante modificadores de acceso (`private`, `protected`, `public`).
- **Abstracción**: Definición de interfaces claras mediante clases y métodos.
- **Herencia**: Reutilización y especialización de comportamientos entre clases.
- **Polimorfismo**: Capacidad de tratar objetos de diferentes clases de forma uniforme a través de métodos virtuales.

## 2. Gestión de Memoria Dinámica
En C++, el programador es responsable del ciclo de vida de los objetos en el *heap*.
- **`new` / `delete`**: Operadores para la reserva y liberación de memoria.
- **Constructor y Destructor**: El destructor es crítico para evitar fugas de memoria (*memory leaks*) mediante la liberación de punteros internos.

## 📝 Caso Práctico: Implementación de una Clase Segura
Implemente el "Big Three" (Constructor de copia, Operador de asignación y Destructor) para una clase que gestiona un array dinámico de enteros.

*Justificación Técnica*: Si una clase gestiona memoria dinámica, el constructor de copia por defecto realiza una copia superficial (*shallow copy*), lo que conduce a problemas de doble liberación (*double free*) y corrupción de memoria. Es imperativo realizar una copia profunda (*deep copy*).
```cpp
class VectorDinamico {
private:
    int *datos;
    int size;
public:
    VectorDinamico(const VectorDinamico& orig) {
        size = orig.size;
        datos = new int[size];
        for(int i=0; i<size; i++) datos[i] = orig.datos[i];
    }
    ~VectorDinamico() { delete[] datos; }
};
```
