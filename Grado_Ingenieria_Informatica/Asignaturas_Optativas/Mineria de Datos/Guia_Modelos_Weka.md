# Minería de Datos: Guía de Modelos Weka (Proyecto Práctico)

Esta guía documenta los modelos predictivos que hemos generado utilizando la herramienta Weka durante las sesiones prácticas de la asignatura. Se incluyen modelos de árboles de decisión, bayesianos y lazy learning.

## 1. Clasificación: Árboles de Decisión (J48)
El algoritmo **J48** es la implementación en Java del clásico C4.5. En nuestro repositorio contamos con los modelos `J48_credit.model` y `J48_vehicle.model`.

Este algoritmo construye árboles de decisión basándose en el criterio de ganancia de información (entropía). Es especialmente útil cuando necesitamos explicar el *por qué* de una decisión, ya que las reglas resultantes son muy legibles (del tipo `SI ingresos > 30k Y edad < 50 ENTONCES conceder_credito`).

## 2. Clasificación Bayesiana (NaiveBayes)
El modelo `NaiveBayes_credit.model` se basa en el Teorema de Bayes, asumiendo (ingenuamente) que todos los atributos son independientes entre sí.

Aunque esta suposición rara vez es cierta en la realidad, el modelo suele comportarse sorprendentemente bien y funciona muy rápido, por lo que lo usamos como *baseline* para comparar con modelos más complejos. La fórmula base es $P(C|X) \propto P(C) \prod P(x_i|C)$.

## 3. Lazy Learning (IBk - kNN)
Tenemos los modelos `ibk10trai.model` y `ibk17.model`. IBk hace referencia a *Instance-Based learning with k neighbors* (k-NN).

A diferencia de los anteriores, este algoritmo no construye un modelo explícito durante el entrenamiento (por eso es "vago" o *lazy*). Simplemente memoriza las instancias y, al llegar una nueva, busca las $k$ más cercanas para votar su clase. El parámetro $k$ es crítico: un valor muy bajo (ej. $k=1$) es sensible al ruido (overfitting), mientras que uno muy alto difumina las fronteras de decisión.

## 4. Reglas Simples (OneR)
El modelo `OneR_credit.model` genera reglas basándose en un único atributo (el que tenga menor tasa de error). Generalmente lo usamos solo para saber cuál es el mínimo rendimiento aceptable. Si nuestro modelo complejo no supera a OneR, algo estamos haciendo mal.

## 5. Support Vector Machines (SMO)
El archivo `smo.model` utiliza el algoritmo *Sequential Minimal Optimization* para entrenar una SVM. Básicamente busca el hiperplano óptimo que separa las clases maximizando el margen entre ellas.

---
> [!NOTE]
> **Sobre los experimentos (.exp)**: Los archivos con extensión `.exp` que aparecen en la carpeta pertenecen al **Experimenter** de Weka. Los usamos para validar estadísticamente (mediante t-tests cruzados) qué modelo funcionaba significativamente mejor que los demás, en lugar de fiarnos solo del porcentaje de acierto de una prueba puntual.
