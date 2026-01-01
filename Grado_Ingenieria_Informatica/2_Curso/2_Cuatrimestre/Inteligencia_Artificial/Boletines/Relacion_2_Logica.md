# IA - Relación 2: Lógica de Predicados y Resolución (Oficial UHU)

## 🧠 El Salto a Primer Orden (FOPL)
A diferencia de la proposicional, en Primer Orden podemos hablar de objetos y sus propiedades.

## 📝 Ejercicio de Examen: Demostración por Resolución

**Enunciado**: Demuestra que "A Juan le gustan los cacahuetes" a partir de:
1. "Juan es una persona".
2. "A todas las personas les gusta la comida".
3. "Todo lo que se come es comida".
4. "Los cacahuetes se comen y no matan a nadie".

### Paso 1: Formalización
- $Per(juan)$
- $\forall x (Per(x) \rightarrow Gusta(x, Comida))$  -- *Simplificando: Gusta(x, comida)*
- $\forall x (SeCome(x) \rightarrow EsComida(x))$
- $SeCome(cacahuetes) \land \neg Mata(cacahuetes, y)$

### Paso 2: Paso a Cláusulas (FNC) e Inclusión de la Negación del Objetivo
- C1: $\{Per(juan)\}$
- C2: $\{\neg Per(x), Gusta(x, Comida(x))\}$ -- *Nota: Comida se convierte en función si depende de x*
- C3: $\{\neg SeCome(y), EsComida(y)\}$
- C4: $\{SeCome(cacahuetes)\}$
- **Objetivo Negado**: $\{\neg Gusta(juan, cacahuetes)\}$

### Paso 3: Resolución (Búsqueda de la Contradicción)
1. Unificamos C1 y C2 con $x=juan \implies \{Gusta(juan, Comida(juan))\}$
2. ... (aquí el proceso se complica con la unificación de "cacahuetes" y "comida")

---
### 🧠 Concepto Clave: Unificación
Para combinar dos cláusulas, debemos encontrar una sustitución de variables que las haga iguales. Ejemplo:
- $\{Gusta(x, pizza)\}$ y $\{\neg Gusta(juan, y)\}$
- Unificador: $x/juan, y/pizza \implies \emptyset$ (Vacío).

> [!TIP]
> En los exámenes de la UHU, asegúrate de **estandarizar las variables** (que cada cláusula tenga sus propias letras x, y, z) antes de empezar a resolver.
