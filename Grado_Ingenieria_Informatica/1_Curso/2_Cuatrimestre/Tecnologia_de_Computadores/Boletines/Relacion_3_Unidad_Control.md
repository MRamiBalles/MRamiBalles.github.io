# TC - Relación 3: La Unidad de Control (Oficial UHU)

La Unidad de Control (UC) es el "cerebro" dentro de la CPU que coordina el flujo de datos y las operaciones de la Unidad Aritmético-Lógica (ALU) y la memoria.

## 🧠 Fundamentos Teóricos
- **Ciclo de Instrucción**:
  1. **Fetch (Búsqueda)**: $MAR \leftarrow PC; PC \leftarrow PC+4; MBR \leftarrow Mem[MAR]; IR \leftarrow MBR$.
  2. **Decode (Decodificación)**: Se interpreta el código de operación.
  3. **Execute (Ejecución)**: Se generan las señales de control necesarias.
- **Implementaciones**:
  - **Cableada (Hardwired)**: Lógica combinacional pura (FSM). Muy rápida pero rígida.
  - **Microprogramada**: Las señales de control se almacenan en una ROM interna (Memoria de Control). Más lenta pero flexible y fácil de actualizar.

## 📝 Ejercicios de la Relación

1. **Microoperaciones de un Salto Incondicional (`JUMP`)**
   *Enunciado*: Indica la secuencia de transferencias entre registros para ejecutar un salto a la dirección `dir`.
   *Resolución*: 
   - $T_0$: $MAR \leftarrow PC$
   - $T_1$: $MBR \leftarrow Mem[MAR]; PC \leftarrow PC+4$
   - $T_2$: $IR \leftarrow MBR$
   - **$T_3$ (Ejecución):** $PC \leftarrow IR(Address)$

2. **Diseño de la Lógica de Control**
   *Enunciado*: Si el código de operación (OP) de `ADD` es `0001`, ¿qué señal debe activarse en la ALU?
   *Resolución*: La UC detecta el patrón `0001` mediante puertas AND/OR o un decodificador y activa la señal `S_ALU_ADD = 1`.

3. **Memoria de Control vs Cableada**
   *Enunciado*: ¿Por qué se prefiere la microprogramación en procesadores CISC (complejos)?
   *Resolución*: Porque implementar instrucciones muy complejas con puertas lógicas (cableada) requeriría un área de silicio masiva y sería casi imposible de depurar. La microprogramación permite emular instrucciones complejas mediante "microrrutinas".

---
> [!TIP]
> En los exámenes de la UHU, suele pedirse el diagrama de estados de la UC para instrucciones específicas (LW, SW, BEQ). Repásalos con el esquema del Datapath multiciclo.
