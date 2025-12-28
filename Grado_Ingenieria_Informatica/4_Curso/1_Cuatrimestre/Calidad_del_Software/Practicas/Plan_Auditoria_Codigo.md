# CS - Práctica Avanzada: Plan de Auditoría de Código y Métricas Estáticas

La calidad del software no es accidental; requiere la aplicación de procesos de revisión formal y el análisis automatizado de la base de código.

## 1. Alcance de la Auditoría
Este plan define las actividades de verificación para garantizar que el software cumple con los estándares de mantenibilidad, fiabilidad y eficiencia definidos en la ISO/IEC 25010.

## 2. Herramientas de Análisis Estático
Se propone la integración en el pipeline de CI/CD de las siguientes herramientas:
- **SonarQube**: Para el seguimiento de la deuda técnica, "code smells" y cobertura de pruebas.
- **Checkstyle/ESLint**: Para garantizar el cumplimiento de las normas de estilo de codificación.
- **Valgrind**: Para la detección de fugas de memoria y errores de direccionamiento en tiempo de ejecución.

## 3. Métricas de Interés
- **Complejidad Ciclo-mática por Módulo**: El límite aceptable se establece en $V(G) \le 10$.
- **Densidad de Comentarios**: Se requiere un ratio mínimo del 20% para facilitar el mantenimiento.
- **Acoplamiento Eferente y Aferente**: Control de dependencias entre paquetes para evitar arquitecturas quebradizas.

## 📝 Documento de Resultados (Plantilla)
| Módulo | Complejidad $V(G)$ | Líneas de Código (LOC) | Hallazgos Críticos | Acción Correctiva |
| :--- | :--- | :--- | :--- | :--- |
| `Autenticador.cpp` | 15 | 450 | Exceso de anidamiento | Refactorización de lógica. |
| `GestorDB.java` | 6 | 200 | Falta de logs en errores | Implementación de SLF4J. |

---
*Calidad del Software - ETSI Universidad de Huelva.*
