# FC - Relación 1: Representación de la Información (Oficial UHU)

## 🧠 Contexto Teórico
La base de la arquitectura de computadores es cómo codificamos los datos en binario.

*   **Sistemas Posicionales**: Binario (base 2), Octal (base 8), Hexadecimal (base 16).
*   **Complemento a 2 (C2)**: Representación de enteros negativos. $N_{C2} = 2^n - |N|$.
*   **IEEE 754**: Coma flotante. Valor $= (-1)^S \cdot 1.M \cdot 2^{E-127}$.

## 📝 Ejercicios de la Relación
1.  **Conversión de Bases**: Pasa el número $175_{10}$ a binario y hexadecimal.
    *   *Resolución:* $175/2 = 87 (r1), 87/2 = 43 (r1), 43/2 = 21 (r1), 21/2 = 10 (r1), 10/2 = 5 (r0), 5/2 = 2 (r1), 2/2 = 1 (r0), 1/2 = 0 (r1)$. Binario: $10101111_2$. Hex: $AF_{16}$.
2.  **Aritmética en C2**: Realiza la operación $7 - 5$ en 8 bits usando Complemento a 2.
    *   *Resolución:* $+7 = 00000111$. $-5 = \text{C2}(00000101) = 11111011$. Al sumar: $00000111 + 11111011 = (1)00000010 = 2_{10}$.
3.  **Análisis IEEE 754**: ¿Qué número representa el patrón `0 10000010 1010...0`?
    *   *Resolución:* $S=0 (+)$. $E = 130 \implies 130-127 = 3$. Mantissa = $1.101_2$. Valor: $1.101 \times 2^3 = 1101_2 = 13_{10}$.
