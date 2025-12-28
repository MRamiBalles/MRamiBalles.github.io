# Ejercicios Resueltos: Fundamentos de Computadores

*Problemas resueltos paso a paso siguiendo el modelo de examen de la UHU.*

## P1. Conversión a IEEE 754 (Precisión Simple)
**Enunciado:** Representa el número decimal $-22.625$ en el estándar IEEE 754 de 32 bits.

**Resolución:**
1.  **Signo:** Es negativo $\implies S = 1$.
2.  **Pasar a binario (Valor absoluto 22.625):**
    *   $22 = 10110_2$
    *   $0.625 = 0.5 + 0.125 = 2^{-1} + 2^{-3} = .101_2$
    *   Total: $10110.101_2$
3.  **Normalizar:** Corremos la coma 4 posiciones a la izquierda.
    *   $1.0110101 \times 2^4$
4.  **Exponente (E):** Exceso 127.
    *   $E = 4 + 127 = 131$
    *   $131$ en binario: $10000011_2$ (8 bits).
5.  **Mantissa (M):** Los bits a la derecha del punto.
    *   $0110101$ y rellenamos con ceros hasta 23 bits.

**Resultado Final:**
`1 | 10000011 | 01101010000000000000000`

---

## P2. Simplificación por Karnaugh (NAND-only)
**Enunciado:** Simplifica $F(A,B,C) = \sum m(1, 3, 4, 5, 6, 7)$ e impleméntala usando solo puertas NAND.

**Resolución:**
1.  **Mapa de Karnaugh (3 variables):**
    *   Grupo 1 (4 unos): $A=1$ (Filas de abajo). Término: $A$.
    *   Grupo 2 (2 unos): Columna de $BC = 01$ y $11$. Término: $C$.
2.  **Función Simplificada:** $F = A + C$.
3.  **Paso a NAND:** Usamos las leyes de De Morgan.
    *   $A + C = \overline{\overline{A+C}} = \overline{\overline{A} \cdot \overline{C}}$
    *   Implementación: Invertimos A con una NAND puenteada, invertimos C con otra NAND, y metemos ambas a una tercera NAND.

---

## P3. Diseño de un Contador (Lógica Secuencial)
**Enunciado:** Diseña un contador síncrono que siga la secuencia 0 -> 2 -> 3 -> 0 usando biestables tipo D.

**Resolución:**
1.  **Tabla de Estados (Presente -> Siguiente):**
    *   $00 \to 10$
    *   $10 \to 11$
    *   $11 \to 00$
    *   $01$ (Estado no usado) $\to XX$ (Indiferencia)
2.  **Ecuaciones de Excitación (Para Biestable D, $D = Q_{next}$):**
    *   $D_1 = (Q_1 \cdot \overline{Q_0}) \implies$ Simplificando con el estado $01$: $D_1 = \overline{Q_0}$.
    *   $D_0 = Q_1 \cdot \overline{Q_0}$.
3.  **Circuito:** Conectamos las salidas $Q$ a la lógica combinacional para alimentar las entradas $D$.

---
> [!TIP]
> **IEEE 754:** Recuerda que el exponente 00000000 (cero) y 11111111 (todo unos) están reservados para casos especiales (Cero, Infinito, NaN).
