# Ejercicios Resueltos: Matemáticas III

*Problemas de probabilidad e inferencia resueltos paso a paso.*

## P1. Probabilidad: Teorema de Bayes
**Enunciado:** Un test de seguridad falla el 1% de las veces si hay un virus y el 5% si no lo hay. El 2% de los archivos tienen virus. Si el test da positivo, ¿cuál es la probabilidad de que realmente haya un virus?

**Resolución:**
*   $P(V) = 0.02, P(\neg V) = 0.98$
*   $P(+|V) = 0.99, P(+|\neg V) = 0.05$
Usamos Bayes:
$P(V|+) = \frac{P(+|V) \cdot P(V)}{P(+|V) \cdot P(V) + P(+|\neg V) \cdot P(\neg V)}$
$P(V|+) = \frac{0.99 \cdot 0.02}{0.99 \cdot 0.02 + 0.05 \cdot 0.98} = \frac{0.0198}{0.0198 + 0.049} = \frac{0.0198}{0.0688} \approx 0.287$
**Resultado:** Aproximadamente un 28.7%.

---

## P2. Distribución Normal
**Enunciado:** El tiempo de respuesta de un servidor sigue una $N(200, 50)$ ms. Halla la probabilidad de que responda en menos de 250ms.

**Resolución:**
Tipificamos la variable $Z = \frac{X - \mu}{\sigma}$.
$P(X < 250) = P(Z < \frac{250 - 200}{50}) = P(Z < \frac{50}{50}) = P(Z < 1)$.
Buscando en las tablas de la Normal N(0,1):
$P(Z < 1) = 0.8413$.
**Resultado:** 84.13%.

---

## P3. Intervalos de Confianza
**Enunciado:** En una muestra de 100 usuarios, la media de tiempo de uso es de 5h con $\sigma = 1h$. Halla el I.C. al 95%.

**Resolución:**
$I.C. = \bar{x} \pm z_{\alpha/2} \cdot \frac{\sigma}{\sqrt{n}}$
*   $\bar{x} = 5, \sigma = 1, n = 100, z_{0.025} = 1.96$
$I.C. = 5 \pm 1.96 \cdot \frac{1}{\sqrt{100}} = 5 \pm 0.196$
**Resultado:** $[4.804, 5.196]$ horas.

---
> [!TIP]
> **Tablas de la Normal:** Recuerda que la tabla suele dar el área a la izquierda ($P(Z < z)$). Si necesitas $P(Z > z)$, usa el complementario $1 - P(Z < z)$.
