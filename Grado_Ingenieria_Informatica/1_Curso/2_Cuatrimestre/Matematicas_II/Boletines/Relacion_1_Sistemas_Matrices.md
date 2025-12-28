# Matemáticas II - Relación 1: Sistemas de Ecuaciones Lineales y Matrices

El Álgebra Lineal proporciona el lenguaje formal para la computación gráfica, el procesamiento de datos masivos (Big Data) y la resolución de sistemas físicos multidimensionales.

## 1. Sistemas de Ecuaciones Lineales (SEL)
Clasificación según el **Teorema de Rouché-Frobenius**:
- **Sistema Compatible Determinado (SCD)**: Solución única ($rang(A) = rang(A^*) = n$).
- **Sistema Compatible Indeterminado (SCI)**: Infinitas soluciones ($rang(A) = rang(A^*) < n$).
- **Sistema Incompatible (SI)**: Sin solución ($rang(A) \neq rang(A^*)$).

## 2. Matrices y Determinantes
- **Rango de una Matriz**: Número de filas o columnas linealmente independientes.
- **Inversa de una Matriz**: $A^{-1}$ tal que $A \cdot A^{-1} = I$. Solo existe si $|A| \neq 0$.
- **Propiedades del Determinante**: $|A \cdot B| = |A| \cdot |B|$; $|A^T| = |A|$.

## 📝 Ejercicio Técnico: Resolución mediante Gauss-Jordan
Resuelva el sistema definido por:
$x + y + z = 6$
$2x - y + z = 3$
$x + 2y - z = 2$

*Resolución*: Aplicando operaciones elementales de fila sobre la matriz ampliada:
$\begin{pmatrix} 1 & 1 & 1 & | & 6 \\ 2 & -1 & 1 & | & 3 \\ 1 & 2 & -1 & | & 2 \end{pmatrix} \to \dots \to \begin{pmatrix} 1 & 0 & 0 & | & 1 \\ 0 & 1 & 0 & | & 2 \\ 0 & 0 & 1 & | & 3 \end{pmatrix}$
- Solución única: $x=1, y=2, z=3$.

## 3. Espacios Vectoriales
Definición de base, dimensión y subespacios. La independencia lineal es la base de la reducción de dimensionalidad en ingeniería (ej. PCA).
