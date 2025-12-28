# STR - Relación 1: Diseño de Ejecutivos Cíclicos (Oficial UHU)

El diseño de un Ejecutivo Cíclico es la técnica de planificación determinista más sencilla para sistemas de tiempo real, donde la secuencia de tareas se define estáticamente en una tabla de tiempo denominada *Plan Maestro*.

## 1. Parámetros del Sistema
Dada una colección de tareas periódicas $\tau_i = (C_i, T_i)$, donde $C_i$ es el tiempo de cómputo y $T_i$ el periodo:
- **Hiperperiodo ($H$)**: El ciclo principal de ejecución, calculado como el $mcm(T_1, T_2, \dots, T_n)$.
- **Ciclo Secundario ($f$)**: División temporal de $H$ que debe cumplir:
  1. $f \ge \max(C_i)$ (una tarea debe caber en un ciclo).
  2. $H \pmod f = 0$.
  3. $2f - mcd(T_i, f) \le D_i$ (Restricción de latencia).

## 📝 Ejercicio Técnico: Diseño de Plan Maestro
Considere el siguiente conjunto de tareas:
- $\tau_1 = (1, 4)$
- $\tau_2 = (2, 6)$
- $\tau_3 = (1, 12)$

*Resolución*:
1. **Hiperperiodo**: $H = mcm(4, 6, 12) = 12$.
2. **Ciclo Secundario ($f$)**:
   - $f \ge 2$ (por $C_2$).
   - $f \in \{2, 3, 4, 6\}$.
   - Tras comprobar restricciones, seleccionamos $f=4$.
3. **Plan Maestro**:
   - Ciclo 1 ($t=0..4$): $\tau_1, \tau_2[part 1]$.
   - Ciclo 2 ($t=4..8$): $\tau_1, \tau_2[part 2], \tau_3$.
   - Ciclo 3 ($t=8..12$): $\tau_1, \tau_2$.

## 2. Ventajas y Limitaciones
- **Ventajas**: Determinismo absoluto, no requiere soporte de hardware complejo (timers/interrupciones), ausencia de sobrecarga por cambio de contexto dinámico.
- **Limitaciones**: Inflexibilidad ante cambios en el conjunto de tareas, dificultad para gestionar tareas esporádicas, desperdicio de CPU si los periodos no son armónicos.
