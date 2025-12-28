# AA - Relación 1: Optimización y Descenso de Gradiente (Oficial UHU)

El aprendizaje automático se fundamenta en la búsqueda de los parámetros de un modelo que minimizan una función de pérdida definida sobre un conjunto de datos.

## 1. Función de Coste ($J(\theta)$)
Mide el error entre la predicción del modelo y el valor real.
- **Error Cuadrático Medio (MSE)**: Utilizado en regresión. $J(\theta) = \frac{1}{2m} \sum (h_\theta(x^{(i)}) - y^{(i)})^2$.

## 2. Descenso de Gradiente (Gradient Descent)
Algoritmo iterativo para encontrar el mínimo global de una función convexa.
- **Regla de Actualización**: $\theta_j := \theta_j - \alpha \frac{\partial}{\partial \theta_j} J(\theta)$, donde $\alpha$ es la **Tasa de Aprendizaje** (learning rate).
- **Tipos**:
  - **Batch**: Usa todos los datos por iteración. Estable pero lento.
  - **Stochastic (SGD)**: Usa un único dato aleatorio por iteración. Rápido pero ruidoso.
  - **Mini-batch**: Equilibrio entre ambos.

## 📝 Ejercicio Técnico: Cálculo de Gradiente
Derive la regla de actualización para una regresión lineal con una variable.
*Resolución*: 
- Sea $h_\theta(x) = \theta_0 + \theta_1 x$.
- $\frac{\partial J}{\partial \theta_0} = \frac{1}{m} \sum (h_\theta(x^{(i)}) - y^{(i)})$
- $\frac{\partial J}{\partial \theta_1} = \frac{1}{m} \sum (h_\theta(x^{(i)}) - y^{(i)}) \cdot x^{(i)}$

## 3. Problemas de Convergencia
- **$\alpha$ muy pequeña**: Convergencia excesivamente lenta.
- **$\alpha$ muy grande**: Puede sobrepasar el mínimo e incluso divergir.
- **Normalización**: Escalar los atributos (0-1) es crítico para que el descenso de gradiente sea eficiente y no se estanque en valles elípticos.
