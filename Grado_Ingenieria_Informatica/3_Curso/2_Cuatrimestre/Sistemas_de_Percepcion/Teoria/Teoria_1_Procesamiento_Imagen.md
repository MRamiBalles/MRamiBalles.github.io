# Sistemas de Percepción - Teoría 1: Procesamiento Digital de Imágenes (Oficial UHU)

Los Sistemas de Percepción permiten que un computador interprete su entorno mediante la captura y el análisis de señales visuales y sensoriales.

## 1. El Proceso de Visión Artificial
1. **Adquisición**: Captura mediante sensores CCD/CMOS.
2. **Preprocesamiento**: Mejora del contraste, reducción de ruido (Filtros Gaussianos, Mediana).
3. **Segmentación**: Separación de objetos del fondo (Umbralización, Canny, Watershed).
4. **Extracción de Características**: Descriptores de forma, color o textura (HOG, SIFT, SURF).
5. **Reconocimiento**: Clasificación mediante técnicas de IA.

## 2. Operaciones de Filtrado y Convolución
El filtrado espacial se basa en la aplicación de una máscara (kernel) sobre la imagen.
- **Suavizado**: Filtros de media o paso bajo.
- **Realce de Bordes**: Filtros de paso alto o gradientes (Operadores Sobel, Prewitt, Laplace).

## 📝 Ejercicio Técnico: Aplicación de Filtro Sobel
Explique cómo se detectan los bordes verticales en una imagen utilizando el operador de Sobel.
*Respuesta*: Se aplica una convolución con el kernel $G_x = \begin{pmatrix} -1 & 0 & 1 \\ -2 & 0 & 2 \\ -1 & 0 & 1 \end{pmatrix}$. Este operador penaliza los cambios bruscos de intensidad en la dirección horizontal, resaltando así las líneas verticales.

## 3. Visión Estéreo y Profundidad
Cálculo de la disparidad entre dos cámaras (ojo izquierdo y derecho) para triangular la distancia a los objetos, fundamental para la navegación de robots autónomos.

---
*Escuela Técnica Superior de Ingeniería - Universidad de Huelva.*
