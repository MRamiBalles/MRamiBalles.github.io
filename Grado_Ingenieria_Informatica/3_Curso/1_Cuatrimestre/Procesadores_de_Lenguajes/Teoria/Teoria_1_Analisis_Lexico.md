# PL - Teoría 1: Análisis Léxico y Flex (Oficial UHU)

## 🧠 ¿Qué hace el Analizador Léxico?
Es el primer paso del compilador. Se encarga de leer el código fuente (un chorro de caracteres) y agruparlos en "Tokens" (palabras con significado).

*   **Token**: Una categoría (ej. `IDENTIFICADOR`, `NUMERO`, `RESERVADA_IF`).
*   **Lexema**: El texto real (ej. `3.14`, `miVariable`).
*   **Patrón**: Una Expresión Regular que describe cómo es el token.

## 🛠️ Herramienta: Flex (Fast Lexical Analyzer)
En la UHU usamos Flex. El archivo `.l` tiene tres partes:
1.  **Definiciones**: Código C puro e inclusión de librerías.
2.  **Reglas**: Expresiones regulares y la acción (código C) que se ejecuta al encontrarlas.
3.  **Código**: La función `main` y otras utilidades.

## 📝 Ejemplo de código Flex (Boilerplate)
```c
%{
#include <stdio.h>
%}

DIGITO  [0-9]
LETRA   [a-zA-Z]

%%
{DIGITO}+           { printf("Encontrado un número: %s\n", yytext); }
{LETRA}({LETRA}|{DIGITO})*  { printf("Encontrado un identificador: %s\n", yytext); }
[ \t\n]             ; /* Ignorar espacios y saltos */
.                   { printf("Error: carácter no reconocido %s\n", yytext); }
%%

int main() {
    yylex();
    return 0;
}
```

*   **Organic Tip**: En el examen suelen pedir que definas una expresión regular para algo complejo (ej. números reales con exponente opcional). Practicad mucho las RE (Expresiones Regulares), ¡es medio examen!
