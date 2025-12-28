# FC - Boletín 2: Álgebra de Boole y Karnaugh

## 🧠 Contexto Teórico
Optimización de circuitos mediante lógica formal.

*   **Identidad:** $A+0=A, A\cdot 1=A$.
*   **Karnaugh:** Agrupar unos en potencias de 2. Permite simplificar visualmente.

## 📝 Ejercicios
1.  **Simplificación Algebraica:** Simplifica $A \overline{B} + AB$.
    *   *Resolución:* Sacamos factor común A: $A(\overline{B} + B) = A \cdot 1 = A$.
2.  **Mapa de Karnaugh:** Simplifica $F(A,B,C) = \sum m(0,1,2,3)$.
    *   *Resolución:* En el mapa de 3 variables, los minterms 0,1,2,3 forman un bloque de 4 en la fila de $A=0$. Resultado: $F = \overline{A}$.
3.  **Puertas Universales:** Implementa una NOT usando solo una NAND.
    *   *Resolución:* Puenteando ambas entradas de la NAND. $\overline{A \cdot A} = \overline{A}$.
