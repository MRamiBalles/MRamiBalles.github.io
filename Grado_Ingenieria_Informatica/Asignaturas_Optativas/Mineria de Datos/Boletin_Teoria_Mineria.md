# Minería de Datos - Boletín Teórico: Proceso KDD y Algoritmos

Este boletín cubre los fundamentos teóricos del Descubrimiento de Conocimiento en Bases de Datos (KDD).

## 1. El Proceso KDD (Knowledge Discovery in Databases)
No es un paso único, sino un flujo iterativo:
1.  **Selección**: Elegir los datos relevantes (Target Data).
2.  **Preprocesamiento**: Limpieza de ruido, gestión de nulos (Missing Values).
3.  **Transformación**: Normalización (Min-Max, Z-Score), reducción de dimensionalidad (PCA).
4.  **Minería de Datos**: Aplicación del algoritmo (Clustering, Regresión, Clasificación).
5.  **Interpretación/Evaluación**: Validar si el patrón es útil (Knowledge).

## 2. Reglas de Asociación (Algoritmo Apriori)
Busca relaciones tipo "Si compra pañales, compra cerveza".
- **Soporte**: Frecuencia de la regla en la BD. $Sup(A \to B) = P(A \cup B)$.
- **Confianza**: Fiabilidad de la regla. $Conf(A \to B) = P(B|A)$.
- **Algoritmo**:
    1.  Encontrar items frecuentes (superan soporte mínimo).
    2.  Generar reglas a partir de ellos que superen confianza mínima.
    3.  **Propiedad Apriori**: Si un conjunto es frecuente, todos sus subconjuntos también lo son.

## 3. Clustering (Agrupamiento No Supervisado)
### K-Means
Divide los datos en $k$ grupos (clusters) minimizando la distancia intra-cluster.
**Pasos**:
1.  Elegir $k$ centroides aleatorios.
2.  Asignar cada punto al centroide más cercano.
3.  Recalcular los centroides (media de los puntos asignados).
4.  Repetir hasta convergencia (los centroides no se mueven).

**Problemas**: Sensible a outliers y a la inicialización aleatoria. Requiere fijar $k$ a priori.

## 4. Preprocesamiento: Filtros
- **Discretización**: Convertir variable continua (Edad) en rangos (Joven, Adulto). Útil para algoritmos que solo aceptan nominales (Bayes).
- **Selección de Atributos**: Eliminar atributos redundantes o irrelevantes (CorrelationAttributeEval) para evitar la "maldición de la dimensionalidad".

---
> [!TIP]
> **Validación Cruzada (Cross-Validation)**: En minería supervisada, nunca evalúes el modelo con los mismos datos de entrenamiento. Usa k-fold (ej. 10-fold) para asegurar que el modelo generaliza bien.
