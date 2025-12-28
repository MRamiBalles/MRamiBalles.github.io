# FRC - Relación 1: Introducción y Capa de Aplicación (Oficial UHU)

## 🧠 Contexto Teórico
Estudio de los retardos en red y los protocolos de alto nivel (HTTP, DNS).

*   **Retardo Total**: $d_{proc} + d_{cola} + d_{trans} + d_{prop}$.
*   **Retardo de Transmisión**: $L/R$ (Longitud / Velocidad). Depende de la capacidad del enlace.
*   **Retardo de Propagación**: $d/s$ (Distancia / Velocidad de la luz en el medio). Depende del medio físico.

## 📝 Ejercicios de la Relación
1.  **Cálculo de Retardos**: Un paquete de 1000 bits viaja por un enlace de 1 Mbps de 1000km ($s=2 \cdot 10^8 m/s$). Halla el retardo total (sin cola ni proc).
    *   *Resolución:* 
        *   $d_{trans} = 1000 / 10^6 = 0.001 s = 1 ms$.
        *   $d_{prop} = 10^6 / (2 \cdot 10^8) = 0.005 s = 5 ms$.
        *   Total: $6 ms$.
2.  **HTTP no persistente**: ¿Cuánto tarda en descargarse una web con 1 objeto si el RTT es de 20ms?
    *   *Resolución:* 1 RTT (establecer TCP) + 1 RTT (petición/respuesta objeto) = 2 RTT + tiempo transmisión.
3.  **DNS**: Diferencia entre consulta iterativa y recursiva.
    *   *Resolución:* En la recursiva, el servidor DNS trabaja por ti hasta tener la IP. En la iterativa, te devuelve la dirección del siguiente servidor al que preguntar.
