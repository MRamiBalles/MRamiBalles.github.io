# DGP - Relación 1: Planificación de Proyectos (PERT/CPM) (Oficial UHU)

La gestión de proyectos de ingeniería requiere una planificación temporal determinista basada en dependencias de tareas.

## 1. El Método del Camino Crítico (CPM)
Identifica la secuencia de tareas que determina la duración mínima del proyecto. Cualquier retraso en una tarea crítica impacta directamente en la fecha de finalización.
- **Holgura (Slack)**: Tiempo que una tarea puede retrasarse sin afectar al proyecto. Las tareas críticas tienen holgura cero.

## 2. Técnica PERT (Program Evaluation and Review Technique)
Utiliza estimaciones probabilísticas para la duración de las tareas:
- $T_e = \frac{O + 4M + P}{6}$
  - Donde $O$ es el tiempo optimista, $M$ el más probable y $P$ el pesimista.

## 📝 Ejercicio de Planificación
Dada la siguiente tabla de actividades:

| Actividad | Precedencia | Duración ($T_e$) |
| :--- | :--- | :--- |
| A | - | 3 |
| B | A | 4 |
| C | A | 2 |
| D | B, C | 5 |

- **a)** Dibuje el diagrama de red (AOA o AON).
- **b)** Identifique el camino crítico.
- **c)** Calcule la duración total esperada del proyecto.

*Resolución*: 
- Caminos posibles: $A \to B \to D$ (12 días) y $A \to C \to D$ (10 días).
- El **camino crítico** es $A-B-D$.
- Duración total: **12 unidades de tiempo**.
- La holgura de la actividad C es de 2 unidades de tiempo.
