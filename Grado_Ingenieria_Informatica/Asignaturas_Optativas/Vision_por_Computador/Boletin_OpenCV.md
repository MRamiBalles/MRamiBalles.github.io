# Visión por Computador - Boletín: Fundamentos de Procesamiento de Imágenes (OpenCV)

Este documento resume los conceptos de procesamiento de bajo nivel que hemos visto en teoría, aplicados ahora con la librería OpenCV (Python), complementando así los scripts de MATLAB que tenemos para la parte de clasificación.

## 1. Espacios de Color e Histogramas
Es fundamental entender cómo representa el ordenador el color.
- **RGB vs HSV**: Habitualmente trabajamos en RGB, pero para visión artificial es terrible porque mezcla información de color e iluminación. Si quieres detectar un objeto rojo y le da una sombra, el valor RGB cambia totalmente. En cambio, en **HSV** (Hue, Saturation, Value), el color (Hue) se mantiene constante aunque cambie la iluminación (Value). Usad siempre HSV para segmentar colores.
- **Ecualización del Histograma**: Es un truco muy útil cuando una imagen tiene poco contraste (muy oscura o muy lavada). Redistribuye las intensidades para aprovechar todo el rango dinámico.

## 2. Filtrado y Suavizado (Eliminación de Ruido)
Antes de detectar nada, hay que limpiar la imagen.
- **Filtro Gaussiano**: Es el más suave. Básicamente desenfoca la imagen (`cv2.GaussianBlur`) para eliminar el ruido aleatorio (gaussiano).
- **Filtro de Mediana**: Este es "magia" contra el ruido tipo "sal y pimienta" (puntitos blancos y negros). Reemplaza cada píxel por la mediana de sus vecinos, lo que elimina el punto de ruido sin borronear los bordes del objeto.

## 3. Detección de Bordes (Canny)
El algoritmo de Canny es el estándar de facto. No es un simple filtro, es un proceso en pasos:
1.  **Suavizado**: Primero limpia el ruido (Gaussiano).
2.  **Gradiente**: Calcula dónde cambia la intensidad bruscamente (usando Sobel).
3.  **Supresión de No Máximos**: "Adelgaza" los bordes para que tengan solo 1 píxel de ancho (se queda con el pico de intensidad).
4.  **Histéresis**: Usa dos umbrales. Si un borde es muy fuerte ($>T_{alto}$), lo acepta. Si es débil, solo lo acepta si está tocando a uno fuerte. Esto permite cerrar contornos.

## 4. Operaciones Morfológicas
Son operaciones matemáticas basadas en la forma, aplicadas sobre imágenes binarias (blanco y negro).
- **Erosión**: "Come" píxeles del borde. Ideal para separar objetos que están tocándose levemente o eliminar ruido pequeño.
- **Dilatación**: Lo contrario, añade píxeles. Sirve para rellenar agujeros dentro de un objeto.
- **Apertura (Opening)**: Erocionas y luego dilatas. Elimina el ruido externo (motas de polvo) sin cambiar el tamaño del objeto.
- **Cierre (Closing)**: Dilatas y luego erosionas. Cierra esos pequeños agujeros negros dentro de tu objeto blanco.

---
> [!TIP]
> **OpenCV (Python)**: Es la librería estándar de la industria. Mientras que MATLAB es excelente para prototipar algoritmos matemáticos (como tus scripts de LDA/KNN), OpenCV es lo que usarás en producción para tiempo real.
