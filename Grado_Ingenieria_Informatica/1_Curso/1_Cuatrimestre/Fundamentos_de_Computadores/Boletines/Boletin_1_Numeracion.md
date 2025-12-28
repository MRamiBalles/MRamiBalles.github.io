# FC - Boletín 1: Sistemas de Numeración e IEEE 754

## 🧠 Contexto Teórico
La representación de datos es la base del hardware.

*   **Complemento a 2:** $N_{C2} = \text{inv}(N) + 1$. Permite usar sumadores para restar.
*   **IEEE 754:** Estándar para reales. $S | E | M$. Exceso 127 en 32 bits.

## 📝 Ejercicios
1.  **Enteros:** Halla el C2 de -5 en 8 bits.
    *   *Resolución:* $+5 = 00000101$. Invirtiendo: $11111010$. Sumando 1: $11111011$.
2.  **IEEE 754:** Pasa $8.5$ a simple precisión.
    *   *Resolución:* $8.5 = 1000.1_2 = 1.0001 \times 2^3$. $E = 3 + 127 = 130 (10000010_2)$. Mantissa: $0001...$.
3.  **Rangos:** ¿Cuál es el mayor número representable en 16 bits sin signo y con C2?
    *   *Resolución:* Sin signo: $2^{16}-1 = 65535$. C2: $2^{16-1}-1 = 32767$.
