# 💎 Especificación del Lenguaje: Urium (TFG - Functional Extension)

**Proyecto**: Introducción de Características de Programación Funcional en el Lenguaje Urium.
**Base**: Compilador académico Tinto (v0.1) - Orientado a Procedimientos.
**Objetivo**: Evolucionar el lenguaje hacia un paradigma híbrido Imperativo-Funcional.

## 1. Hoja de Ruta del Proyecto (Extracted from TFG.docx)

### Fase 1: Funciones Puras
Implementación de la palabra clave `pure` y mecanismos de validación de efectos colaterales.
- **Léxico/Sintáctico**: Nueva palabra reservada `pure`.
- **Semántico**: Comprobación de transparencia referencial (no uso de variables globales mutables, no E/S).
- **Backend**: Optimizaciones posibles gracias a la pureza (Memoización básica).

### Fase 2: Optimización de Recursión por Cola (TCO)
Modificación del compilador para detectar y optimizar llamadas recursivas finales.
- **Objetivo**: Transformar la recursión en iteración (bucles `while`) en el código intermedio o ensamblador.
- **Impacto**: Evitar el desbordamiento de pila (Stack Benchmark) en algoritmos recursivos profundos.

### Fase 3: Funciones como Tipos de Datos (First-Class Citizens)
Permitir pasar funciones como argumentos y retornarlas.
- **Tipado**: Definición de tipos funcionales (ej. `(int, int) -> int`).
- **Implementación**: Gestión de Clausuras (Closures) y punteros a función en el backend (MIPS/RISC-V).

## 2. Gramática Base (v0.1) vs Extensiones

### Sintaxis Actual (v0.1)
```ebnf
Function ::= Access Type Id "(" Args ")" "{" Stmts "}"
```

### Sintaxis Propuesta (v1.0 Funcional)
```ebnf
// Fase 1: Pure Functions
Function     ::= Access ["pure"] Type Id "(" Args ")" "{" Stmts "}"

// Fase 3: Function Types
Type         ::= "int" | "char" | "boolean" | FunctionType
FunctionType ::= "(" [TypeList] ")" "->" Type
```

## 3. Justificación Académica
Este TFG explora la brecha entre la programación imperativa clásica (C) y la funcional, implementando conceptos avanzados de "Teoría de Lenguajes" sobre un compilador real. Se diferencia de una simple "extensión de tipos" (Arrays/Structs) por su complejidad algorítmica y teórica.

---
*Escuela Técnica Superior de Ingeniería - Proyecto Fin de Grado*
