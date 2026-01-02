# Metaheurísticas - Relación 1: Búsqueda por Trayectorias

Los algoritmos de trayectoria parten de una única solución inicial y la mejoran iterativamente moviéndose a soluciones vecinas.

## 1. Búsqueda Local y el Problema de los Mínimos Locales
- **Hill Climbing (Escalada)**: Acepta siempre el mejor vecino.
  - *Problema*: Se queda atrapado fácilmente en óptimos locales (cimas de colinas que no son la cima más alta).

## 2. Enfriamiento Simulado (Simulated Annealing)
Inspirado en el recocido de metales. Permite aceptar peores soluciones con una probabilidad que disminuye con el tiempo (Temperatura).

### Función de Probabilidad de Boltzmann
La probabilidad de aceptar una solución peor ($E_{nueva} > E_{actual}$ en minimización) es:
$$P(\Delta E, T) = e^{-\frac{\Delta E}{T}}$$
Donde $\Delta E = E_{nueva} - E_{actual}$ y $T$ es la temperatura actual.
- Al principio ($T$ alta): $P \approx 1$ (Exploración, comportamiento aleatorio).
- Al final ($T$ baja): $P \approx 0$ (Explotación, comportamiento Hill Climbing).

## 3. Búsqueda Tabú (Tabu Search)
Utiliza la memoria para guiar la búsqueda y evitar ciclos.
- **Lista Tabú**: Mantiene los últimos movimientos realizados. Estos movimientos están "prohibidos" (tabú) durante un tiempo (tenencia tabú) para evitar volver atrás inmediatamente.
- **Criterio de Aspiración**: Regla que permite violar la restricción tabú si la solución encontrada es excelente (ej. mejor que la mejor global encontrada hasta ahora).

---

## 📝 Ejercicio Técnico: Traza de Búsqueda Tabú
**Problema**: Minimizar $f(x) = x^2$ en el rango $[-10, 10]$. Solución actual $x=3$. Vecindario $N(x) = \{x-1, x+1\}$.
**Lista Tabú**: Tamaño 2. Inicialmente vacía.

**Iteración 1**:
- Actual: $x=3, f(3)=9$.
- Vecinos:
  - $x=2, f(2)=4$.
  - $x=4, f(4)=16$.
- Mejor vecino: $x=2$. ¿Es Tabú? No.
- Movimiento: Ir a $x=2$.
- Lista Tabú: $\{3\}$ (prohibido volver a 3).

**Iteración 2**:
- Actual: $x=2, f(2)=4$.
- Vecinos:
  - $x=1, f(1)=1$.
  - $x=3, f(3)=9$.
- Mejor vecino no tabú: $x=1$ (3 es tabú).
- Movimiento: Ir a $x=1$.
- Lista Tabú: $\{3, 2\}$.

**Iteración 3**:
- Actual: $x=1, f(1)=1$.
- Vecinos: $x=0 (0), x=2 (4)$.
- 2 es Tabú. Elegimos 0.
- Lista Tabú: $\{2, 1\}$ (el 3 sale de la lista).

---
> [!TIP]
> **Estrategia**: Simulated Annealing es mejor cuando no conocemos nada del terreno (búsqueda ciega robusta). Tabu Search es muy potente si podemos diseñar un buen vecindario y una memoria inteligente.
