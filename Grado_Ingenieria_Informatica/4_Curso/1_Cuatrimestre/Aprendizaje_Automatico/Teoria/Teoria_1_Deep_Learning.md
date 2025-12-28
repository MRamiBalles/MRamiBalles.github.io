# AA - Teoría 1: Optimización y Redes Neuronales Profundas (Oficial UHU)

El Aprendizaje Automático (ML) actual se fundamenta en la optimización de funciones de pérdida mediante algoritmos de gradiente en arquitecturas neuronales complejas.

## 1. El Perceptrón Multicapa (MLP)
Extensión del perceptrón simple que permite resolver problemas no linealmente separables (ej. XOR) mediante la introducción de capas ocultas y funciones de activación no lineales (ReLU, Sigmoide, Tanh).

## 2. Algoritmo de Retropropagación (Backpropagation)
Es el mecanismo fundamental para el entrenamiento. Utiliza la regla de la cadena para calcular el gradiente de la función de pérdida con respecto a cada peso de la red, permitiendo la actualización de los mismos mediante Descenso de Gradiente Estocástico (SGD).

## 3. Regularización y Sobreajuste (Overfitting)
Capacidad de la red para generalizar a datos no vistos.
- **L1/L2 Regularization**: Añade una penalización a la magnitud de los pesos.
- **Dropout**: Desactiva neuronas aleatoriamente durante el entrenamiento para evitar co-dependencias.

## 4. Deep Learning Avanzado
- **Redes Convolucionales (CNN)**: Especializadas en datos espaciales (imágenes).
- **Redes Recurrentes (RNN/LSTM)**: Especializadas en datos secuenciales (texto, series temporales).

## 📝 Formulación Técnica
La función de pérdida para una regresión logística multiclasa (Softmax) viene dada por la Entropía Cruzada:
$$L = -\sum y_i \log(\hat{y}_i)$$
Donde $\hat{y}_i$ es la probabilidad predicha para la clase $i$.

*Pregunta Crítica*: ¿Por qué la función ReLU ayuda a mitigar el problema del "Vanishing Gradient" en redes muy profundas en comparación con la Sigmoide?
*Respuesta*: Porque la derivada de ReLU es 1 para valores positivos, permitiendo que el gradiente fluya sin disminuir exponencialmente capa tras capa, a diferencia de la Sigmoide cuya derivada máxima es 0.25.
