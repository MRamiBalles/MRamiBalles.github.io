# Mat III - Relación 3: Extremos de Funciones (Oficial UHU)

## 🧠 Contexto Teórico
Generalización de los máximos y mínimos a funciones de varias variables.

*   **Puntos Críticos**: Donde el gradiente $\nabla f = 0$.
*   **Hessiana ($H$):** 
    1.  Det($H$) $> 0$ y $f_{xx} > 0 \implies$ Mínimo.
    2.  Det($H$) $> 0$ y $f_{xx} < 0 \implies$ Máximo.
    3.  Det($H$) $< 0 \implies$ Punto de Silla.
*   **Multiplicadores de Lagrange**: Optimización con restricciones $g(x,y)=c$. $\nabla f = \lambda \nabla g$.

## 📝 Ejercicios de la Relación
1.  **Clasificación**: Halla y clasifica los extremos de $f(x,y) = x^2 + y^2 - 2x$.
    *   *Resolución:* $f_x = 2x-2=0 \implies x=1$; $f_y = 2y=0 \implies y=0$. Hessiana: $f_{xx}=2, f_{yy}=2, f_{xy}=0$. Det($H$) = 4. Como $f_{xx} > 0$, es un **Mínimo relativo**.
2.  **Lagrange**: Halla el punto de la recta $x+y=1$ más cercano al origen.
    *   *Resolución:* Minimizar $f(x,y) = x^2 + y^2$ sujeto a $x+y=1$. $\nabla f = (2x, 2y), \nabla g = (1,1)$. $(2x, 2y) = \lambda (1,1) \implies x=y$. Sustituyendo en la restricción: $x+x=1 \implies x=1/2$. Punto $(1/2, 1/2)$.
3.  **Punto de Silla**: Analiza $f(x,y) = x^2 - y^2$.
    *   *Resolución:* Punto crítico $(0,0)$. Hessiana: $f_{xx}=2, f_{yy}=-2, f_{xy}=0$. Det($H$) = -4. Es un **Punto de Silla**.
