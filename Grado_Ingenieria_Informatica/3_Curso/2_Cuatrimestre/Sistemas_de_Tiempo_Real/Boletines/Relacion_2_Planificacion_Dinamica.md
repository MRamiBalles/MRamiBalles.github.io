# STR - Relación 2: Planificación Dinámica RM y EDF (Oficial UHU)

La planificación dinámica permite una mayor flexibilidad al asignar prioridades en tiempo de ejecución, basándose en parámetros temporales de las tareas.

## 1. Rate Monotonic (RM)
Planificador de prioridad estática: mayor prioridad a menor periodo ($T_i$).
- **Condición de Utilización**: $\sum \frac{C_i}{T_i} \le n(2^{1/n} - 1)$.
- **Test de Respuesta (Exacto)**: $R_i = C_i + \sum_{j \in HP(i)} \lceil \frac{R_i}{T_j} \rceil C_j$. El sistema es planificable si $\forall i, R_i \le D_i$.

## 2. Earliest Deadline First (EDF)
Planificador de prioridad dinámica: mayor prioridad a la tarea con el plazo más cercano.
- **Optimalidad**: EDF es óptimo en procesadores mononúcleo; si existe un planificador capaz de planificar un conjunto de tareas, EDF también puede.
- **Condición**: $\sum \frac{C_i}{T_i} \le 1$.

## 📝 Ejercicio de Análisis: Planificabilidad RM
Analice la planificabilidad por RM del siguiente sistema: $\tau_1 = (2, 5)$, $\tau_2 = (4, 10)$.
*Resolución*:
1. **Utilización**: $U = 2/5 + 4/10 = 0.4 + 0.4 = 0.8$.
2. **Cota de Liu & Layland**: $2(2^{1/2} - 1) \approx 0.828$.
3. **Conclusión**: Como $0.8 \le 0.828$, el sistema es garantizadamente planificable por RM.

## 3. Comparativa RM vs EDF
| Característica | Rate Monotonic (RM) | Earliest Deadline First (EDF) |
| :--- | :--- | :--- |
| **Prioridad** | Estática (basada en $T$) | Dinámica (basada en $d$) |
| **Utilización Máxima** | $\approx 69\%$ (general) | $100\%$ |
| **Implementación** | Sencilla (colas de prioridad fijas) | Compleja (re-ordenación constante) |
| **Sobrecarga** | Baja | Alta |
