# PFIS - Relación 2: Análisis con UML (Diagramas de Clase y Casos de Uso) (Oficial UHU)

## 🧠 UML: El lenguaje del Ingeniero
El UML no es para que el programa sea bonito, es para que el equipo se entienda.

*   **Casos de Uso**: Describen qué hace el sistema, no cómo.
    - **Actor**: El que inicia la acción (Usuario, Administrador, o incluso otro Sistema).
    - **Relaciones**: `<<include>>` (siempre pasa) y `<<extend>>` (pasa a veces, bajo condición).
*   **Diagramas de Clase**: La estructura estática.
    - **Atributos y Métodos**: Con su visibilidad (+ público, - privado, # protegido).
    - **Asociación vs Agregación vs Composición**: Composición es cuando el hijo no tiene sentido sin el padre (ej. Casa y Habitaciones). Si la Casa muere, las Habitaciones también.

## 📝 Los ejercicios de la "Guía Docente"
1.  **Casos de Uso de un Cajero**: Dibuja el diagrama.
    *   *Tips*: "Sacar dinero" incluye `<<include>>` "Validar PIN". "Pedir recibo" es un `<<extend>>` de "Sacar dinero" (solo si el usuario quiere).
2.  **Paso de Enunciado a Clases**: "Una Universidad tiene varios Departamentos. Cada Departamento tiene Profesores...".
    *   *Resolución*: 
        - Clase `Universidad` (1) --- (*) `Departamento` (Agregación).
        - Clase `Departamento` (1) --- (*) `Profesor` (Agregación).
3.  **Herencia vs Interfaz**:
    *   *Organic Tip*: Usa herencia cuando sea un "es un" (ej. `Perro` es un `Animal`). Usa interfaces para "comportamientos" (ej. `Volador` para `Pájaro` y `Avión`).
