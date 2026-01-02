# Robótica - Boletín de Cinemática: Denavit-Hartenberg

Este boletín cubre la teoría fundamental para describir la geometría de brazos robóticos.

## 1. Matrices de Transformación Homogénea
Una matriz $T$ de $4 \times 4$ combina rotación $R$ y traslación $P$:
$$T = \begin{bmatrix} R_{3\times3} & P_{3\times1} \\ 0_{1\times3} & 1 \end{bmatrix}$$
Permite componer movimientos mediante multiplicación de matrices: $T_{base}^{final} = T_{base}^1 \cdot T_1^2 \cdot \dots \cdot T_{n-1}^{final}$.

## 2. Parámetros de Denavit-Hartenberg (DH)
Estándar para describir la relación entre dos eslabones consecutivos usando 4 parámetros:
1.  **$\theta_i$ (Theta)**: Ángulo de rotación alrededor del eje $z_{i-1}$.
2.  **$d_i$ (D)**: Desplazamiento a lo largo del eje $z_{i-1}$.
3.  **$a_i$ (A)**: Longitud del eslabón a lo largo del eje $x_i$ (distancia común normal).
4.  **$\alpha_i$ (Alpha)**: Ángulo de torsión alrededor del eje $x_i$.

### Matriz de Transición DH
La transformación del sistema $i-1$ al sistema $i$ es:
$$A_i = Rot_z(\theta_i) \cdot Trans_z(d_i) \cdot Trans_x(a_i) \cdot Rot_x(\alpha_i)$$

## 3. Cinemática Directa vs Inversa
- **Directa**: Dados los ángulos $q = [\theta_1, \dots, \theta_n]$, hallar la posición y orientación del extremo. (Fácil, multiplicación de matrices).
- **Inversa**: Dada la posición deseada del extremo $T_{deseada}$, hallar los ángulos $q$. (Difícil, múltiples soluciones, singularidades).

## 📝 Ejercicio: Robot Planar de 2 Grados de Libertad (2-DOF)
Dos eslabones de longitud $L_1$ y $L_2$ en el plano XY.
1.  **Matrices**:
    - $T_0^1 = Rot_z(\theta_1) \cdot Trans_x(L_1)$
    - $T_1^2 = Rot_z(\theta_2) \cdot Trans_x(L_2)$
2.  **Posición Final ($x, y$)**:
    - $x = L_1 \cos(\theta_1) + L_2 \cos(\theta_1 + \theta_2)$
    - $y = L_1 \sin(\theta_1) + L_2 \sin(\theta_1 + \theta_2)$

---
> [!IMPORTANT]
> **Convención**: En DH, el eje $z_i$ siempre es el eje de rotación/deslizamiento de la articulación $i+1$. El eje $x_i$ es perpendicular a $z_{i-1}$ y $z_i$.
