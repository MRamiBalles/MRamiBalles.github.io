# Mat I - Relación 4: Cálculo Diferencial (Oficial UHU)

## 🧠 Contexto Teórico
Estudio de la tasa de variación de funciones de una variable.

*   **Derivabilidad**: Una función es derivable si existe el límite del cociente incremental.
*   **Teorema del Valor Medio (Lagrange)**: Si $f$ es continua en $[a,b]$ y derivable en $(a,b)$, existe $c \in (a,b)$ tal que $f'(c) = \frac{f(b)-f(a)}{b-a}$.
*   **Polinomio de Taylor**: Aproximación de una función en el entorno de un punto.

## 📝 Ejercicios de la Relación
1.  **Regla de L'Hôpital**: Calcula $\lim_{x \to 0} \frac{e^x - x - 1}{x^2}$.
    *   *Resolución:* Indeterminación $0/0$. Derivando: $\lim \frac{e^x - 1}{2x}$. Otra vez $0/0$: $\lim \frac{e^x}{2} = 1/2$.
2.  **Optimización**: Halla las dimensiones del rectángulo de área máxima que se puede inscribir en un semicírculo de radio $R$.
    *   *Resolución:* Función a maximizar $A(x) = 2x \sqrt{R^2-x^2}$. Derivando e igualando a cero: $x = R/\sqrt{2}$.
3.  **Extremos**: Clasifica los puntos críticos de $f(x) = x^3 - 3x^2$.
    *   *Resolución:* $f'(x) = 3x^2 - 6x = 0 \implies x=0, x=2$. $f''(0) = -6$ (Máx), $f''(2) = 6$ (Mín).
