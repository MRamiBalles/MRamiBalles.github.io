# BD - Relación 5: SQL II - Consultas Avanzadas (Oficial UHU)

## 🧠 Contexto Teórico
Uso avanzado de SQL para extraer información compleja de la base de datos.

*   **INNER JOIN**: Cruce básico de tablas.
*   **LEFT/RIGHT JOIN**: Cruce que mantiene filas sin pareja de una de las tablas.
*   **GROUP BY / HAVING**: Agrupación y filtrado sobre grupos (ej. "media de notas por curso").
*   **Subconsultas**: Consultas dentro de otras (cláusula `IN`, `EXISTS`).

## 📝 Ejercicios de la Relación
1.  **Join Multitabla**: Muestra el nombre de los alumnos y el nombre de las asignaturas en las que están matriculados.
    *   *Resolución:*
        ```sql
        SELECT A.nombre, ASIG.nombre
        FROM Alumno A
        JOIN Matricula M ON A.dni = M.dni_alumno
        JOIN Asignatura ASIG ON M.cod_asig = ASIG.id;
        ```
2.  **Agrupación**: Halla la nota media de cada asignatura, pero solo de aquellas con más de 10 alumnos.
    *   *Resolución:*
        ```sql
        SELECT cod_asig, AVG(nota)
        FROM Matricula
        GROUP BY cod_asig
        HAVING COUNT(*) > 10;
        ```
3.  **Subconsulta**: Muestra los alumnos que no están matriculados en ninguna asignatura.
    *   *Resolución:*
        ```sql
        SELECT nombre FROM Alumno
        WHERE dni NOT IN (SELECT dni_alumno FROM Matricula);
        ```
