# Minería de Datos - Teoría 1: Descubrimiento de Conocimiento en Bases de Datos (KDD)

La Minería de Datos es una etapa dentro del proceso KDD orientada a la extracción de patrones implícitos, previamente desconocidos y potencialmente útiles a partir de grandes volúmenes de datos.

## 1. El Proceso KDD
1. **Selección**: Identificación del conjunto de datos objetivo.
2. **Preprocesamiento**: Limpieza de ruido e inconsistencias.
3. **Transformación**: Consolidación y normalización.
4. **Minería de Datos**: Aplicación de algoritmos para extraer patrones.
5. **Evaluación/Interpretación**: Validación de los resultados mediante métricas de interés.

## 2. Tareas de Minería de Datos
- **Aprendizaje Supervisado (Predictivo)**:
  - **Clasificación**: Asignación de objetos a categorías predefinidas (ej. Árboles de Decisión, SVM).
  - **Regresión**: Predicción de valores numéricos continuos.
- **Aprendizaje No Supervisado (Descriptivo)**:
  - **Clustering**: Agrupamiento de objetos por similitud (ej. K-Means).
  - **Reglas de Asociación**: Identificación de dependencias entre variables (ej. Algoritmo Apriori).

## 3. Métricas de Evaluación
- **Clasificación**: Matriz de Confusión, Precisión, Recall, F1-Score.
- **Asociación**: Soporte, Confianza y Lift.

## 📝 Ejercicio Teórico: El Algoritmo K-Means
Explique por qué el algoritmo K-Means es sensible a la escala de los atributos y proponga una solución.
*Respuesta*: K-Means utiliza la distancia euclídea para asignar puntos a centroides. Si un atributo tiene un rango mucho mayor que otro, dominará el cálculo de la distancia. La solución es aplicar **Normalización** (ej. Min-Max) o **Estandarización** (Z-score) antes de la ejecución del algoritmo.
