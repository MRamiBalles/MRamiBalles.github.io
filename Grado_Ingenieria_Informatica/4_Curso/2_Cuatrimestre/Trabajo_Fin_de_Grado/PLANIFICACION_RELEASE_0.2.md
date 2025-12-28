# 📅 Planificación Release 0.2: Introducción al Paradigma Funcional

Esta release tiene como objetivo romper la compatibilidad puramente imperativa de Tinto (Urium v0.1) introduciendo el concepto de funciones puras.

## 1. Modificaciones Léxicas (`Tinto.jj`)
- **Nuevos Palabras Reservadas**: 
    - `pure`: Identificador de función sin efectos colaterales.
    - `var` / `val`: Distinción explícita entre mutable e inmutable (preparación).

## 2. Modificaciones Sintácticas
La gramática se extenderá para aceptar el modificador de función:
```java
// Antes
FunctionDecl ::= Access Type Id "(" Args ")" ...

// Ahora
FunctionDecl ::= Access ( "pure" )? Type Id "(" Args ")" ...
```

## 3. Modificaciones Semánticas (`TypeSystem.java`)
El analizador semántico debe verificar las restricciones de pureza:
1.  **Immutabilidad Global**: Una función pura NO puede leer ni escribir variables globales mutables.
2.  **Transparencia Referencial**: Una función pura solo puede llamar a otras funciones puras.
3.  **Sin Efectos de E/S**: Prohibido el uso de `syscall` o métodos nativos de consola dentro de un bloque `pure`.

## 4. Pruebas de Concepto
- `pure_math.ur`: Librería matemática (gcd, fibonacci) definida como pura.
- `side_effect_error.ur`: Test negativo intentando imprimir desde una función pura.
