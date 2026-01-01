# Fundamentos de Computadores - Relación 3: Bloques Combinacionales

El diseño combinacional se enfoca en circuitos cuyas salidas dependen exclusivamente de los valores actuales de sus entradas en un instante dado.

## Fundamentación Teórica

### Bloques de Procesamiento de Datos
- **Codificadores y Decodificadores**: Traducción entre representaciones binarias (ej. binario a 7 segmentos).
- **Multiplexores (MUX) y Demultiplexores (DEMUX)**: Selección y enrutamiento de señales de datos bajo el control de señales de selección.
- **Comparadores**: Determinación de relaciones de igualdad o magnitud entre dos palabras binarias.

### Bloques Aritméticos
- **Semisumador (Half-Adder)** y **Sumador Completo (Full-Adder)**.
- **Unidad Lógica Aritmética (ALU)**: Bloque fundamental capaz de realizar múltiples operaciones aritméticas y lógicas.

## Resolución de Problemas Seleccionados

1. **Diseño de un Sumador de 4 Bits (Ripple Carry Adder)**
   *Problema*: Interconexión de sumadores completos para procesar palabras de 4 bits.
   *Concepto Crítico*: El retardo de propagación del acarreo ($C_{out}$) limita la frecuencia máxima de operación del circuito. Para mitigar esto, en diseños avanzados se utilizan sumadores con anticipación de acarreo (Carry Look-Ahead).

2. **Implementación de Funciones Lógicas con Multiplexores**
   *Problema*: Utilizar un MUX de 8 a 1 para implementar la función $f(A,B,C,D) = \sum m(0,1,3,4,8,9,15)$.
   *Metodología*: Se utilizan las variables $A, B, C$ como señales de selección y se conecta la variable $D$ o sus constantes (0, 1) a las entradas de datos según la tabla de verdad.

3. **Decodificadores de Siete Segmentos**
   *Problema*: Diseño de la lógica para el segmento 'a' de un visualizador LED basado en una entrada BCD de 4 bits.
   *Resolución*: Definición de minitérminos para los dígitos 0-9 y tratamiento como "don't care" (X) para los valores 10-15 para optimizar el área del circuito.

## 📝 Proyecto de Diseño: Implementación de una ALU de 4 Bits
**Objetivo**: Diseñar una Unidad Lógica Aritmética capaz de realizar 4 operaciones básicas (SUMA, RESTA, AND, OR) mediante el uso de sumadores y multiplexores.

### Especificaciones Técnicas
- **Entradas**: Dos palabras de 4 bits ($A, B$).
- **Seleccion de Operación ($S_1, S_0$)**:
  - `00`: AND ($A \cdot B$)
  - `01`: OR ($A + B$)
  - `10`: SUMA ($A + B$)
  - `11`: RESTA ($A - B$)

### Metodología de Diseño
1. **Unidad Aritmética**: Uso de un Sumador de 4 bits. Para la resta, se utiliza una puerta XOR para negar $B$ y se introduce un 1 en el acarreo inicial ($C_{in}$) para realizar el Complemento a 2.
2. **Unidad Lógica**: Implementación en paralelo de las puertas AND y OR para cada bit.
3. **Selector de Salida**: Un Multiplexor de 4 a 1 por cada bit de salida para escoger entre los resultados lógico y aritmético.

---
> [!TIP]
> En Logisim, puedes agrupar este diseño en un solo bloque (Subcircuit) para simplificar el diseño de una CPU completa más adelante.
