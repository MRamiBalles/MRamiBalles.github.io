# EC - Relación 5: Jerarquía de Memoria Avanzada (Oficial UHU)

## 🧠 Contexto Teórico
Análisis detallado de cómo la caché afecta al tiempo de ejecución.

*   **Fallo de Lectura vs Fallo de Escritura**: El de escritura es más complejo (*Write-through* vs *Write-back*).
*   **Asociatividad**: Una dirección puede ir a un conjunto de $K$ vías. Reduce los fallos de conflicto.
*   **Bit de Sucio (Dirty Bit)**: En *Write-back*, indica que el bloque en caché ha sido modificado y debe volcarse a RAM al ser reemplazado.

## 📝 Ejercicios de la Relación
1.  **Asociativa por Conjuntos**: Caché de 2 vías, 4 conjuntos. ¿Dónde va el bloque 10?
    *   *Resolución:* $10 \pmod 4 = 2$. Va al conjunto 2. Puede ocupar cualquiera de las 2 vías disponibles en ese conjunto.
2.  **Tamaño de la Etiqueta (Tag)**: Dirección de 32 bits, bloques de 64B, caché de 1MB mapeo directo.
    *   *Resolución:*
        *   Offset: $\log_2 64 = 6$ bits.
        *   Índice: $1MB/64B = 16384$ bloques. $\log_2 16384 = 14$ bits.
        *   Tag: $32 - 14 - 6 = 12$ bits.
3.  **AMAT**: $Time_{hit} + \text{Tasa Fallo} \cdot \text{Penalización de Fallo}$.
    *   *Resolución:* Si el Hit es 1 ciclo, fallo 1% y penalización 50 ciclos: $1 + 0.01 \cdot 50 = 1.5$ ciclos por acceso de media.
---
> [!NOTE]
> En Estructura de Computadores (2º), los ejercicios de caché son más complejos que en Tecnología (1º) porque incluyen el cálculo de bits de Tag e Índice.
