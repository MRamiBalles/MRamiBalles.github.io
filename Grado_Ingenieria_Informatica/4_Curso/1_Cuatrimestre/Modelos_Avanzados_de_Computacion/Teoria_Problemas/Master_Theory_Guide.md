# MAC - Guía Maestra de Teoría (Oficial UHU)

Este documento resume los pilares teóricos de la asignatura para facilitar la resolución de los boletines prácticos de 4º curso.

---

## 1. Fundamentos de la Computabilidad (Temas 1-6)

### La Máquina de Turing (MT) y el Problema de la Parada
La MT es el modelo matemático definitivo de la computación. Cualquier cosa "computable" puede ser realizada por una MT.
- **Tesis de Church-Turing**: Todo algoritmo puede ser ejecutado por una MT.
- **Decidibilidad**: Un lenguaje es decidible si existe una MT que lo acepte y se detenga siempre.
- **El Problema de la Parada ($H$)**: Es el ejemplo clásico de lenguaje indecidible. No existe un programa que pueda determinar si cualquier otro programa terminará o no.

### Jerarquía de Chomsky (Repaso Avanzado)
1. **Tipo 3 (Regulares)**: Autómatas Finitos.
2. **Tipo 2 (Independientes del contexto)**: Autómatas con Pila.
3. **Tipo 1 (Sensibles al contexto)**: Autómatas Linealmente Acotados.
4. **Tipo 0 (Recursivamente enumerables)**: Máquinas de Turing.

---

## 2. Complejidad Computacional (Tema 8)

### Las Clases P y NP
- **Clase P**: Problemas que pueden resolverse en tiempo polinomial por una MT determinista.
- **Clase NP**: Problemas cuya solución puede *verificarse* en tiempo polinomial por una MT determinista (o resolverse en tiempo polinomial por una MT no determinista).
- **NP-Completo**: Un problema es NP-Completo si está en NP y cualquier problema de NP puede reducirse a él en tiempo polinomial (Ej: Problema del Viajante, SAT).

---

## 3. Programación Funcional en Haskell (Laboratorios 1-9)

Haskell no es solo un lenguaje, es una implementación de la **Lógica de Combinadores** y el **Lambda Cálculo**.

### Conceptos Clave para los Boletines
- **Pureza**: Las funciones no tienen efectos secundarios. Para una misma entrada, siempre dan la misma salida.
- **Evaluación Perezosa (Lazy Evaluation)**: No se calcula nada hasta que es estrictamente necesario (permite listas infinitas).
- **Sistemas de Tipos**: Tipos fuertemente tipados. El compilador es tu mejor amigo.
- **Mónadas**: "Cajas" que encapsulan computaciones con contexto (I/O, estados, errores). Sin ellas, no podríamos manejar el mundo real en Haskell.

---

## 4. Computación Cuántica (Tema 9)

El salto del Bit al Qubit.
- **Superposición**: Un qubit puede ser 0 y 1 a la vez con ciertas probabilidades.
- **Entrelazamiento**: Dos qubits pueden estar correlacionados de forma que el estado de uno afecta instantáneamente al otro, sin importar la distancia (acción fantasmal a distancia).
- **Algoritmos**: Grover (búsqueda) y Shor (factorización de primos, lo que rompería RSA).

---
> [!TIP]
> **Relación MAC-Haskell**: Para resolver los ejercicios complejos de Haskell (como el de Blockchain), piensa en las transiciones de estado como si fueran movimientos en la cinta de una Máquina de Turing. La inmutabilidad de Haskell es perfecta para modelar la naturaleza inalterable de un bloque.
