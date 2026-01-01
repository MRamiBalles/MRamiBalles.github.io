# FAA - Relación 5: Programación Dinámica

La Programación Dinámica es una técnica de diseño de algoritmos que resuelve problemas complejos descomponiéndolos en subproblemas solapados. A diferencia de "Divide y Vencerás", esta técnica evita la redundancia mediante la memorización o tabulación de resultados.

## 1. Requisitos para la Aplicación
1. **Subestructura Óptima**: La solución al problema original puede construirse eficientemente a partir de las soluciones óptimas de sus subproblemas.
2. **Subproblemas Solapados**: El espacio de subproblemas es pequeño, y los mismos subproblemas se resuelven repetidamente.

## 2. Metodología de Resolución
- **Enfoque Top-Down (Memoization)**: Resolución recursiva con almacenamiento de resultados para evitar recomputaciones.
- **Enfoque Bottom-Up (Tabular)**: Resolución iterativa que rellena una tabla de menor a mayor complejidad de subproblema.

## 📝 Aplicación Técnica: Multiplicación de Cadenas de Matrices
El objetivo es determinar el orden óptimo de paréntesis para minimizar el número de multiplicaciones escalares.
- **Ecuación de Recurrencia**: 
  $m[i,j] = \min_{i \le k < j} \{ m[i,k] + m[k+1,j] + p_{i-1}p_kp_j \}$
  Donde $p$ define las dimensiones de las matrices.

## 📝 Problema Clásico: El Cambio de Monedas
**Enunciado**: Dado un sistema de monedas con valores $V = \{v_1, v_2, \dots, v_n\}$ y una cantidad $C$, determine el número mínimo de monedas necesarias para obtener el cambio exacto.

### Ecuación de Recurrencia
Sea $f(i, j)$ el número mínimo de monedas para obtener la cantidad $j$ utilizando las $i$ primeras monedas:
$$
f(i, j) = \begin{cases} 
f(i-1, j) & \text{si } v_i > j \\
\min(f(i-1, j), 1 + f(i, j - v_i)) & \text{si } v_i \le j 
\end{cases}
$$

### Ejercicio Práctico
Sistema de monedas: $\{1, 4, 6\}$. Cantidad a devolver: $8$.
**Tabla de resolución**:

| Moneda / Cant | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **{1}** | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
| **{1, 4}** | 0 | 1 | 2 | 3 | 1 | 2 | 3 | 4 | 2 |
| **{1, 4, 6}** | 0 | 1 | 2 | 3 | 1 | 2 | 1 | 2 | 2 |

**Resultado**: Se necesitan **2 monedas** (dos monedas de 4, o una de 6 y dos de 1... espera, revisemos: $4+4=8$ (2 monedas); $6+1+1=8$ (3 monedas). El óptimo es con dos de 4).

---
> [!TIP]
> En los exámenes de la UHU, si te piden reconstruir la solución (qué monedas has usado), debes guardar en una tabla auxiliar los índices de las decisiones tomadas o recorrer la tabla principal hacia atrás.
