# Mat II - Relación 1: Espacios Vectoriales (Oficial UHU)

## 🧠 Contexto Teórico
Un espacio vectorial es un conjunto de elementos (vectores) donde se definen la suma y el producto por un escalar.

*   **Combinación Lineal**: Un vector $v$ es C.L. de $\{v_1, ..., v_n\}$ si existe $v = a_1v_1 + ... + a_nv_n$.
*   **Independencia Lineal**: Los vectores son L.I. si la única C.L. que da el vector nulo es con todos los escalares $a_i = 0$.
*   **Base y Dimensión**: Una base es un conjunto L.I. que genera el espacio. La dimensión es el número de elementos de la base.

## 📝 Ejercicios de la Relación
1.  **Cálculo de Base**: Halla una base y la dimensión del subespacio $U = \{(x,y,z,t) \in \mathbb{R}^4 : x-y+z=0, t=0\}$.
    *   *Resolución:* Tenemos 2 ecuaciones y 4 incógnitas $\implies \dim = 4 - 2 = 2$. Despejando: $x = y - z, t = 0$. Vector genérico: $(y-z, y, z, 0) = y(1,1,0,0) + z(-1,0,1,0)$. Base $B_U = \{(1,1,0,0), (-1,0,1,0)\}$.
2.  **Suma de Subespacios**: Dados $U$ y $W$, ¿cuándo la suma es directa ($U \oplus W$)?
    *   *Resolución:* Cuando $U \cap W = \{0\}$. En tal caso $\dim(U+W) = \dim(U) + \dim(W)$.
3.  **Coordenadas**: Halla las coordenadas del vector $(1,2)$ en la base $B' = \{(1,1), (0,1)\}$.
    *   *Resolución:* $(1,2) = a(1,1) + b(0,1) \implies a=1, a+b=2 \implies b=1$. Coordenadas: $(1,1)_{B'}$.
