# Matemáticas I: Álgebra Lineal y Cálculo (Resumen ETSI)

*Compendio de teoría fundamental para modelado en ingeniería.*

## 1. Álgebra Lineal
El álgebra lineal es el lenguaje de las dimensiones y las transformaciones.

### 1.1. Espacios y Subespacios Vectoriales
*   **Base de un espacio:** Conjunto de vectores linealmente independientes (L.I.) que generan todo el espacio.
*   **Dimensión:** Número de vectores de cualquier base.
*   **Subespacios:** $U, W \subseteq V$. 
    *   **Unión e Intersección:** La intersección $U \cap W$ siempre es subespacio. La unión no siempre, por eso usamos la **Suma** $U + W$.
    *   *Fórmula de Grassmann:* $\dim(U+W) = \dim(U) + \dim(W) - \dim(U \cap W)$.

### 1.2. Aplicaciones Lineales y Diagonalización
*   **Autovalores ($\lambda$):** Raíces del polinomio característico $|A - \lambda I| = 0$.
*   **Diagonalización:** Una matriz $A$ es diagonalizable si existe una base de autovectores. 
    *   Condición necesaria: La multiplicidad algebraica de cada $\lambda$ debe ser igual a su multiplicidad geométrica.

---

## 2. Cálculo Infinitesimal
### 2.1. Derivadas y Aplicaciones
*   La derivada nos da la tasa de cambio. 
*   **Teorema de Taylor:** Permite aproximar funciones complejas mediante polinomios. Vital para algoritmos numéricos.

### 2.2. Integración
*   **Teorema Fundamental del Cálculo:** Conecta la derivación con la integración.
*   **Regla de Barrow:** $\int_{a}^{b} f(x)dx = F(b) - F(a)$.
*   *Técnicas:* Partes ($\int u dv$), sustitución, fracciones simples (para racionales).

---
> [!TIP]
> **Pro Tip Diagonalización:** Si todos los autovalores son reales y distintos, la matriz es diagonalizable seguro. Si hay repetidos, toca revisar la dimensión del subespacio de autovectores.
