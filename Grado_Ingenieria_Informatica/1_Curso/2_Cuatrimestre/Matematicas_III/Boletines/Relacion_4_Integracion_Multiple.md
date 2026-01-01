# Mat III - Relación 4: Integración Múltiple (Oficial UHU)

## 🧠 Integrales Triples y Cambios de Variable
La integración múltiple nos permite calcular volúmenes, centros de masa y momentos de inercia de sólidos complejos.

### 1. Coordenadas Cilíndricas
Ideal para sólidos con simetría axial (cilindros, paraboloides).
- $x = \rho \cos \theta, y = \rho \sin \theta, z = z$
- **Jacoviano**: $|J| = \rho$
- $dV = \rho \, d\rho \, d\theta \, dz$

### 2. Coordenadas Esféricas
Ideal para esferas o conos.
- $x = r \sin \phi \cos \theta$
- $y = r \sin \phi \sin \theta$
- $z = r \cos \phi$
- **Jacoviano**: $|J| = r^2 \sin \phi$
- $dV = r^2 \sin \phi \, dr \, d\phi \, d\theta$

## 📝 Ejercicios Resueltos

1. **Volumen de una Esfera**: Calcula el volumen de una esfera de radio $R$ usando integrales triples.
   *Resolución*: 
   - Límites: $r \in [0, R], \phi \in [0, \pi], \theta \in [0, 2\pi]$.
   - $V = \int_0^{2\pi} \int_0^\pi \int_0^R r^2 \sin \phi \, dr \, d\phi \, d\theta$
   - $V = 2\pi \cdot [-\cos \phi]_0^\pi \cdot [\frac{r^3}{3}]_0^R = 2\pi \cdot 2 \cdot \frac{R^3}{3} = \frac{4}{3}\pi R^3$.

2. **Cilindro Recortado**: Halla el volumen del sólido limitado por $x^2 + y^2 = 4$ y los planos $z=0$ y $z=5$.
   *Resolución*: 
   - Usamos cilíndricas: $\rho \in [0, 2], \theta \in [0, 2\pi], z \in [0, 5]$.
   - $V = \int_0^{2\pi} \int_0^2 \int_0^5 \rho \, dz \, d\rho \, d\theta = 5 \cdot \frac{2^2}{2} \cdot 2\pi = 20\pi u^3$.

3. **Masa de un Sólido**: Un cubo de lado 1 tiene una densidad variable $\sigma(x,y,z) = x+y+z$. Halla su masa.
   *Resolución*: 
   - $M = \int_0^1 \int_0^1 \int_0^1 (x+y+z) dx dy dz = \dots = 3/2$ unidades de masa.

---
> [!TIP]
> Si el dominio tiene $x^2+y^2$ piensa en cilíndricas. Si aparece $x^2+y^2+z^2$ usa esféricas directamente para simplificar el integrando.
