# Sistemas de Tiempo Real (STR)

Determinismo, planificación de tareas críticas y sistemas empotrados.

## 📋 Guía Docente y Bibliografía
- **Guía Oficial**: [Enlace a Guía UHU](https://www.uhu.es/etsi/guias/get-guia.php?curso=2023&codigo=606010230)
- **Bibliografía Recomendada**:
  - *Real-Time Systems and Programming Languages* - Burns & Wellings.
  - *Real-Time Systems* - Hermann Kopetz.

## 🧠 Síntesis Teórica
1. **Conceptos de STR**: Tiempo real estricto (Hard) vs laxo (Soft). Determinismo.
2. **Planificación**: Rate Monotonic (RM) y Earliest Deadline First (EDF).
3. **Comunicación y Sincronización**: Protocolos de prioridad (Priority Inheritance/Ceiling).
4. **Plataformas**: RTOS, Linux con parche PREEMPT_RT.

## 🛠️ Plan de Desarrollo y Estados
### 📂 Inventario de Contenido
- [ ] **Código STR**: [PLACEHOLDER] - Buscar archivos Ada o C (Real-time).
- [ ] **Cronogramas**: Análisis de planificabilidad en **PAPEL**.

### 🚀 Etapas de Trabajo
- **Etapa 1**: Simular un conjunto de tareas periódicas y analizar su planificabilidad mediante RM.
- **Etapa 2**: Investigar el desarrollo sobre placas tipo ESP32 o Raspberry Pi con RTOS.
- **Etapa 3**: Documentar el impacto del jitter y la latencia en sistemas críticos.
