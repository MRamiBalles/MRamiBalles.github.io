# Mat II - Relación 2: Aplicaciones Lineales (Oficial UHU)

## 🧠 Contexto Teórico
Una aplicación $f: V \to W$ es lineal si respeta la suma y el producto escalar.

*   **Núcleo ($\text{Ker } f$)**: Vectores de $V$ cuya imagen es el vector nulo de $W$.
*   **Imagen ($\text{Im } f$)**: Conjunto de vectores de $W$ que son imagen de algún vector de $V$.
*   **Teorema de la Dimensión**: $\dim(V) = \dim(\text{Ker } f) + \dim(\text{Im } f)$.

## 📝 Ejercicios de la Relación
1.  **Hallar la Matriz Asociada**: $f: \mathbb{R}^2 \to \mathbb{R}^2$ tal que $f(1,0)=(2,3)$ y $f(0,1)=(4,5)$.
    *   *Resolución:* La matriz en bases canónicas es $A = \begin{pmatrix} 2 & 4 \\ 3 & 5 \end{pmatrix}$.
2.  **Cálculo del Núcleo**: Determina el núcleo de la aplicación anterior.
    *   *Resolución:* Resolvemos $A\mathbf{x} = \mathbf{0} \implies |A| = 10 - 12 = -2 \neq 0$. El sistema es compatible determinado. $\text{Ker } f = \{(0,0)\}$. La aplicación es inyectiva.
3.  **Imagen**: Halla la dimensión de la imagen de $f(x,y,z) = (x+y, x-y, 2x)$.
    *   *Resolución:* Matriz $A = \begin{pmatrix} 1 & 1 & 0 \\ 1 & -1 & 0 \\ 2 & 0 & 0 \end{pmatrix}$. El rango es 2 (filas 1 y 2 L.I.). $\dim(\text{Im } f) = 2$.
