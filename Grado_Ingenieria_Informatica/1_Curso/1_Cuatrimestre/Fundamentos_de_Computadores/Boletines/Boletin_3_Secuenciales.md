# FC - Boletín 3: Circuitos Secuenciales y Contadores

## 🧠 Contexto Teórico
Circuitos con estado interno (memoria).

*   **Reloj (Clock):** Sincroniza las transiciones.
*   **Biestable JK:** El más versátil. Si $J=1, K=1$, conmuta el estado actual ($T$ mode).
*   **Contadores:** Secuencia de estados que se repite.

## 📝 Ejercicios
1.  **Análisis de JK:** Si $Q=0$ y llegan $J=1, K=0$, ¿cuál es el nuevo Q?
    *   *Resolución:* $Q_{next} = 1$ (Set).
2.  **Diseño de Contador:** Queremos contar de 0 a 3. ¿Cuántos biestables hacen falta?
    *   *Resolución:* $2^n \ge 4 \implies n=2$. Usamos 2 biestables.
3.  **Diferencia Latch/Flip-flop:**
    *   *Resolución:* El Latch es sensible al nivel. El Flip-flop es sensible al flanco (subida o bajada) del reloj.
