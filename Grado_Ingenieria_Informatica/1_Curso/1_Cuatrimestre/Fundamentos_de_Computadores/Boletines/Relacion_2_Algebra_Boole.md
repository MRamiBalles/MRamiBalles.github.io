# Fundamentos de Computadores - Relación 2: Álgebra de Boole y Funciones Lógicas

Esta unidad profundiza en las estructuras algebraicas aplicadas al diseño de circuitos lógicos y la optimización de expresiones booleanas.

## Fundamentación Teórica

### Axiomas y Teoremas del Álgebra de Boole
El diseño lógico se rige por un conjunto de axiomas (identidad, conmutatividad, distributividad, complementación) y teoremas derivados.
- **Teoremas de De Morgan**: Fundamentales para la transformación de puertas lógicas.
  - $\overline{A + B} = \overline{A} \cdot \overline{B}$
  - $\overline{A \cdot B} = \overline{A} + \overline{B}$
- **Principio de Dualidad**: Toda identidad booleana sigue siendo válida si se intercambian los operadores (+ y $\cdot$) y los elementos neutros (0 y 1).

### Formas Canónicas
- **Primera Forma Canónica (Suma de Productos)**: Basada en minitérminos.
- **Segunda Forma Canónica (Producto de Sumas)**: Basada en maxitérminos.

### Simplificación de Funciones
- **Mapas de Karnaugh (K-Maps)**: Método gráfico para la minimización de funciones de hasta 6 variables.
- **Método de Quine-McCluskey**: Algoritmo tabular para la simplificación sistemática, especialmente útil en funciones con un elevado número de variables.

## Resolución de Problemas Seleccionados

1. **Simplificación Mediante Postulados**
   *Problema*: Simplificar la expresión $F = A \cdot B + A \cdot (B + C) + B \cdot (B + C)$.
   *Resolución*: 
   - $F = A \cdot B + A \cdot B + A \cdot C + B \cdot B + B \cdot C$ (Propiedad Distributiva e Idempotencia)
   - $F = A \cdot B + A \cdot C + B + B \cdot C$
   - $F = A \cdot B + A \cdot C + B \cdot (1 + C)$ (Factor común)
   - $F = A \cdot B + B + A \cdot C = B \cdot (A + 1) + A \cdot C = B + A \cdot C$.

2. **Minimización con Mapas de Karnaugh**
   *Problema*: Minimizar $f(A,B,C,D) = \sum m(0,2,8,10,12,14)$.
   *Resolución*: Al agrupar los minitérminos en el mapa de 4 variables, se observa una adyacencia que permite extraer los factores comunes:
   - Los términos laterales forman un grupo de 4: $\bar{B} \bar{D}$.
   - Los términos de la fila inferior forman un grupo de 4: $A \bar{D}$.
   - Expresión mínima: $f = \bar{B} \bar{D} + A \bar{D} = (A + \bar{B})\bar{D}$.

3. **Implementación con Puertas NAND**
   *Problema*: Implementar una función XOR utilizando únicamente puertas NAND.
   *Metodología*: Aplicación repetida de las leyes de De Morgan para transformar la expresión $A\bar{B} + \bar{A}B$ en una estructura compatible con la lógica NAND.
