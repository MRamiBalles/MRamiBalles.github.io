# EC - Relación 4: Segmentación (Pipelining) (Oficial UHU)

## 🧠 Contexto Teórico
Solapamiento de instrucciones para mejorar el rendimiento.

*   **Etapas**: FI (Fetch), DI (Decode), EX (Execute), ME (Memory), WB (Write Back).
*   **Paradas de Cauce**: Ciclos en los que una etapa se detiene por un riesgo.
*   **Adelantamiento (Forwarding)**: Enviar el resultado de una etapa anterior directamente a la entrada de la siguiente sin pasar por el registro.

## 📝 Ejercicios de la Relación
1.  **Traza de Segmentación**: Dibuja el diagrama de Gantt para 3 instrucciones `add` seguidas sin adelantamiento.
    *   *Resolución:* Cada instrucción depende del registro escrito por la anterior. Si no hay adelantamiento, hay que esperar al WB. Se insertan paradas.
2.  **Riesgo de Control**: Un salto condicional se resuelve en la etapa EX. ¿Cuántos burbujas se insertan si no hay predicción?
    *   *Resolución:* 3 burbujas (las instrucciones en FI, DI y la propia carga en ese ciclo).
3.  **Cálculo de Ciclos**: Tiempo total = $(N + K - 1 + \text{paradas}) \cdot T_{ciclo}$.
    *   *Resolución:* N=instrucciones, K=etapas. Sirve para comparar el rendimiento real frente al ideal.
