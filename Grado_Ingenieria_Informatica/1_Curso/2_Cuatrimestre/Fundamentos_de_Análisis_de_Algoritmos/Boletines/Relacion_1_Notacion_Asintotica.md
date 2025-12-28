# FAA - Relación 1: Conceptos Básicos y Notación Asintótica (Oficial UHU)

## 🧠 Apuntes de Supervivencia
Para clasificar algoritmos en la UHU, olvidaos de los tiempos en segundos. Aquí mandan las cotas asintóticas. El truco es simplificar a lo bestia: quédate con el que más rápido suba y olvida las constantes.

*   **¿Qué es O?**: Es ponerle un techo al algoritmo (peor caso).
*   **Ranking de coste (de mejor a peor)**: 1 (constante) < log n < n < n log n < n² < 2^n < n!. Si tu algoritmo es n!, vete pidiendo cita para el examen de septiembre.

## 📝 Ejercicios para practicar
1.  **Guerra de Límites**: ¿Quién gana entre $n^2 \log n$ y $n^3$?
    *   *Resolución*: Hacemos el límite del cociente: $\lim \frac{n^2 \log n}{n^3} = \dots = \lim \frac{\log n}{n} = 0$.
    *   *Directo*: Como el límite es cero, el de abajo es mucho más potente. Por tanto, $n^2 \log n = O(n^3)$. Ganamos.
2.  **Ordenar funciones**: $2^n, n!, 1000n, n^2$.
    *   *Ojo con esto*: El 1000n parece mucho, pero es lineal. El orden real es $1000n \ll n^2 \ll 2^n \ll n!$.
3.  **Transitividad**: Si $f = O(g)$ y $g = O(h)$, entonces $f = O(h)$. 
    *   *Lógica pura*: Si $f$ es más pequeño que $g$ y $g$ es más pequeño que $h$... pues $f$ es más pequeño que $h$. No hay más.
