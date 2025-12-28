# FAA - Relación 4: Algoritmos Ávidos / Greedy (Oficial UHU)

## 🧠 Apuntes Rápidos (Lo que entra)
Los algoritmos Greedy toman la mejor decisión local en cada paso esperando llegar al óptimo global. No siempre funcionan, hay que demostrar su optimalidad (aunque en el examen de la UHU suelen pedirte que apliques el algoritmo directamente).

*   **Esquema general**: 
    1.  Conjunto de candidatos.
    2.  Función de selección (la más "codiciosa").
    3.  Función de factibilidad.
*   **Problemas estrella**: Cambio de monedas, Mochila (fraccionaria), Dijkstra, Kruskal/Prim.

## 📝 Los "clásicos" de la ETSI
1.  **El problema de las monedas**: Tienes monedas de 1, 5, 10 y 25. Tienes que dar el cambio de 37 con el mínimo número de monedas.
    *   *A ver, el Greedy aquí es obvio*: Coges siempre la más grande que quepa.
    *   1. Cogemos una de 25. Quedan 12.
    *   2. Cogemos una de 10. Quedan 2.
    *   3. Cogemos una de 1. Queda 1.
    *   4. Otra de 1. Listo.
    *   *Resultado*: 4 monedas {25, 10, 1, 1}.
    *   *Ojo*: Si las monedas fueran {1, 3, 4} y pides el cambio de 6, el Greedy daría {4, 1, 1} (3 monedas) pero el óptimo es {3, 3} (2 monedas). ¡Greedy falla si el sistema no es canónico!

2.  **Mochila Fraccionaria**: Tienes objetos con (peso, valor). Objeto A(10, 60), B(20, 100), C(30, 120). Capacidad 50.
    *   *Estrategia*: Calculamos el valor/peso (densidad de valor).
    *   A: 60/10 = 6.
    *   B: 100/20 = 5.
    *   C: 120/30 = 4.
    *   Metemos A entero (quedan 40 de hueco).
    *   Metemos B entero (quedan 20 de hueco).
    *   De C solo podemos meter 20/30 partes.
    *   *Valor final*: 60 + 100 + (2/3)*120 = 240.

3.  **Kruskal**: Para el árbol de expansión mínima.
    *   *Pasos*: Ordenas todas las aristas de menor a mayor peso y las vas metiendo si no forman ciclos. Es un Greedy de manual.
