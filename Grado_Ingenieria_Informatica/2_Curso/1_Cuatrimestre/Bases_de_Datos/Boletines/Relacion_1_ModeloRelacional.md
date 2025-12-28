# Bases de Datos - Relación 1: El Modelo Relacional y Algebra Relacional

El Modelo Relacional, propuesto por E.F. Codd, fundamenta la gestión de datos en la teoría de conjuntos y la lógica de predicados.

## 1. Conceptos Fundamentales
- **Relación**: Un conjunto de tuplas (filas) que comparten un esquema común (atributos).
- **Atributos**: Columnas que definen el dominio de los datos.
- **Clave Primaria (PK)**: Identificador único e inequívoco de una tupla en una relación.
- **Clave Foránea (FK)**: Atributo que establece una relación referencial hacia la PK de otra tabla, garantizando la **Integridad Referencial**.

## 2. Álgebra Relacional (Operadores)
Conjunto de operaciones teóricas que permiten la manipulación de relaciones para obtener nuevas relaciones.
- **Selección ($\sigma$)**: Filtra tuplas según una condición.
- **Proyección ($\pi$)**: Selecciona atributos específicos.
- **Producto Cartesiano ($\times$)**: Combina todas las tuplas de dos relaciones.
- **Unión ($\cup$)**, **Intersección ($\cap$)** y **Diferencia ($-$)**.
- **Join / Reunión ($\bowtie$)**: Combinación de relaciones basada en una condición de igualdad entre atributos comunes.

## 📝 Ejercicio Técnico: Resolución de Consultas
Dada la base de datos de una universidad (Estudiantes, Asignaturas, Matriculas):
- **a)** Obtenga los nombres de los estudiantes matriculados en 'Bases de Datos'.
- **b)** Proyecte los códigos de asignaturas que no tienen alumnos matriculados.

*Resolución (Álgebra)*:
- a) $\pi_{nombre}(\sigma_{nombre\_asig = 'Bases de Datos'}(Estudiantes \bowtie Matriculas \bowtie Asignaturas))$
- b) $\pi_{cod\_asig}(Asignaturas) - \pi_{cod\_asig}(Matriculas)$
