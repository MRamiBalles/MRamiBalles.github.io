# MAC - Boletín Tema 4: Gramáticas y Autómatas de Pila (Resolución Oficial)

Este boletín se centra en la jerarquía de Chomsky, el reconocimiento de lenguajes libres de contexto mediante Autómatas de Pila (PDA) y el algoritmo de parsing CYK.

---

## Ejercicio 4.1: Autómata de Pila para $L = \{a^n b^n \mid n \geq 0\}$
**Idea**: Por cada 'a' leída, apilamos un símbolo. Por cada 'b' leída, desapilamos.
- **Transiciones**:
  1. $(q_0, a, Z_0) \to (q_0, AZ_0)$ (Primera 'a', $Z_0$ es fondo de pila).
  2. $(q_0, a, A) \to (q_0, AA)$ (Siguientes 'a').
  3. $(q_0, b, A) \to (q_1, \epsilon)$ (Primera 'b', empezamos a desapilar).
  4. $(q_1, b, A) \to (q_1, \epsilon)$ (Siguientes 'b').
  5. $(q_1, \epsilon, Z_0) \to (q_f, Z_0)$ (Aceptación por estado final o pila vacía).

---

## Ejercicio 4.2: El lenguaje $L = \{a^{2^n} \mid n \geq 0\}$
Este lenguaje no es libre de contexto (no se puede contar una potencia de 2 con una sola pila), pero es **Sensible al Contexto** (Tipo 1).
- **Prueba**: Se puede construir una gramática de Tipo 1 o una Máquina de Turing linealmente acotada que, mediante marcas, divida la longitud entre 2 sucesivamente hasta llegar a 1.

---

## Ejercicio 4.3: Algoritmo CYK (Cocke-Younger-Kasami)
Para aplicar CYK, la gramática debe estar en **Forma Normal de Chomsky (FNC)**: $A \to BC$ o $A \to a$.

**Pasos del Algoritmo**:
1. Construir una tabla triangular $T$.
2. Fila 1: Ver qué variables generan cada símbolo terminal de la cadena.
3. Filas superiores ($j$): Combinar celdas anteriores tales que $T_{i,j}$ provenga de $A \to BC$ donde $B \in T_{i, k}$ y $C \in T_{i+k, j-k}$.
4. Aceptación: Si la variable inicial $S$ está en la celda superior de la tabla.

---

## Ejercicio 4.10: De PDA a Gramática Libre de Contexto
**Metodología**:
- Las variables de la gramática son de la forma $[q, X, p]$, que representan "ir del estado $q$ al $p$ desapilando $X$".
- Reglas:
  - Para cada transición $(q, a, X) \to (r, Y_1 Y_2 \dots Y_k)$, se generan reglas que cubran todos los estados intermedios posibles.

---

## Ejercicio 4.11: Pumping Lemma para Lenguajes No Libres de Contexto
Para demostrar que un lenguaje **NO** es libre de contexto:
1. Suponer que $L$ es LC.
2. Existe una constante de bombeo $p$.
3. Elegir una cadena $s \in L$ tal que $|s| \geq p$.
4. Dividir $s = uvxyz$ tal que $|vxy| \leq p$ y $|vy| \geq 1$.
5. Bombear $uv^i xy^i z$: Si para algún $i$, la cadena resultante $\notin L$, entonces $L$ no es LC.

**Ejemplo $\{a^n b^n c^n\}$**: Si bombeamos $v$ y $y$, alteramos el número de una o dos letras, pero nunca de las tres a la vez, rompiendo la igualdad $n=n=n$.

---
> [!IMPORTANT]
> El algoritmo CYK tiene una complejidad temporal de $O(n^3 \cdot |G|)$, lo que lo hace muy eficiente para verificar pertenencia a lenguajes libres de contexto en comparación con el backtracking.
