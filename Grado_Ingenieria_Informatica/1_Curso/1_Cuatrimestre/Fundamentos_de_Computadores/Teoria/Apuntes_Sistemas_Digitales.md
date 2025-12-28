# Fundamentos de Computadores: Teoría y Apuntes de Sistemas Digitales

*Apuntes para dominar la base del hardware y la representación de datos.*

## 1. Representación Numérica
En informática, no solo usamos binario puro. Dependiendo de si el número tiene signo o parte decimal, usamos distintos sistemas.

### 1.1. Enteros con Signo
*   **Signo-Magnitud:** El primer bit es el signo (0+, 1-). Problema: Doble cero (+0 y -0).
*   **Complemento a 1 (C1):** Se invierten todos los bits.
*   **Complemento a 2 (C2):** El estándar. Se invierten los bits y se suma 1. Permite restar usando sumadores. 
    *   *Rango*: $[-2^{n-1}, 2^{n-1}-1]$

### 1.2. Coma Flotante (IEEE 754)
Para números reales. El formato de **Precisión Simple (32 bits)** es el más preguntado:
1.  **Bit de Signo (S)**: 1 bit.
2.  **Exponente con exceso (E)**: 8 bits (Exceso 127).
3.  **Mantissa (M)**: 23 bits (bit implícito '1' a la izquierda del punto).

---

## 2. Álgebra de Boole y Diseño Lógico
### 2.1. Puertas Lógicas Universales
*   **NAND** y **NOR** son universales. Cualquier circuito se puede construir *solo* con ellas. Esto es vital para optimizar costes de fabricación de chips.

### 2.2. Simplificación: Mapas de Karnaugh
Es un método gráfico para simplificar funciones booleanas.
*   Se agrupan unos en potencias de 2 (1, 2, 4, 8...).
*   Se busca la combinación más grande posible para eliminar el mayor número de variables.
*   *Clave:* Los grupos pueden "dar la vuelta" por los bordes.

---

## 3. Circuitos Secuenciales
A diferencia de los combinacionales, estos tienen **memoria**. Su estado depende de las entradas actuales y de las anteriores.
*   **Elemento base:** El Biestable (*Flip-flop*).
*   **Tipos comunes:** RS, D (Transfiere la entrada), J-K (Universal), T (Conmuta).

> [!IMPORTANT]
> **Consejo ETSI:** En las tablas de transición de Flip-flops, no olvides marcar el estado de "indiferencia" o "no importa" ($X$) para simplificar las funciones de excitación.
