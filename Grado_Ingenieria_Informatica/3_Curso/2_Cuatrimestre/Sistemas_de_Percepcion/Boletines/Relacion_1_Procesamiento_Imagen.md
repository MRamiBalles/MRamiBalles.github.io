# SP - Relación 1: Procesamiento Digital de Imágenes (Oficial UHU)

Sistemas de Percepción permite que una máquina extraiga información útil de imágenes digitales mediante algoritmos matemáticos que operan sobre la matriz de píxeles.

## 1. Operaciones Puntuales e Histogramas
- **Brillo y Contraste**: Transformación lineal $I' = aI + b$.
- **Ecualización de Histograma**: Técnica para mejorar el contraste distribuyendo uniformemente los niveles de gris.

## 2. Filtrado Espacial (Convolución)
Aplicamos una máscara (kernel) de $N \times N$ sobre cada píxel.
- **Filtro de Media (Box Blur)**: Suavizado, elimina ruido pero emborrona bordes.
- **Filtro Gaussiano**: Suavizado más natural, preserva mejor las estructuras.

### 📝 Ejercicio Técnico: Convolución Manual
**Enunciado**: Dada una imagen de $3 \times 3$ con valores constantes a 100, aplique un filtro de media de $3 \times 3$ (normalizado) sobre el píxel central.
*Respuesta*: La suma de los 9 vecinos es $100 \cdot 9 = 900$. El valor normalizado es $900/9 = 100$. El píxel se mantiene igual (como era de esperar en una imagen uniforme).

## 3. Detección de Bordes (Gradiente)
Los bordes son cambios bruscos de intensidad.
- **Operador Sobel**: Utiliza dos máscaras ($Gx, Gy$) para detectar variaciones horizontales y verticales.
- **Filtro de Canny**: El algoritmo estándar de oro. Incluye supresión de no-máximos y umbralización por histéresis.

### 📝 Ejercicio de Examen: Máscaras de Sobel
Escriba las máscaras de Sobel para detectar bordes verticales ($Gx$).

$$
Gx = \begin{pmatrix}
-1 & 0 & 1 \\
-2 & 0 & 2 \\
-1 & 0 & 1
\end{pmatrix}
$$

---
> [!TIP]
> **Umbralización (Thresholding)**: Es el proceso de convertir una imagen de grises a blanco y negro (binarización). El método de **Otsu** es el más utilizado para encontrar el umbral óptimo automáticamente basándose en el histograma.
