# STR - Relación 3: Compartición de Recursos y Protocolos de Techo (Oficial UHU)

En sistemas de tiempo real, el uso de semáforos convencionales para proteger secciones críticas puede provocar el fenómeno de la **Inversión de Prioridad**.

## 1. Inversión de Prioridad
Ocurre cuando una tarea de alta prioridad ($H$) es bloqueada por una de baja prioridad ($L$) que posee un recurso, mientras una tarea intermedia ($M$) expulsa a $L$ de la CPU, retrasando indirectamente a $H$ indefinidamente.

## 2. Priority Inheritance Protocol (PIP)
- **Mecanismo**: Cuando $H$ intenta acceder a un recurso bloqueado por $L$, $L$ hereda temporalmente la prioridad de $H$.
- **Limitación**: No evita interbloqueos (*deadlocks*) ni el bloqueo encadenado.

## 3. Priority Ceiling Protocol (PCP)
- **Techo de Prioridad**: Cada recurso tiene un techo igual a la prioridad de la tarea más alta que puede usarlo.
- **Regla de Bloqueo**: Una tarea solo puede entrar en su sección crítica si su prioridad es estrictamente mayor que el techo de todos los recursos actualmente bloqueados por otras tareas.
- **Ventajas**: Evita deadlocks y garantiza que una tarea solo sufra bloqueo una vez por cada ciclo de ejecución.

## 📝 Ejercicio Técnico: Análisis de Bloqueo
Identifique el "Peor Caso de Bloqueo" ($B_i$) para una tarea $\tau_i$ bajo PCP.
*Respuesta*: $B_i$ es el tiempo máximo que $\tau_i$ puede estar bloqueada por tareas de menor prioridad que poseen recursos cuyo techo de prioridad es $\ge Pri(\tau_i)$. Bajo PCP, este bloqueo se produce como máximo una vez por el recurso de mayor duración.

---
*Escuela Técnica Superior de Ingeniería - Universidad de Huelva.*
