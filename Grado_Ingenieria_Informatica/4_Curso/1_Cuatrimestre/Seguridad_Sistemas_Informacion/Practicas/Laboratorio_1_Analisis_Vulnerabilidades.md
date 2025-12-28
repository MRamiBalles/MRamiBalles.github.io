# SSI - Lab 1: Auditoría de Seguridad y Análisis de Vulnerabilidades

Este laboratorio práctico se enfoca en la identificación proactiva de debilidades en sistemas y redes, siguiendo metodologías estándar de la industria (OWASP, OSSTMM).

## 1. Objetivos del Laboratorio
- Realizar el reconocimiento de activos en una red controlada.
- Ejecutar escaneos de puertos y servicios para identificar vectores de ataque.
- Analizar vulnerabilidades conocidas (CVE) y proponer medidas de mitigación.

## 2. Metodología de Ejecución
1.  **Fase de Reconocimiento (Footprinting)**: Uso de herramientas pasivas y activas para determinar la topología.
2.  **Fase de Escaneo**: Empleo de `Nmap` para la detección de servicios y versiones de software.
3.  **Análisis de Vulnerabilidades**: Uso de `Nessus` u `OpenVAS` para la correlación con bases de datos de vulnerabilidades.

## 3. Guion de Actividades
- **Tarea A**: Identifique los servicios en ejecución en el host `10.0.2.15` y determine si existe algún servicio de gestión remota inseguro (ej. Telnet).
- **Tarea B**: Verifique la presencia de la vulnerabilidad *EternalBlue* (MS17-010) mediante el uso de scripts de `Nmap` (`--script vuln`).
- **Tarea C**: Redacte un informe técnico de hallazgos, priorizando las vulnerabilidades por su puntuación CVSS (Common Vulnerability Scoring System).

## 📝 Formato de Reporte de Hallazgos
| Activo | Vulnerabilidad | Gravedad | Puntuación CVSS | Mitigación Propuesta |
| :--- | :--- | :--- | :--- | :--- |
| Server-DB | SQL Injection | Alta | 8.5 | Uso de consultas parametrizadas. |
| Switch-01 | Default Credentials | Crítica | 10.0 | Cambio inmediato de credenciales. |

---
*Laboratorio de Seguridad - ETSI Universidad de Huelva.*
