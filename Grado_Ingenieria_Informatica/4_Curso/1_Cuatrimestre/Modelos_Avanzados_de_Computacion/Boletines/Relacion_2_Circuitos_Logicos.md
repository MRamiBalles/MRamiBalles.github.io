# MAC - Boletín Tema 2: Circuitos Lógicos (Resolución Oficial)

Este boletín analiza la potencia de los conjuntos de puertas universales (NAND) y la complejidad espacial de funciones booleanas fundamentales.

---

## 2.1 Eficiencia con puertas NAND
**a) ¿Cuántas funciones binarias de 2 variables ($x, y$) pueden construirse con una sola puerta NAND?**

Usando una puerta NAND y las variables como entradas (sin constantes), las únicas expresiones posibles son:
- $\text{NAND}(x, x) = \bar{x}$
- $\text{NAND}(y, y) = \bar{y}$
- $\text{NAND}(x, y) = \overline{x \cdot y}$

Resultan **3 funciones** distintas.

**b) ¿Y con dos puertas NAND?**
Al usar dos etapas, podemos construir:
- $\text{NAND}(\text{NAND}(x, y), \text{NAND}(x, y)) = x \cdot y$ (AND)
- $\text{NAND}(\text{NAND}(x, x), \text{NAND}(y, y)) = x + y$ (OR, por De Morgan)
- $\text{NAND}(\text{NAND}(x, x), y) = x + \bar{y}$
- $\text{NAND}(x, \text{NAND}(y, y)) = \bar{x} + y$

---

## 2.2 Función de Paridad
$Paridad(x_1, \dots, x_n)$ es 1 si el número de unos es par.

**a) Análisis en DNF (Forma Normal Disyuntiva)**:
En DNF, el circuito es una puerta OR de todos los minitérminos que dan 1.
- Exactamente $2^{n-1}$ vectores de entrada tienen paridad par.
- **Tamaño**: Se requieren $2^{n-1}$ puertas AND. Por tanto, el tamaño crece de forma **exponencial** $O(2^n)$. No es posible reducirlo en Suma de Productos (SOP) porque no hay minitérminos adyacentes (cualquier cambio en un bit cambia la paridad).

**b) Análisis en RSE (Ring-Sum Expansion)**:
En el álgebra de Boole sobre el anillo $\mathbb{F}_2$, la paridad es la suma directa (XOR).
- $f = x_1 \oplus x_2 \oplus \dots \oplus x_n \oplus 1$.
- **Tamaño**: Solo $n$ puertas XOR. El tamaño es **lineal** $O(n)$.

---

## 2.3 Complejidad de la función Modulo 3
$Mod3(x_1, \dots, x_n) = 1$ si $\sum x_i \pmod 3 = 0$.

**Demostración de crecimiento exponencial**:
A diferencia de la paridad, la función mod3 no tiene una representación simétrica simple en RSE (XOR). Para distinguir entre restos 0, 1 y 2, se requieren términos de interacción de todos los grados posibles. Tanto en DNF, CNF como en RSE, la falta de simplificaciones locales obliga a representar una fracción constante de todos los posibles minitérminos, resultando en un tamaño $O(2^n)$.

---

## 2.4 Diseño de Circuito Mod3 Iterativo
Para evitar el crecimiento exponencial del tamaño, se puede diseñar un circuito que procese las entradas secuencialmente.

- **Diseño del bloque base**: Un circuito que recibe el resto acumulado (2 bits) y una nueva entrada, y saca el nuevo resto (2 bits).
- **Tamaño**: Como cada etapa añade un número constante de puertas, el tamaño total es **lineal** $O(n)$.
- **Profundidad**: Como cada etapa depende de la anterior, la profundidad es **lineal** $O(n)$.

---
> [!TIP]
> **Conclusión técnica**: Este boletín demuestra que la elección de la arquitectura del circuito (DNF vs Iterativo) y el conjunto de puertas (AND/OR vs XOR) puede suponer la diferencia entre un diseño físicamente imposible (exponencial) y uno eficiente (lineal).
