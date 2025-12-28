# Mat I - Relación 3: Límites y Continuidad (Oficial UHU)

## 🧠 Conceptos clave
Para que una función sea continua en un punto, los límites laterales deben ser iguales y coincidir con el valor de la función.

*   **Infinitésimos**: Comparar funciones que van a cero.
*   **Teorema de Bolzano**: Si $f$ cambia de signo en $[a,b]$, hay al menos una raíz ($f(c)=0$).
*   **Teorema de Weierstrass**: En un compacto (cerrado y acotado), la función alcanza su máximo y mínimo.

## 📝 Ejercicios de la Relación
1.  **Límite con indeterminación $1^\infty$**: Calcula $\lim_{x \to 0} (1+x)^{1/x}$.
    *   *Truco*: Es la definición del número $e$. Si no te acuerdas, usa la fórmula $e^{\lim (f-1)g}$. $(1+x-1) \cdot (1/x) = 1$. Resultado $e^1 = e$.
2.  **Continuidad con Parámetros**: Halla $k$ para que $f(x) = x^2$ si $x<1$ y $f(x) = kx+1$ si $x \ge 1$ sea continua.
    *   *Límites laterales*: $1^2 = 1$ y $k(1)+1 = k+1$.
    *   *Igualamos*: $1 = k+1 \implies k = 0$.
3.  **Existencia de Raíces**: Demuestra que $\cos(x) = x$ tiene una solución en $[0, \pi/2]$.
    *   *Bolzano*: Sea $g(x) = \cos(x) - x$.
    *   $g(0) = 1 - 0 = 1 > 0$.
    *   $g(\pi/2) = 0 - \pi/2 < 0$.
    *   Como hay cambio de signo, existe un punto donde se cortan.
---
> [!TIP]
> **En el examen**: No te olvides de decir que la función es continua antes de aplicar Bolzano, si no el profesor te quitará puntos.
