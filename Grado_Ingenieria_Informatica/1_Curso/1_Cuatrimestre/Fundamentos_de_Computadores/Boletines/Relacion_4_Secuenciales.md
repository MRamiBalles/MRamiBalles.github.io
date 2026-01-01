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

## 📝 Proyecto de Diseño: Contador Síncrono de 3 Bits (Modulo 8)
**Objetivo**: Diseñar un contador que siga la secuencia binaria natural (000 a 111) utilizando biestables tipo D.

### Metodología de Diseño Paso a Paso
1. **Diagrama de Estados**: Grafo circular con 8 nodos ($S_0$ a $S_7$) y transiciones unívocas con cada flanco de reloj.
2. **Tabla de Transición y Excitación**:
   - Estado Actual ($Q_2, Q_1, Q_0$) $\to$ Siguiente Estado ($Q_2^+, Q_1^+, Q_0^+$).
   - Para biestables D, la entrada $D_i$ es igual al estado siguiente deseado $Q_i^+$.
3. **Mapas de Karnaugh para las Entradas D**:
   - $D_0 = \bar{Q}_0$ (Bascula en cada ciclo).
   - $D_1 = Q_1 \oplus Q_0$ (Cambia si $Q_0$ es 1).
   - $D_2 = Q_2 \oplus (Q_1 \cdot Q_0)$ (Cambia si $Q_1$ y $Q_0$ son 1).
4. **Implementación Lógica**: Esquema con 3 biestables D y puertas XOR/AND para la lógica de excitación.

---
> [!IMPORTANT]
> En contadores síncronos, todos los biestables comparten la misma señal de reloj, eliminando el problema del "glicheo" por retardos acumulados típico de los contadores asíncronos.
