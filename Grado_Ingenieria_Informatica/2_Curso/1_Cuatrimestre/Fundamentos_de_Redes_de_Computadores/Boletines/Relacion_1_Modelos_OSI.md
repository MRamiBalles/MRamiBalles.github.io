# Redes de Computadores - Relación 1: El Modelo de Referencia OSI y la Pila TCP/IP

La comunicación en redes de datos se basa en arquitecturas estratificadas que permiten la interoperabilidad entre sistemas heterogéneos mediante la definición de protocolos y niveles de servicio.

## 1. El Modelo de Referencia OSI (ISO)
Divide las funciones de red en 7 capas conceptuales:
1.  **Física**: Transmisión de bits a través del canal.
2.  **Enlace**: Gestión de acceso al medio y detección de errores (Tramas).
3.  **Red**: Enrutamiento y direccionamiento lógico (Paquetes).
4.  **Transporte**: Transferencia de datos extremo a extremo con control de flujo y errores.
5.  **Sesión**, **Presentación** y **Aplicación**: Capas orientadas al usuario y formato de datos.

## 2. La Pila TCP/IP
Modelo pragmático utilizado en Internet, simplificado en 4 capas:
- **Acceso a Red**: Equivalente a las capas 1 y 2 de OSI.
- **Internet**: Protocolo IP.
- **Transporte**: Protocolos TCP (orientado a conexión) y UDP (no orientado a conexión).
- **Aplicación**: Protocolos HTTP, FTP, DNS, SMTP.

## 3. Unidades de Datos de Protocolo (PDU)
Cada capa añade metadatos (cabeceras) a los datos de la capa superior mediante el proceso de **Encapsulación**.
- Capa 4: Segmento / Datagrama.
- Capa 3: Paquete.
- Capa 2: Trama.

## 📝 Ejercicio Teórico: Comparativa TCP vs UDP
Explique por qué un protocolo de transmisión de video en tiempo real suele utilizar UDP en lugar de TCP.
*Respuesta*: TCP garantiza la entrega mediante retransmisiones y control de congestión, lo que introduce una latencia (jitter) inaceptable para el streaming en tiempo real. UDP prioriza la velocidad y la baja latencia sobre la fiabilidad, permitiendo la pérdida de paquetes aislados sin detener el flujo multimedia.
