# SI - Relación 1: Aprendizaje por Refuerzo y Redes Neuronales (Oficial UHU)

Sistemas Inteligentes profundiza en algoritmos donde el agente aprende de su propia experiencia (Refuerzo) o de grandes volúmenes de datos (Supervizado).

## 1. Aprendizaje por Refuerzo: Q-Learning
El agente aprende una política óptima mediante recompensas y castigos. La clave es la **Tabla Q(estado, acción)**.

### 📝 Ejercicio Técnico: Trazado de Q-Learning
**Enunciado**: Un agente está en el estado $S_1$ y tiene dos acciones: $A$ (recompensa 0) y $B$ (recompensa 10). Si $\gamma = 0.9$ (factor de descuento) y $\alpha = 0.1$ (tasa de aprendizaje), calcule el nuevo valor de $Q(S_1, B)$ tras ejecutar la acción B, asumiendo que el valor inicial era 0.

**Ecuación**: $Q(s, a) = Q(s, a) + \alpha [R + \gamma \max Q(s', a') - Q(s, a)]$
*Resolución*: 
- $Q(S_1, B) = 0 + 0.1 \cdot [10 + 0.9 \cdot 0 - 0] = 1$.
**Resultado**: El valor de la acción B ha subido a 1, indicando al agente que es una buena decisión.

## 2. Redes Neuronales: El Perceptrón
Es la unidad básica de una red neuronal. Calcula la suma ponderada de sus entradas y aplica una función de activación (ej. Sigmoide o ReLU).

### 📝 Ejercicio de Examen: Lógica con Neuronas
**Enunciado**: Diseñe un perceptrón que simule una puerta **AND**.
- Pesos: $w_1 = 1$, $w_2 = 1$.
- Umbral (Bias): $\theta = 1.5$.
- Función: $1$ si $\sum w_i x_i > \theta$, else $0$.

**Verificación**:
- Entrada (0,0): $0 < 1.5 \implies 0$.
- Entrada (1,0): $1 < 1.5 \implies 0$.
- Entrada (1,1): $2 > 1.5 \implies 1$ (Correcto).

## 3. Algoritmos Genéticos
Inspirados en la evolución natural: Selección, Cruce y Mutación.
- **Cromosoma**: Codificación de la solución.
- **Fitness (Aptitud)**: Qué tan buena es la solución.

---
> [!IMPORTANT]
> **Exploración vs Explotación**: En Q-Learning, la política $\epsilon$-greedy permite al agente elegir a veces acciones al azar (exploración) para no quedarse atrapado en una solución subóptima (explotación).
