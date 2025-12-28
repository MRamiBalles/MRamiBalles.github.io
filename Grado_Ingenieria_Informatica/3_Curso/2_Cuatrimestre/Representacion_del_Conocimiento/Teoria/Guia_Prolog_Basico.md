# RC - Guía de Prolog 1: Hechos, Reglas y Consultas (Oficial UHU)

## 🧠 ¿Qué es Prolog?
Es Programación Lógica. Aquí no dices "cómo" hacer las cosas (sentencias iterativas), sino "qué" es verdad. Prolog se encarga de buscar la solución por ti usando "Backtracking".

*   **Hechos**: Afirmaciones simples. `padre(juan, maria).` (Juan es padre de María).
*   **Reglas**: Conclusiones basadas en condiciones. `abuelo(X, Y) :- padre(X, Z), padre(Z, Y).`
*   **Consultas**: Preguntarle a Prolog. `?- padre(juan, Quien).`

## 📝 El "Hola Mundo" de la Lógica
```prolog
% Hechos
humano(socrates).
humano(platon).
mortal(X) :- humano(X).

% Consultas
% ?- mortal(socrates). -> true.
% ?- mortal(platon). -> true.
```

## 📝 Ejercicios Prácticos
1.  **Recursividad**: Define un antepasado.
    ```prolog
    antepasado(X, Y) :- padre(X, Y).
    antepasado(X, Y) :- padre(X, Z), antepasado(Z, Y).
    ```
2.  **El corte (`!`)**: Sirve para parar el backtracking. Úsalo con cuidado, si te pasas puedes "romper" la lógica del programa y que no encuentre todas las respuestas.
3.  **Listas**: `[Cabeza | Cola]`. Es la forma básica de trabajar con datos en Prolog.

*   *Organic Tip*: En los exámenes de RC suelen poner problemas de "Zebra" o acertijos lógicos. El truco es definir bien las restricciones y dejar que Prolog haga el trabajo sucio.
