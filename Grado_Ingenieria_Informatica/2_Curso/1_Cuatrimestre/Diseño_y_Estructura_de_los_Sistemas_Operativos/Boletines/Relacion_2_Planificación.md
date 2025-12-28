# DESO - Relación 2: Planificación de CPU (Oficial UHU)

## 🧠 Contexto Teórico
El SO debe decidir qué proceso usa la CPU en cada momento.

*   **FCFS**: El primero que llega, primero que se atiende.
*   **SJF**: El más corto primero. Minimiza el tiempo medio de espera.
*   **Round Robin**: Por turnos de tiempo fijo (*quántum*). Ideal para interactividad.
*   **Prioridades**: Se atiende según un valor de importancia.

## 📝 Ejercicios de la Relación
1.  **Gantt de Round Robin**: Procesos P1(5ms), P2(3ms) con Quántum=2.
    *   *Resolución:* $0-2: P1; 2-4: P2; 4-6: P1; 6-7: P2 (\text{Acaba}); 7-8: P1 (\text{Acaba})$.
2.  **Tiempo de Espera Medio**: En FCFS con ráfagas P1(24), P2(3), P3(3).
    *   *Resolución:* P1 espera 0, P2 espera 24, P3 espera 27. Media: $(0+24+27)/3 = 17 \text{ ms}$.
3.  **SJF Expulsivo**: ¿Qué pasa si llega un proceso más corto mientras uno está ejecutando?
    *   *Resolución:* Se expulsa al actual para meter al más corto. Se conoce como *Shortest Remaining Time First* (SRTF).
