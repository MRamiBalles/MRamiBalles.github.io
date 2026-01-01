# TC - Relación 1: Evaluación del Rendimiento (Oficial UHU)

El rendimiento de un sistema informático se define por su capacidad de procesar trabajo en el menor tiempo posible o con la mayor tasa de throughput.

## 🧠 Fundamentos Teóricos
- **Tiempo de Ejecución**: $T_{ex} = IC \times CPI \times T_c = \frac{IC \times CPI}{f}$
  - $IC$: Cuenta de Instrucciones.
  - $CPI$: Ciclos por Instrucción.
  - $f$: Frecuencia de reloj (Hz).
- **MIPS (Millones de Instrucciones por Segundo)**: $MIPS = \frac{f}{CPI \times 10^6}$
- **Ley de Amdahl**: El incremento de velocidad mejora el rendimiento total en función de la fracción de tiempo que se ve afectada por la mejora.
  - $Aceleración_{Global} = \frac{1}{(1 - f_{mejorada}) + \frac{f_{mejorada}}{acc_{local}}}$

## 📝 Ejercicios de la Relación

1. **Cálculo de Tiempos de Ejecución**
   *Enunciado*: Un procesador A funciona a 4GHz y un procesador B a 2GHz. Un programa tarda 10s en A con un CPI de 2.0. Si el mismo programa en B tiene un CPI de 1.2, ¿cuál es más rápido y cuánto?
   *Resolución*: 
   - $IC = \frac{T_{ex} \times f}{CPI} = \frac{10 \times 4 \cdot 10^9}{2} = 20 \cdot 10^9$ instrucciones.
   - $T_{ex, B} = \frac{20 \cdot 10^9 \times 1.2}{2 \cdot 10^9} = 12 s$.
   - **Conclusión**: El procesador A es un **20% más rápido** ($12/10 = 1.2$).

2. **Ley de Amdahl: Optimización de FPU**
   *Enunciado*: Queremos mejorar las instrucciones de punto flotante que representan el 40% del tiempo de ejecución. Si aceleramos estas instrucciones 5 veces, ¿qué mejora global obtenemos?
   *Resolución*: 
   - $Acc_{Global} = \frac{1}{(1 - 0.4) + \frac{0.4}{5}} = \frac{1}{0.6 + 0.08} = \frac{1}{0.68} \approx 1.47$.
   - **Resultado**: El rendimiento global mejora un **47%**.

3. **Comparativa MIPS**
   *Enunciado*: Un procesador tiene un CPI medio de 1.5 y corre a 3GHz. Calcula sus MIPS.
   *Resolución*: 
   - $MIPS = \frac{3000 \cdot 10^6}{1.5 \cdot 10^6} = 2000 MIPS$.

---
> [!WARNING]
> Ten cuidado con los MIPS; no son una medida fiable de rendimiento real entre arquitecturas distintas (anomalía de MIPS), ya que el IC y el CPI varían según el compilador y el ISA.
