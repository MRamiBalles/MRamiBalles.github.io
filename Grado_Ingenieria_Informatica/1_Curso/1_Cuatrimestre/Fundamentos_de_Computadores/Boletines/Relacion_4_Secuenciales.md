# FC - Relación 4: Introducción a Circuitos Secuenciales (Oficial UHU)

## 🧠 Contexto Teórico
Circuitos con capacidad de almacenamiento (estado interno).

*   **Biestables (Flip-Flops)**: S-R, D (Data), J-K (Universal), T (Toggle).
*   **Señal de Reloj (CLK)**: Sincroniza los cambios. Disparo por flanco.
*   **Diagramas de Estado**: Representación de la lógica del sistema.

## 📝 Ejercicios de la Relación
1.  **Tabla de Excitación JK**: Si el estado actual es $Q=0$ y queremos pasar a $Q=1$, ¿qué valores deben tener J y K?
    *   *Resolución:* $J=1, K=X$ (indiferente, ya que tanto $1,0$ como $1,1$ llevan a 1).
2.  **Análisis de Cronograma**: Dibuja la salida de un biestable D disparado por flanco de subida si D cambia de 0 a 1 justo antes del flanco.
    *   *Resolución:* La salida $Q$ copiará el valor 1 en el momento del flanco y lo mantendrá hasta el siguiente.
3.  **Contadores**: Diseña un contador módulo 3 (0, 1, 2, 0...) usando biestables tipo D.
    *   *Resolución:* Necesitamos 2 biestables ($2^2 = 4 > 3$). Tabla de transición: $00 \to 01, 01 \to 10, 10 \to 00$.
