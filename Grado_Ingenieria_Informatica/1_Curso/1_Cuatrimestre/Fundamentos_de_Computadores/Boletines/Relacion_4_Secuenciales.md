# Fundamentos de Computadores - Relación 4: Circuitos Secuenciales

A diferencia de los sistemas combinacionales, los circuitos secuenciales incorporan elementos de memoria, permitiendo que la salida dependa tanto de las entradas actuales como de la historia previa del sistema (estado interno).

## Fundamentación Teórica

### Elementos de Memoria
- **Biestables (Flip-Flops)**: Unidades básicas de almacenamiento sincronizadas por una señal de reloj ($CLK$).
  - **Tipo D**: Almacena el valor de entrada en el flanco activo.
  - **Tipo JK**: Versátil, permite funciones de set, reset, memoria y basculación (toggle).
  - **Tipo T**: Cambia el estado interno si la entrada es 1.

### Máquinas de Estados Finitos (FSM)
- **Modelo de Mealy**: La salida depende del estado actual y de las entradas.
- **Modelo de Moore**: La salida depende exclusivamente del estado actual.

### Registros y Contadores
- **Registros de Desplazamiento**: Movimiento secuencial de datos bit a bit.
- **Contadores Síncronos y Asíncronos**: Evolución de estados siguiendo una secuencia numérica (Binaria, Gray, BCD).

## Resolución de Problemas Seleccionados

1. **Análisis de un Contador Síncrono**
   *Problema*: Determinar la secuencia de estados de un contador basado en dos biestables JK.
   *Metodología*: 
   - Obtención de las ecuaciones de excitación de las entradas $J$ y $K$.
   - Elaboración de la tabla de transición de estados.
   - Identificación de ciclos o estados no deseados (autocorrección).

2. **Diseño de un Detector de Secuencia**
   *Problema*: Diseñar una FSM que detecte la secuencia binaria `1011` en una corriente de datos de entrada.
   *Resolución*: 
   - Definición del diagrama de estados (5 estados requeridos para el modelo de Moore).
   - Codificación de estados y selección de biestables.
   - Síntesis de la lógica de control lógica combinacional de entrada y salida.

3. **Cronogramas (Timing Diagrams)**
   *Problema*: Dibujar la evolución temporal de la salida $Q$ de un Flip-Flop D disparado por flanco de subida, considerando tiempos de establecimiento ($t_{setup}$) y mantenimiento ($t_{hold}$).
   *Concepto Crítico*: La violación de estos parámetros temporales puede inducir estados de metaestabilidad en el sistema.
