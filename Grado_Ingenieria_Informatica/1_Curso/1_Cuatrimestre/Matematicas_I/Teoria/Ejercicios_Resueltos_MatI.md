# Ejercicios Resueltos: Matemáticas I (Álgebra y Cálculo)

*Resolución de problemas tipo examen centrados en los bloques de mayor peso.*

## P1. Subespacios Vectoriales (Intersección y Suma)
**Enunciado:** Dados $U = \{ (x,y,z) : x+y+z=0 \}$ y $W = \text{gen}\{ (1,0,0), (0,1,1) \}$, halla la base y dimensión de $U \cap W$.

**Resolución:**
1.  **Ecuaciones de W:** Un vector $(x,y,z) \in W$ si $(x,y,z) = a(1,0,0) + b(0,1,1) = (a, b, b) \implies y=z$.
2.  **Intersección $U \cap W$:** Debe cumplir ambas condiciones:
    *   De U: $x+y+z=0$
    *   De W: $y-z=0 \implies y=z$
3.  **Sustitución:** $x + y + y = 0 \implies x = -2y$.
4.  **Vector genérico:** $(-2y, y, y) = y(-2, 1, 1)$.
**Resultado:** Base $B_{U \cap W} = \{ (-2, 1, 1) \}$, $\dim = 1$.

---

## P2. Diagonalización de Matrices
**Enunciado:** Diagonaliza $A = \begin{pmatrix} 1 & 1 \\ 0 & 2 \end{pmatrix}$. Halla $P$ y $D$.

**Resolución:**
1.  **Polinomio Característico:** $|A - \lambda I| = (1-\lambda)(2-\lambda) - 0 = 0$.
2.  **Autovalores:** $\lambda_1 = 1, \lambda_2 = 2$. (Distintos $\implies$ diagonalizable).
3.  **Autovectores:**
    *   Para $\lambda=1$: $\begin{pmatrix} 0 & 1 \\ 0 & 1 \end{pmatrix} \begin{pmatrix} x \\ y \end{pmatrix} = 0 \implies y=0$. Vector: $(1,0)$.
    *   Para $\lambda=2$: $\begin{pmatrix} -1 & 1 \\ 0 & 0 \end{pmatrix} \begin{pmatrix} x \\ y \end{pmatrix} = 0 \implies x=y$. Vector: $(1,1)$.
**Resultado:** $D = \begin{pmatrix} 1 & 0 \\ 0 & 2 \end{pmatrix}$, $P = \begin{pmatrix} 1 & 1 \\ 0 & 1 \end{pmatrix}$.

---

## P3. Cálculo de Integrales (Fracciones Simples)
**Enunciado:** Resuelve $\int \frac{1}{x^2 - 1} dx$.

**Resolución:**
1.  **Descomposición:** $\frac{1}{(x-1)(x+1)} = \frac{1/2}{x-1} - \frac{1/2}{x+1}$.
2.  **Integración:** $\frac{1}{2} \int \frac{1}{x-1} dx - \frac{1}{2} \int \frac{1}{x+1} dx$.
**Resultado:** $\frac{1}{2} \ln|x-1| - \frac{1}{2} \ln|x+1| + C = \ln \sqrt{\left| \frac{x-1}{x+1} \right|} + C$.

---
> [!IMPORTANT]
> En los exámenes de la UHU, no olvides indicar siempre las hipótesis de los teoremas que uses (ej. "Como la matriz es diagonalizable, existe $P$ tal que...").
