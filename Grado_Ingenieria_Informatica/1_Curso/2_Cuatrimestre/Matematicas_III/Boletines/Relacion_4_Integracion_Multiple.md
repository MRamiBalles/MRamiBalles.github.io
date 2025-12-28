# Mat III - Relación 4: Integración Múltiple (Oficial UHU)

## 🧠 Contexto Teórico
Extensión de la integral a funciones de varias variables para calcular volúmenes y masas.

*   **Teorema de Fubini**: Permite calcular una integral doble como integrales iteradas si el dominio es regular.
*   **Cambio de Variable**: $dx dy = |J| du dv$, donde $|J|$ es el determinante jacobiano.
*   **Coordenadas Polares**: $x = r \cos \theta, y = r \sin \theta$. Jacoviano $|J| = r$.

## 📝 Ejercicios de la Relación
1.  **Integral Doble en Rectángulo**: Calcula $\iint_R xy^2 dA$ donde $R = [0,1] \times [0,2]$.
    *   *Resolución:* $\int_0^1 x dx \cdot \int_0^2 y^2 dy = [\frac{x^2}{2}]_0^1 \cdot [\frac{y^3}{3}]_0^2 = \frac{1}{2} \cdot \frac{8}{3} = 4/3$.
2.  **Cambio a Polares**: Calcula el área de un círculo de radio $R$ usando integrales dobles.
    *   *Resolución:* $\int_0^{2\pi} \int_0^R r dr d\theta = \int_0^{2\pi} \frac{R^2}{2} d\theta = \frac{R^2}{2} \cdot 2\pi = \pi R^2$.
3.  **Volumen**: Halla el volumen bajo el plano $z = 1-x-y$ en el primer octante.
    *   *Resolución:* $\int_0^1 \int_0^{1-x} (1-x-y) dy dx = \dots = 1/6 u^3$.
