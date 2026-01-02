# MAC - Boletín Tema 3: Autómatas Finitos y Transductores (Resolución Oficial)

Este boletín aborda el diseño de autómatas para realizar operaciones aritméticas y de cifrado, utilizando modelos de Mealy y Moore.

---

## Ejercicio 3.1: Multiplicar un número decimal por 3
**Objetivo**: Diseñar un AFD que reciba un número decimal (dígito a dígito de derecha a izquierda) y acepte si el resultado acumulado es coherente. 

*Nota*: Para multiplicar por 3 en decimal procesando desde el dígito menos significativo, el estado debe representar el **acarreo**. 
- Sea $d$ el dígito actual, el resultado local es $3d + acarreo_{prev}$.
- El nuevo dígito de salida es $(3d + acarreo_{prev}) \pmod{10}$.
- El nuevo acarreo es $\lfloor (3d + acarreo_{prev}) / 10 \rfloor$.
- Máximo acarreo: Para $d=9$, $3(9)+2 = 29$, acarreo 2. Los estados son $\{q_0, q_1, q_2\}$ representando acarreos 0, 1 y 2.

---

## Ejercicio 3.2: Transductor para el "Complemento a 2"
El complemento a 2 de un número binario se obtiene (leyendo de derecha a izquierda) manteniendo todos los ceros y el primer uno igual, e invirtiendo todos los bits siguientes.

### Modelo de Mealy:
- **Estado $q_0$ (Buscando el primer 1)**: 
  - Si lee 0: Escribe 0, sigue en $q_0$.
  - Si lee 1: Escribe 1, va a $q_1$.
- **Estado $q_1$ (Invirtiendo)**:
  - Si lee 0: Escribe 1, sigue en $q_1$.
  - Si lee 1: Escribe 0, sigue en $q_1$.

---

## Ejercicio 3.3: Cifrado XOR
**Proceso**: Cifrado de "Wiki" con clave de 8 bits.
1. Traducir "Wiki" a ASCII: W(87), i(105), k(107), i(105).
2. En binario: `01010111`, `01101001`, `01101011`, `01101001`.
3. Aplicar XOR bit a bit con la clave (ej. clave `k`): `Mensaje ⊕ Clave = Cifrado`.
4. **Propiedad**: El descifrado es idéntico al cifrado: `Cifrado ⊕ Clave = Mensaje`.

---

## Ejercicio 3.4: Resta de números binarios ($A - B$)
Procesando de derecha (LSB) a izquierda. La clave es el **acarreo negativo (borrow)**.

### Modelo de Mealy:
- **Estado $q_0$ (Sin deuda)**:
  - Entrada (0,0) $\to$ Salida 0, $q_0$.
  - Entrada (1,0) $\to$ Salida 1, $q_0$.
  - Entrada (1,1) $\to$ Salida 0, $q_0$.
  - Entrada (0,1) $\to$ Salida 1, va a $q_1$ (pide prestado).
- **Estado $q_1$ (Con deuda)**:
  - Entrada (1,0) $\to$ Salida 0, $q_0$ (paga deuda).
  - Entrada (1,1) $\to$ Salida 1, $q_1$.
  - Entrada (0,0) $\to$ Salida 1, $q_1$.
  - Entrada (0,1) $\to$ Salida 0, $q_1$.

---

## Ejercicio 3.5: Multiplicar por 3 un número binario
Equivale a $3x = 2x + x$. En binario, $2x$ es un desplazamiento a la izquierda (añadir un 0 a la derecha).

### Algoritmo de autómata (Mealy):
Se basa en sumar el número consigo mismo desplazado. Los estados representan el acarreo de la suma $\{0, 1\}$.
- **Transición**: $Siguiente\_Acarreo = \lfloor (Bit\_Actual + Bit\_Anterior + Acarreo) / 2 \rfloor$.
- **Salida**: Suma $\pmod 2$.

---

## Ejercicio 3.6: Multiplicar por 5 un número binario
Equivale a $5x = 4x + x$. $4x$ es desplazar dos bits a la izquierda.
- Se requiere un autómata que mantenga en su estado los **dos últimos bits leídos** (para representar el valor de $x$ que se suma a $4x$) y el **acarreo** de la suma.
- Estados: Combinaciones de $\{0, 1\}^2 \times \{Acarreo\}$.

---
> [!NOTE]
> En los exámenes de la UHU, es vital diferenciar entre Mealy (salida en la transición) y Moore (salida en el estado). El modelo de Mealy suele ser más eficiente en número de estados para operaciones aritméticas.
