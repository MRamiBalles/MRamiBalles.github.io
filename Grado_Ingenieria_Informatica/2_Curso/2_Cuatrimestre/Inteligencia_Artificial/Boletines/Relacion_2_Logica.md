# IA - Relación 2: Lógica de Predicados y Resolución (Oficial UHU)

## 🧠 El Salto a Primer Orden (FOPL)
A diferencia de la proposicional, en Primer Orden podemos hablar de objetos y sus propiedades.

## 📝 Ejercicio de Examen: Demostración por Resolución

**Enunciado**: Demuestra que "A Juan le gustan los cacahuetes" ($Gusta(juan, cacahuetes)$) a partir de:
1. "Juan es una persona".
2. "A todas las personas les gusta la comida".
3. "Todo lo que se come es comida".
4. "Los cacahuetes se comen".

### Paso 1: Formalización
- F1: $Per(juan)$
- F2: $\forall x (Per(x) \rightarrow EsComida(x))$ (Simplificación para el ejercicio)
- F3: $\forall x (SeCome(x) \rightarrow EsComida(x))$
- F4: $SeCome(cacahuetes)$

### Paso 2: Paso a Cláusulas (FNC)
- C1: $\{Per(juan)\}$
- C2: $\{\neg Per(x), Gusta(x, comida)\}$ (Asumiendo "comida" como constante para simplificar unificación)
- C3: $\{\neg SeCome(y), EsComida(y)\}$
- C4: $\{SeCome(cacahuetes)\}$
- **Negación del Objetivo**: C5: $\{\neg Gusta(juan, cacahuetes)\}$

### Paso 3: Resolución (Búsqueda de la Contradicción - Cláusula Vacía)
1. **Unificar C1 y C2**: Sustitución $\{x/juan\}$.
   - Resolución: $\{Gusta(juan, comida)\}$ (C6)
2. **Unificar C4 y C3**: Sustitución $\{y/cacahuetes\}$.
   - Resolución: $\{EsComida(cacahuetes)\}$ (C7)
3. **Contradicción Final**:
   - Aquí es donde se usa el conocimiento de que "cacahuetes" es "comida".
   - Unificamos C6 y C5 con la premisa de que `comida = cacahuetes`.
   - $\{Gusta(juan, cacahuetes)\} + \{\neg Gusta(juan, cacahuetes)\} \implies \emptyset$

---
### 🧠 Concepto Clave: Unificación
Para combinar dos cláusulas, debemos encontrar una sustitución de variables que las haga iguales. Ejemplo:
- $\{Gusta(x, pizza)\}$ y $\{\neg Gusta(juan, y)\}$
- Unificador: $x/juan, y/pizza \implies \emptyset$ (Vacío).

> [!TIP]
> En los exámenes de la UHU, asegúrate de **estandarizar las variables** (que cada cláusula tenga sus propias letras x, y, z) antes de empezar a resolver para evitar colisiones de nombres.
