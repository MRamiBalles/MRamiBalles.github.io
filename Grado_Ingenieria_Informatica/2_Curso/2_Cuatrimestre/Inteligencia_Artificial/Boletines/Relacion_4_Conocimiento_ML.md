# IA - Relación 4: Representación del Conocimiento y ML (Oficial UHU)

## 🧠 Más allá de las reglas: Ontologías y Aprendizaje
En la última parte de la asignatura vemos cómo estructurar el conocimiento complejo y cómo hacer que la máquina "aprenda" sola.

1.  **Redes Semánticas y Marcos**: Dibujos de conceptos unidos por flechas de tipo "es-un" o "parte-de".
2.  **Sistemas Basados en Reglas**: Un conjunto de reglas IF-THEN.
    - **Encadenamiento hacia adelante**: Empiezas con los datos y ves a qué conclusión llegas.
    - **Encadenamiento hacia atrás**: Empiezas con la hipótesis y buscas pruebas en los datos.
3.  **Machine Learning (ML)**:
    - **Supervisado**: Tienes ejemplos con respuesta (ej. clasificar spam).
    - **No Supervisado**: Buscas patrones sin saber qué buscas (ej. agrupar clientes por gustos).

## 📝 Ejercicios Prácticos
1.  **Razonamiento con Reglas**: R1: Si tiene plumas, es ave. R2: Si vuela y es ave, es albatros. Tenemos "Tiene plumas" y "Vuela".
    *   *Encadenamiento adelante*: R1 se activa $\rightarrow$ Es ave. Ahora R2 se activa $\rightarrow$ Es albatros. ¡Deducido!
2.  **Árboles de Decisión**: Elegir el mejor atributo para dividir los datos usando la **Entropía** o la **Ganancia de Información**.
    *   *Tip*: El atributo que más "ordene" los datos (el que deje grupos más puros) es el que va arriba del árbol.
3.  **Perceptrón**: La unidad básica de las redes neuronales. Solo puede resolver problemas linealmente separables (como la puerta AND u OR, pero NO la XOR).
    *   *Dato UHU*: Para la XOR necesitas al menos una capa oculta (Perceptrón Multicapa).
