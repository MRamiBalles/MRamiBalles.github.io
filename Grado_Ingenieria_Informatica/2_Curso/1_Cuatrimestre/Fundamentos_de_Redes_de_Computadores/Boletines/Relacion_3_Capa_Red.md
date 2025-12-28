# FRC - Relación 3: Capa de Red e IP (Oficial UHU)

## 🧠 Contexto Teórico
La capa de red se encarga del direccionamiento y enrutamiento paquete a paquete.

*   **Dirección IPv4**: 32 bits divididos en 4 octetos.
*   **Máscara de Subred**: Indica qué parte es red y qué parte es host.
*   **Subnetting**: Dividir una red grande en trozos pequeños para mayor eficiencia y seguridad.
*   **CIDR**: Notación `/24`, `/16`, etc.

## 📝 Ejercicios de la Relación
1.  **Cálculo de Red**: Dada la IP `192.168.1.50` y máscara `255.255.255.0`, halla la dirección de red.
    *   *Resolución:* Hacemos un AND binario. La máscara es un `/24`. Dirección de red: `192.168.1.0`.
2.  **Subnetting**: Divide la red `10.0.0.0/8` en 4 subredes iguales.
    *   *Resolución:* Necesitamos "robar" 2 bits al host ($2^2=4$). La nueva máscara es $/10$.
        *   Subred 1: `10.0.0.0/10`
        *   Subred 2: `10.64.0.0/10`
        *   Subred 3: `10.128.0.0/10`
        *   Subred 4: `10.192.0.0/10`
3.  **Hosts Disponibles**: ¿Cuántos hosts útiles tiene un `/27`?
    *   *Resolución:* Quedan $32-27 = 5$ bits para host. $2^5 - 2 = 30$ direcciones útiles (quitamos red y broadcast).
