# Mat III - Relación 5: Inferencia y Contrastes de Hipótesis (Oficial UHU)

## 🧠 La Estadística de Verdad
Aquí dejamos de describir datos y empezamos a tomar decisiones. "¿Es verdad que este servidor es más rápido que el otro?".

*   **Hipótesis Nula ($H_0$)**: La que queremos contrastar (suele ser el "no pasa nada" o "son iguales").
*   **Nivel de Significación ($\alpha$)**: Probabilidad de equivocarnos rechazando $H_0$ cuando era verdad (error tipo I). Suele ser 0.05.
*   **p-valor**: Si $p < \alpha$, rechazamos $H_0$. "Si el p-valor es bajo, la nula al carajo".

## 📝 Los ejercicios que caen
1.  **Contraste de Media**: Queremos saber si la media de una CPU es mayor de 3GHz. Tomamos 100 muestras, $\bar{x} = 3.1, \sigma = 0.5$.
    *   *Estadístico*: $Z = \frac{3.1 - 3}{0.5 / \sqrt{100}} = \frac{0.1}{0.05} = 2$.
    *   *Resultado*: Como $2 > 1.64$ (valor crítico para $\alpha=0.05$ una cola), rechazamos la nula. **Sí, es más rápida**.
2.  **Error Tipo II ($\beta$)**: ¿Qué es?
    *   *Resolución*: No rechazar $H_0$ cuando realmente era falsa. Es decir, decir que no hay cambios cuando sí los hay.
3.  **Chi-cuadrado**: Se usa para contrastar si dos variables son independientes (ej. "el fallo del disco depende de la marca").
    *   *Tip*: Construye la tabla de frecuencias esperadas y compara con las observadas.
