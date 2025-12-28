# Fundamentos de Programación - Relación 2: Estructuras de Datos Estáticas y Punteros

El dominio del lenguaje C requiere una comprensión profunda de la gestión de memoria y el direccionamiento indirecto.

## Fundamentación Teórica

### Vectores y Matrices (Arrays)
Colecciones de elementos del mismo tipo almacenados de forma contigua en memoria. El acceso se realiza mediante índices, con una complejidad de $O(1)$.

### Punteros y Direccionamiento
Un puntero es una variable que almacena la dirección de memoria de otra variable.
- **Operador de Dirección (`&`)**: Obtiene la dirección de una variable.
- **Operador de Indirección (`*`)**: Accede al contenido de la dirección almacenada.
- **Aritmética de Punteros**: Permite recorrer estructuras de datos mediante desplazamientos de memoria.

### Cadenas de Caracteres (`strings`)
En C, las cadenas son arrays de `char` finalizados por el carácter nulo `\0`. Su manipulación requiere el uso de librerías como `<string.h>`.

## Resolución de Problemas Seleccionados

1. **Manipulación de Arrays Mediante Punteros**
   *Problema*: Implementar una función que calcule la suma de los elementos de un vector utilizando exclusivamente aritmética de punteros.
   ```c
   int suma_vector(int *ptr, int n) {
       int suma = 0;
       for (int i = 0; i < n; i++) {
           suma += *(ptr + i);
       }
       return suma;
   }
   ```

2. **Cadenas de Caracteres: Inversión de String**
   *Problema*: Desarrollar un algoritmo *in-place* para invertir el contenido de una cadena.
   *Metodología*: Uso de dos punteros (inicio y fin) que convergen hacia el centro de la cadena intercambiando caracteres.

3. **Paso de Argumentos por Referencia**
   *Problema*: Diseñar una función `swap` para intercambiar los valores de dos variables enteras del ámbito llamante.
   *Resolución*: Uso de punteros como parámetros para permitir la modificación persistente fuera del contexto de la función.
