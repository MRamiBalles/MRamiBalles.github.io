# AC - Relación 3: Paralelismo a Nivel de Instrucción (ILP) (Oficial UHU)

## 🧠 Superescalares y VLIW
Si la segmentación básica es tener una fila en el supermercado, el superescalar es tener varias cajas abiertas.

*   **Superescalar**: El hardware decide en tiempo de ejecución qué instrucciones lanzar a la vez (OoO).
*   **VLIW (Very Long Instruction Word)**: Es el **compilador** el que empaqueta las instrucciones. El hardware es más tonto pero consume menos energía.
*   **Limitaciones**: Las dependencias de datos y los saltos. Si una instrucción depende del resultado de otra, no pueden ir juntas al "súper".

## 📝 Ejercicio de Planificación
Te dan un trozo de código (típico bucle de suma de vectores) y te piden que lo planifiques para un procesador que lanza 2 instrucciones por ciclo (1 de memoria + 1 de cálculo).

1.  **Código original**:
    ```assembly
    L.D F0, 0(R1)
    ADD.D F4, F0, F2
    S.D F4, 0(R1)
    DSUBI R1, R1, 8
    BNEZ R1, loop
    ```
2.  **Análisis de Stalls**: La `ADD.D` tiene que esperar a que `L.D` traiga el dato. La `S.D` tiene que esperar a que termine el `ADD.D`. ¡Un desastre de rendimiento!
3.  **Optimización**: 
    - **Bucle Unrolling**: Desenrollamos 2 o 4 veces.
    - **Renombrado**: Usamos F6, F8... para que las iteraciones no se peguen por los registros.
    - **Resultado**: Llenamos todos los huecos (slots) del procesador. 

*   *Organic Tip*: En el examen fijaos bien en las latencias que os den (ej. Multiplicación 6 ciclos, Suma 2). Eso es lo que marca dónde van los `nop` (burbujas).
