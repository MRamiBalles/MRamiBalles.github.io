# AA - Relación 3: Árboles de Decisión y Métodos de Ensamblado (Oficial UHU)

Los árboles de decisión son modelos de aprendizaje supervisado no paramétricos que utilizan una estructura jerárquica de nodos para tomar decisiones basadas en las características de los datos.

## 1. Construcción del Árbol: Criterios de División
El objetivo es dividir el dataset de forma que cada partición sea lo más "pura" posible respecto a la variable objetivo.

### Ganancia de Información (Entropía)
La entropía mide el desorden en un conjunto de datos.
$$H(S) = - \sum_{i=1}^{c} p_i \log_2 p_i$$
La **Ganancia de Información** es la reducción de entropía tras realizar una división:
$$IG(S, A) = H(S) - \sum_{v \in Values(A)} \frac{|S_v|}{|S|} H(S_v)$$

### Índice de Gini
Utilizado por el algoritmo CART, mide la probabilidad de clasificar erróneamente un elemento elegido al azar.
$$Gini = 1 - \sum p_i^2$$

## 📝 Ejercicio Técnico: Cálculo de Entropía
**Escenario**: Dataset con 14 muestras: 9 "Sí" (Jugar al tenis) y 5 "No".
**Pregunta**: Calcule la entropía inicial del sistema.

**Resolución**:
$p(+) = 9/14$, $p(-) = 5/14$
$H(S) = - (9/14 \log_2 9/14 + 5/14 \log_2 5/14) \approx 0.940$ bits.

---

## 2. El Problema del Sobreajuste: Podado (Pruning)
Los árboles tienden a crecer hasta memorizar el ruido.
- **Pre-pruning**: Detener el crecimiento si el número de muestras en un nodo es muy bajo.
- **Post-pruning**: Cortar ramas que no aportan una mejora significativa en la precisión de validación.

## 3. Métodos de Ensamblado (Ensemble)
Combinan múltiples modelos débiles para crear uno fuerte.

### Bagging (Random Forest)
- Entrena múltiples árboles de forma independiente usando muestras aleatorias con reemplazo (**Bootstrap**).
- Introduce aleatoriedad en la selección de atributos en cada nodo.
- Resultado: Promedio (regresión) o Votación (clasificación).

### Boosting (XGBoost, AdaBoost)
- Entrena modelos de forma secuencial.
- Cada nuevo modelo intenta corregir los errores de los anteriores asignando más peso a las muestras mal clasificadas.

---
> [!IMPORTANT]
> **Interpretabilidad**: Una gran ventaja de los árboles individuales es su alta interpretabilidad ("Caja Blanca"). Sin embargo, los modelos de ensamblado suelen comportarse como "Cajas Negras", ofreciendo mucha más precisión a cambio de perder la capacidad de visualizar la decisión fácilmente.
