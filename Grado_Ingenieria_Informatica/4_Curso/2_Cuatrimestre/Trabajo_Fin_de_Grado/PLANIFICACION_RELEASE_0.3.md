# 📅 Planificación Release 0.3: Optimización y Orden Superior

Esta release aborda la eficiencia y la expresividad del lenguaje, permitiendo recursión profunda y el paso de funciones como argumentos.

## 1. Optimización de Recursión por Cola (TCO)
### 1.1. Análisis y Detección
Identificar llamadas recursivas en posición de cola (Tail Call).
- **Criterio**: La llamada a la función es la *última instrucción* del camino de ejecución y su valor se retorna directamente sin procesamiento adicional.

### 1.2. Transformación de Código Intermedio
Modificar el generador de código (`code/`) para transformar la llamada `CALL` en un `JUMP` al inicio de la función actual, reutilizando el marco de pila (Stack Frame).
- **Backend MIPS/RISC-V**: Reutilización de registros `$a0-$a3` y salto incondicional `j label`.

## 2. Funciones de Primera Clase
### 2.1. Tipos de Función (`FunctionType`)
Introducir un nuevo tipo de dato en `DataType.java` que represente la firma de una función.
- Sintaxis: `(int, int) -> int`

### 2.2. Clausuras (Closures)
Implementación básica de clausuras para capturar el entorno léxico (solo variables inmutables en esta versión).

### 2.3. Lambdas Anónimas
Sintaxis para definir funciones in-line:
```
val suma = (int a, int b) -> int { return a + b; };
```

## 3. Pruebas de Concepto
- `tail_factorial.ur`: Cálculo de factorial con acumulador (debe soportar n=100000 sin StackOverflow).
- `map_filter.ur`: Implementación de funciones de orden superior sobre arrays.
