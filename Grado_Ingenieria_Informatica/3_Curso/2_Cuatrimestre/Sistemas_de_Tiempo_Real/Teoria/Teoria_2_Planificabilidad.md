# STR - Teoría 2: Análisis de Planificabilidad y Algoritmos (Oficial UHU)

En sistemas de tiempo real, la corrección del sistema depende del cumplimiento de los plazos (deadlines). El análisis de planificabilidad permite determinar a priori si un conjunto de tareas cumplirá siempre sus plazos bajo un algoritmo dado.

## 1. Modelo de Tareas Periódicas
Una tarea $\tau_i$ se define por la tupla $(C_i, T_i, D_i)$:
- $C_i$: Tiempo de ejecución en el peor caso (WCET).
- $T_i$: Periodo.
- $D_i$: Plazo de ejecución (Deadline). Generalmente $D_i = T_i$.

## 2. Algoritmo Rate Monotonic (RM)
Es un algoritmo de prioridad estática: a menor periodo, mayor prioridad.
- **Condición Suficiente (Liu & Layland)**: Un conjunto de $n$ tareas es planificable si la utilización $U = \sum \frac{C_i}{T_i} \le n(2^{1/n} - 1)$.
- Para $n \to \infty$, el límite de utilización es aproximadamente $0.693$.

## 3. Algoritmo Earliest Deadline First (EDF)
Es un algoritmo de prioridad dinámica: la tarea con el deadline más cercano tiene la mayor prioridad.
- **Condición Necesaria y Suficiente**: Si $D_i = T_i$, el conjunto es planificable si y solo si $U \le 1$.

## 4. Inversión de Prioridad
Ocurre cuando una tarea de alta prioridad es bloqueada por una de baja prioridad que posee un recurso compartido.
- **Protocolo de Techo de Prioridad (PCP)**: Asigna a cada recurso una prioridad igual a la máxima prioridad de las tareas que pueden usarlo. Evita deadlocks e inversión de prioridad encadenada.

## 📝 Ejercicio de Análisis
Dado el siguiente conjunto de tareas:
- $\tau_1(1, 4)$, $\tau_2(2, 6)$, $\tau_3(1, 10)$.
Determine si es planificable mediante RM.

*Resolución*: 
$U = \frac{1}{4} + \frac{2}{6} + \frac{1}{10} = 0.25 + 0.333 + 0.1 = 0.683$.
El límite de Liu & Layland para $n=3$ es $3(2^{1/3} - 1) \approx 0.779$.
Como $0.683 \le 0.779$, el sistema es **planificable** bajo RM.
