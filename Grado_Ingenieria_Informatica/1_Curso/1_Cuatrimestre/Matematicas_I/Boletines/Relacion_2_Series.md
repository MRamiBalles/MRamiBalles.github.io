# Mat I - Relación 2: Sucesiones y Series (Oficial UHU)

## 🧠 ¿Esto converge?
El objetivo es saber si una suma infinita de números da un valor finito o se va al infinito.

*   **Sucesiones**: Límites de $a_n$. Criterio de Stolz (el L'Hôpital de las sucesiones).
*   **Series de Términos Positivos**:
    1.  **Criterio del Cociente (D'Alembert)**: Si $\lim |a_{n+1}/a_n| < 1$, converge.
    2.  **Criterio del Raíz (Cauchy)**: $\sqrt[n]{a_n}$.
    3.  **Comparación**: Comparas con la serie armónica $1/n^p$ (converge si $p>1$).

## 📝 Ejercicios de la Relación
1.  **Criterio de Stolz**: Calcula $\lim \frac{1+2+...+n}{n^2}$.
    *   *Resolución*: Restamos arriba y abajo: $\frac{(n+1)}{(n+1)^2 - n^2} = \frac{n+1}{2n+1} \to 1/2$.
2.  **Convergencia de Serie**: ¿Es convergente $\sum \frac{n!}{n^n}$?
    *   *Criterio del Cociente*: $\frac{(n+1)!}{(n+1)^{n+1}} \cdot \frac{n^n}{n!} = \frac{n+1}{(n+1)(n+1)^n} \cdot n^n = (n/(n+1))^n \to 1/e$.
    *   *Resultado*: Como $1/e < 1$, **es convergente**.
3.  **Serie Geométrica**: Suma de $1 + 1/2 + 1/4 + ...$.
    *   *Fórmula*: $S = a / (1-r)$. Aquí $a=1, r=1/2$, por tanto $S = 1 / (0.5) = 2$.
