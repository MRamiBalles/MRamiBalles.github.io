# BD - Relación 8: Seguridad y Privilegios (Oficial UHU)

## 🧠 Gestionando Usuarios
En la ETSI solemos ver esto al final del cuatri. Se trata de dar o quitar permisos a los usuarios de la base de datos.

*   **Privilegios de Sistema**: Permiso para conectarse, crear tablas, etc.
*   **Privilegios de Objeto**: Permiso para hacer SELECT, UPDATE o DELETE en una tabla concreta.

## 📝 Ejercicios de la Relación
1.  **GRANT/REVOKE**: Dale permiso a 'Pepe' para que pueda ver la tabla `Alumnos`.
    *   *Resolución*: `GRANT SELECT ON Alumnos TO Pepe;`
2.  **Pasar el testigo**: ¿Cómo permites que Pepe pueda a su vez dar ese permiso a otros?
    *   *Resolución*: Usas la cláusula `WITH GRANT OPTION`.
3.  **Vistas por Seguridad**: ¿Por qué usamos vistas (`VIEW`) para la seguridad?
    *   *Resolución*: Porque podemos crear una tabla "virtual" que solo enseñe los campos que queremos (por ejemplo, ocultar el salario de los empleados) y darle permiso al usuario sobre la vista, no sobre la tabla real.
