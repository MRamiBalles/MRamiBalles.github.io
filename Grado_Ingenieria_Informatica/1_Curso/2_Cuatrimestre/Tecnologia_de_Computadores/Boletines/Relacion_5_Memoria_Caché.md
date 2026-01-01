# TC - Relación 5: Jerarquía de Memoria (Oficial UHU)

## 🧠 Contexto Teórico
Optimización del acceso a datos mediante memorias caché.

*   **Localidad**: Temporal (reutilización) y Espacial (vecindad).
*   **Parámetros de Caché**:
    *   **Acierto (Hit)**: El dato está en caché.
    *   **Fallo (Miss)**: El dato no está, hay que ir a memoria principal.
*   **Tipos de Mapeo**:
    1. **Directo**: Cada dirección va a un único bloque.
    2. **Totalmente Asociativo**: Una dirección puede ir a cualquier bloque.
    3. **Asociativo por Conjuntos**: La dirección va a un conjunto, y dentro de él a cualquier bloque.

## 📝 Ejercicios de la Relación
1.  **Mapeo Directo**: Una caché tiene 8 bloques. ¿A qué bloque va la dirección 22?
    *   *Resolución:* $22 \pmod 8 = 6$. Va al bloque 6.
2.  **Rendimiento**: CPI base = 1.0. Tasa de fallos = 2%. Penalización por fallo = 100 ciclos. Halla el CPI real.
    *   *Resolución:* $CPI_{real} = 1.0 + (0.02 \cdot 100) = 1.0 + 2.0 = 3.0$. El sistema es 3 veces más lento por los fallos de caché.
3.  **Configuración**: Caché de 4KB, bloques de 16 bytes. ¿Cuántos bloques tiene?
    *   *Resolución:* $4096 / 16 = 256$ bloques.

## 📝 Ejercicio Avanzado: Caché Asociativa por Conjuntos
**Enunciado**: Tenemos una caché de 2 vías (2-way set associative) con 16 bloques en total. El tamaño de bloque es de 4 bytes. ¿A qué conjunto va la dirección de memoria 42?

**Resolución**: 
1. **Número de conjuntos**: $16 \text{ bloques} / 2 \text{ vías} = 8 \text{ conjuntos}$.
2. **Dirección de bloque**: $42 \text{ (dir)} / 4 \text{ (byte/bloque)} = 10 \text{ (índice de bloque absoluto)}$.
3. **Conjunto**: $10 \pmod 8 = 2$.
- **Resultado**: La dirección 42 se mapeará en el **Conjunto 2**.

---
> [!IMPORTANT]
> La caché asociativa reduce los fallos por conflicto frente al mapeo directo, pero aumenta la complejidad del hardware (comparadores) y el tiempo de acceso.
