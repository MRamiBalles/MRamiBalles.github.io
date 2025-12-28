# DDSI - Teoría 1: Arquitecturas de Sistemas de Información (Oficial UHU)

El Diseño y Desarrollo de Sistemas de Información (DDSI) aborda la ingeniería de aplicaciones corporativas, con un enfoque particular en la integración con sistemas de gestión de bases de datos (SGBD).

## 1. Arquitecturas Multicapa (N-Tier)
La separación de responsabilidades permite el desarrollo escalable y el mantenimiento eficiente.
- **Capa de Presentación**: Interfaz de usuario (web, móvil, escritorio).
- **Capa de Lógica de Negocio**: Procesamiento de reglas y servicios.
- **Capa de Persistencia (Datos)**: Interacción con el SGBD mediante SQL o mapeadores objeto-relacionales (ORM).

## 2. El Patrón MVC (Modelo-Vista-Controlador)
Es el estándar de facto para el desarrollo de interfaces de usuario.
- **Modelo**: Representa los datos y la lógica de negocio.
- **Vista**: Representación visual de los datos.
- **Controlador**: Gestiona la entrada del usuario y coordina la interacción entre el modelo y la vista.

## 3. Transacciones y Concurrencia
Para garantizar la integridad de los datos en entornos multi-usuario, es fundamental el uso de transacciones ACID (Atomicidad, Consistencia, Isolación, Durabilidad).
- **Control de Bloqueos**: Estrategias optimistas y pesimistas.

## 📝 Análisis Técnico: Inyección de Dependencias
Explique cómo el uso de contenedores de inversión de control (IoC) mejora el desacoplamiento en grandes sistemas de información.
*Respuesta*: Permite que las dependencias de una clase sean suministradas externamente en lugar de ser instanciadas internamente. Esto facilita la realización de pruebas unitarias mediante el uso de objetos simulados (*mocks*) y permite cambiar implementaciones sin modificar el código de negocio.
