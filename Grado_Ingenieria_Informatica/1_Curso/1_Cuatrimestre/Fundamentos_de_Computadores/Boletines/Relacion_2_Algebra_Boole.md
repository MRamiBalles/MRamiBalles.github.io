# FC - Relación 2: Álgebra de Boole y Funciones (Oficial UHU)

## 🧠 Contexto Teórico
El álgebra de Boole proporciona las leyes para manipular variables lógicas (0 y 1).

*   **Postulados Básicos**: Identidad, Conmutativa, Distributiva, Complemento.
*   **Teoremas de De Morgan**: $\overline{A+B} = \overline{A}\overline{B}$ y $\overline{AB} = \overline{A}+\overline{B}$.
*   **Formas Canónicas**: Suma de Productos (minterms) y Producto de Sumas (maxterms).

## 📝 Ejercicios de la Relación
1.  **Simplificación por Identidades**: Simplifica $F = AB + A\overline{B} + \overline{A}B$.
    *   *Resolución:* $A(B+\overline{B}) + \overline{A}B = A(1) + \overline{A}B = A + B$ (por teorema de absorción).
2.  **Conversión a NAND**: Expresa $F = AB + C$ usando solo puertas NAND.
    *   *Resolución:* $\overline{\overline{AB+C}} = \overline{\overline{AB} \cdot \overline{C}}$. Necesitamos una NAND para $AB$, y otra para combinar con $\overline{C}$.
3.  **Obtención de Función**: Dada una tabla de verdad con unos en (0, 2, 3), escribe la función como suma de minterms.
    *   *Resolución:* $F(x,y,z) = \sum m(0, 2, 3) = \overline{x}\overline{y}\overline{z} + \overline{x}y\overline{z} + \overline{x}yz$.
