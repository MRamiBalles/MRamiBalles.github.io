# FAA - Relación 6: Diseño por Backtracking (Oficial UHU)

La técnica de Backtracking (Vuelta Atrás) se basa en la exploración sistemática del espacio de soluciones mediante un árbol de búsqueda (espacio de estados).

## 🧠 Esquema General (Template C++)
Para resolver un problema por Backtracking, solemos seguir este patrón:

```cpp
void backtracking(Estado actual, int nivel) {
    if (esSolucion(actual)) {
        tratarSolucion(actual);
    } else {
        for (auto opcion : opcionesPosibles) {
            if (esPrometedor(opcion, actual)) {
                aplicar(opcion, actual);
                backtracking(actual, nivel + 1);
                deshacer(opcion, actual); // ¡CRÍTICO!
            }
        }
    }
}
```

## 📝 Ejercicios de la Relación

1. **El Problema de las N-Reinas**
   *Objetivo*: Colocar $N$ reinas en un tablero $N \times N$ sin que se amenacen.
   *Estrategia*:
   - Una reina por fila.
   - Guardar columnas y diagonales ocupadas en arrays booleanos para `esPrometedor` en $O(1)$.

2. **Suma de Subconjuntos**
   *Enunciado*: Dado un conjunto de números, busca un subconjunto que sume exactamente $M$.
   *Poda*: Si la suma actual más el siguiente elemento supera $M$, no seguimos por esa rama (solo si los números son positivos).

3. **Ciclo Hamiltoniano**
   *Enunciado*: En un grafo, encontrar un camino que visite cada vértice exactamente una vez y vuelva al inicio.
   *Coste*: En el peor caso, la complejidad es exponencial $O(2^n)$ o $O(n!)$, ya que exploramos todas las combinaciones.

## 📝 Caso Práctico: Mochila 0/1 (Backtracking)
**Enunciado**: Tenemos objetos con peso y valor. Queremos maximizar el valor sin superar el peso $W$.
**Diferencia con Greedy**: Aquí probamos todas las combinaciones reales (meter/no meter) devolviendo la mejor encontrada.

---
> [!IMPORTANT]
> El Backtracking siempre garantiza encontrar la solución óptima (si existe), pero su coste temporal suele ser inasumible para entradas grandes. Es fundamental aplicar buenas **punciones** (podas) para reducir el espacio de búsqueda.
