# PL - Práctica 1: Mi Primer Compilador (Calculadora)

## 📂 Estructura del Proyecto
Para las prácticas de PL, lo mejor es tenerlo todo organizado:
- `lexer.l`: Definiciones de Flex.
- `parser.y`: Gramática en Bison.
- `makefile`: Para compilarlo todo de un tirón.

## 📝 El Makefile Mágico
```makefile
calculadora: lexer.l parser.y
	flex lexer.l
	bison -d parser.y
	gcc parser.tab.c lex.yy.c -o calculadora -lfl

clean:
	rm -f calculadora lex.yy.c parser.tab.c parser.tab.h
```

## 🚀 Cómo probarlo
1. Escribe `make`.
2. Ejecuta `./calculadora`.
3. Escribe una expresión como `3 + 5 * 2`.
4. Mira cómo el parser hace su magia.

*   **Tip para la nota**: Si quieres un 10 en la práctica, añade gestión de errores detallada (indica la línea y el carácter exacto donde el usuario se ha equivocado). ¡El profesor lo valorará mucho!
