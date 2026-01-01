# Estructuras de Datos II - Relación 1: Árboles de Búsqueda de Alto Rendimiento (AVL)

Las estructuras de datos avanzadas permiten la optimización de las operaciones de búsqueda, inserción y borrado, garantizando complejidades temporales logarítmicas incluso en el peor de los casos.

## 1. Árboles Binarios de Búsqueda (BST)
Estructura donde para cada nodo, los valores del subárbol izquierdo son menores y los del derecho mayores. Su principal limitación es la degradación a listas enlazadas ($O(n)$) si no están balanceados.

## 2. Árboles AVL (Adelson-Velsky y Landis)
Son árboles auto-balanceados donde, para cada nodo, la diferencia de alturas entre sus subárboles (Factor de Equilibrio) es como máximo 1.
- **Balanceo**: Se realiza mediante rotaciones simples (L, R) o dobles (LR, RL).
- **Complejidad**: Garantiza $O(\log n)$ para todas las operaciones fundamentales.

## 📝 Implementación de Referencia: Árbol AVL en C++

A continuación se presenta una implementación robusta que incluye las funciones de rotación y el cálculo dinámico de la altura para mantener el balanceo.

```cpp
#include <iostream>
#include <algorithm>

template <typename T>
struct Nodo {
    T dato;
    Nodo* izq;
    Nodo* der;
    int altura;

    Nodo(T v) : dato(v), izq(nullptr), der(nullptr), altura(1) {}
};

template <typename T>
class ArbolAVL {
private:
    Nodo<T>* raiz;

    int obtenerAltura(Nodo<T>* n) { return n ? n->altura : 0; }

    int obtenerBalance(Nodo<T>* n) {
        return n ? obtenerAltura(n->izq) - obtenerAltura(n->der) : 0;
    }

    Nodo<T>* rotarDerecha(Nodo<T>* y) {
        Nodo<T>* x = y->izq;
        Nodo<T>* T2 = x->der;
        x->der = y;
        y->izq = T2;
        y->altura = std::max(obtenerAltura(y->izq), obtenerAltura(y->der)) + 1;
        x->altura = std::max(obtenerAltura(x->izq), obtenerAltura(x->der)) + 1;
        return x;
    }

    Nodo<T>* rotarIzquierda(Nodo<T>* x) {
        Nodo<T>* y = x->der;
        Nodo<T>* T2 = y->izq;
        y->izq = x;
        x->der = T2;
        x->altura = std::max(obtenerAltura(x->izq), obtenerAltura(x->der)) + 1;
        y->altura = std::max(obtenerAltura(y->izq), obtenerAltura(y->der)) + 1;
        return y;
    }

    Nodo<T>* insertar(Nodo<T>* nodo, T dato) {
        if (!nodo) return new Nodo<T>(dato);

        if (dato < nodo->dato) nodo->izq = insertar(nodo->izq, dato);
        else if (dato > nodo->dato) nodo->der = insertar(nodo->der, dato);
        else return nodo;

        nodo->altura = 1 + std::max(obtenerAltura(nodo->izq), obtenerAltura(nodo->der));
        int balance = obtenerBalance(nodo);

        // Caso Simple Derecha (LL)
        if (balance > 1 && dato < nodo->izq->dato) return rotarDerecha(nodo);
        // Caso Simple Izquierda (RR)
        if (balance < -1 && dato > nodo->der->dato) return rotarIzquierda(nodo);
        // Caso Doble Izquierda-Derecha (LR)
        if (balance > 1 && dato > nodo->izq->dato) {
            nodo->izq = rotarIzquierda(nodo->izq);
            return rotarDerecha(nodo);
        }
        // Caso Doble Derecha-Izquierda (RL)
        if (balance < -1 && dato < nodo->der->dato) {
            nodo->der = rotarDerecha(nodo->der);
            return rotarIzquierda(nodo);
        }
        return nodo;
    }

public:
    ArbolAVL() : raiz(nullptr) {}
    void insertar(T dato) { raiz = insertar(raiz, dato); }
};
```

## 📝 Ejercicio de Examen: Seguimiento de Inserciones
**Enunciado**: Dibuje el estado final de un árbol AVL tras insertar la secuencia: `10, 20, 30, 40, 50, 25`.

**Resolución Paso a Paso**:
1.  **Inserción 10, 20, 30**: Al insertar 30, el nodo 10 tiene un balance de -2. Rotación simple a la izquierda sobre 10. Raíz: 20, hijos 10 y 30.
2.  **Inserción 40, 50**: Al insertar 50, el nodo 30 tiene un balance de -2. Rotación simple a la izquierda sobre 30.
3.  **Inserción 25**: Provoca un desequilibrio en la raíz (20). Se requiere un análisis de balanceo global para restaurar la propiedad AVL.

---
> [!IMPORTANT]
> Recuerda que en un árbol AVL, el factor de equilibrio $FE$ siempre debe cumplir $|FE| \leq 1$. Si $|FE| = 2$, el árbol debe rotar inmediatamente.
