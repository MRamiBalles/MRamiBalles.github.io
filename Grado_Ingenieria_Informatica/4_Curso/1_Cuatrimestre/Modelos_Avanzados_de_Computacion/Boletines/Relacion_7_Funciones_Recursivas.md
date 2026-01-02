# MAC - Boletín Tema 7: Funciones Primitivas Recursivas (Resolución Oficial)

Las Funciones Primitivas Recursivas (FPR) se construyen a partir de funciones base (Nula, Sucesor, Proyecciones) mediante **Composición** y **Recursión Primitiva**.

---

## Conceptos Básicos
- **Función Nula**: $Z(x) = 0$
- **Función Sucesor**: $S(x) = x + 1$
- **Funciones Proyección**: $P_i^n(x_1, \dots, x_n) = x_i$

---

## Ejercicio 7.1: Función Igualdad $Eq(x, y)$
Definimos primero la resta limitada $x \ominus y$:
1. $pred(0) = 0$; $pred(S(x)) = x$.
2. $x \ominus 0 = x$; $x \ominus S(y) = pred(x \ominus y)$.

Entonces, $Eq(x, y) = \neg (x \ominus y + y \ominus x)$.
- Si $x=y$, ambos términos son 0, la suma es 0, el negado es 1.
- Si $x \neq y$, uno de los términos es $>0$, el negado de algo $>0$ es 0.

---

## Ejercicio 7.3: Función Resto entre 3 ($Mod3(x)$)
Se define por recursión sobre $x$:
- $Mod3(0) = 0$
- $Mod3(S(x)) = \begin{cases} S(Mod3(x)) & \text{si } Mod3(x) < 2 \\ 0 & \text{si } Mod3(x) = 2 \end{cases}$

Utilizando la función condicional primitiva $if(cond, then, else)$, que es FPR.

---

## Ejercicio 7.4: División Entera $Div(x, y)$
$Div(x, y)$ devuelve el número de veces que $y$ cabe en $x$.
- $Div(0, y) = 0$
- $Div(S(x), y) = Div(x, y) + Eq(S(x), (Div(x, y) + 1) \cdot y)$
(Sumamos 1 solo cuando el sucesor de $x$ alcanza un nuevo múltiplo de $y$).

---

## Ejercicio 7.8: Detección de Números Primos $Primo(x)$
1. **Función Divisible**: $Divisible(x, y) = Eq(Resto(x, y), 0)$.
2. **Contador de Divisores**: $NDiv(x) = \sum_{i=1}^{x} Divisible(x, i)$.
3. **Primo(x)**: $Eq(NDiv(x), 2)$.
(Un número es primo si y solo si tiene exactamente 2 divisores: 1 y él mismo).

---

## Ejercicio 7.9: El k-ésimo primo $Pr(k)$
Usando el **Teorema de Bertrand** (siempre hay un primo entre $n$ y $2n$):
- $Pr(0) = 2$
- $Pr(S(k)) = \mu_{i \leq 2 \cdot Pr(k) + 1} [i > Pr(k) \wedge Primo(i)]$
(El operador de minimización acotada $\mu_{i \leq z}$ mantiene la función dentro de la clase de las Primitivas Recursivas).

---
> [!IMPORTANT]
> A diferencia de las funciones $\mu$-recursivas totales, las FPR siempre terminan. No pueden modelar funciones no computables o el problema de la parada, pero cubren casi toda la aritmética usual.
