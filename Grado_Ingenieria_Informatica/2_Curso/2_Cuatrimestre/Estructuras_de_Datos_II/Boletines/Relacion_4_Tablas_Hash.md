# ED II - Relación 4: Tablas Hash y Dispersión (Oficial UHU)

## 🧠 Búsqueda Ultrarrápida ($O(1)$)
Si en un árbol tardamos $\log n$, en una Tabla Hash tardamos (idealmente) tiempo constante. ¿Cómo? Usando una **Función Hash** que convierte una clave (ej. "Manu") en una posición del array (ej. 42).

*   **Colisiones**: Cuando dos claves quieren ir al mismo sitio.
    - **Encadenamiento (Chaining)**: Cada hueco de la tabla tiene una lista. Si chocan, se meten en la lista.
    - **Direccionamiento Abierto**: Buscas otro hueco libre. (Prueba lineal, cuadrática, o doble hash).
*   **Factor de Carga ($\alpha$)**: $\alpha = \text{elementos} / \text{tamaño\_tabla}$. Si $\alpha$ sube mucho (cerca de 1 o superior), la tabla se vuelve lenta y hay que hacer un **Rehash** (agrandarla).

## 📝 Ejercicios de Diseño
1.  **Insertar con Prueba Lineal**: Tabla de tamaño 10, función $h(k) = k \mod 10$. Inserta {12, 22, 32}.
    *   *Resolución*: 
        - 12 va al hueco 2.
        - 22 quiere ir al 2, pero está ocupado. Prueba el 3. Libre.
        - 32 quiere ir al 2, ocupado. Prueba el 3, ocupado. Prueba el 4. Libre.
    *   *Problema*: Se forman "racimos" (clustering) que ralentizan todo.
2.  **Buenas Funciones Hash**: Deben ser rápidas de calcular y distribuir los datos uniformemente. Usar números primos para el tamaño de la tabla suele ayudar.
3.  **Borrado en Direccionamiento Abierto**: Ojo, no puedes dejar el hueco vacío (null), tienes que marcarlo como "borrado" (`DELETED`) para que las búsquedas de elementos que chocaron después sigan funcionando.
