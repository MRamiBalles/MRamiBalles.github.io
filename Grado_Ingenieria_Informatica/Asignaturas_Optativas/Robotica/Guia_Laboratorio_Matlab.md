# Robótica - Guía de Laboratorio (MATLAB)

Esta guía explica el uso de los scripts de MATLAB organizados en las carpetas `Cinematica` y `Control`.

## 1. Cinemática (Cinematica/)
Esta carpeta contiene funciones para calcular la posición y orientación del robot.

### Scripts Clave
- **`Rotacionx.m`, `Rotaciony.m`, `Rotacionz.m`**: Generan las matrices de rotación básicas (3x3) dado un ángulo.
  $$R_x(\alpha) = \begin{bmatrix} 1 & 0 & 0 \\ 0 & \cos\alpha & -\sin\alpha \\ 0 & \sin\alpha & \cos\alpha \end{bmatrix}$$
- **`CinematicoDirecto.m`**: Calcula la posición del efector final ($x, y, z$) dados los ángulos de las articulaciones ($q_1, q_2, \dots$).
- **`inv_kinema_ur3.p`**: Función (compilada) para la Cinemática Inversa del robot UR3. Calcula los ángulos necesarios para alcanzar una posición $(x, y, z)$.
- **`pinta_robot_v3.m`**: Visualizador gráfico del robot en 3D. Útil para verificar visualmente las soluciones cinemáticas.

## 2. Control (Control/)
Scripts para el control de movimiento y trayectorias.

- **`Controlador.m`**: Bucle principal de control. Probablemente implementa un control PID o P para mover las articulaciones a una referencia.
- **`ControladorCabezaRobot.m`**: Script específico para mover una articulación "cabeza" o efector final.

## 3. Prácticas (Prac*.m)
Corresponden a las sesiones de laboratorio:
- **`Prac1.m`**: Introducción a Matrices de Transformación Homogénea (T).
- **`Prac2.m`**: Cinemática Directa (DH).

---
> [!TIP]
> **Uso**: Para correr una simulación, abre `Prac1.m` o `Ejemplo.m` en MATLAB. Asegúrate de añadir la carpeta `Cinematica` al *Path* de MATLAB (`addpath('Cinematica')`) para que los scripts puedan llamar a las funciones de rotación y visualización.
