# Ejercicios Resueltos: Matemáticas II

*Problemas de lógica y grafos resueltos según los boletines de la UHU.*

## P1. Lógica: Tablas de Verdad e Implicación
**Enunciado:** Comprueba si $(P \wedge (P \implies Q)) \implies Q$ es una tautología.

**Resolución:**
| P | Q | $P \implies Q$ | $P \wedge (P \implies Q)$ | Resultado Final |
|---|---|---|---|---|
| 0 | 0 | 1 | 0 | 1 |
| 0 | 1 | 1 | 0 | 1 |
| 1 | 0 | 0 | 0 | 1 |
| 1 | 1 | 1 | 1 | 1 |

**Resultado:** Es una **Tautología**. Este esquema se conoce como *Modus Ponens*.

---

## P2. Grafos: Algoritmo de Dijkstra
**Enunciado:** Halla el camino mínimo desde el nodo A al resto en un grafo con aristas: (A,B,2), (A,C,5), (B,C,1), (B,D,6), (C,D,2).

**Resolución:**
1.  **Iteración 0:** $Dist(A)=0, Dist(Otros)=\infty$. Visitado: {}.
2.  **Iteración 1:** Nodo actual A. Vecinos: B(2), C(5). Visitado: {A}.
3.  **Iteración 2:** Nodo actual B (mínimo). Vecinos: C(2+1=3), D(2+6=8). Como $3 < 5$, actualizamos $Dist(C)=3$. Visitado: {A, B}.
4.  **Iteración 3:** Nodo actual C (mínimo). Vecino: D(3+2=5). Como $5 < 8$, actualizamos $Dist(D)=5$. Visitado: {A, B, C}.
**Resultado:** Camino mínimo a D es A -> B -> C -> D con coste 5.

---

## P3. Combinatoria
**Enunciado:** ¿De cuántas formas se pueden sentar 5 personas en una fila de 5 sillas?

**Resolución:**
Es una permutación simple de 5 elementos.
$P_5 = 5! = 5 \cdot 4 \cdot 3 \cdot 2 \cdot 1 = 120$.
**Resultado:** 120 formas.

---
> [!IMPORTANT]
> **Inducción:** Muchos exámenes de Mat II incluyen una demostración por inducción. Recuerda los dos pasos: 1) Paso base (para n=1) y 2) Paso inductivo (si vale para k, demostrar para k+1).
