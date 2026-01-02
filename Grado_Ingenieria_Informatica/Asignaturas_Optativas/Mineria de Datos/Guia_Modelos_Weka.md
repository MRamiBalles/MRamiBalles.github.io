# Minería de Datos: Guía de Modelos Weka (Proyecto Práctico)

Esta guía documenta los modelos predictivos generados en Weka que se encuentran en el repositorio.

## 1. Clasificación: Árboles de Decisión (J48)
El algoritmo **J48** es la implementación en Java de C4.5.
- **Archivos**: `J48_credit.model`, `J48_vehicle.model`.
- **Funcionamiento**: Construye un árbol de decisión basado en la ganancia de información (entropía).
- **Uso**: Ideal para interpretar reglas claras (ej. `SI ingresos > 30k Y edad < 50 ENTONCES conceder_credito`).

## 2. Clasificación Bayesiana (NaiveBayes)
Basado en el Teorema de Bayes con la asunción de independencia entre atributos.
- **Archivos**: `NaiveBayes_credit.model`.
- **Funcionamiento**: $P(C|X) \propto P(C) \prod P(x_i|C)$.
- **Uso**: Muy rápido y robusto, estándar base para comparación.

## 3. Lazy Learning (IBk - kNN)
Aprendizaje basado en instancias (k-Nearest Neighbors).
- **Archivos**: `ibk10trai.model`, `ibk17.model`.
- **Funcionamiento**: No construye un modelo explícito. Clasifica una nueva instancia buscando las $k$ instancias más cercanas en el conjunto de entrenamiento (ej. $k=10, k=17$).
- **Ajuste**: El valor de $k$ es crítico (muy bajo = overfitting, muy alto = suavizado excesivo).

## 4. Reglas Simples (OneR)
Genera reglas basadas en un solo atributo.
- **Archivos**: `OneR_credit.model`.
- **Uso**: Sirve como "baseline". Si un modelo complejo no supera a OneR por mucho, no merece la pena.

## 5. Support Vector Machines (SMO)
Optimización Secuencial Mínima para entrenar SVM.
- **Archivos**: `smo.model`.
- **Funcionamiento**: Busca el hiperplano que maximiza el margen entre clases.

---
> [!NOTE]
> **Extensiones**: Los archivos `.exp` indican que se realizaron experimentos comparativos usando el **Experimenter** de Weka para validar estadísticamente qué modelo funcionaba mejor (t-test cruzado).
