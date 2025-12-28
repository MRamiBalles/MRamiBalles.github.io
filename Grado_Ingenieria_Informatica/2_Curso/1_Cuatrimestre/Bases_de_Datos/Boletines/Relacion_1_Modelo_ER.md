# BD - Relación 1: Modelo Entidad/Relación (Oficial UHU)

## 🧠 Contexto Teórico
Diseño conceptual de la base de datos independiente del software que se use.

*   **Entidad**: Objeto del mundo real (rectángulo).
*   **Atributo**: Propiedad de la entidad (elipse). El atributo clave va subrayado.
*   **Relación**: Asociación entre entidades (rombo).
*   **Cardinalidad**: Indica cuántas ocurrencias de una entidad se relacionan con otra (1:1, 1:N, N:M).

## 📝 Ejercicios de la Relación
1.  **Diseño E/R**: Diseña el esquema para una biblioteca donde los socios alquilan libros.
    *   *Resolución:* 
        *   Entidades: `Socio` (DNI, Nombre), `Libro` (ISBN, Título).
        *   Relación: `Alquila` (Fecha).
        *   Cardinalidad: Un socio alquila N libros, un libro es alquilado por M socios (histórico). Es N:M.
2.  **Entidades Débiles**: ¿Qué es una entidad débil y cómo se representa?
    *   *Resolución:* Una entidad que no tiene clave propia y depende de otra (ej. `Hijo` de un `Empleado`). Se representa con doble recuadro.
3.  **Generalización/Especialización**: Representa que un `Empleado` puede ser `Administrativo` o `Técnico`.
    *   *Resolución:* Se usa un triángulo (ISA). Puede ser Total/Parcial y Exclusiva/Solapada.
