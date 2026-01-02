# MAC - Boletín Tema 5: Máquinas de Turing (Resolución Oficial)

La Máquina de Turing (MT) es el modelo general de computación. En este boletín resolvemos problemas de procesamiento de cadenas y aritmética binaria.

---

## Ejercicio 5.1: Sucesor de un número binario
**Entrada**: Cadena binaria leída de izquierda a derecha (ej. $110 \to 6$).
**Lógica**: Sumar 1 empezando por el bit menos significativo (izquierda).
1. Leer bit actual. Si es 1, cambiar por 0 y mover a la derecha (acarreo).
2. Si es 0, cambiar por 1 y parar (fin de acarreo).
3. Si lee blanco ($B$), escribir 1 y parar (desbordamiento).

---

## Ejercicio 5.2: Extraer el tercer número de una lista
**Entrada**: $n_1\$n_2\$n_3\$n_4...$
1. Buscar el primer '$', saltar.
2. Buscar el segundo '$', saltar.
3. El contenido tras el segundo '$' hasta el siguiente '$' o blanco es el objetivo.
4. Borrar el resto de la cinta o copiar $n_3$ al inicio.

---

## Ejercicio 5.3: Comparación de cadenas ($w_1 \$ w_2$)
**Algoritmo**:
1. Leer el primer símbolo de $w_1$, marcarlo (ej. con una $X$). Recordar el símbolo en el estado.
2. Mover a la derecha hasta pasar el '$' y encontrar el primer símbolo no marcado de $w_2$.
3. Si coinciden, marcarlo y volver al inicio de $w_1$.
4. Si no coinciden o falta un símbolo, **Rechazar**.
5. Si todos los símbolos están marcados en ambos lados, **Aceptar**.

---

## Ejercicio 5.6: Suma de dos números binarios ($A \# B$)
**Idea**: Decrementar $B$ repetidamente y sumar 1 a $A$ cada vez, o usar el algoritmo de suma bit a bit con acarreo.
- **Bit a bit**: Requiere marcar los bits procesados en ambos números y usar estados para recordar el acarreo $\{c_0, c_1\}$. El resultado se escribe en un espacio libre de la cinta.

---

## Ejercicio 5.8: Duplicar una palabra ($w \to ww$)
**Pasos**:
1. Leer un símbolo de $w$, sustituirlo por una versión marcada (ej. $a \to \bar{a}$).
2. Mover al final de la cinta y escribir el mismo símbolo.
3. Volver, buscar el siguiente símbolo no marcado y repetir.
4. Al final, desmarcar todos los símbolos originales de $w$.

---

## Ejercicio 5.10: Invertir una palabra ($w \to w^R$)
**Algoritmo**:
1. Mover al final de la palabra original.
2. Leer el último símbolo, borrarlo (o marcarlo) y escribirlo en una nueva sección de la cinta.
3. Repetir moviéndose hacia atrás en la palabra original.
4. Limpiar la cinta dejando solo el resultado invertido.

---
> [!TIP]
> Para diseñar Máquinas de Turing complejas, el truco es usar el **Estado** para recordar información finita (como el símbolo leído) y la **Cinta** para la memoria infinita y el posicionamiento.
