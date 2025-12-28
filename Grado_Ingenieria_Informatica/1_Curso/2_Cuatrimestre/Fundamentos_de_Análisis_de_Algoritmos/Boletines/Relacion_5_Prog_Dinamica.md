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

## 📝 Ejercicio de Examen
Dada una secuencia de matrices con dimensiones $10 \times 100$, $100 \times 5$ y $5 \times 50$, calcule el coste mínimo de multiplicación.
*Resolución*:
1. Multiplicar $(A_1 A_2) A_3$: $(10 \cdot 100 \cdot 5) + (10 \cdot 5 \cdot 50) = 5000 + 2500 = 7500$ operaciones.
2. Multiplicar $A_1 (A_2 A_3)$: $(100 \cdot 5 \cdot 50) + (10 \cdot 100 \cdot 50) = 25000 + 50000 = 75000$ operaciones.
*Conclusión*: La primera opción es el orden óptimo.
