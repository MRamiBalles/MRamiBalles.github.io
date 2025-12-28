# AC - Relación 2: Planificación Dinámica de Instrucciones (Algoritmo de Tomasulo)

El Algoritmo de Tomasulo permite la ejecución de instrucciones fuera de orden (Out-of-Order Execution), maximizando el paralelismo a nivel de instrucción (ILP) mediante el renombramiento de registros y la eliminación de riesgos de datos.

## 1. Mecanismos Fundamentales
- **Estaciones de Reserva (RS)**: Buffers que almacenan instrucciones pendientes, sus operandos (si están disponibles) o el identificador de la unidad funcional que producirá el operando.
- **Common Data Bus (CDB)**: Bus de difusión que permite la propagación de resultados directamente a todas las RS que los requieran, evitando cuellos de botella en el banco de registros.
- **Renombramiento de Registros**: Mitiga riesgos WAR (Write After Read) y WAW (Write After Write) al desacoplar los nombres de los registros lógicos de sus valores físicos.

## 2. Etapas del Algoritmo
1. **Emisión (Issue)**: La instrucción se traslada a una RS libre. Se realiza el renombramiento de registros.
2. **Ejecución (Execute)**: Cuando los operandos son válidos, la unidad funcional inicia la operación.
3. **Escritura (Write Result)**: El resultado se difunde por el CDB y se actualiza el banco de registros y las RS dependientes.

## 📝 Análisis de Estado (RS Table)
En un ciclo de reloj determinado, la tabla de Estaciones de Reserva permite visualizar la telemetría del procesador:
- `Busy`: Indica si la RS está ocupada.
- `Op`: Operación a realizar.
- `Vj, Vk`: Valores de los operandos.
- `Qj, Qk`: Unidades funcionales de las que se espera un resultado.

*Nota Técnica*: El uso del CDB permite la resolución de riesgos RAW (Read After Write) mediante el "forwarding" hardware, reduciendo los ciclos de parada (stalls) en comparación con técnicas de planificación estática.
