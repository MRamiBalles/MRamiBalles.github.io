# Mat II - Relación 3: Matrices y Sistemas de Ecuaciones (Oficial UHU)

## 🧠 Contexto Teórico
Las matrices son la herramienta principal para resolver sistemas lineales y representar transformaciones.

*   **Rango de una matriz**: Número de filas o columnas linealmente independientes.
*   **Teorema de Rouché-Frobenius**: 
    1.  $\text{rg}(A) \neq \text{rg}(A|B) \implies$ Incompatible.
    2.  $\text{rg}(A) = \text{rg}(A|B) = n \implies$ Compatible Determinado.
    3.  $\text{rg}(A) = \text{rg}(A|B) < n \implies$ Compatible Indeterminado.

## 📝 Ejercicios de la Relación
1.  **Sistemas con Parámetros**: Discute según $k$: $x+y=1, x+ky=2$.
    *   *Resolución:* $|A| = k-1$. Si $k \neq 1$, S.C.D. Si $k=1$, $\text{rg}(A)=1$ pero $\text{rg}(A|B)=2$ (filas $(1,1,1)$ y $(1,1,2)$ paralelas), S.I.
2.  **Inversa por Gauss-Jordan**: Calcula la inversa de $\begin{pmatrix} 1 & 2 \\ 3 & 4 \end{pmatrix}$.
    *   *Resolución:* $[A | I] = \begin{pmatrix} 1 & 2 | 1 & 0 \\ 3 & 4 | 0 & 1 \end{pmatrix} \to ... \to \begin{pmatrix} 1 & 0 | -2 & 1 \\ 0 & 1 | 1.5 & -0.5 \end{pmatrix}$. Inversa $A^{-1} = \begin{pmatrix} -2 & 1 \\ 1.5 & -0.5 \end{pmatrix}$.
3.  **Determinantes**: Propiedades de los determinantes (fila nula, filas proporcionales, etc).
