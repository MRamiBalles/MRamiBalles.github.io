# DESO - Relación 1: Conceptos Fundamentales de Sistemas Operativos

El Diseño y Estructura de los Sistemas Operativos (DESO) se centra en la capa de software que actúa como interfaz entre el hardware y las aplicaciones, gestionando los recursos de forma eficiente y segura.

## 1. Funciones del Sistema Operativo
- **Gestión de Procesos**: Planificación, creación y destrucción de procesos.
- **Gestión de Memoria**: Administración del espacio de direcciones y jerarquía de memoria (RAM vs Disco).
- **Gestión de Almacenamiento**: Abstracción del hardware mediante sistemas de archivos.
- **Seguridad y Protección**: Control de acceso a recursos y aislamiento de procesos.

## 2. Tipos de Estructuras (Arquitecturas)
- **Sistemas Monolíticos**: Todo el SO se ejecuta en el espacio del núcleo (kernel mode). Alta eficiencia pero baja modularidad.
- **Microkernels**: Solo las funciones mínimas están en el núcleo; el resto se ejecuta como servidores en espacio de usuario. Mayor robustez y extensibilidad.
- **Sistemas por Capas**: Organización jerárquica donde cada capa ofrece servicios a la superior.

## 📝 Ejercicio Teórico: Llamadas al Sistema (System Calls)
Explique el proceso de transición de modo usuario a modo núcleo cuando se invoca una llamada al sistema `read()`.
*Respuesta*: Se genera una interrupción por software (trap). La CPU guarda el estado del proceso actual, cambia el bit de modo a 'núcleo' y transfiere el control a la rutina de servicio del sistema operativo predefinida en la tabla de vectores de interrupción. Una vez completada la operación, se restaura el estado y se vuelve al modo usuario.

## 3. Estados de un Proceso
Un proceso evoluciona a través de los estados: **Nuevo**, **Listo**, **Ejecución**, **Bloqueado** y **Terminado**. El planificador (scheduler) es responsable de las transiciones entre estos estados basándose en políticas de prioridad o tiempo.
