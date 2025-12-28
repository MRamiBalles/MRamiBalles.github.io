# Plan de Especialización y Migración: Grado Ing. Informática

Este documento detalla la hoja de ruta para especializar cada asignatura y el mapeo de los archivos actuales a la nueva estructura.

## Mapeo de Migración (Propuesto)

| Carpeta Actual | Destino en `Grado_Ingenieria_Informatica` | Categoría |
| :--- | :--- | :--- |
| `actividad AA` | `4_Curso/1_Cuatrimestre/Aprendizaje_Automatico` | `Practicas` |
| `sesion_practica1` | `1_Curso/1_Cuatrimestre/Matematicas_I` | `Practicas` |
| `Cuarto/MAC` | `3_Curso/1_Cuatrimestre/Algoritmica_y_Modelos_de_Computacion` | `Practicas` |
| `Cuarto/PCD 2mat` | `3_Curso/1_Cuatrimestre/Programacion_Concurrente_y_Distribuida` | `Practicas` |
| `Uni 2025/TFG` | `4_Curso/2_Cuatrimestre/Trabajo_Fin_de_Grado` | `Documentacion/Codigo` |
| `Uni 2024/DDSI` | `3_Curso/1_Cuatrimestre/Diseño_y_Desarrollo_de_Sistemas_de_Informacion` | `Practicas` |
| `Uni 2024/IAAR` | `2_Curso/2_Cuatrimestre/Inteligencia_Artificial` | `Practicas` |

## Plan de Especialización por Asignatura

Para cada asignatura se seguirá este flujo de trabajo:

1. **Auditoría de Contenido**: Identificar qué partes de la Guía Docente (Teoría/Prácticas) están cubiertas por los archivos migrados.
2. **Identificación de Gaps**: Señalar los temas de la guía que no tienen material en el repositorio.
3. **Optimización de Prácticas**: Refactorizar código existente y añadir comentarios técnicos (`AAD`).
4. **Ampliación Bibliográfica**: Añadir links a recursos avanzados (repos de GitHub, papers de investigación) en el `README.md` de la asignatura.

### Ejemplo: Aprendizaje Automático
- **Estado**: Se migrarán scripts de clustering y actividad de aprendizaje.
- **Acción**: Añadir sección de "Deep Learning" y "Refuerzo" (temas avanzados de la especialidad).

## Notas de Revisión
- Se mantendrán los archivos originales intactos mediante copias (o movimientos si el usuario prefiere). *Nota: Procederé con movimientos para limpiar la raíz, a menos que se indique lo contrario.*
