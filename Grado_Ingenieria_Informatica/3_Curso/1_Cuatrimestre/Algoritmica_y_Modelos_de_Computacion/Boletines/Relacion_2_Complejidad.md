# AMC - Relación 2: Computabilidad y Complejidad (Oficial UHU)

Esta unidad analiza los límites de la computación, distinguiendo entre lo que es computable y lo que es eficiente desde el punto de vista algorítmico.

## 1. La Máquina de Turing (MT)
Es el modelo general de computación. Una MT se define como $M = (Q, \Sigma, \Gamma, \delta, q_0, B, F)$.
- $\Gamma$: Alfabeto de cinta (incluye al blanco $B$).
- $\delta$: $Q \times \Gamma \to Q \times \Gamma \times \{L, R\}$ (Dirección de movimiento).

## 📝 Ejercicio Técnico: Diseño de una MT
**Enunciado**: Diseñe una MT que reconozca el lenguaje $L = \{0^n 1^n \mid n \ge 1\}$. Este es un lenguaje no regular que requiere memoria de cinta.

**Estrategia de Resolución**:
1. Marcar un `0` con una `X` y moverse a la derecha hasta encontrar el primer `1`.
2. Marcar el `1` con una `Y` y moverse a la izquierda hasta encontrar la última `X`.
3. Repetir hasta que todos los `0` y `1` estén marcados.
4. Si sobran símbolos de un tipo, rechazar. Si todo está marcado, aceptar.

**Transiciones Clave**:
- $\delta(q_0, 0) = (q_1, X, R)$ (Marco 0)
- $\delta(q_1, 0) = (q_1, 0, R)$; $\delta(q_1, Y) = (q_1, Y, R)$ (Salto 0s e Ys)
- $\delta(q_1, 1) = (q_2, Y, L)$ (Marco 1 y vuelvo)
- $\delta(q_2, 0) = (q_2, 0, L)$; $\delta(q_2, Y) = (q_2, Y, L)$ (Busco X)
- $\delta(q_2, X) = (q_0, X, R)$ (Encontrado, reinicio ciclo)

## 2. Clases de Complejidad (P vs NP)
- **P**: Resolubles en tiempo polinómico (ej. Encontrar el camino más corto).
- **NP**: Verificables en tiempo polinómico (ej. Problema del Viajante).
- **NP-Completo**: Si resuelves uno en tiempo polinómico, resuelves todos ($P=NP$).

## 📝 Ejercicio de Complejidad
Demuestre por qué el problema del **Ciclo Hamiltoniano** es NP.
*Respuesta*: Dado un grafo y una secuencia de vértices (certificado), podemos verificar en tiempo polinómico $O(V)$ si: 1) Todos los vértices están en la lista exactamente una vez. 2) Existe una arista entre cada par consecutivo. 3) Existe una arista entre el último y el primero. Como la verificación es polinómica, el problema pertenece a la clase **NP**.

---
*Escuela Técnica Superior de Ingeniería - Universidad de Huelva.*
