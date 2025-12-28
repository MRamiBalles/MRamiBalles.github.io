# 🏥 Simulacro de Examen: Matemáticas II (Mat II)
*Nivel: Espacio Euclídeo y Diagonalización*

## ⏱️ Instrucciones
- ¡Recordad que el determinante no es el único dios! Usad Gauss cuando sea más rápido.
- Revisad los signos, el 90% de los fallos en Mat II son por un signo cambiado.

---

### [Ejercicio 1] Espacios Vectoriales y Subespacios (2.5 puntos)
Sea $V = \mathbb{R}^4$ y el subespacio $U$ definido por:
$x + y - z = 0$
$2x - w = 0$
- **a)** Halla una base y la dimensión de $U$.
- **b)** Halla el subespacio ortogonal $U^\perp$.

### [Ejercicio 2] Aplicaciones Lineales (2.5 puntos)
Dada la aplicación $f: \mathbb{R}^3 \to \mathbb{R}^2$ tal que:
$f(x, y, z) = (x+y, y-2z)$
- **a)** Halla la matriz de la aplicación en las bases canónicas.
- **b)** Calcula el núcleo (Kernel) y la imagen. ¿Es inyectiva? ¿Es sobreyectiva?

### [Ejercicio 3] Diagonalización (5 puntos)
Dada la matriz $A$:
$$A = \begin{pmatrix} 1 & 1 & 0 \\ 0 & 2 & 0 \\ 0 & 0 & 1 \end{pmatrix}$$
- **a)** Halla el polinomio característico y los autovalores (valores propios).
- **b)** Halla los autovectores (vectores propios) asociados.
- **c)** ¿Es la matriz $A$ diagonalizable? Razona tu respuesta (multiplicidad geométrica vs algebraica).

---

## 🔑 Soluciones (Brief)
1. **$U$**: Dimensión 2 (4 variables - 2 ecuaciones). Base: $\{(1, -1, 0, 2), (0, 1, 1, 0)\}$ (ejemplo).
2. **Núcleo**: El Ker tiene dimensión 1 ($z$ libre). No es inyectiva porque $Ker \neq \{0\}$. Es sobreyectiva porque $dim(Im) = 2$.
3. **Diagonalización**: Autovalores $\lambda = 1$ (doble) y $\lambda = 2$ (simple). Para $\lambda = 1$, busca si salen 2 vectores independientes. En este caso sí, por tanto ES diagonalizable.
