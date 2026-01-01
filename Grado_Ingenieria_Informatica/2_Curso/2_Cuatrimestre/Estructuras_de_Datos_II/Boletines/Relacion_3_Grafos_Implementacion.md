# ED II - Relación 3: Grafos y Algoritmos de Caminos (Oficial UHU)

## 🧠 Algoritmos sobre Grafos
Una vez tenemos el grafo en memoria (Listas o Matriz de Adyacencia), el problema más común es encontrar el camino mínimo.

## 📝 Ejercicio Resuelto: Algoritmo de Dijkstra
Encontrar el camino mínimo desde el nodo **A** al resto de nodos.

**Grafo de Entrada**:
- (A, B) peso 4
- (A, C) peso 2
- (B, C) peso 5
- (B, D) peso 10
- (C, D) peso 3

### Evolución Paso a Paso

1. **Inicialización**:
   - `Distancias`: {A:0, B:∞, C:∞, D:∞}
   - `Visitados`: {}
2. **Paso 1 (Elegir A)**:
   - Miramos vecinos de A: B y C.
   - `Dist(B) = min(∞, 0+4) = 4`
   - `Dist(C) = min(∞, 0+2) = 2`
   - `Visitados`: {A}
3. **Paso 2 (Elegir C - es el menor no visitado)**:
   - Miramos vecinos de C: B y D.
   - `Dist(B) = min(4, 2+5) = 4` (Se queda como estaba)
   - `Dist(D) = min(∞, 2+3) = 5`
   - `Visitados`: {A, C}
4. **Paso 3 (Elegir B)**:
   - Miramos vecinos de B: D.
   - `Dist(D) = min(5, 4+10) = 5`
   - `Visitados`: {A, C, B}
5. **Paso 4 (Elegir D)**:
   - No hay más vecinos. Fin.

**Resultado Final**:
- Camino más corto a D: **5** (vía A -> C -> D).

---
### 🛠️ Implementación en C++ (Esquema)
```cpp
void dijkstra(Grafo g, int origen) {
    priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    vector<int> dist(V, INF);

    dist[origen] = 0;
    pq.push({0, origen});

    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();

        for (auto v : g.adyacencia[u]) {
            if (dist[v.destino] > dist[u] + v.peso) {
                dist[v.destino] = dist[u] + v.peso;
                pq.push({dist[v.destino], v.destino});
            }
        }
    }
}
```

> [!IMPORTANT]
> Dijkstra solo funciona con pesos **positivos**. Si hay pesos negativos, debes usar el algoritmo de **Bellman-Ford**.
