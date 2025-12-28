# 🏥 Simulacro de Examen: Fundamentos de Redes de Computadores (FRC)
*Nivel: Examen Final (Arquitectura y Protocolos)*

## ⏱️ Instrucciones
- Tiempo sugerido: 180 minutos.
- Justifique técnicamente todas las respuestas basándose en el modelo OSI.

---

### [Ejercicio 1] Capa Física y de Enlace (2.5 puntos)
Se dispone de un enlace de fibra óptica con un ancho de banda de 1 Gbps y un retardo de propagación de 10 ms.
- **a)** Calcule el tamaño máximo de ventana para un protocolo de ventana deslizante ("Go-Back-N") si se desea una utilización del canal del 100% con tramas de 1500 bytes.
- **b)** Explique la diferencia entre el método de acceso CSMA/CD y CSMA/CA. ¿Por qué se utiliza este último en redes Wi-Fi?

### [Ejercicio 2] Capa de Red e IP (3.5 puntos)
Un router recibe un datagrama IP con una longitud total de 4000 bytes y debe enviarlo a través de un enlace con una MTU de 1500 bytes.
- **a)** Determine el número de fragmentos resultantes.
- **b)** Indique para cada fragmento: Longitud (Total Length), Flag 'More Fragments' y el Desplazamiento (Fragment Offset).

### [Ejercicio 3] Capa de Transporte (4 puntos)
Considere una conexión TCP que se encuentra en la fase de "Congestion Avoidance" con un `cwnd` de 16 segmentos.
- **a)** ¿Qué ocurre con el `cwnd` si se produce un "Triple Duplicate ACK"? ¿Y si se produce un "Timeout"?
- **b)** Analice el proceso de establecimiento de conexión ("Three-way handshake"). ¿Qué valores de Flags (SYN, ACK) y Números de Secuencia se intercambian?

---

## 🔑 Soluciones (Brief)
1. **Utilización**: Se requiere $W \ge (2 \cdot t_{prop} \cdot R) / L + 1$.
2. **Fragmentación**: Fragmento 1 (1500 bytes, MF=1, Off=0), Frag 2 (1500, MF=1, Off=185), Frag 3 (1040, MF=0, Off=370). *Nota: Offsets calculados en unidades de 8 bytes.*
3. **TCP**: Triple ACK $\implies cwnd = cwnd/2$ (Fast Recovery). Timeout $\implies cwnd = 1$ (Slow Start).
