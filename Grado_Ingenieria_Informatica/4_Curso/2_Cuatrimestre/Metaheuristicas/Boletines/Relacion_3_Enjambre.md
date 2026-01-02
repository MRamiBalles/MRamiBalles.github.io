# Metaheurísticas - Relación 3: Inteligencia de Enjambre (Oficial UHU)

La Inteligencia de Enjambre (Swarm Intelligence) se basa en el comportamiento colectivo y descentralizado de sistemas auto-organizados (hormigas, pájaros, peces).

## 1. Optimización por Colonia de Hormigas (ACO)
Inspirado en cómo las hormigas encuentran el camino más corto mediante el depósito de feromonas.
- **Feromona ($\tau_{ij}$)**: Rastro químico dejado en el camino $i \to j$. Se evapora con el tiempo.
- **Visibilidad ($\eta_{ij}$)**: Información heurística (inversa de la distancia $1/d_{ij}$).

### Regla de Transición de Estado (Probabilidad)
La probabilidad de que la hormiga $k$ vaya de $i$ a $j$ es:
$$P_{ij}^k = \frac{[\tau_{ij}]^\alpha \cdot [\eta_{ij}]^\beta}{\sum_{l \in N_i^k} [\tau_{il}]^\alpha \cdot [\eta_{il}]^\beta}$$
Donde $\alpha$ y $\beta$ controlan la importancia relativa de feromona vs heurística.

### Actualización de Feromona
$$\tau_{ij} \leftarrow (1-\rho) \cdot \tau_{ij} + \sum \Delta \tau_{ij}^k$$
Donde $\rho$ es la tasa de evaporación.

## 2. Optimización por Enjambre de Partículas (PSO)
Inspirado en el movimiento de bandadas de pájaros.
- Cada partícula tiene **Posición ($x$)** y **Velocidad ($v$)**.
- Recuerda su mejor posición histórica (**pBest**) y conoce la mejor del enjambre (**gBest**).

### Ecuación de Movimiento
$$v_{id}(t+1) = w \cdot v_{id}(t) + c_1 r_1 (pBest_{id} - x_{id}) + c_2 r_2 (gBest_d - x_{id})$$
$$x_{id}(t+1) = x_{id}(t) + v_{id}(t+1)$$
- **Inercia ($w$)**: Tendencia a seguir su camino.
- **Componente Cognitiva ($c_1$)**: Tendencia a volver a su mejor hallazgo.
- **Componente Social ($c_2$)**: Tendencia a seguir al líder del grupo.

## 📝 Ejercicio Técnico: Actualización de Feromona (ACO)
**Escenario**: Arista $A-B$ con feromona inicial $\tau_{AB} = 0.5$. Tasa de evaporación $\rho = 0.2$.
Pasaron 3 hormigas por esta arista, depositando aportes de calidad: $0.1, 0.2, 0.05$.
**Cálculo**:
1. Evaporación: parte restante $= (1 - 0.2) \cdot 0.5 = 0.8 \cdot 0.5 = 0.4$.
2. Depósito nuevo: $\Delta \tau = 0.1 + 0.2 + 0.05 = 0.35$.
3. Feromona final: $\tau_{AB}(t+1) = 0.4 + 0.35 = 0.75$.

---
> [!NOTE]
> **Aplicaciones**: ACO es excelente para grafos dinámicos (enrutamiento de redes), mientras que PSO destaca en optimización de funciones continuas y entrenamiento de redes neuronales.
