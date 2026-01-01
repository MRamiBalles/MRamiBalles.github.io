# IRC - Relación 2: Enrutamiento Dinámico y Listas de Control de Acceso (ACL)

El enrutamiento dinámico permite que los routers intercambien información sobre la topología de la red automáticamente, mientras que las ACLs proporcionan el mecanismo fundamental de filtrado y seguridad.

## 1. Protocolos de Enrutamiento Dinámico
- **RIP (Routing Information Protocol)**: Vector de distancia. Métrica: Saltos (máx 15). Envía actualizaciones completas cada 30s.
- **OSPF (Open Shortest Path First)**: Estado de enlace. Algoritmo de Dijkstra. Métrica: Coste (basado en ancho de banda). Convergencia rápida y soporte de áreas.

### 📝 Ejercicio de Examen: Tabla de Rutas
Dado un router con las siguientes rutas aprendidas por OSPF:
- `10.0.1.0/24 [110/65]`
- `10.0.1.0/24 [120/2]` (vía RIP)

**¿Cuál elegirá el router?**
*Respuesta*: OSPF. El router decide basándose en la **Distancia Administrativa (AD)**. RIP tiene AD=120 y OSPF AD=110. Cuanto menor sea la AD, más "fiable" es el protocolo.

## 2. Listas de Control de Acceso (ACL)
Las ACLs se procesan de arriba a abajo. Al final siempre hay un `deny any` implícito.

### 📝 Caso Práctico: ACL Extendida
**Escenario**: Impedir que los hosts de la red `192.168.1.0/24` accedan al servidor web (`172.16.0.10`) pero permitirles el resto de accesos.

```bash
access-list 101 deny tcp 192.168.1.0 0.0.0.255 host 172.16.0.10 eq 80
access-list 101 permit ip any any
# Aplicar en la interfaz de entrada del router
interface gigabitEthernet 0/0
 ip access-group 101 in
```

## 3. Traducción de Direcciones de Red (NAT)
- **Estático**: 1 a 1 (servidores).
- **Dinámico**: Pool de direcciones.
- **PAT (Overload)**: Muchos a 1 usando puertos (lo más común en hogares).

---
> [!TIP]
> **Wildcard Masks**: En las ACLs no se usa la máscara de subred convencional, sino su inversa (Wildcard). Para `/24` (255.255.255.0), la wildcard es `0.0.0.255`.
