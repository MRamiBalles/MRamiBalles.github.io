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
