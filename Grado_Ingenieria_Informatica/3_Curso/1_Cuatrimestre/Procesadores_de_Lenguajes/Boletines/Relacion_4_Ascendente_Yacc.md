# PL - Relación 4: Análisis Sintáctico Ascendente (LALR) y Bison (Oficial UHU)

El análisis ascendente (Bottom-Up) construye el árbol de análisis desde las hojas hacia la raíz mediante operaciones de **Desplazamiento (Shift)** y **Reducción (Reduce)**. Es más potente que el descendente (LL).

## 1. Funcionamiento del Analizador LR
- **Shift**: Mueve el siguiente token de la entrada a la pila.
- **Reduce**: Sustituye un conjunto de símbolos en la cima de la pila (el mango o *handle*) por el lado izquierdo de una producción.
- **Conflictos**:
  - **Desplazamiento/Reducción**: No sabe si seguir leyendo o reducir ya.
  - **Reducción/Reducción**: No sabe qué regla aplicar para reducir.

## 2. Herramientas: BISON / YACC
Bison genera un analizador LALR en C. Se complementa con Flex (Léxico).

### 📝 Ejercicio Técnico: Calculadora en Bison
Archivo `calc.y`:
```yacc
%{
#include <stdio.h>
#include <math.h>
int yylex();
void yyerror(const char *s);
%}

%token NUM
%left '+' '-'
%left '*' '/'

%%
input:   /* vacío */
        | input linea
        ;

linea:   '\n'
        | exp '\n'  { printf("Resultado: %d\n", $1); }
        ;

exp:      NUM       { $$ = $1; }
        | exp '+' exp { $$ = $1 + $3; }
        | exp '*' exp { $$ = $1 * $3; }
        | '(' exp ')' { $$ = $2; }
        ;
%%

void yyerror(const char *s) { fprintf(stderr, "Error: %s\n", s); }
int main() { return yyparse(); }
```

## 3. Manejo de la Ambigüedad y Prioridad
En Bison, la prioridad se resuelve con las directivas `%left`, `%right` y `%nonassoc`. Las declaraciones que aparecen al final tienen mayor prioridad.

---
> [!IMPORTANT]
> **El Mango (Handle)**: En un análisis ascendente, el mango es la secuencia de símbolos que coincide con el lado derecho de una producción y cuya reducción representa un paso en la derivación inversa por la derecha.
