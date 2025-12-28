# RC - Boletín 1: Lógica y Acertijos en Prolog (Oficial UHU)

## 🧠 Entrenando el cerebro lógico
Prolog es perfecto para resolver problemas donde tienes muchas pistas y tienes que encajarlas.

## 📝 El Acertijo de las Casas (Versión ETSI)
Hay 3 casas de colores (Roja, Azul, Verde) y 3 alumnos (Pepe, Ana, Juan).
Pistas:
1. El que vive en la Roja estudia IA.
2. Ana vive en la Azul.
3. Juan no estudia PL.
4. Uno estudia STR.

## 📝 Resolución en Prolog
```prolog
resolver(Casas) :-
    Casas = [casa(roja, _, _), casa(azul, _, _), casa(verde, _, _)],
    member(casa(roja, _, ia), Casas),
    member(casa(azul, ana, _), Casas),
    member(casa(_, juan, Proy), Casas), Proy \= pl,
    member(casa(_, pepe, _), Casas),
    member(casa(_, _, pl), Casas),
    member(casa(_, _, str), Casas).

% ?- resolver(Sol).
```

*   **Reto**: Modifica el programa para que también diga qué perro tiene cada alumno.
*   **Organic Tip**: Acostúmbrate a usar `member/2` y `select/3`. Son tus mejores amigos en las primeras semanas de RC.
