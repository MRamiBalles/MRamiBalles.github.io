# Arquitectura de Computadores

Diseño avanzado de procesadores, paralelismo a nivel de instrucción y coherencia de caché.

## 📋 Guía Docente y Bibliografía
- **Guía Oficial**: [Enlace a Guía UHU](https://www.uhu.es/etsi/guias/get-guia.php?curso=2023&codigo=606010209)
- **Bibliografía Recomendada**:
  - *Arquitectura de Computadores: Un enfoque cuantitativo* - Hennessy & Patterson.
  - *Modern Processor Design* - Shen & Lipasti.

## 🧠 Síntesis Teórica
1. **Paralelismo ILP**: Ejecución fuera de orden, algoritmos de Scoreboard y Tomasulo.
2. **Predicción de Saltos**: BTB, predictores locales y globales.
3. **Jerarquía de Memoria Avanzada**: Optimización de cachés multinivel.
4. **Multiprocesadores**: Coherencia de caché (MSI/MESI/MOESI) y modelos de consistencia.
5. **Arquitecturas SIMD**: Vectorizadores y GPUs.

## 🛠️ Plan de Desarrollo y Estados
### 📂 Inventario de Contenido
- [ ] **Análisis de Rendimiento**: Muchos cálculos de Speedup y CPI en **PAPEL**.
- [ ] **Simulaciones**: [PLACEHOLDER] - Verificar si se usó WinDLX o Sim-Outorder.

### 🚀 Etapas de Trabajo
- **Etapa 1**: Digitalizar los diagramas de ejecución del Algoritmo de Tomasulo.
- **Etapa 2**: Resolver los problemas de coherencia de caché mediante tablas de estados.
- **Etapa 3**: Conectar con los paradigmas superescalares modernos (M1/M2, Intel Core).
