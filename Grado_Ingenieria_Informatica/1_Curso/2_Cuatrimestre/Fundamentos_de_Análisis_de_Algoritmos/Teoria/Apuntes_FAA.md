# FAA: Análisis de Algoritmos (Resumen de Teoría)

*Notas rápidas para estudio y repaso de conceptos clave de la UHU.*

## 1. Notación Asintótica (Las Cotas)
No nos importa el tiempo exacto en segundos (depende de la CPU), sino cómo escala el algoritmo al crecer $n$.

*   **$O$ (Cota Superior):** Peor caso. El algoritmo no irá "peor que esto".
*   **$\Omega$ (Cota Inferior):** Mejor caso (o al menos así de rápido).
*   **$\Theta$ (Cota Ajustada):** El "clavo" exacto. Solo si $O$ y $\Omega$ coinciden.

> [!TIP]
> **Ojo en exámenes:** Si te piden "la mejor cota", se refieren a $\Theta$. Si pones $O(n^2)$ para un algoritmo lineal, técnicamente es cierto pero te quitarán puntos por no ser ajustada.

### Ranking de Crecimiento
Para comparar funciones rápido:
$1 \ll \log n \ll \sqrt{n} \ll n \ll n \log n \ll n^2 \ll n^3 \ll 2^n \ll n!$

## 2. Algoritmos Iterativos (Bucles)
Se calculan mediante sumatorios ($\sum$). 

*   **Bucle simple (1 a n):** $\sum_{1}^{n} 1 = n \to \Theta(n)$
*   **Bucle anidado:** $\sum_{i=1}^{n} \sum_{j=1}^{i} 1 = \frac{n(n+1)}{2} \to \Theta(n^2)$
*   **Bucle con salto (`i *= 2`):** El número de veces que puedes doblar un número hasta llegar a $n \to \Theta(\log n)$

## 3. Algoritmos Recursivos
### Teorema Maestro (El atajo)
Para $T(n) = aT(n/b) + f(n)$:
1.  Saca el **valor crítico**: $c = \log_b a$.
2.  Compara $f(n)$ con $n^c$:
    *   Si domina $n^c \to T(n) = \Theta(n^c)$
    *   Si son iguales $\to T(n) = \Theta(n^c \log n)$
    *   Si domina $f(n) \to T(n) = \Theta(f(n))$

### Sustitución (A mano)
Cuando el Maestro no sirve (ej. $T(n) = T(n-1) + n$), hay que "desenrollar" la ecuación o usar inducción. 
*Típico de examen:* $T(n) = T(n-1) + 1 \implies \Theta(n)$.

---
**Recordatorio:** Las constantes ($2n$, $500$, etc.) desaparecen en el análisis asintótico. Lo que importa es el grado del polinomio.
