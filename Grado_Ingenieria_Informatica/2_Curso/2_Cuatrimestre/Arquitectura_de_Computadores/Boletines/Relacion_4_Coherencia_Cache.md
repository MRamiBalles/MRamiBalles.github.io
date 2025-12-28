# AC - Relación 4: Multiprocesadores y Coherencia de Caché (Oficial UHU)

## 🧠 El Problema de la Coherencia
Cuando tienes varios núcleos (CPUs) y cada uno tiene su propia caché L1, puede que la CPU 1 escriba un valor en una variable y la CPU 2 siga viendo el valor viejo. ¡Caos total!

*   **Protocolos de "Snooping" (Husmeo)**: Las cachés vigilan el bus para ver qué hacen las demás.
*   **MSI (Modified, Shared, Invalid)**:
    - **Modified**: Yo tengo el dato y lo he cambiado. Soy el único que lo tiene bien.
    - **Shared**: Varias cachés lo tienen, es de solo lectura.
    - **Invalid**: Mi copia no vale, alguien la ha cambiado.
*   **Falsas Comparticiones (False Sharing)**: Cuando dos hilos tocan variables distintas pero que están en la misma "línea de caché". Esto mata el rendimiento.

## 📝 Ejercicios de Seguimiento de Bus
Te dan una secuencia de operaciones (CPU1 Read A, CPU2 Write A...) y tienes que decir el estado de cada caché en cada paso.
1.  **CPU1 lee A**: Estado en C1: Shared. Bus: Memory Read.
2.  **CPU2 lee A**: Estado en C1: Shared. Estado en C2: Shared.
3.  **CPU1 escribe A**: Estado en C1: Modified. Estado en C2: **Invalid**. Bus: Invalidate (o Write-back si fuera necesario).
4.  **CPU2 lee A**: C1 tiene que pasar de Modified a Shared y escribir el dato en memoria o pasárselo a C2. C2 pasa a Shared.

*   *Organic Tip*: En el examen, dibujad una tablita con columnas `Paso`, `Acción`, `C1`, `C2` y `Bus`. Es la única forma de no liarse con los estados.
