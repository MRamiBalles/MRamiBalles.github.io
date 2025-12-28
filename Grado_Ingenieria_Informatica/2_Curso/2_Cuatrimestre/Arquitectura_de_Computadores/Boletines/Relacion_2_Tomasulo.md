# AC - Relación 2: Planificación Dinámica - Tomasulo (Oficial UHU)

## 🧠 Entendiendo a Tomasulo
Este es el "coco" de la asignatura. El objetivo es ejecutar instrucciones fuera de orden (OoO) para no pararnos si una instrucción tarda mucho.

*   **Estaciones de Reserva (RS)**: Buffers donde las instrucciones esperan a que sus operandos estén listos.
*   **Renombramiento de Registros**: Evita los riesgos WAW y WAR. Desligamos el "nombre" del registro ($R1, R2$) del "valor" real.
*   **CDB (Common Data Bus)**: El bus por el que los resultados vuelan hacia todas las RS que los estén esperando.

## 📝 Ejercicio de Examen (La Tabla)
Te dan un código y tienes que rellenar el estado de las RS en el ciclo $X$.
1.  **Emisión (Issue)**: La instrucción entra en una RS si hay hueco.
2.  **Ejecución**: Si tiene los valores ($Vj, Vk$ están listos), empieza a contar ciclos.
3.  **Escritura**: El resultado se lanza al CDB.

*   *El truco de la UHU*: Si ves un campo $Qj$ con algo como `Add1`, significa que está esperando a que la unidad `Add1` termine. En cuanto termine, ese valor pasa a ser un `Vj` (valor real).
*   *Diferencia con Scoreboarding*: Tomasulo usa el CDB y renombramiento; Scoreboarding es más simple y tiene riesgos WAR/WAW.
