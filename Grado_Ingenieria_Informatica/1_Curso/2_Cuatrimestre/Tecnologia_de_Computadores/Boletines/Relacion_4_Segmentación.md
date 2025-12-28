# TC - Relación 4: Segmentación / Pipelining (Oficial UHU)

## 🧠 Contexto Teórico
Técnica de implementación para que varias instrucciones se solapen en su ejecución.

*   **Etapas**: IF, ID, EX, MEM, WB.
*   **Riesgos (Hazards)**:
    1.  **Estructurales**: Falta de recursos hardware.
    2.  **De Datos**: Una instrucción depende del resultado de una anterior (solución: adelantamientos o *forwarding*).
    3.  **De Control**: Saltos que rompen la secuencia.

## 📝 Ejercicios de la Relación
1.  **Riesgo de Datos**: Analiza el siguiente código:
    ```assembly
    add $s0, $t0, $t1
    sub $t2, $s0, $t3
    ```
    *   *Resolución:* Hay un riesgo de datos en `$s0`. `sub` necesita el valor que genera `add`. Si no hay adelantamiento, hay que insertar 2 burbujas.
2.  **Aceleración (Speedup)**: Calcula el speedup ideal de una segmentación de 5 etapas frente a una monociclo.
    *   *Resolución:* En el caso ideal (sin paradas), el speedup es igual al número de etapas: 5.
3.  **Saltos**: ¿Cómo afecta un salto mal predicho al pipeline?
    *   *Resolución:* Obliga a vaciar las etapas de IF e ID que ya habían cargado instrucciones incorrectas, provocando una penalización de ciclos.
