# AMC - Relación 3: Máquinas de Turing, Decidibilidad y Chomsky

Este boletín profundiza en los límites teóricos del cálculo y la clasificación formal de todos los lenguajes posibles.

## 1. Variantes de la Máquina de Turing
- **MT con Varias Cintas**: No son más potentes que la MT estándar, pero ahorran tiempo. $T(n) \to T^2(n)$.
- **MT No Deterministas (MTN)**: Tampoco son más potentes. Toda MTN tiene una MTD equivalente. Es la base de las clases P y NP.

## 2. La Jerarquía de Chomsky
Clasificación de lenguajes según la estructura de sus gramáticas:

| Tipo | Lenguaje | Autómata | Gramática |
| :--- | :--- | :--- | :--- |
| **0** | Recursivamente Enumerables | Máquina de Turing | Sin restricciones |
| **1** | Sensibles al Contexto | Autómata Linealmente Acotado | $\alpha A \beta \to \alpha \gamma \beta$ |
| **2** | Libres de Contexto | Autómata de Pila (PDA) | $A \to \gamma$ |
| **3** | Regulares | Autómata Finito (DFA/NFA) | $A \to aB$ o $A \to a$ |

## 📝 Ejercicio Técnico: Lenguajes Sensibles al Contexto
**Enunciado**: ¿Es el lenguaje $L = \{a^n b^n c^n \mid n \ge 1\}$ de tipo 2 (Libre de contexto)?
*Respuesta*: **No**. Mediante el Lema del Bombeo (Pumping Lemma) para lenguajes libres de contexto, se puede demostrar que no existe un autómata de pila capaz de comparar tres contadores al mismo tiempo ($n$). Es un lenguaje de **Tipo 1** (Sensible al contexto), procesable por una Máquina de Turing.

## 3. Decidibilidad y Diagonalización
- **Lenguaje Diagonal ($L_d$)**: Conjunto de máquinas que no se aceptan a sí mismas. Se usa para demostrar que existen lenguajes que no son siquiera recursivamente enumerables.
- **Teorema de Rice**: Cualquier propiedad no trivial sobre el lenguaje aceptado por una MT es indecidible. (Ej: "¿Acepta esta MT el lenguaje vacío?").

---
> [!NOTE]
> **Tesis de Church-Turing**: Todo lo que es intuitivamente computable puede ser computado por una Máquina de Turing. Si no lo hace una MT, no lo hace nadie.
