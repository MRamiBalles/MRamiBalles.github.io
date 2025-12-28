# FAA - Relación 4: Estrategias de Diseño Ávido (Greedy)

Los algoritmos ávidos construyen una solución global mediante la toma de decisiones óptimas locales en cada paso sucesivo. Para garantizar la validez de este enfoque, el problema debe poseer la **Propiedad de Elección Ávida** y la **Subestructura Óptima**.

## 1. Propiedades Fundamentales
- **Elección Ávida**: Es posible alcanzar una solución óptima mediante decisiones óptimas locales sin retroceso (no-backtracking).
- **Subestructura Óptima**: La solución óptima al problema global contiene dentro de sí soluciones óptimas a los subproblemas.

## 2. Problemas de Optimización Clásicos
- **Planificación de Tareas**: Minimización de la latencia o maximización del beneficio en sistemas de una sola unidad de procesamiento.
- **Árboles de Expansión Mínima (MST)**: Algoritmos de Kruskal y Prim.
- **Camino más corto en grafos con pesos positivos**: Algoritmo de Dijkstra.

## 📝 Análisis de Casos: El Problema de la Mochila
Se diferencia entre la Mochila Fraccionaria (solucionable mediante Greedy) y la Mochila 0/1 (que requiere Programación Dinámica).

*Justificación Técnica*: En el caso fraccionario, la selección basada en la densidad de valor ($v_i/w_i$) garantiza la optimalidad al permitir agotar la capacidad con la mayor eficiencia de valor por unidad de peso. En el caso 0/1, la indivisibilidad de los objetos rompe la propiedad de elección ávida, ya que la selección del objeto con mayor densidad puede impedir la inclusión de combinaciones con mayor valor agregado.

## 📝 Ejercicio de Examen
Demuestre formalmente por qué el algoritmo de Kruskal no computa ciclos durante la construcción del MST.
*Respuesta*: Kruskal utiliza una estructura de datos de conjuntos disjuntos (Union-Find). Antes de integrar una arista $(u, v)$, verifica si $find(u) == find(v)$. La igualdad de representantes implica la existencia previa de una ruta entre ambos nodos, por lo que la adición de la arista cerraría un ciclo. El algoritmo solo perimite la unión si ambos nodos pertenecen a componentes conexas distintas.
