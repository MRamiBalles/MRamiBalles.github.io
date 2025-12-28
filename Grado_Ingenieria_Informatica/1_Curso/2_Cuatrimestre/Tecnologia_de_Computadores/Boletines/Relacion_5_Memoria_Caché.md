# TC - Relación 5: Jerarquía de Memoria (Oficial UHU)

## 🧠 Contexto Teórico
Optimización del acceso a datos mediante memorias caché.

*   **Localidad**: Temporal (reutilización) y Espacial (vecindad).
*   **Parámetros de Caché**:
    *   **Acierto (Hit)**: El dato está en caché.
    *   **Fallo (Miss)**: El dato no está, hay que ir a memoria principal.
*   **Tipos de Fallos**: Obligatorio, Capacidad, Conflicto.

## 📝 Ejercicios de la Relación
1.  **Mapeo Directo**: Una caché tiene 8 bloques. ¿A qué bloque va la dirección 22?
    *   *Resolución:* $22 \pmod 8 = 6$. Va al bloque 6.
2.  **Rendimiento**: CPI base = 1.0. Tasa de fallos = 2%. Penalización por fallo = 100 ciclos. Halla el CPI real.
    *   *Resolución:* $CPI_{real} = 1.0 + (0.02 \cdot 100) = 1.0 + 2.0 = 3.0$. El sistema es 3 veces más lento por los fallos de caché.
3.  **Configuración**: Caché de 4KB, bloques de 16 bytes. ¿Cuántos bloques tiene?
    *   *Resolución:* $4096 / 16 = 256$ bloques.
