# PL - Relación 1: Análisis Léxico y Autómatas (Oficial UHU)

El análisis léxico es la primera fase de un compilador, responsable de agrupar los caracteres de entrada en secuencias con significado lógico denominadas **Tokens**.

## 1. Expresiones Regulares y Autómatas
Un componente léxico se describe mediante gramáticas regulares o expresiones regulares (RE).
- **Algoritmo de Thompson**: Transforma una RE en un Autómata Finito No Determinista ($\epsilon$-AFN).
- **Subconjuntos**: Transforma un AFN en un Autómata Finito Determinista (AFD) equivalente.

## 2. Herramientas: LEX / FLEX
Generan código C para un analizador léxico a partir de una especificación basada en RE.
```lex
%{
#include "y.tab.h"
%}
DIGITO  [0-9]
LETRA   [a-zA-Z]
%%
{DIGITO}+  { return NUMERO; }
{LETRA}+   { return IDENTIFICADOR; }
[ \t\n]    ; // Ignorar espacios
.          { return ERROR; }
%%
```

## 📝 Ejercicio Técnico: Construcción de AFD
Diseñe un AFD que reconozca cadenas de dígitos que representen números múltiplos de 3 en binario.
*Resolución*: 
- Estados: $q_0$ (resto 0, inicial y final), $q_1$ (resto 1), $q_2$ (resto 2).
- Transiciones:
  - $\delta(q_0, 0) = q_0$; $\delta(q_0, 1) = q_1$
  - $\delta(q_1, 0) = q_2$; $\delta(q_1, 1) = q_0$
  - $\delta(q_2, 0) = q_1$; $\delta(q_2, 1) = q_2$

## 3. Manejo de Errores Léxicos
Estrategias de recuperación:
- **Modo Pánico**: Ignorar caracteres hasta encontrar uno válido.
- **Reparación Mínima**: Insertar, borrar o sustituir un carácter para formar un token válido.
