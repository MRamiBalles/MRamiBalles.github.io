# Mat II - Relación 5: Formas Cuadráticas y Espacio Euclídeo (Oficial UHU)

## 🧠 El bloque final
Aquí es donde aplicamos las matrices para medir distancias y ángulos.

*   **Producto Escalar**: Operación que nos da un número. Si $\mathbf{u} \cdot \mathbf{v} = 0$, son ortogonales (perpendiculares).
*   **Gram-Schmidt**: El método "tortura" para sacar una base ortonormal a partir de una base cualquiera.
*   **Formas Cuadráticas**: Expresiones del tipo $x^T A x$. Se clasifican por sus autovalores:
    - Todos $+ \implies$ Definida Positiva.
    - Todos $- \implies$ Definida Negativa.
    - Signos mezclados $\implies$ Indefinida.

## 📝 Ejercicios de examen
1.  **Clasificación**: Clasifica la forma $Q(x,y) = x^2 + 4xy + y^2$.
    *   *Matriz asociada*: $A = \begin{pmatrix} 1 & 2 \\ 2 & 1 \end{pmatrix}$.
    *   *Autovalores*: $|A-\lambda I| = (1-\lambda)^2 - 4 = 0 \implies 1-\lambda = \pm 2 \implies \lambda = 3, \lambda = -1$.
    *   *Resultado*: **Indefinida**, ya que hay un autovalor positivo y otro negativo.
2.  **Ortogonalización**: Ortogonaliza $\{ (1,1), (0,1) \}$ usando Gram-Schmidt.
    *   *Paso 1*: $v_1 = (1,1)$.
    *   *Paso 2*: $v_2 = (0,1) - \frac{(0,1) \cdot (1,1)}{\|(1,1)\|^2} (1,1) = (0,1) - \frac{1}{2}(1,1) = (-1/2, 1/2)$.
3.  **Distancias**: Halla la norma (longitud) del vector $(3,4)$.
    *   *Resolución*: $\|v\| = \sqrt{3^2 + 4^2} = \sqrt{25} = 5$.
