# AA - Relación 2: Modelos de Clasificación y Clasificadores Nucleares (Oficial UHU)

La clasificación es una tarea de aprendizaje supervisado donde el objetivo es predecir una etiqueta discreta a partir de un vector de características.

## 1. Regresión Logística
A pesar de su nombre, es un modelo de clasificación binaria que utiliza la función sigmoide: $g(z) = \frac{1}{1 + e^{-z}}$.
- **Interpretación**: Proporciona el grado de confianza (probabilidad) de que una muestra pertenezca a la clase positiva.

## 2. Máquinas de Vector de Soporte (SVM)
Buscan el hiperplano que maximiza el margen entre clases.
- **Vectores de Soporte**: Muestras que definen el margen.
- **Truco del Kernel (Kernel Trick)**: Permite proyectar los datos a un espacio de mayor dimensión para resolver problemas no lineales sin calcular explícitamente dicha proyección.

## 📝 Ejercicio Teórico: Bias vs Variance
Explique el concepto de Sobreajuste (*Overfitting*) en términos de sesgo y varianza.
*Respuesta*: 
- **Alto Sesgo (Underfitting)**: El modelo es demasiado simple y no captura la estructura de los datos (ej. recta para datos parabólicos). Error alto en entrenamiento y test.
- **Alta Varianza (Overfitting)**: El modelo es demasiado complejo y "memoriza" el ruido del entrenamiento. Error muy bajo en entrenamiento pero muy alto en datos nuevos (test).

## 3. Regularización ($L_1, L_2$)
Tecnica para combatir el sobreajuste penalizando los pesos altos en la función de coste.
- **Ridge ($L_2$)**: Añade $\lambda \sum \theta_j^2$.
- **Lasso ($L_1$)**: Añade $\lambda \sum |\theta_j|$. Útil para la selección de atributos ya que tiende a anular pesos no importantes.
