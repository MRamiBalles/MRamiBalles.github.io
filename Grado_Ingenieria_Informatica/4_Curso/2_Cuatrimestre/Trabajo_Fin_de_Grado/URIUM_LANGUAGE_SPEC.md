# 💎 Especificación del Lenguaje: Urium

**Urium** es un Lenguaje de Dominio Específico (DSL) diseñado para la orquestación segura y de alto rendimiento en sistemas distribuidos. Este proyecto se propone como un Trabajo Fin de Grado (TFG) de alta complejidad técnica, integrando conocimientos de Procesadores de Lenguajes, Sistemas Operativos y Seguridad Informática.

## 1. Visión Holística
Urium permite definir flujos de datos y políticas de seguridad mediante una sintaxis declarativa que transpila a C++ optimizado. Su objetivo es reducir la superficie de ataque y los errores de concurrencia en entornos críticos.

## 2. Definición Formal de la Gramática (Resumen)
La gramática de Urium utiliza una estructura inspirada en Rust y Go, priorizando la inmutabilidad y el tipado fuerte.

### 2.1. Tokens y Léxico
- **Palabras Reservadas**: `secure`, `flow`, `node`, `verify`, `emit`.
- **Operadores de Seguridad**: `|->` (transferencia segura), `?=` (verificación de integridad).

### 2.2. Sintaxis (EBNF Simplificado)
```ebnf
program      ::= { statement }
statement    ::= flow_def | node_def | security_rule
flow_def     ::= "flow" identifier "{" { flow_step } "}"
flow_step    ::= identifier "|->" identifier
security_rule ::= "verify" identifier "with" hash_algorithm
```

## 3. Características Diferenciales para el TFG
Para que este proyecto sea calificado con Matrícula de Honor en la ETSI, se proponen las siguientes funcionalidades:
1.  **Transpiler a C++ 20**: Generación de código eficiente que utilice punteros inteligentes y abstracciones de red de bajo nivel.
2.  **Análisis Estático de Seguridad**: El compilador debe detectar potenciales condiciones de carrera y fugas de datos antes de la ejecución.
3.  **Integración con Sockets**: Implementación de un runtime que permita la comunicación real entre nodos definidos en Urium.

## 4. Estado del Desarrollo
- [x] Especificación de Gramática Inicial.
- [ ] Implementación del Analizador Léxico (Flex/Lex).
- [ ] Implementación del Analizador Sintáctico (Bison/Yacc).
- [ ] Generador de Código para Backend C++.

---
*Manual de Proyecto - Rama de Computación*
