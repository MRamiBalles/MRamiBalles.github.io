# Mat II - Relación 4: Diagonalización (Oficial UHU)

## 🧠 Contexto Teórico
El objetivo es encontrar una base en la que la matriz de un endomorfismo sea la más simple posible (diagonal).

*   **Autovalores ($\lambda$)**: Raíces de $P(\lambda) = |A - \lambda I| = 0$.
*   **Autovectores ($\mathbf{v}$)**: Soluciones de $(A - \lambda I)\mathbf{v} = \mathbf{0}$.
*   **Condición de Diagonalización**: $A$ es diagonalizable si para cada $\lambda_i$, su multiplicidad algebraica ($m_a$) es igual a su multiplicidad geométrica ($m_g$), donde $m_g = \dim(\text{Espacio característico}) = n - \text{rg}(A - \lambda_i I)$.

## 📝 Ejercicios de la Relación
1.  **Cálculo de Autovalores**: Halla los autovalores de $A = \begin{pmatrix} 0 & 1 & 0 \\ 0 & 0 & 1 \\ 0 & 0 & 0 \end{pmatrix}$.
    *   *Resolución:* $|A-\lambda I| = -\lambda^3 = 0 \implies \lambda = 0$ (triple).
2.  **Comprobación de Diagonalización**: ¿Es la matriz anterior diagonalizable?
    *   *Resolución:* $m_a(0) = 3$. $m_g(0) = 3 - \text{rg}(A) = 3 - 2 = 1$. Como $m_g \neq m_a$, **no es diagonalizable**.
3.  **Potencia de una Matriz**: Si $A = PDP^{-1}$, calcula $A^{10}$.
    *   *Resolución:* $A^{10} = (PDP^{-1})^{10} = PD^{10}P^{-1}$. Solo hay que elevar a 10 los elementos de la diagonal de $D$.
