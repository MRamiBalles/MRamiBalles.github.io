# Estructuras de Datos II - Relación 1: Árboles de Búsqueda de Alto Rendimiento (AVL)

Las estructuras de datos avanzadas permiten la optimización de las operaciones de búsqueda, inserción y borrado, garantizando complejidades temporales logarítmicas incluso en el peor de los casos.

## 1. Árboles AVL (Adelson-Velsky y Landis)
Son árboles auto-balanceados donde el Factor de Equilibrio ($FE = Altura_{izq} - Altura_{der}$) de cada nodo es $\{-1, 0, 1\}$.

## 📝 Ejercicio de Examen: Seguimiento de Inserciones
**Enunciado**: Dibuje el estado final de un árbol AVL tras insertar la secuencia: `10, 20, 30, 40, 50, 25`.

**Resolución Paso a Paso**:
1.  **Inserción 10, 20, 30**:
    - Se forma una línea derecha. El nodo 10 tiene $FE = -2$.
    - **Rotación Simple Izquierda (RSI)** sobre 10.
    - Árbol: `[20]` con hijos `(10, 30)`.
2.  **Inserción 40, 50**:
    - Se insertan a la derecha de 30. El nodo 30 queda con $FE = -2$.
    - **RSI** sobre 30.
    - Árbol: `[20]` con hijos `(10, 40)`. El 40 tiene hijos `(30, 50)`.
3.  **Inserción 25**:
    - Se inserta a la izquierda de 30.
    - Check de balances: 30(1), 40(2), 20(-2).
    - El primer nodo desequilibrado es 40 ($FE = 2$). Como 25 es menor que 30, es un caso **Izquierda-Izquierda** en el subárbol.
    - **Rotación Simple Derecha** sobre 40.
    - **Estado Final**: Raíz `20`, subárbol derecho `[30]` con hijos `(25, 40)`, y 40 tiene a `50` a su derecha.

---
## 📝 Implementación de Referencia (Extracto)
```cpp
int obtenerBalance(Nodo<T>* n) {
    return n ? obtenerAltura(n->izq) - obtenerAltura(n->der) : 0;
}

Nodo<T>* balancear(Nodo<T>* nodo, T dato) {
    int balance = obtenerBalance(nodo);
    // Casos de rotación: LL, RR, LR, RL...
    // [Implementación detallada en el código fuente del repositorio]
}
```
