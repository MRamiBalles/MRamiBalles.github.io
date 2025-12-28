# Mat II - Boletín 1: Lógica de Predicados y Cuantificadores

## 🧠 Contexto Teórico
Extensión de la lógica proposicional para manejar "todos" y "algunos".

*   **$\forall$ (Universal):** Se cumple para todo elemento del dominio.
*   **$\exists$ (Existencial):** Existe al menos un elemento.
*   **Negación de cuantificadores:** $\neg(\forall x, P(x)) \equiv \exists x, \neg P(x)$.

## 📝 Ejercicios
1.  **Traducción:** Traduce "Todos los informáticos saben programar".
    *   *Resolución:* $\forall x (\text{Informatico}(x) \implies \text{SabeProgramar}(x))$.
2.  **Negación:** Niega "Hay algún número primo que es par".
    *   *Resolución:* Original: $\exists x (\text{Primo}(x) \wedge \text{Par}(x))$. Negación: $\forall x (\neg\text{Primo}(x) \vee \neg\text{Par}(x))$ (Todos los primos son impares).
3.  **Validez:** En el dominio de $\mathbb{N}$, ¿es cierto $\forall n (n^2 > n)$?
    *   *Resolución:* Falso. Para $n=1$, $1^2 = 1$, no mayor que 1.
