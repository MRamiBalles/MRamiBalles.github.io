# PL - Teoría 2: Análisis Sintáctico y Bison (Oficial UHU)

## 🧠 El Analizador Sintáctico (Parser)
Si el Lexer nos da palabras sueltas, el Parser construye la frase. Comprueba que el orden de los tokens sea correcto según la gramática del lenguaje.

*   **Gramática Independiente del Contexto (GIC)**: Se define mediante reglas de producción (ej. `Sentencia -> IF Expresion THEN Sentencia`).
*   **Árbol de Análisis**: La representación jerárquica del código.

## 🛠️ Herramienta: Bison / Yacc
Bison lee un archivo `.y` y genera un parser en C.
1.  **Símbolos Terminales**: Los tokens que vienen del Lexer.
2.  **Símbolos No Terminales**: Estructuras de alto nivel (Expresion, Sentencia).
3.  **Conflictos Shift/Reduce**: Cuando el parser no sabe si seguir leyendo o aplicar una regla. Suelen pasar por ambigüedad.

## 📝 Ejemplo de estructura Bison
```yacc
%{
#include <stdio.h>
void yyerror(const char *s);
int yylex();
%}

%token NUMERO SUMA
%left SUMA

%%
expresion: NUMERO
         | expresion SUMA expresion { printf("Suma detectada!\n"); }
         ;
%%

void yyerror(const char *s) {
    fprintf(stderr, "Error sintáctico: %s\n", s);
}
```

*   **Organic Tip**: Para los exámenes de la ETSI, recordad la precedencia. La multiplicación (`*`) siempre tiene más prioridad que la suma (`+`). Si no lo pones, Bison se liará.
