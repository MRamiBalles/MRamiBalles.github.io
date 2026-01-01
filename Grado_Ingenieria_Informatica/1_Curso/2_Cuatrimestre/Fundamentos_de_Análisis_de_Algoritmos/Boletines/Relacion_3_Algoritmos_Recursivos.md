# FAA - Relación 3: Análisis de Algoritmos Recursivos (Oficial UHU)

El análisis de algoritmos recursivos requiere la resolución de ecuaciones de recurrencia para determinar su complejidad asintótica.

## 🧠 Herramientas de Resolución
1. **Teorema Maestro**: Para recurrencias de la forma $T(n) = aT(n/b) + f(n)$.
   - Si $f(n) = O(n^c)$ y $\log_b a < c \implies T(n) = \Theta(n^c)$.
   - Si $\log_b a = c \implies T(n) = \Theta(n^c \log n)$.
   - Si $\log_b a > c \implies T(n) = \Theta(n^{\log_b a})$.
2. **Método del Árbol de Recurrencia**: Visualización del coste en cada nivel de la recursión.
3. **Método de Sustitución**: Demostración por inducción matemática.

## 📝 Ejercicios de la Relación

1. **Aplicación del Teorema Maestro**
   *Enunciado*: Halla el coste de $T(n) = 2T(n/2) + n$. (Algoritmo tipo MergeSort).
   *Resolución*: 
   - $a=2, b=2, f(n)=n^1 \to c=1$.
   - $\log_2 2 = 1$. Como $\log_b a = c$, el coste es **$\Theta(n \log n)$**.

2. **Árbol de Recurrencia**
   *Enunciado*: Analiza $T(n) = 3T(n/4) + n^2$.
   *Resolución*: 
   - $a=3, b=4, c=2$.
   - $\log_4 3 \approx 0.79$. Como $0.79 < 2$, el término $f(n)$ domina.
   - Coste: **$\Theta(n^2)$**.

3. **Recurrencia Lineal: Factorial**
   *Enunciado*: $T(n) = T(n-1) + 1$.
   *Resolución*: Por expansión: $T(n) = T(n-2) + 1 + 1 = \dots = T(0) + n$.
   - Coste: **$\Theta(n)$**.

## 📝 Problema de Examen: Búsqueda Binaria
**Enunciado**: Escribe la recurrencia de la búsqueda binaria y resuélvela.
**Resolución**: 
- $T(n) = T(n/2) + \Theta(1)$.
- $a=1, b=2, c=0$. $\log_2 1 = 0$.
- Caso 2 del Teorema Maestro: **$\Theta(\log n)$**.

---
> [!TIP]
> Si la recurrencia no encaja en el Teorema Maestro (ej. $T(n) = T(n-1) + \dots$), usa siempre expansión o el método de la característica.
