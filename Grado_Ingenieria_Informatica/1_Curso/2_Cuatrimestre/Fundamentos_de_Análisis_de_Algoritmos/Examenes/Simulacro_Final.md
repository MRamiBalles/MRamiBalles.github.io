# 🏥 Simulacro de Examen: Fundamentos de Análisis de Algoritmos (FAA)
*Nivel: Examen Final (Estrategias de Diseño)*

## ⏱️ Instrucciones
- Tiempo sugerido: 120 minutos.
- Razona todas las respuestas. En FAA, el "qué" importa tanto como el "por qué".

---

### [Ejercicio 1] Esquema Greedy / Ávido (2.5 puntos)
Tienes un conjunto de $n$ tareas, cada una con un beneficio $b_i$ y una fecha límite $d_i$. Todas las tareas tardan 1 unidad de tiempo. Solo puedes trabajar en una tarea a la vez.
- **a)** Propón una estrategia Greedy para maximizar el beneficio total.
- **b)** ¿Es siempre óptima? Pon un contraejemplo si no lo es, o razona su optimalidad.

### [Ejercicio 2] Programación Dinámica (3.5 puntos)
El problema del **Alineamiento de Secuencias**. Dadas dos cadenas $A$ (longitud $n$) y $B$ (longitud $m$), queremos encontrar el coste mínimo para transformarlas (operaciones: insertar, borrar, sustituir).
- **a)** Define la ecuación de recurrencia.
- **b)** ¿Cuál es el orden de complejidad temporal y espacial usando una tabla?
- **c)** ¿Cómo podrías reducir la complejidad espacial a $O(\min(n, m))$?

### [Ejercicio 3] Vuelta Atrás / Backtracking (4 puntos)
El problema del **Ciclo Hamiltoniano**. Dado un grafo de $V$ nodos, queremos ver si hay un camino que visite cada nodo una sola vez y vuelva al origen.
- **a)** Describe el árbol de búsqueda (espacio de estados).
- **b)** Propón una poda (pruning) para evitar explorar ramas inútiles.
- **c)** ¿Qué diferencia hay entre este enfoque y Branch & Bound si tuviéramos pesos en las aristas?

---

## 🔑 Soluciones (Brief)
1. **Planificación de tareas**: La estrategia óptima es ordenar por beneficio decrescientemente e intentar colocar cada tarea lo más tarde posible (en su $d_i$ o antes). Es óptima (Demostración por intercambio).
2. **Edit Distance**: Similar a Levenshtein. $T[i][j] = \min(\dots)$. Complejidad $O(nm)$. Se puede reducir el espacio usando solo dos filas de la tabla.
3. **Backtracking**: Se poda si el nodo actual no tiene aristas hacia nodos no visitados o si no hay arista de vuelta al origen desde el último posible.
