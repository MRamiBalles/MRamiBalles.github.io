# Mat I - Relación 1: Números Reales y Complejos (Oficial UHU)

## 🧠 Repasando lo básico
Antes de derivar, hay que saber con qué números jugamos. En la ETSI le dan mucha caña a los Complejos, sobre todo para luego usarlos en Circuitos (Computadores).

*   **Inducción**: Demostrar cosas para $n$. Paso base y Paso inductivo.
*   **Complejos**: $z = a + bi$.
    - **Forma Polar**: $z = r_{\alpha}$ donde $r$ es el módulo y $\alpha$ el argumento (ángulo).
    - **Fórmula de Moivre**: $(r_{\alpha})^n = (r^n)_{n\alpha}$. Fundamental para sacar potencias y raíces.

## 📝 Ejercicios "de calentamiento"
1.  **Inducción**: Demuestra que $1+2+...+n = \frac{n(n+1)}{2}$.
    *   *Paso Base ($n=1$)*: $1 = \frac{1(2)}{2} = 1$. Ok.
    *   *Paso Inductivo*: Si vale para $k$, sumamos $(k+1)$ en ambos lados y vemos que sale la fórmula para $(k+1)$. Típico de primero.
2.  **Operaciones Complejas**: Calcula $(1+i)^8$.
    *   *Pasamos a polar*: $1+i$ tiene módulo $\sqrt{2}$ y ángulo 45º ($\pi/4$).
    *   *Moivre*: $(\sqrt{2}_{\pi/4})^8 = (\sqrt{2})^8_{8\pi/4} = 16_{2\pi} = 16$. Sale un número real. Ojo con los ángulos, trabajad siempre en radianes si podéis.
3.  **Raíces**: Halla las raíces cúbicas de $8i$.
    *   *Resolución*: $8i = 8_{\pi/2}$. Las raíces tendrán módulo $\sqrt[3]{8} = 2$. Los ángulos serán $(\pi/2 + 2k\pi)/3$ para $k=0,1,2$. Salen 3 raíces separadas 120º.
