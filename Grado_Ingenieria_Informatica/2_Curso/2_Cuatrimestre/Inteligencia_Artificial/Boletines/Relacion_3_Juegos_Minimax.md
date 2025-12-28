# IA - Relación 3: Juegos y Búsqueda Adversaria (Oficial UHU)

## 🧠 IA que Juega (Ajedrez, 3 en raya...)
En estos problemas no estamos solos, hay un "enemigo" que quiere fastidiarnos. Por eso usamos algoritmos de Minimax.

*   **Minimax**: Yo quiero MAXimizar mi beneficio, el rival quiere MINimizarlo.
    - Se explora el árbol de estados hasta una profundidad $D$.
    - Se aplica una **Función de Evaluación** a las hojas (ej. "¿quién tiene más piezas?").
*   **Poda Alfa-Beta**: Es la magia que hace que Minimax sea rápido.
    - Si ya sabemos que una rama es peor que lo que ya hemos encontrado, dejamos de mirarla. **No cambia el resultado**, solo ahorra tiempo.

## 📝 Ejercicios de la ETSI
1.  **Simular Minimax**: Te dan un árbol con valores en las hojas y tienes que decir qué movimiento elige el jugador MAX.
    *   *Ojo*: Hacedlo de abajo a arriba. Los nodos MIN cogen el valor más pequeño de sus hijos, los MAX el más grande.
2.  **¿Dónde se poda?**: Marca en el árbol anterior dónde actuaría la poda Alfa-Beta.
    *   *Regla de oro*: Si $\alpha \ge \beta$, ¡corta! (Podas por debajo de un nodo si el valor que viene de ahí ya no puede mejorar lo que ya tienes garantizado).
3.  **Heurísticas en Juegos**: ¿Cómo evaluarías una partida de Damas a mitad de juego?
    *   *Organic Tip*: No cuentes solo fichas. Cuenta fichas, cuántas son "reinas", y la posición central. Una IA que solo cuenta fichas es muy fácil de engañar.
