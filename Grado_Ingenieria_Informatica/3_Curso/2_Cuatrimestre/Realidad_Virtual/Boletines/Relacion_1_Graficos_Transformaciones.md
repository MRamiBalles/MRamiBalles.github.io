# RV - Relación 1: Gráficos 3D y Transformaciones Homogéneas (Oficial UHU)

La Realidad Virtual se basa en la manipulación de objetos en un espacio tridimensional. Para ello, utilizamos **Coordenadas Homogéneas** (matrices $4 \times 4$) que permiten unificar traslaciones, rotaciones y escalados.

## 1. Transformaciones Básicas
- **Traslación**: Mover un punto $(x, y, z)$ sumando un vector $(tx, ty, tz)$.
- **Escalado**: Multiplicar cada componente por un factor $S$.
- **Rotación**: Girar alrededor de uno de los ejes (X, Y o Z).

## 📝 Ejercicio Técnico: Composición de Transformaciones
**Enunciado**: Se desea aplicar las siguientes operaciones a un objeto en el orden dado:
1. Escalar al doble ($S=2$).
2. Trasladar 5 unidades en el eje X ($tx=5$).

**Resolución**: 
En gráficos, las transformaciones se aplican multiplicando matrices. Si el punto es $P$, el resultado es $P' = T \cdot S \cdot P$.
*Importante*: El orden importa. No es lo mismo escalar y luego trasladar que viceversa.

Matriz Proyectiva Resultante ($M$):
$$
M = \begin{pmatrix}
2 & 0 & 0 & 5 \\
0 & 2 & 0 & 0 \\
0 & 0 & 2 & 0 \\
0 & 0 & 0 & 1
\end{pmatrix}
$$

## 2. La Cámara Virtual
- **View Matrix**: Transforma del mundo al espacio de la cámara.
- **Projection Matrix**: Proyecta el volumen 3D (Frustum) en una imagen 2D (pantalla). Puede ser **Perspectiva** (objetos lejanos son más pequeños) o **Ortográfica** (planos paralelos).

## 3. Optimización: Culling
Para que la RV sea fluida (mínimo 90 FPS), no debemos dibujar lo que no se ve.
- **Backface Culling**: No dibuja las caras traseras de los polígonos.
- **Frustum Culling**: No dibuja lo que queda fuera del campo de visión de la cámara.

---
> [!IMPORTANT]
> **Cuaterniones**: Aunque en este boletín usamos matrices, en la práctica profesional de RV se usan Cuaterniones para las rotaciones para evitar el efecto **Gimbal Lock** (pérdida de un grado de libertad).
