# AMC - Relación 1: Autómatas y Lenguajes Formales (Oficial UHU)

El estudio de los Modelos de Computación se fundamenta en la teoría de la computación, que clasifica los problemas según la complejidad de la máquina necesaria para resolverlos.

## 1. Alfabetos, Cadenas y Lenguajes
- **Alfabeto ($\Sigma$)**: Conjunto finito de símbolos.
- **Cadena (Palabra)**: Secuencia finita de símbolos de un alfabeto.
- **Lenguaje ($L$)**: Conjunto de cadenas.

## 2. Autómatas Finitos Deterministas (DFA)
Un DFA se define por la quíntupla $M = (Q, \Sigma, \delta, q_0, F)$.
- $Q$: Conjunto de estados.
- $\delta$: Función de transición $Q \times \Sigma \to Q$.
- El lenguaje aceptado por un DFA es un **Lenguaje Regular**.

## 3. Autómatas Finitos No Deterministas (NFA)
Permiten múltiples transiciones para un mismo símbolo desde un estado.
- **Equivalencia**: Todo NFA puede transformarse en un DFA equivalente mediante el algoritmo de construcción por subconjuntos.

## 📝 Ejercicio Técnico: Diseño de Autómatas
Diseñe un DFA sobre el alfabeto $\Sigma = \{0, 1\}$ que acepte el lenguaje $L = \{w \mid w \text{ contiene un número par de ceros}\}$.

*Metodología de Resolución*:
- Estado $q_0$ (Inicial y Final): Número par de ceros encontrados.
- Estado $q_1$: Número impar de ceros encontrados.
- Transiciones:
  - $\delta(q_0, 1) = q_0$; $\delta(q_0, 0) = q_1$
  - $\delta(q_1, 1) = q_1$; $\delta(q_1, 0) = q_0$

## 4. Expresiones Regulares (RE)
Proporcionan una notación algebraica para lenguajes regulares.
- Operadores: Unión ($+$), Concatenación ($\cdot$), Cierre de Kleene ($*$).
- Teorema de Kleene: Un lenguaje es regular si y solo si puede describirse mediante una RE.
