# BD - Relación 2: El Modelo Relacional (Oficial UHU)

## 🧠 Contexto Teórico
Transformación del diseño conceptual (ER) a una estructura de tablas lógica.

*   **Relación (Tabla)**: Conjunto de tuplas (filas).
*   **Clave Primaria (PK)**: Atributo que identifica unívocamente a la fila.
*   **Clave Foránea (FK)**: Atributo que referencia a la PK de otra tabla.

## 📝 Ejercicios de la Relación (Reglas de Transformación)
1.  **Relación 1:N**: Un departamento tiene muchos empleados.
    *   *Resolución:* La PK de la entidad "1" (Departamento) pasa como FK a la tabla de la entidad "N" (Empleado).
2.  **Relación N:M**: Los alumnos se matriculan en asignaturas.
    *   *Resolución:* Se crea una **nueva tabla** intermedia `Matricula` que contiene las PKs de ambas entidades como FKs (y juntas forman la PK de la relación).
3.  **Integridad Referencial**: ¿Qué significa `ON DELETE CASCADE`?
    *   *Resolución:* Que si borras una fila padre, automáticamente se borran todas las filas hijas que la referencian.
