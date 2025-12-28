# FRC - Relación 2: Capa de Transporte y TCP (Oficial UHU)

## 🧠 Contexto Teórico
Comunicación extremo a extremo de forma fiable (TCP) o rápida (UDP).

*   **TCP**: Orientado a conexión, fiable, control de flujo (ventana).
*   **UDP**: No fiable, sin conexión, rápido (streaming, juegos).
*   **Three-way Handshake**: SYN, SYN-ACK, ACK (establecimiento de conexión).
*   **Números de Secuencia y ACK**: Permiten ordenar los datos y confirmar recepción.

## 📝 Ejercicios de la Relación
1.  **Ventana de Deslizamiento**: Si la ventana es de 5 paquetes y el emisor envía 1, 2, 3, 4, 5. Recibe el ACK de 2. ¿Cuál es la nueva ventana?
    *   *Resolución:* Se desliza. Ahora puede enviar 3, 4, 5, 6, 7.
2.  **Cálculo de RTT**: ¿Cómo influye el RTT en el rendimiento de una transferencia TCP?
    *   *Resolución:* El rendimiento está limitado por $\text{Ventana} / RTT$. A mayor latencia, menor velocidad efectiva por mucho ancho de banda que haya.
3.  **Checksum**: Propósito y debilidades.
    *   *Resolución:* Sirve para detectar errores básicos de bits. No es infalible contra errores malintencionados (se usa criptografía para eso).
---
> [!IMPORTANT]
> **TCP vs UDP**: Pregunta fija de examen. TCP prioriza integridad; UDP prioriza velocidad.
