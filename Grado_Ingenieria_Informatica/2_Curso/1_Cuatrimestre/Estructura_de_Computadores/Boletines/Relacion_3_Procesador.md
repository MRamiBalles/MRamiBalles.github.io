# EC - Relación 3: El Procesador y la Unidad de Control (Oficial UHU)

## 🧠 Contexto Teórico
Diseño interno de la CPU siguiendo el modelo de Von Neumann.

*   **Camino de Datos**: Registros, ALU y conexiones.
*   **Unidad de Control**: Genera las señales que activan cada parte del camino según la instrucción.
*   **Arquitectura Monociclo**: Cada instrucción tarda un único ciclo de reloj. (Ineficiente pero simple).

## 📝 Ejercicios de la Relación
1.  **Señales de Control**: ¿Qué señal se activa en un `lw` (load word) que no se activa en un `add`?
    *   *Resolución:* `MemRead`. El procesador necesita leer de la memoria de datos.
2.  **ALU Control**: Si la instrucción es `beq`, ¿qué operación realiza la ALU internamente?
    *   *Resolución:* Una resta (`sub`). Si el resultado de la resta es cero, los operandos son iguales y se toma el salto.
3.  **Crítica al Monociclo**: ¿Cuál es el mayor problema del diseño monociclo?
    *   *Resolución:* El ciclo de reloj debe ser tan largo como la instrucción más lenta (`lw`), lo que desperdicia tiempo en instrucciones rápidas (`add`).
