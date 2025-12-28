# 🏥 Simulacro de Examen: Arquitectura de Computadores (AC)
*Nivel: Parcial 1 (Segmentación y Rendimiento)*

## ⏱️ Instrucciones
- Tiempo sugerido: 90 minutos.
- Se permite calculadora no programable.
- ¡Ojo con las latencias! No te comas ciclos.

---

### [Ejercicio 1] Rendimiento (2.5 puntos)
Un programa tarda 100 segundos en ejecutarse en una CPU actual. El 30% del tiempo se dedica a operaciones de E/S. Queremos una mejora en el procesador que haga que el cálculo sea 5 veces más rápido.
- **a)** ¿Cuál es la ganancia de velocidad (speedup) global?
- **b)** Si quisiéramos un speedup global de 3, ¿es físicamente posible actuando solo sobre el tiempo de cálculo? Demuéstralo.

### [Ejercicio 2] Segmentación y Riesgos (2.5 puntos)
Dado el siguiente código MIPS:
```assembly
I1: L.D F2, 0(R1)
I2: ADD.D F4, F2, F0
I3: S.D F4, 8(R1)
```
- **a)** Identifica todas las dependencias de datos.
- **b)** Dibuja el diagrama de tiempos para un pipeline de 5 etapas sin adelantamiento (forwarding). Indica dónde hay burbujas.
- **c)** Calcula el CPI de este fragmento de código.

### [Ejercicio 3] Tomasulo (5 puntos)
Tienes 2 unidades de suma (latencia 2) y 1 de multiplicación (latencia 4). Rellena la tabla de estado de las estaciones de reserva en el ciclo 5 para el siguiente código:
1. `ADD.D F6, F2, F0`
2. `MUL.D F0, F6, F4`
3. `ADD.D F8, F0, F2`

---

## 🔑 Soluciones (Brief)
*Solo mira esto después de intentarlo.*

1. **Amdahl**: $S = 1 / (0.3 + 0.7/5) = 1 / 0.44 = 2.27x$. Para un speedup de 3, el límite teórico es $1/0.3 = 3.33$. Es posible, pero tendrías que acelerar el cálculo casi infinitamente ($S_{calc} \approx 30$).
2. **Dependencias**: RAW en F2 (I1-I2) y RAW en F4 (I2-I3).
3. **Tomasulo**: En el ciclo 5, la I1 ya ha terminado, la I2 está ejecutándose y la I3 está en emisión esperando por F0 (`Qj = Mult1`).
