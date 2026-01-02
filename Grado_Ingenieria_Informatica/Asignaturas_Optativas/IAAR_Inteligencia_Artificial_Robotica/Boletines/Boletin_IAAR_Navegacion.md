# IAAR - Boletín: Navegación y Planificación de Trayectorias

En este boletín abordamos el problema fundamental de la robótica móvil autónoma: ¿Cómo hago que el robot se mueva del punto A al B sin chocarse y sabiendo dónde está?

## 1. Navegación y Localización (SLAM)
El santo grial de la robótica móvil es el **SLAM** (Simultaneous Localization and Mapping). El problema es el del huevo y la gallina: para hacer un mapa necesito saber dónde estoy, pero para saber dónde estoy necesito un mapa.

- **Filtro de Kalman Extendido (EKF)**:
  Es la solución clásica. Asume que todo el ruido es gaussiano (campana de Gauss). Mantiene una estimación probabilística de dónde creemos que está el robot y una matriz de covarianza (nuestra incertidumbre).
    - *Predicción*: "Si me moví 1 metro adelante, debería estar aquí". (Usa odometría).
    - *Actualización*: "Pero el láser dice que la pared está más cerca, así que corrijo mi posición". (Usa sensores).

- **Filtro de Partículas (Monte Carlo)**:
  Más moderno y robusto. En lugar de una sola estimación matemática, lanzamos miles de "partículas" (hipótesis) en el mapa.
  - Al principio, las partículas están por todo el mapa (incertidumbre total).
  - A medida que el robot se mueve y detecta paredes, las partículas que no coinciden con la realidad "mueren".
  - Las que sobreviven se agrupan, indicando la posición más probable. Es genial para recuperarse del "problema del robot secuestrado" (si teletransportas al robot).

## 2. Planificación de Trayectorias (Path Planning)
Una vez sé dónde estoy y tengo el mapa, necesito calcular la ruta óptima.

### A* (A Star)
Es el algoritmo de búsqueda en grafos por excelencia (el que usan los videojuegos).
- Usa una función de coste $f(n) = g(n) + h(n)$, donde $g$ es lo que ya has recorrido y $h$ es una heurística (estimación) de lo que falta.
- **Veredicto**: Es óptimo (encuentra el mejor camino), pero si el mapa es enorme o tiene muchas dimensiones, se vuelve lento.

### RRT (Rapidly-exploring Random Trees)
Este es mucho más interesante para robótica compleja (brazos, drones). En lugar de buscar en una rejilla cuadriculada, ¡muerea aleatoriamente!
1.  Elijo un punto al azar en el espacio ($q_{rand}$).
2.  Busco el nodo más cercano en mi árbol actual ($q_{near}$).
3.  Intento extender una rama hacia ese punto aleatorio.
4.  Si no choco con nada, añado la rama.

**Ventaja Clave**: Explorar espacios de alta dimensión rapidísimo. No garantiza el camino más corto, pero garantiza encontrar **un** camino si existe, lo cual a veces es más importante.

## 📝 Ejercicio Teórico: RRT
Dibuja un espacio 2D con un obstáculo circular en el centro. Simula 5 iteraciones del algoritmo RRT partiendo de la esquina inferior izquierda (0,0) intentando llegar a la superior derecha (10,10).
1.  Generar $q_{rand}$.
2.  Buscar $q_{near}$.
3.  Comprobar colisión.
4.  Añadir rama.

---
> [!NOTE]
> **Relación con ROS**: En la industria, estos algoritmos se implementan usando el **Navigation Stack** de ROS (Robot Operating System), que usa `amcl` (Monte Carlo) para localización y `move_base` (Costmaps + Planners) para movimiento.
