# FRC - Relación 5: Detalle de la Capa de Aplicación (Oficial UHU)

## 🧠 Protocolos que usamos a diario
Aquí profundizamos en cómo funcionan los programas que se conectan a la red.

*   **HTTP**: Sin estado (*stateless*). Cookies para mantener la sesión. Mensajes GET, POST, HEAD.
*   **DNS**: Árbol jerárquico. Servidores Raíz -> TLD -> Autoritativos. Usa UDP puerto 53 (normalmente).
*   **SMTP/POP3/IMAP**: Los protocolos del correo. SMTP envía, POP3 descarga y borra, IMAP mantiene en el servidor.

## 📝 Ejercicios "de red"
1.  **DNS Jerárquico**: ¿Qué pasa cuando pides `www.uhu.es`?
    *   *Resolución*: Tu PC pregunta al resolver local. Si no sabe, va al Root (.), luego al `.es`, luego al de la `uhu.es` y este le da la IP. Todo esto suele tardar unos ms gracias a la caché DNS.
2.  **Tiempo de descarga HTTP**: Un objeto de 1MB en un enlace de 10Mbps con RTT de 100ms.
    *   *Cálculo*: $d_{trans} = (10^6 \cdot 8) / 10^7 = 0.8 s$. Si es no persistente, sumamos 2 RTT (0.2s). Total $\approx 1s$.
3.  **Cabeceras HTTP**: Diferencia entre código 200, 404 y 500.
    *   *Resolución*: 
        - **200 OK**: Todo bien.
        - **404 Not Found**: No existe el archivo (has escrito mal la URL).
        - **500 Server Error**: El servidor ha petado (error de PHP/Java/etc).
---
> [!IMPORTANT]
> **Puerto 80 vs 443**: El 80 es HTTP (texto plano, peligroso). El 443 es HTTPS (encriptado con TLS/SSL). ¡Fijo en el test de Redes!
