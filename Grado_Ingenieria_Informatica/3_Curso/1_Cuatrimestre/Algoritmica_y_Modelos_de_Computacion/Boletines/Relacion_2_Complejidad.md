# AMC - Relación 2: Computabilidad y Complejidad (Oficial UHU)

Esta unidad analiza los límites de la computación, distinguiendo entre lo que es computable y lo que es eficiente desde el punto de vista algorítmico.

## 1. La Máquina de Turing (MT)
Es el modelo general de computación. Define la noción de **Algoritmo** según la Tesis de Church-Turing.
- Tipos de lenguajes: 
  - **Recursivos**: La MT siempre se detiene (lenguajes decidibles).
  - **Recursivamente Enumerables**: La MT se acepta para palabras del lenguaje, pero puede no detenerse para palabras fuera del mismo.

## 2. Decidibilidad y el Problema de la Parada (Halting Problem)
Existen problemas para los cuales no es posible construir un algoritmo general. El Problema de la Parada es el ejemplo clásico de indecidibilidad: no existe un programa que determine si otro programa arbitrario se detendrá para una entrada dada.

## 3. Clases de Complejidad
- **P**: Problemas resolubles en tiempo polinómico por una MT determinista (eficientes).
- **NP**: Problemas cuya solución puede verificarse en tiempo polinómico por una MT determinista (o resolubles en tiempo polinómico por una MT no determinista).
- **NP-Completo**: Los problemas más difíciles dentro de NP. Si se hallara un algoritmo polinómico para un problema NP-completo, entonces $P = NP$.

## 📝 Análisis de Reducción
La técnica de **Reducción Polinómica** permite demostrar que un problema es al menos tan difícil como otro. 
*Ejercicio*: Explique el concepto de "Reducción de Cook-Levin" y su relevancia en la definición de la clase NP-Completo.
*Respuesta*: Demostró que el problema de satisfacibilidad booleana (SAT) es NP-completo, estableciendo la base para probar la pertenencia a esta clase de cientos de otros problemas (cliques, ciclos hamiltonianos, mochila 0/1, etc.) mediante reducciones sucesivas desde SAT.

---
*Escuela Técnica Superior de Ingeniería - Universidad de Huelva.*
