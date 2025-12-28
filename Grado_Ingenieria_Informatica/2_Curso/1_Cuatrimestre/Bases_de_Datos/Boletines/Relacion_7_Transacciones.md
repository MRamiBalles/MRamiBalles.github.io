# BD - Relación 7: Transacciones y Control de Concurrencia (Oficial UHU)

## 🧠 Conceptos Pro
Una transacción es una unidad lógica de trabajo que debe cumplir las propiedades **ACID** (Atomaticidad, Consistencia, Aislamiento, Durabilidad).

*   **COMMIT**: "Guarda mis cambios para siempre".
*   **ROLLBACK**: "Me he equivocado, deja la base de datos como estaba antes de empezar".
*   **Problemas de concurrencia**: Lectura sucia, lectura no repetible, lectura fantasma.

## 📝 Ejercicios de la Relación
1.  **Transferencia Bancaria**: Explica por qué hace falta una transacción.
    *   *Resolución*: Porque si restas el dinero de la cuenta A y el sistema se cae antes de sumarlo en la B, el dinero desaparece. Usamos un bloque `BEGIN TRANSACTION ... COMMIT`.
2.  **Niveles de Aislamiento**: ¿Qué es el `SERIALIZABLE`?
    *   *Resolución*: Es el nivel más estricto. Las transacciones se ejecutan como si fueran una detrás de otra. Evita todos los problemas de concurrencia pero es el más lento.
3.  **Deadlock en BD**: ¿Cómo lo soluciona el SGBD?
    *   *Resolución*: Detecta el ciclo de espera y elige a una "víctima" (la transacción más barata de abortar) para que haga un Rollback y libere los recursos.
