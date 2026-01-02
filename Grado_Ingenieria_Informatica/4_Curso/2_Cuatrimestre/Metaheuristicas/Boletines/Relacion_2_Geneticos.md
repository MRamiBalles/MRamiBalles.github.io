# Metaheurísticas - Relación 2: Algoritmos Genéticos (Oficial UHU)

Los Algoritmos Genéticos (AG) son métodos de búsqueda estocástica basados en la teoría de la evolución natural y la genética. Trabajan con una **población** de soluciones en lugar de una única solución.

## 1. Componentes Básicos
- **Individuo (Cromosoma)**: Representación de una posible solución.
  - **Genotipo**: La codificación interna (ej. cadena de bits `101101`).
  - **Fenotipo**: La expresión de la solución en el mundo real (ej. valor $x=45$).
- **Población**: Conjunto de individuos en una generación $t$.
- **Fitness (Aptitud)**: Función objetivo que queremos optimizar.

## 2. El Ciclo Evolutivo
1.  **Inicialización**: Generar población aleatoria $P(0)$.
2.  **Evaluación**: Calcular fitness de cada individuo de $P(t)$.
3.  **Selección**: Elegir los padres de la siguiente generación.
    - **Ruleta**: Probabilidad proporcional al fitness ($p_i = f_i / \sum f_j$).
    - **Torneo**: Elegir $k$ al azar y quedarse con el mejor.
4.  **Cruce (Crossover)**: Combinar material genético de padres para crear hijos.
    - **Un Punto**: Cortar y pegar.
    - **PMX (Partially Mapped Crossover)**: Para permutaciones (ej. TSP) para evitar duplicados.
5.  **Mutación**: Alterar aleatoriamente un gen con probabilidad muy baja ($p_m \approx 0.01$). Introduce diversidad.
6.  **Reemplazo**: Formar $P(t+1)$.

## 3. Teorema de los Esquemas (Holland)
Explica por qué funcionan los AG.
- **Esquema ($H$)**: Patron que representa un subconjunto de cadenas (ej. `1*0*` representa `1000`, `1001`, `1100`, `1101`).
- **Teorema**: Los esquemas de **bajo orden** (pocos bits fijos), **corta longitud** (distancia entre bits fijos) y **fitness superior a la media** aumentan exponencialmente en la población.

## 📝 Ejercicio Técnico: Algoritmo Genético Manual
**Objetivo**: Maximizar $f(x) = x^2$ en el rango $[0, 31]$. Codificación binaria de 5 bits.
**Población Inicial**:
1. $I_1: 01101$ ($x=13, f=169$)
2. $I_2: 11000$ ($x=24, f=576$)
3. $I_3: 01000$ ($x=8, f=64$)
4. $I_4: 10011$ ($x=19, f=361$)

**Paso 1: Selección (Torneo Binario)**
- Torneo A: $I_1$ vs $I_2 \to$ Gana $I_2$ (576 > 169).
- Torneo B: $I_3$ vs $I_4 \to$ Gana $I_4$ (361 > 64).
- Padres: $I_2 (11000)$ y $I_4 (10011)$.

**Paso 2: Cruce (Un punto, corte tras el 2º bit)**
- Padre 1: `11 | 000`
- Padre 2: `10 | 011`
- Hijo 1: `11011` ($x=27, f=729$) ¡Mejor que ambos padres!
- Hijo 2: `10000` ($x=16, f=256$)

**Conclusión**: El algoritmo ha encontrado una solución (27) mejor que la mejor de la generación anterior (24).

---
> [!IMPORTANT]
> **Exploración vs Explotación**: La selección presiona hacia la explotación (mejores fitness), mientras que el cruce y la mutación favorecen la exploración (nuevas zonas). El equilibrio es la clave del éxito.
