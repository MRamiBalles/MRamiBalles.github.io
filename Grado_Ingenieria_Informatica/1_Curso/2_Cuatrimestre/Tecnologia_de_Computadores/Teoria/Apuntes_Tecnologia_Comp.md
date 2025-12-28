# Tecnología de Computadores (Apuntes ETSI)

*Análisis de rendimiento, segmentación y jerarquía de memoria.*

## 1. Evaluación del Rendimiento
No medimos en MHz, sino en Tiempo de CPU.
$T_{CPU} = \text{I} \cdot \text{CPI} \cdot T_{ciclo}$
*   **I**: Número de instrucciones del programa.
*   **CPI**: Ciclos por Instrucción (media).
*   **T ciclo**: Inversa de la frecuencia de reloj.

## 2. Jerarquía de Memoria y Memoria Caché
El objetivo es ofrecer la velocidad de la memoria más rápida con la capacidad de la más barata.
*   **Caché:** Basada en la *Localidad Temporal* (si usas algo, lo volverás a usar pronto) y *Localidad Espacial* (si usas algo, usarás lo que tiene al lado).
*   **Mapeo:** Directo, Asociativo por conjuntos, Totalmente Asociativo.

## 3. Segmentación (Pipelining)
Dividir la ejecución en etapas (FETCH, DECODE, EXE, MEM, WB) para ejecutar varias instrucciones a la vez. 
*   **Riesgos (Hazards):** Estructurales, de Datos y de Control (Saltos).

---
> [!TIP]
> **Ley de Amdahl:** Sirve para calcular la mejora máxima si solo optimizas una parte del sistema. "La mejora total está limitada por la fracción que no se mejora".
