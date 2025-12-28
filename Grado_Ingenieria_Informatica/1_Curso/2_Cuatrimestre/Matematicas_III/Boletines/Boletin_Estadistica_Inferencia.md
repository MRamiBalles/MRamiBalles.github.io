# Matemáticas III - Teoría y Problemas: Inferencia Estadística y Regresión

La Inferencia Estadística es la rama de las matemáticas que permite extraer conclusiones sobre una población a partir de una muestra representativa, cuantificando el grado de incertidumbre mediante niveles de confianza.

## 1. Contrastes de Hipótesis
Procedimiento formal para aceptar o rechazar una afirmación sobre un parámetro poblacional.
- **Hipótesis Nula ($H_0$)**: Representa el estado actual o la ausencia de efecto.
- **Hipótesis Alternativa ($H_1$)**: La afirmación que se desea probar.
- **Errores**:
  - Tipo I ($\alpha$): Rechazar $H_0$ siendo cierta (Nivel de significación).
  - Tipo II ($\beta$): No rechazar $H_0$ siendo falsa.

## 2. Regresión Lineal Simple
Modela la relación entre una variable dependiente ($Y$) y una independiente ($X$) mediante una recta: $Y = \beta_0 + \beta_1 X + \epsilon$.
- **Coeficiente de Correlación ($r$)**: Mide la fuerza de la relación lineal ($[-1, 1]$).
- **Coeficiente de Determinación ($R^2$)**: Proporción de la varianza de $Y$ explicada por el modelo.

## 📝 Problema de Examen: Contraste de Medias
Un profesor de la ETSI sospecha que el tiempo medio de resolución de una práctica ha aumentado respecto al año pasado ($\mu_0 = 12h$). Se toma una muestra de 16 alumnos con una media de $13.5h$ y una desviación estándar de $2h$. Realice el contraste con un nivel de confianza del 95% ($\alpha = 0.05$).

*Resolución*:
- $H_0: \mu = 12$; $H_1: \mu > 12$.
- Estadístico de contraste ($t$ de Student, $n-1=15$ g.l.):
  $t_{exp} = \frac{\bar{x} - \mu}{s / \sqrt{n}} = \frac{13.5 - 12}{2 / 4} = \frac{1.5}{0.5} = 3.0$
- Comparación: $t_{crit}$ para $15$ g.l. y $\alpha=0.05$ es $1.753$.
- Conclusión: Como $t_{exp} > t_{crit}$ ($3.0 > 1.753$), se rechaza $H_0$ con evidencia estadística suficiente.
