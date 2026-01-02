# AA - Relación 4: Redes Neuronales y Deep Learning (Oficial UHU)

El Deep Learning es una subcategoría del Machine Learning basada en Redes Neuronales Artificiales con múltiples capas ocultas, capaces de aprender representaciones jerárquicas de los datos.

## 1. El Perceptrón Multicapa (MLP)
Consiste en una capa de entrada, una o más capas ocultas y una capa de salida. Cada neurona realiza una transformación afín seguida de una **Función de Activación**.

### Funciones de Activación Comunes
- **Sigmoide**: $\sigma(z) = \frac{1}{1+e^{-z}}$. Rango (0, 1). Sufre de desvanecimiento de gradiente.
- **ReLU (Rectified Linear Unit)**: $f(z) = \max(0, z)$. Estándar en capas ocultas por su eficiencia.
- **Softmax**: Utilizada en la capa de salida para clasificación multiclase (proporciona una distribución de probabilidad).

## 2. El Algoritmo de Retropropagación (Backpropagation)
Es la técnica fundamental para entrenar redes. Utiliza la **Regla de la Cadena** para calcular el gradiente de la función de pérdida respecto a cada peso de la red.

### 📝 Trazado Simplificado (Matemáticas del Gradiente)
Para un peso $w_{ij}$ en la capa $l$, el ajuste sigue la regla:
$$\Delta w_{ij} = - \alpha \frac{\partial Loss}{\partial w_{ij}}$$
Descomponiendo por la regla de la cadena:
$$\frac{\partial Loss}{\partial w_{ij}} = \frac{\partial Loss}{\partial out_j} \cdot \frac{\partial out_j}{\partial net_j} \cdot \frac{\partial net_j}{\partial w_{ij}}$$

## 3. Redes Neuronales Convolucionales (CNN)
Diseñadas para procesar datos con estructura de rejilla (imágenes).
- **Capas de Convolución**: Utilizan filtros (kernels) para extraer características espaciales (bordes, texturas).
- **Capas de Pooling (Submuestreo)**: Reducen la resolución espacial, aportando invariancia a pequeñas traslaciones y reduciendo parámetros.

## 4. Redes Neuronales Recurrentes (RNN)
Diseñadas para datos secuenciales (texto, audio, series temporales).
- Poseen conexiones que retroalimentan la información de pasos anteriores (**Memoria**).
- **LSTM (Long Short-Term Memory)**: Variante avanzada que soluciona el problema de la memoria a largo plazo mediante "puertas" (gates).

---
## 📝 Ejercicio Técnico: Cálculo de Salida
**Enunciado**: Dada una neurona con entradas $x_1=0.5, x_2=0.8$, pesos $w_1=0.2, w_2=0.4$ y sesgo (bias) $b=-0.1$. Calcule la salida si se usa una función de activación ReLU.

**Resolución**:
1. Suma ponderada: $z = (0.5 \cdot 0.2) + (0.8 \cdot 0.4) - 0.1$
2. $z = 0.1 + 0.32 - 0.1 = 0.32$
3. Activación: $f(0.32) = \max(0, 0.32) = 0.32$

---
> [!CAUTION]
> **Desvanecimiento de Gradiente (Vanishing Gradient)**: Ocurre cuando los gradientes se vuelven muy pequeños al retropropagarse por muchas capas, impidiendo que los pesos de las primeras capas se actualicen. El uso de ReLU y arquitecturas como ResNet mitigan este problema.
