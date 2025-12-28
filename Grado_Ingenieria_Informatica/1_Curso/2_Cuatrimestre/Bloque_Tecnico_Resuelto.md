# Ejercicios Resueltos: ED I y Tecnología

*Problemas técnicos sobre lógica de datos y rendimiento de hardware.*

## P1. ED I: Implementación de una Pila (C++)
**Enunciado:** Implementa una clase `Pila` básica usando arrays dinámicos.

```cpp
template <typename T>
class Pila {
private:
    T* datos;
    int tope;
    int capacidad;
public:
    Pila(int n=10) : capacidad(n), tope(-1) { datos = new T[n]; }
    ~Pila() { delete[] datos; }
    void push(T v) { if (tope < capacidad-1) datos[++tope] = v; }
    T pop() { return (tope >= 0) ? datos[tope--] : T(); }
    bool esVacia() { return tope == -1; }
};
```

---

## P2. Tec. Comp: Tiempo de CPU
**Enunciado:** Tenemos un programa de 10^6 instrucciones. El 20% son saltos (4 ciclos) y el 80% son aritméticas (1 ciclo). La CPU corre a 2GHz. Halla el tiempo de ejecución.

**Resolución:**
1.  **CPI Medio:** $(0.20 \cdot 4) + (0.80 \cdot 1) = 0.8 + 0.8 = 1.6$ ciclos/inst.
2.  **Tiempo de ciclo:** $1 / (2 \cdot 10^9) = 0.5 \text{ ns}$.
3.  **T CPU:** $10^6 \cdot 1.6 \cdot 0.5 \cdot 10^{-9} = 0.8 \cdot 10^{-3} = 0.8 \text{ ms}$.
**Resultado:** $0.8$ milisegundos.

---

## P3. Tec. Comp: Memoria Caché
**Enunciado:** Un sistema tiene una caché de mapeo directo con bloques de 16 bytes. ¿A qué bloque de caché va la dirección de memoria 0x002A?

**Resolución:**
1.  $0x2A$ en decimal es $2 \cdot 16 + 10 = 42$.
2.  Tamaño del bloque = 16.
3.  Número de bloque en memoria principal = $42 / 16 = 2$ (parte entera).
4.  Si la caché tiene, por ejemplo, 4 líneas: $2 \pmod 4 = 2$.
**Resultado:** Iría a la línea 2 de la caché.

---
> [!NOTE]
> **ED I:** En el examen de la UHU suelen pedir el recorrido de un árbol (Inorden, Preorden, Postorden). Recuerda: Inorden en un BST te da los elementos ordenados.
