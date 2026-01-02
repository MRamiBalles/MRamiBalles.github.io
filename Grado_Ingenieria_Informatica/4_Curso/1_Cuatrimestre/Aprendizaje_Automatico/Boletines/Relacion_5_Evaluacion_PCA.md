# AA - Relación 5: Preprocesamiento y Evaluación de Modelos (Oficial UHU)

Un modelo de aprendizaje automático es tan bueno como los datos con los que se entrena y el rigor con el que se evalúa.

## 1. Preprocesamiento y Reducción de Dimensionalidad
Antes del entrenamiento, los datos deben ser normalizados para asegurar que todas las características tengan el mismo peso relativo.

### PCA (Análisis de Componentes Principales)
Es una técnica de aprendizaje no supervisado que transforma un conjunto de variables correlacionadas en un número menor de variables no correlacionadas llamadas **Componentes Principales**.
- **Objetivo**: Capturar la máxima varianza posible con la mínima dimensión.
- **Proceso**: Cálculo de la matriz de covarianza y obtención de sus autovectores (ejes) y autovalores (importancia).

## 2. Métricas de Evaluación (Clasificación)
La **Matriz de Confusión** permite desglosar los errores del modelo.

| | Predicho Positivo | Predicho Negativo |
| :--- | :--- | :--- |
| **Real Positivo** | Verdadero Positivo (VP) | Falso Negativo (FN) |
| **Real Negativo** | Falso Positivo (FP) | Verdadero Negativo (VN) |

- **Precisión (Precision)**: $\frac{VP}{VP + FP}$ (De los que dije que eran SI, ¿cuántos lo eran?).
- **Sensibilidad (Recall)**: $\frac{VP}{VP + FN}$ (De todos los que eran SI, ¿cuántos detecté?).
- **F1-Score**: Media armónica entre Precisión y Sensibilidad. Útil para datasets desequilibrados.

## 📝 Ejercicio Técnico: Curvas ROC y AUC
**Enunciado**: ¿Qué indica un valor de AUC (Area Under Curve) de 0.5?
*Respuesta*: Indica que el modelo no tiene capacidad de discriminación; se comporta exactamente igual que el azar (lanzar una moneda). Un modelo perfecto tiene un AUC de 1.0.

## 3. Validación Cruzada (K-Fold Cross-Validation)
Para evitar el sobreajuste y obtener una estimación robusta del rendimiento:
1. Se divide el dataset en $K$ subconjuntos iguales.
2. Se entrena $K$ veces, usando en cada iteración un subconjunto distinto para test y el resto para entrenamiento.
3. El resultado final es el promedio de las $K$ evaluaciones.

---
> [!TIP]
> **Data Leakage (Fuga de Datos)**: Ocurre cuando se utiliza información del conjunto de test durante el preprocesamiento del entrenamiento (ej. calcular la media de normalización sobre todo el dataset en lugar de solo sobre el de train). Es un error crítico que infla artificialmente los resultados.
