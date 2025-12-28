# Estructuras de Datos II - Relación 1: Árboles de Búsqueda de Alto Rendimiento (AVL)

Las estructuras de datos avanzadas permiten la optimización de las operaciones de búsqueda, inserción y borrado, garantizando complejidades temporales logarítmicas incluso en el peor de los casos.

## 1. Árboles Binarios de Búsqueda (BST)
Estructura donde para cada nodo, los valores del subárbol izquierdo son menores y los del derecho mayores. Su principal limitación es la degradación a listas enlazadas ($O(n)$) si no están balanceados.

## 2. Árboles AVL (Adelson-Velsky y Landis)
Son árboles auto-balanceados donde, para cada nodo, la diferencia de alturas entre sus subárboles (Factor de Equilibrio) es como máximo 1.
- **Balanceo**: Se realiza mediante rotaciones simples (L, R) o dobles (LR, RL).
- **Complejidad**: Garantiza $O(\log n)$ para todas las operaciones fundamentales.

## 📝 Ejercicio Técnico: Rotación Doble
Considere un árbol AVL en el que se inserta un nodo que provoca un desequilibrio de tipo Izquierda-Derecha (LR). Describa la secuencia de rotaciones necesaria.
*Respuesta*: Se requiere una rotación doble a la izquierda-derecha. Primero, se realiza una rotación simple a la izquierda sobre el hijo izquierdo del nodo desequilibrado. Posteriormente, se realiza una rotación simple a la derecha sobre el propio nodo desequilibrado.

## 3. Árboles B y B+
Utilizados en sistemas de archivos y bases de datos para minimizar los accesos a disco. Permiten múltiples claves por nodo, reduciendo la altura del árbol y optimizando la E/S.
