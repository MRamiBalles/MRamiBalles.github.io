# Ejercicios Resueltos: Física I

*Problemas clásicos de examen resueltos paso a paso con rigor técnico.*

## P1. Dinámica: Bloque en Plano Inclinado
**Enunciado:** Un bloque de 5kg baja por un plano inclinado 30º con un coeficiente de rozamiento $\mu = 0.2$. Halla la aceleración.

**Resolución:**
1.  **Eje Y (Perpendicular al plano):** $N - P \cdot \cos(30) = 0 \implies N = 5 \cdot 9.8 \cdot \cos(30) = 42.43 N$.
2.  **Fuerza de Rozamiento:** $F_r = \mu \cdot N = 0.2 \cdot 42.43 = 8.49 N$.
3.  **Eje X (Paralelo al plano):** $P \cdot \sin(30) - F_r = m \cdot a$.
    *   $5 \cdot 9.8 \cdot 0.5 - 8.49 = 5 \cdot a$
    *   $24.5 - 8.49 = 5a \implies 16.01 = 5a \implies a = 3.20 m/s^2$.
**Resultado:** $a = 3.20 m/s^2$.

---

## P2. Electrostática: Ley de Gauss
**Enunciado:** Halla el campo eléctrico creado por una corteza esférica conductora de radio $R$ con carga $Q$ en un punto exterior ($r > R$).

**Resolución:**
1.  **Superficie Gaussiana:** Elegimos una esfera concéntrica de radio $r$.
2.  **Flujo:** $\Phi = E \cdot 4\pi r^2$ (por simetría esférica).
3.  **Carga encerrada:** Como $r > R$, la carga encerrada es toda la carga $Q$.
4.  **Aplicando Gauss:** $E \cdot 4\pi r^2 = \frac{Q}{\epsilon_0} \implies E = \frac{Q}{4\pi\epsilon_0 r^2}$.
**Resultado:** El campo en el exterior se comporta como el de una carga puntual situada en el centro.

---

## P3. Circuitos: Leyes de Kirchhoff
**Enunciado:** En una malla con una pila de $V=10V$ y dos resistencias en serie $R_1=2\Omega, R_2=3\Omega$, halla la intensidad.

**Resolución:**
1.  **Ecuación de la malla:** $V - I \cdot R_1 - I \cdot R_2 = 0$.
2.  **Sustitución:** $10 - I(2+3) = 0 \implies 10 = 5I \implies I = 2A$.
**Resultado:** $I = 2A$. La caída de tensión en $R_2$ sería $V_2 = 2 \cdot 3 = 6V$.

---
> [!IMPORTANT]
> **Unidades:** En física, un resultado sin unidades (m, N, A, V) es un resultado incompleto. No lo olvides en el examen.
