# FAA: Boletín de Problemas Resueltos

*Resolución de ejercicios tipo examen con el rigor de la ETSI.*

## P1. Análisis de Bucles (Sumatorios)
**Calcular la complejidad de:**
```cpp
for (int i = 1; i <= n; i++)
    for (int j = i; j <= n; j++)
        count++;
```

**Resolución:**
El bucle interno no va de 1 a $n$, sino de $i$ a $n$. Hace $n - i + 1$ iteraciones.
$T(n) = \sum_{i=1}^{n} (n - i + 1)$
Si expandimos: $(n-1+1) + (n-2+1) + ... + (n-n+1)$
Es decir: $n + (n-1) + (n-2) + ... + 1$
Es la suma de los $n$ primeros naturales: $\frac{n(n+1)}{2}$
**Resultado:** $\Theta(n^2)$

---

## P2. Recurrencia (Teorema Maestro)
**Resolver:** $T(n) = 3T(n/2) + n$

**Pasos:**
1.  Identificamos: $a=3, b=2, f(n)=n$.
2.  Cálculo crítico: $\log_2 3 \approx 1.58$.
3.  Comparamos $n^1$ frente a $n^{1.58}$.
Como $n^{1.58}$ crece más rápido (Caso 1), el trabajo pesado está en las llamadas recursivas.
**Resultado:** $\Theta(n^{\log_2 3})$

---

## P3. Recurrencia (Método de Sustitución)
**Resolver:** $T(n) = T(n/2) + 1$ (Búsqueda binaria) con $T(1)=c$.

**Despliegue:**
$T(n) = T(n/2) + 1$
$T(n) = (T(n/4) + 1) + 1 = T(n/4) + 2$
$T(n) = T(n/2^k) + k$
Para llegar a $T(1) \implies n/2^k = 1 \implies k = \log_2 n$.
Sustituimos $k$: $T(1) + \log_2 n$.
**Resultado:** $\Theta(\log n)$

---

## P4. Comparación de Funciones
**¿Cuál es mejor?** $A = 100n \log n$ vs $B = 0.01n^2$

**Análisis:**
Aunque $B$ tiene una constante pequeña, $n^2$ siempre acabará superando a $n \log n$ para un $n$ suficientemente grande.
En computación, preferimos **A** porque su orden de magnitud es menor.
**A es $O(B)$ pero B no es $O(A)$.**

---
> [!NOTE]
> En los exámenes de la UHU, si el sumatorio es raro, usa la técnica de "acotar por arriba y por abajo" si no te sabes la fórmula exacta.
