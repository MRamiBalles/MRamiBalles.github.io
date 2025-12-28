# IRC - Caso Práctico: Diseño de Direccionamiento IP (VLSM)

El Variable Length Subnet Masking (VLSM) permite una utilización eficiente del espacio de direccionamiento IPv4 al asignar máscaras de longitud variable según las necesidades específicas de cada subred.

## 1. Fundamentación Técnica
A diferencia del direccionamiento de clases (Classful), VLSM permite la subdivisión de una red en subredes de tamaños desiguales, minimizando el desperdicio de direcciones IP.
- **Estrategia de Asignación**: Se deben ordenar las subredes de mayor a menor número de hosts requeridos para evitar solapamientos y maximizar la agregación.

## 📝 Ejercicio de Ingeniería: Diseño de Red ETSI
Dada la dirección de red base `192.168.10.0/24`, diseñe el esquema de direccionamiento para las siguientes dependencias:
- **Laboratorio A**: 60 hosts.
- **Laboratorio B**: 30 hosts.
- **Administración**: 12 hosts.
- **Enlaces (2 enlaces WAN)**: 2 hosts cada uno.

## 🚀 Resolución Paso a Paso

1. **Laboratorio A (60 hosts)**: Se necesitan $2^6 - 2 = 62$ direcciones. Máscara `/26`.
   - Red: `192.168.10.0/26`
   - Rango: `.1` a `.62` | Broadcast: `.63`

2. **Laboratorio B (30 hosts)**: Se necesitan $2^5 - 2 = 30$ direcciones. Máscara `/27`.
   - Red: `192.168.10.64/27`
   - Rango: `.65` a `.94` | Broadcast: `.95`

3. **Administración (12 hosts)**: Se necesitan $2^4 - 2 = 14$ direcciones. Máscara `/28`.
   - Red: `192.168.10.96/28`
   - Rango: `.97` a `.110` | Broadcast: `.111`

4. **Enlaces WAN (2 hosts c/u)**: Se necesitan $2^2 - 2 = 2$ direcciones. Máscara `/30`.
   - WAN 1: `192.168.10.112/30`
   - WAN 2: `192.168.10.116/30`

*Propiedad de Agregación (CIDR)*: Este diseño permite resumir todas las subredes bajo una única ruta en el núcleo de la red, optimizando las tablas de enrutamiento de los routers troncales.
