# FRC - Relación 4: Capa de Enlace y Ethernet (Oficial UHU)

## 🧠 Contexto Teórico
La capa de enlace gestiona la comunicación entre dos nodos directamente conectados.

*   **Trama**: Unidad de datos de la capa 2.
*   **Dirección MAC**: 48 bits, grabada en el hardware.
*   **Protocolos MAC**: Reparto del canal (ALOHA, CSMA/CD en Ethernet).
*   **Dispositivos**: Hub (capa 1), Switch (capa 2 - aprende direcciones MAC).

## 📝 Ejercicios de la Relación
1.  **CSMA/CD**: ¿Por qué hay una longitud mínima de trama en Ethernet?
    *   *Resolución:* Para asegurar que el emisor detecte la colisión antes de terminar de enviar la trama. Depende del tiempo de propagación ida y vuelta (*slot time*).
2.  **Direccionamiento**: Diferencia entre IP y MAC.
    *   *Resolución:* La IP es jerárquica y lógica (capa 3). La MAC es plana y física (capa 2). El protocolo **ARP** traduce de IP a MAC.
3.  **VLANs**: ¿Para qué sirven?
    *   *Resolución:* Permiten segmentar una red física en varias redes lógicas independientes para mejorar la seguridad y reducir el tráfico de broadcast.
