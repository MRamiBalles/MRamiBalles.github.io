# DESO - Relación 5: Sistemas de Archivos y Planificación de Disco (Oficial UHU)

## 🧠 Contexto Teórico
Organización de los datos en el almacenamiento secundario.

*   **I-nodo**: Estructura que guarda los metadatos de un archivo (permisos, tamaño, punteros a bloques) en sistemas tipo UNIX.
*   **Planificación de Disco**: 
    *   **FCFS**: Orden de llegada.
    *   **SSTF**: El más cercano al cabezal primero.
    *   **SCAN (Ascensor)**: Va de un extremo a otro atendiendo peticiones.

## 📝 Ejercicios de la Relación
1.  **Cálculo de I-nodos**: Si un i-nodo tiene 10 punteros directos y un bloque mide 1KB, ¿cuál es el tamaño máximo del archivo usando solo punteros directos?
    *   *Resolución:* $10 \cdot 1KB = 10 KB$. Para archivos mayores se usan punteros indirectos.
2.  **SSTF**: Peticiones en 98, 183, 37, 122. Cabezal en 53.
    *   *Resolución:* De 53 va a 37 (dist 16), luego a 98 (dist 61), luego a 122 (dist 24), luego a 183 (dist 61). Total movimiento: $16+61+24+61 = 162$.
3.  **Fragmentación**: Diferencia entre interna y externa en el disco.
    *   *Resolución:* Interna: espacio desperdiciado dentro del último bloque de un archivo. Externa: huecos libres entre archivos pero que no son contiguos.
