# DESO - Relación 1: Procesos e Hilos (Oficial UHU)

## 🧠 Contexto Teórico
El proceso es la unidad básica de ejecución gestionada por el SO.

*   **PCB**: Bloque de Control de Proceso. Guarda el estado del proceso.
*   **Hilos (Threads)**: Un proceso puede tener varios hilos que comparten memoria.
*   **Llamadas al sistema**:
    1.  `fork()`: Crea un proceso hijo (copia del padre).
    2.  `exec()`: Carga un nuevo programa en el proceso actual.
    3.  `wait()`: El padre espera a que el hijo termine.

## 📝 Ejercicios de la Relación
1.  **Árbol de Procesos**: ¿Cuántos procesos se crean con 3 `fork()` seguidos?
    *   *Resolución:* $2^3 = 8$ procesos en total (incluyendo el original).
2.  **Estados**: Dibuja el ciclo de vida de un proceso.
    *   *Resolución:* Nuevo -> Listo -> Ejecución -> Espera (si hay E/S) -> Listo -> ... -> Terminado.
3.  **Zombie vs Huérfano**:
    *   *Resolución:* Un **Zombie** ha terminado pero su padre no ha recogido su código de salida. Un **Huérfano** sigue vivo pero su padre murió (es adoptado por `init` / `systemd`).
