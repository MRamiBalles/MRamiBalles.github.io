# Fundamentos de Programación - Relación 1: Metodología Procedural en C

Esta unidad introduce los fundamentos del paradigma de programación procedural, centrándose en el lenguaje C como herramienta de implementación de bajo nivel.

## Fundamentación Teórica

### Tipado y Almacenamiento
En C, el tipado es estático y requiere una gestión explícita por parte del programador. 
- **Tipos Básicos**: `int`, `float`, `double`, `char`.
- **Cualificadores**: `unsigned`, `short`, `long`.
- **Ámbito y Ciclo de Vida**: Variables automáticas (pila) vs. variables estáticas.

### Estructuras de Control de Flujo
- **Seleccion**: `if-else`, `switch-case`.
- **Iteración**: 
  - `while`: Comprobación a la entrada.
  - `do-while`: Comprobación a la salida.
  - `for`: Iteración controlada por contador.

### Diseño Modular: Funciones
La descomposición funcional permite la creación de código reutilizable y mantenible.
- **Paso por Valor**: El valor del argumento se copia en el parámetro formal.
- **Prototipado**: Declaración previa de la interfaz de la función para permitir la compilación separada.

## Resolución de Problemas Seleccionados

1. **Implementación Algorítmica: Cálculo de Números Primos**
   *Problema*: Diseñar una función que determine si un número entero positivo es primo.
   *Metodología*: Aplicación de un bucle optimizado hasta la raíz cuadrada del número para verificar la existencia de divisores.
   ```c
   int es_primo(int n) {
       if (n <= 1) return 0;
       for (int i = 2; i * i <= n; i++) {
           if (n % i == 0) return 0;
       }
       return 1;
   }
   ```

2. **Control de Flujo: Serie de Fibonacci**
   *Problema*: Generar los primeros $N$ términos de la serie de Fibonacci mediante iteración.
   *Resolución*: Uso de variables temporales para el seguimiento del estado previo.

3. **Análisis de Tipos y Precisión**
   *Problema*: Identificar riesgos de desbordamiento (overflow) al sumar valores de tipo `short int` y proponer soluciones mediante el uso de tipos de mayor rango (`long`).
