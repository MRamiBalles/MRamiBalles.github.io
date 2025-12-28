# IA - Relación 2: Lógica Proposicional y de Predicados (Oficial UHU)

## 🧠 Formalizando el pensamiento
La IA no solo busca caminos, también "razona". Para ello usamos la lógica.

1.  **Lógica Proposicional**: Variables ($P, Q$) que son verdad o mentira. 
    - Conectivas: $\neg$ (no), $\land$ (y), $\lor$ (o), $\rightarrow$ (implica).
    - **Resolución**: Es el motor de inferencia. Para demostrar que $G$ es verdad, demostramos que (Base de Conocimientos $\land \neg G$) es una contradicción (insatisfacible).
2.  **Lógica de Predicados (Primer Orden)**: Añadimos objetos y cuantificadores ($\forall x, \exists y$).
    - "Todos los alumnos de la ETSI son cracks": $\forall x (Alumno(x) \land ETSI(x) \rightarrow Crack(x))$.

## 📝 Ejercicios "de examen"
1.  **Forma normal conjuntiva (FNC)**: Pasa $(P \rightarrow Q) \land (Q \rightarrow R)$ a cláusulas.
    *   *Pasos*: Quitas las implicaciones ($\neg P \lor Q$), ($\neg Q \lor R$). Ya está en FNC. Son dos cláusulas: $\{\neg P, Q\}$ y $\{\neg Q, R\}$.
2.  **Algoritmo de Resolución**: Si sabemos que "Si llueve, el suelo se moja" ($P \rightarrow Q$) y "Está lloviendo" ($P$), demuestra que "El suelo se moja" ($Q$).
    *   *Base*: $\{\neg P, Q\}, \{P\}$.
    *   *Negamos objetivo*: $\{\neg Q\}$.
    *   *Resolución*: 
        - Combinamos $\{\neg P, Q\}$ con $\{P\} \Rightarrow \{Q\}$.
        - Combinamos $\{Q\}$ con $\{\neg Q\} \Rightarrow \emptyset$ (Cláusula vacía).
    *   *Conclusión*: Como hemos llegado al vacío, $Q$ es cierto. ¡Fácil!
3.  **Skolemización**: Quitar los $\exists$ sustituyéndolos por constantes o funciones de Skolem. Típico ejercicio para ver si has ido a clase.
