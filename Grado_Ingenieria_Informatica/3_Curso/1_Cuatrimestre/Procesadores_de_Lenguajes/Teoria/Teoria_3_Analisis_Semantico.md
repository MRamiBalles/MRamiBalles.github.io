# PL - Teoría 3: Análisis Semántico y Tablas de Símbolos (Oficial UHU)

El análisis semántico es la fase del compilador que asegura que el programa, además de estar bien estructurado sintácticamente, tenga significado coherente según las reglas del lenguaje.

## 1. Comprobación de Tipos (Type Checking)
El analizador semántico debe verificar que las operaciones se realicen sobre tipos compatibles.
- **Tipado Estático**: Verificación en tiempo de compilación.
- **Tipado Dinámico**: Verificación en tiempo de ejecución.
- **Coerción**: Conversión implícita de tipos (ej. de `int` a `float`).

## 2. La Tabla de Símbolos
Es una estructura de datos central que almacena información sobre los identificadores (variables, funciones, clases).
- **Atributos**: Tipo, ámbito (scope), dirección de memoria, dimensiones (en arrays).
- **Implementación**: Comúnmente mediante tablas Hash para garantizar acceso $O(1)$ o árboles balanceados para facilitar la gestión de ámbitos anidados.

## 3. Gramáticas Atribuidas (L-atribuidas y S-atribuidas)
Permiten asociar reglas semánticas a las producciones de la gramática sintáctica.
- **Atributos Sintetizados**: El valor se calcula a partir de los hijos en el árbol de análisis.
- **Atributos Heredados**: El valor se recibe del padre o de los hermanos.

## 📝 Ejercicio Teórico Avanzado
Dada la siguiente producción gramatical con reglas semánticas:
`E -> E1 + T { E.val = E1.val + T.val }`
Identifique el tipo de atributo y explique cómo se realizaría la comprobación de tipos si `E1` es un entero y `T` es un booleano en un lenguaje con tipado fuerte.

*Resolución*: El atributo `val` es sintetizado. En un lenguaje de tipado fuerte, el analizador semántico lanzaría un error de "Incompatibilidad de tipos" al intentar aplicar el operador aritmético `+` sobre un booleano, a menos que exista una regla de coerción definida.
