# IRC - Teoría 1: Arquitectura de Redes y Protocolos de Enrutamiento (Oficial UHU)

La Interconexión de Redes de Computadores (IRC) se centra en el diseño y despliegue de infraestructuras de red escalables y seguras en la capa de red del modelo OSI.

## 1. Fundamentos del Enrutamiento IP
El enrutamiento es el proceso de selección de rutas en una red para enviar paquetes de datos. Se basa en el uso de tablas de enrutamiento gestionadas por routers.
- **Enrutamiento Estático**: Configuración manual de rutas. Baja escalabilidad.
- **Enrutamiento Dinámico**: Uso de protocolos para la actualización automática de rutas.

## 2. Protocolos de Vector de Distancia (RIP)
Basados en el algoritmo de Bellman-Ford. Utilizan el número de saltos como métrica para la selección del camino más corto.
- **Limitación**: El problema de la "cuenta a infinito". Se mitiga con técnicas como *split horizon* y *poison reverse*.

## 3. Protocolos de Estado de Enlace (OSPF)
Basados en el algoritmo de Dijkstra. Cada router posee un conocimiento completo de la topología de la red (Link State Database).
- **Ventajas**: Convergencia rápida y soporte para redes de gran escala mediante el uso de áreas.

## 4. Redes de Área Amplia y BGP
El protocolo BGP (Border Gateway Protocol) es el estándar para el enrutamiento entre Sistemas Autónomos (AS) en Internet. Utiliza un enfoque de vector de caminos (*path vector*).

## 📝 Ejercicio Técnico: Cálculo de Rutas OSPF
Dado un grafo de red con costes en las aristas, determine el árbol de expansión de caminos mínimos desde el nodo raíz utilizando el algoritmo de Dijkstra.

*Concepto Crítico*: Diferencia entre un conmutador (switch de capa 2) y un router (capa 3) en términos de dominios de colisión y dominios de difusión (broadcast). Los routers fragmentan los dominios de difusión, permitiendo una gestión eficiente del tráfico de red.
