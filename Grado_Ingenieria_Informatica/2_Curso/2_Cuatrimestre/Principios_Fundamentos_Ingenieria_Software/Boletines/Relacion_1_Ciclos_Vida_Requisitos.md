# PFIS - Relación 1: Ciclos de Vida y Requisitos (Oficial UHU)

## 🧠 ¿Para qué sirve PFIS?
A ver, esta asignatura puede parecer "mucho texto", pero es lo que separa a un "pica-teclas" de un Ingeniero de Software. Aquí aprendemos a organizar el caos de un proyecto.

*   **Ciclo de Vida**: Cómo nace, crece y (a veces) muere un software.
    - **Cascada**: El clásico. No puedes volver atrás. Si fallas en los requisitos, el proyecto muere al final.
    - **Incremental/Iterativo**: Vas sacando versiones. Muy de la mano con **Agile**.
    - **Espiral**: Gestión de riesgos desde el principio.
*   **Requisitos**: Lo que el cliente quiere vs Lo que el software debe hacer.
    - **Funcionales**: "El sistema debe permitir loguearse".
    - **No Funcionales**: "El sistema debe cargar en menos de 2 segundos" (Rendimiento, Seguridad, Usabilidad).

## 📝 Casos Prácticos de la ETSI
1.  **Diferenciar Requisitos**: Clasifica: "La base de datos debe ser PostgreSQL", "El usuario puede recuperar su contraseña", "Debe soportar 1000 usuarios concurrentes".
    *   *Resolución*: 
        1. No Funcional (Restricción técnica).
        2. Funcional (Acción del usuario).
        3. No Funcional (Rendimiento).
2.  **Elegir Ciclo de Vida**: Un cliente no tiene ni idea de lo que quiere y el mercado cambia cada mes. ¿Qué eliges?
    *   *Respuesta*: **Agile / Prototipado**. Necesitas feedback rápido para no construir algo que no sirva.
3.  **Matriz de Trazabilidad**: Concepto clave. Sirve para asegurar que cada requisito del cliente se ha implementado en el código y se ha probado. Si falta un link, el proyecto está cojo.
