# PFIS - Relación 3: Patrones de Diseño Avanzados (Oficial UHU)

## 🧠 Patrones Creacionales
El objetivo es desacoplar el sistema de cómo se crean sus objetos.

## 📝 Caso Práctico: El Patrón Factory Method (Fábrica)

**Escenario**: Una aplicación de logística puede enviar paquetes por Camión o por Barco. No queremos que el código principal sepa qué transporte está usando.

### Implementación en C++

```cpp
#include <iostream>
#include <string>

// Producto Base
class Transporte {
public:
    virtual void entregar() = 0;
    virtual ~Transporte() {}
};

// Productos Concretos
class Camion : public Transporte {
public:
    void entregar() override { std::cout << "Entrega por carretera en caja.\n"; }
};

class Barco : public Transporte {
public:
    void entregar() override { std::cout << "Entrega por mar en contenedor.\n"; }
};

// Creador (La Fábrica)
class Logistica {
public:
    virtual Transporte* crearTransporte() = 0;
    
    void planificarEntrega() {
        Transporte* t = crearTransporte();
        t->entregar();
        delete t;
    }
    virtual ~Logistica() {}
};

// Creadores Concretos
class LogisticaTerrestre : public Logistica {
public:
    Transporte* crearTransporte() override { return new Camion(); }
};

class LogisticaMaritima : public Logistica {
public:
    Transporte* crearTransporte() override { return new Barco(); }
};

int main() {
    Logistica* l = new LogisticaTerrestre();
    l->planificarEntrega(); // Imprime "por carretera"
    
    delete l;
    l = new LogisticaMaritima();
    l->planificarEntrega(); // Imprime "por mar"
    
    delete l;
    return 0;
}
```

---
> [!IMPORTANT]
> **¿Cuándo usarlo?** Cuando una clase no puede anticipar la clase de objetos que debe crear, o cuando quieres delegar la responsabilidad de creación a las subclases.
