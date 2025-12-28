# BD - Relación 3: Álgebra Relacional (Oficial UHU)

## 🧠 Contexto Teórico
Lenguaje formal de consulta que sirve de base para SQL.

*   **Selección ($\sigma$):** Filtra filas según una condición.
*   **Proyección ($\pi$):** Selecciona columnas.
*   **Unión ($\cup$):** Combina filas de dos tablas compatibles.
*   **Producto Cartesiano ($\times$):** Todas las combinaciones posibles.
*   **Join ($\bowtie$):** Producto + Selección por igualdad de clave.

## 📝 Ejercicios de la Relación
1.  **Selección y Proyección**: Obtén el nombre de los alumnos mayores de 20 años.
    *   *Resolución:* $\pi_{nombre}(\sigma_{edad > 20}(\text{Alumno}))$.
2.  **Diferencia**: Obtén los alumnos que NO están en la tabla de becados.
    *   *Resolución:* $\text{Alumno} - \text{Becado}$.
3.  **Join**: Obtén el nombre del alumno y el código de las asignaturas en las que está matriculado.
    *   *Resolución:* $\pi_{nombre, cod\_asig}(\text{Alumno} \bowtie_{dni=dni\_alumno} \text{Matricula})$.
