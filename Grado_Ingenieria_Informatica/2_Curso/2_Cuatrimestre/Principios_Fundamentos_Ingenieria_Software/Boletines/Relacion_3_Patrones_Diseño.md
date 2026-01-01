# PFIS - Relación 3: Patrones de Diseño (Oficial UHU)

## 🧠 Soluciones Probadas
Los Patrones de Diseño son soluciones estándar a problemas comunes en el desarrollo de software, facilitando la comunicación entre desarrolladores y la mantenibilidad del código.

### 1. Patrones Creacionales (Creación de Objetos)
- **Singleton**: Garantiza una única instancia de una clase.
- **Factory Method**: Delega la creación de objetos a las subclases.

### 2. Patrones Estructurales (Composición de Clases)
- **Adapter**: Permite que clases con interfaces incompatibles trabajen juntas.
- **Composite**: Trata objetos individuales y composiciones de objetos de manera uniforme.

### 3. Patrones de Comportamiento (Interacción de Objetos)
- **Observer**: Define una dependencia uno-a-muchos para notificar cambios de estado.
- **Strategy**: Permite intercambiar algoritmos en tiempo de ejecución.

---

## 📝 Caso Práctico: Implementación de Factoría (Factory Method)

**Escenario**: Sistema de logística con diferentes medios de transporte.

```cpp
#include <iostream>
#include <string>

// Interfaz común
class Transporte {
public:
    virtual void entregar() = 0;
    virtual ~Transporte() {}
};

// Productos concretos
class Camion : public Transporte {
    void entregar() override { std::cout << "Entrega por carretera.\n"; }
};

class Barco : public Transporte {
    void entregar() override { std::cout << "Entrega por mar.\n"; }
};

// Fábrica
class Logistica {
public:
    virtual Transporte* crearTransporte() = 0;
    void ejecutar() {
        Transporte* t = crearTransporte();
        t->entregar();
        delete t;
    }
};

class LogisticaTerrestre : public Logistica {
    Transporte* crearTransporte() override { return new Camion(); }
};

int main() {
    Logistica* l = new LogisticaTerrestre();
    l->ejecutar();
    delete l;
    return 0;
}
```

## 📝 Ejercicios de Examen
1. **Identificar Singleton**: Constructor privado, instancia estática y método `getInstance()`.
2. **Uso de Observer**: Ideal para sistemas de eventos y actualizaciones de interfaz de usuario.
3. **Drafting Strategy**: Útil para sistemas que requieren diferentes métodos de ordenación o cálculo según el contexto.
