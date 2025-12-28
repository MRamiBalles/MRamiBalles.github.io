# Mat I - Relación 5: Cálculo Integral (Oficial UHU)

## 🧠 Contexto Teórico
La integración es el proceso inverso a la derivación (Teorema Fundamental del Cálculo).

*   **Integral Definida**: Representa el área bajo la curva.
*   **Regla de Barrow**: $\int_a^b f(x)dx = F(b)-F(a)$.
*   **Métodos Clave**:
    1.  **Sustitución**: $u = g(x)$.
    2.  **Por Partes**: $\int u dv = uv - \int v du$. (Slogan: "Un Valiente Soldado Vestido De Uniforme").
    3.  **Racionales**: Descomposición en fracciones simples.

## 📝 Ejercicios de la Relación
1.  **Integración por Partes**: Calcula $\int x \ln x dx$.
    *   *Resolución:* $u = \ln x, dv = x dx$. Entonces $du = 1/x dx, v = x^2/2$.
    *   $\int x \ln x dx = \frac{x^2}{2} \ln x - \int \frac{x^2}{2} \cdot \frac{1}{x} dx = \frac{x^2}{2} \ln x - \frac{x^2}{4} + C$.
2.  **Cálculo de Áreas**: Halla el área encerrada entre $y = x^2$ e $y = x$ en el intervalo $[0, 1]$.
    *   *Resolución:* $\int_0^1 (x - x^2) dx = [\frac{x^2}{2} - \frac{x^3}{3}]_0^1 = \frac{1}{2} - \frac{1}{3} = 1/6 u^2$.
3.  **Sustitución**: Resuelve $\int \frac{e^x}{1+e^{2x}} dx$.
    *   *Resolución:* $u = e^x, du = e^x dx$. $\int \frac{1}{1+u^2} du = \text{arctg}(u) = \text{arctg}(e^x) + C$.
