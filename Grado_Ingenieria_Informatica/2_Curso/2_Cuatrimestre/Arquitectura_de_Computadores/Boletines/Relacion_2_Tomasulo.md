# AC - Relación 2: Planificación Dinámica (Tomasulo) (Oficial UHU)

## 🧠 El Algoritmo de Tomasulo: Explicado
Tomasulo es la base de los procesadores modernos. Permite que las instrucciones se ejecuten en cuanto sus operandos estén listos, sin importar el orden del programa original.

## 📝 Ejercicio de Examen: Traza de Ejecución

Dada la siguiente secuencia de instrucciones y latencias (Suma: 2 ciclos, Carga: 3 ciclos):
1. `L.D F6, 32(R2)`
2. `L.D F2, 44(R3)`
3. `ADD.D F0, F2, F4`
4. `SUB.D F8, F6, F2`

### Estado de las Estaciones de Reserva (Ciclo 4)

| Nombre | Busy | Op | Vj | Vk | Qj | Qk |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Add1** | Yes | ADD.D | | F4_val | Load2 | |
| **Add2** | Yes | SUB.D | | | Load1 | Load2 |
| **Mult1**| No | | | | | |

### Estado del Banco de Registros (Ciclo 4)

| Registro | F0 | F2 | F4 | F6 | F8 | ... |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **Qi** | Add1 | Load2 | | Load1 | Add2 | |

### 🧠 ¿Qué está pasando aquí? (Análisis)
- **F6** está esperando a que termine la primera carga (`Load1`).
- **F2** está esperando a la segunda carga (`Load2`).
- El `ADD.D` depende de **F2**, por lo que su `Qj` apunta a `Load2`.
- El `SUB.D` depende tanto de **F6** como de **F2**, por lo que espera a ambos (`Load1` y `Load2`).
- **Renombramiento**: Gracias a las RS, hemos eliminado el riesgo de que una instrucción posterior escriba en F2 y pise el valor que `ADD.D` todavía no ha leído.

---
> [!TIP]
> En el examen, un error común es olvidar poner el `Lazy Update`: cuando una instrucción escribe en el CDB, TODAS las estaciones de reserva que esperaban ese dato (`Qj` o `Qk`) deben capturarlo y limpiar el campo Qi.
