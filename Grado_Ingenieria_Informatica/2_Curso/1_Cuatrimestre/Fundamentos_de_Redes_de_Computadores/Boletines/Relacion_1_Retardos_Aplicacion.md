# FRC - Relación 1: Introducción y Capa de Aplicación (Oficial UHU)

## 🧠 Modelado de Retardos
El rendimiento de una red se mide por la latencia total que experimenta un paquete desde el origen hasta el destino.

### Componentes del Retardo
1. **Retardo de Procesamiento ($d_{proc}$)**: Tiempo que tarda un router en examinar la cabecera y determinar el destino.
2. **Retardo de Cola ($d_{cola}$)**: Tiempo de espera en los buffers del router hasta ser transmitido.
3. **Retardo de Transmisión ($d_{trans}$)**: Tiempo necesario para "empujar" todos los bits del paquete al enlace.
   - $d_{trans} = L / R$ ($L$: longitud en bits, $R$: velocidad en bps).
4. **Retardo de Propagación ($d_{prop}$)**: Tiempo que tarda un bit en viajar por el medio físico.
   - $d_{prop} = d / s$ ($d$: distancia, $s$: velocidad de propagación $\approx 2 \cdot 10^8$ m/s).

## 📝 Ejercicios de la Relación

1. **Retardo en un Solo Enlace**
   *Enunciado*: Un paquete de 2 Kbytes viaja por un enlace de 10 Mbps de 2500 km. Halla el retardo total despreciando procesado y cola.
   *Resolución*: 
   - $L = 2 \times 1024 \times 8 = 16384$ bits.
   - $d_{trans} = 16384 / 10^7 = 0.0016384 s \approx 1.64 ms$.
   - $d_{prop} = 2.5 \cdot 10^6 / (2 \cdot 10^8) = 0.0125 s = 12.5 ms$.
   - **Total**: $1.64 + 12.5 = 14.14 ms$.

2. **Cálculo Multi-Salto (Store-and-Forward)**
   *Enunciado*: Queremos enviar un paquete de $L$ bits a través de 3 routers (4 enlaces) con velocidad $R$ cada uno. ¿Cuánto tarda el paquete en llegar si no hay otros retardos?
   *Resolución*: 
   - Cada router debe recibir el paquete completo antes de empezar a retransmitirlo.
   - Tiempo total = $4 \times (d_{trans} + d_{prop})$.

3. **HTTP: Persistente vs No Persistente**
   *Enunciado*: Una página web contiene 10 imágenes pequeñas. Compara el tiempo de descarga (en RTTs) para HTTP/1.0 (no persistente) y HTTP/1.1 (persistente sin pipelining).
   *Resolución*: 
   - **HTTP/1.0**: 1 RTT (Handshake) + 1 RTT (Index) + 10 x (1 RTT Handshake + 1 RTT Objeto) = **22 RTTs**.
   - **HTTP/1.1**: 1 RTT (Handshake) + 1 RTT (Index) + 10 x (1 RTT Objeto) = **12 RTTs**.

---
> [!TIP]
> En problemas de redes, asegúrate de convertir siempre las unidades a bits (multiplica bytes por 8) y las distancias a metros para evitar errores de magnitud.
