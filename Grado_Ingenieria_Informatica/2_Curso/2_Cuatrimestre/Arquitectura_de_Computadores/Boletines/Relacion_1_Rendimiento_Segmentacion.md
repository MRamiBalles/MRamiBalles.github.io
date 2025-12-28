# AC - Relación 1: Rendimiento y Segmentación Avanzada (Oficial UHU)

## 🧠 Repaso para el examen
En AC ya no vemos el pipeline básico de 5 etapas de Tecnología (1º), aquí se asume que lo sabes. Nos centramos en cómo exprimir la CPU al máximo.

*   **Ley de Amdahl**: "No sirve de nada mejorar mucho algo que se usa poco". 
    - $Speedup = \frac{1}{(1-f) + f/s}$
*   **Riesgos de Control**: Aquí vemos técnicas como el **Salto Retardado** (delayslot) o la **Predicción de Saltos** (estática y dinámica).
*   **CPI**: Ciclos por instrucción. El objetivo es que sea 1 (ideal) o menor (superescalares).

## 📝 Ejercicios "típicos de parcial"
1.  **Cálculo de Speedup**: Una mejora acelera las instrucciones de coma flotante 10 veces ($s=10$). Estas instrucciones suponen el 40% del tiempo total ($f=0.4$). ¿Cuánto mejora todo el sistema?
    *   *Resolución*: $S = \frac{1}{(1-0.4) + 0.4/10} = \frac{1}{0.6 + 0.04} = \frac{1}{0.64} = 1.56$.
    *   *Moraleja*: Aunque la mejora sea de 10x, el sistema global solo mejora un 56% porque solo afectamos a una parte pequeña.
2.  **Penalización por Salto**: Tenemos un pipeline donde el 20% son saltos. Si no predecimos, perdemos 3 ciclos por salto.
    *   *Cálculo del CPI*: $CPI = 1 (\text{base}) + 0.20 \cdot 3 = 1.6$. 
    *   *Si añadimos predicción (80% acierto)*: El fallo ahora solo ocurre el 20% del 20% de las veces. $CPI = 1 + 0.20 \cdot 0.20 \cdot 3 = 1.12$. ¡Mucho mejor!
3.  **Bucle Unrolling (Desenrollado)**: ¿Para qué sirve?
    *   *Organic Tip*: Sirve para quitar "basura" (el contador `i++` y el `if`) y dejar que el procesador vea más instrucciones de cálculo seguidas, facilitando el paralelismo.
