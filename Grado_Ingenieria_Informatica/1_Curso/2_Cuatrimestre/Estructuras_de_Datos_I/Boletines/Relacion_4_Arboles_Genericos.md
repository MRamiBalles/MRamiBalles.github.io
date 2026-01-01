# ED I - Relación 4: Árboles Genéricos (Oficial UHU)

Un árbol genérico es aquel donde cada nodo puede tener un número arbitrario de hijos ($n$-ario).

## 🧠 Implementación: Hijo-Izquierdo / Hermano-Derecho
La forma más eficiente de representar un árbol genérico en memoria sin desperdiciar espacio es convertirlo en una estructura binaria especial.

```cpp
template <typename T>
struct NodoG {
    T dato;
    NodoG* hijo_izq;   // Puntero al primer hijo
    NodoG* her_der;    // Puntero al siguiente hermano
};
```

## 📝 Ejercicios de la Relación

1. **Recorrido en Preorden**
   *Algoritmo*: Visitar el nodo, luego recorrer recursivamente a todos sus hijos.
   ```cpp
   void preorden(NodoG* r) {
       if (r) {
           visitar(r->dato);
           preorden(r->hijo_izq);
           preorden(r->her_der);
       }
   }
   ```
   *Nota*: Sorprendentemente, el preorden de un árbol genérico coincide con el preorden de su representación binaria.

2. **Cálculo del Grado**
   *Enunciado*: Halla el número máximo de hijos de cualquier nodo.
   *Estrategia*: Para cada nodo, contar cuántos hermanos tiene su hijo izquierdo. El máximo de esas cuentas es el grado del árbol.

3. **Altura del Árbol**
   *Resolución*: La altura de un árbol genérico es $1 + \max(\text{altura de sus hijos})$. En la representación binaria:
   - `altura(r->hijo_izq)` contribuye a la altura.
   - `altura(r->her_der)` NO contribuye (son nodos del mismo nivel).

## 📝 Ejercicio de Examen: Transformación
**Enunciado**: ¿Cómo se transforma un árbol genérico en uno binario?
**Regla de Oro**:
1. El hijo más a la izquierda del nodo $X$ se convierte en su hijo izquierdo en el árbol binario.
2. El hermano inmediato de $X$ se convierte en su hijo derecho en el árbol binario.

---
> [!IMPORTANT]
> Los árboles genéricos son fundamentales para representar estructuras jerárquicas como el sistema de archivos de un SO o el DOM de una página HTML.
