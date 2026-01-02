# Robótica - Guía de Laboratorio (MATLAB)

En este documento se detalla el funcionamiento de los scripts de MATLAB desarrollados durante las prácticas. El código se ha organizado en dos carpetas principales: `Cinematica` y `Control`.

## 1. Cinemática (Cinematica/)
Aquí se encuentran las funciones necesarias para resolver la geometría del movimiento del robot.

### Scripts Clave
- **Matrices de Rotación (`Rotacionx.m`, `Rotaciony.m`, `Rotacionz.m`)**:
  Implementación directa de las matrices de rotación básicas (3x3). Por ejemplo, para una rotación en X:
  $$R_x(\alpha) = \begin{bmatrix} 1 & 0 & 0 \\ 0 & \cos\alpha & -\sin\alpha \\ 0 & \sin\alpha & \cos\alpha \end{bmatrix}$$

- **`CinematicoDirecto.m`**:
  Esta función recibe como entrada los ángulos de las articulaciones ($q_1, q_2, \dots$) y devuelve la posición $(x, y, z)$ del efector final. Es fundamental para saber dónde está el robot.

- **`inv_kinema_ur3.p`**:
  Función compilada para la **Cinemática Inversa** del robot colaborativo UR3. Hace lo contrario: le damos una posición destino $(x, y, z)$ y nos devuelve los ángulos necesarios para alcanzarla. *Nota: Recuerda que puede devolver múltiples soluciones (codo arriba/abajo).*

- **`pinta_robot_v3.m`**:
  Nuestra utilidad de visualización favorita. Pinta el esqueleto del robot en una figura 3D de MATLAB, lo cual es vital para debugear antes de probar en el robot real.

## 2. Control (Control/)
Scripts enfocados en el movimiento y seguimiento de trayectorias.

- **`Controlador.m`**: Contiene el bucle de control principal. Implementa un esquema clásico (probablemente P o PID) para minimizar el error entre la posición actual y la referencia.
- **`ControladorCabezaRobot.m`**: Una variante específica para controlar la orientación del efector final.

## 3. Prácticas (Prac*.m)
Corresponden a los ejercicios realizados sesión a sesión:
- **`Prac1.m`**: Primera toma de contacto con las Matrices de Transformación Homogénea (T).
- **`Prac2.m`**: Resolución completa de la Cinemática Directa usando parámetros DH.

---
> [!TIP]
> **Consejo de Ejecución**: Si vas a correr `Prac1.m` o `Ejemplo.m`, asegúrate de que la carpeta `Cinematica` está en el *Path* de MATLAB (`addpath('Cinematica')`). Si no, MATLAB te dirá que no encuentra las funciones de rotación.
