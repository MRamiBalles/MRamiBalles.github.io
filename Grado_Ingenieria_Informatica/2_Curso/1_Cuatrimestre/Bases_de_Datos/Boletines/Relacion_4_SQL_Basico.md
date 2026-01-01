# BD - Relación 4: SQL Básico (DDL y DML)

El lenguaje SQL (Structured Query Language) es el estándar para interactuar con bases de datos relacionales. Se divide principalmente en DDL (Definición) y DML (Manipulación).

## 🧠 Fundamentos Teóricos
- **DDL (Data Definition Language)**:
  - `CREATE TABLE`: Define la estructura, tipos de datos y restricciones (PK, FK, NOT NULL).
  - `ALTER TABLE`: Modifica la estructura existente.
  - `DROP TABLE`: Elimina la tabla y sus datos.
- **DML (Data Manipulation Language)**:
  - `INSERT INTO`: Añade nuevos registros.
  - `UPDATE`: Modifica registros existentes.
  - `DELETE`: Elimina registros.
- **DQL (Data Query Language) - Básico**:
  - `SELECT`: Columnas a recuperar.
  - `FROM`: Tablas de origen.
  - `WHERE`: Filtros y condiciones.
  - `ORDER BY`: Ordenación (ASC/DESC).

## 📝 Ejercicios de la Relación

1. **Definición de Esquema (DDL)**
   *Enunciado*: Crea una tabla `Departamentos` con un ID autoincremental y un nombre único, y una tabla `Empleados` que referencie al departamento.
   *Resolución*: 
   ```sql
   CREATE TABLE Departamentos (
       id_dept INT PRIMARY KEY AUTO_INCREMENT,
       nombre VARCHAR(50) UNIQUE NOT NULL
   );

   CREATE TABLE Empleados (
       dni CHAR(9) PRIMARY KEY,
       nombre VARCHAR(100) NOT NULL,
       salario DECIMAL(10,2) CHECK (salario > 0),
       id_dept INT,
       CONSTRAINT fk_dept FOREIGN KEY (id_dept) REFERENCES Departamentos(id_dept)
   );
   ```

2. **Manipulación de Datos (DML)**
   *Enunciado*: Inserta un departamento "I+D", añade un empleado y luego súbele el sueldo un 10%.
   *Resolución*: 
   ```sql
   INSERT INTO Departamentos (nombre) VALUES ('I+D');
   INSERT INTO Empleados (dni, nombre, salario, id_dept) 
   VALUES ('12345678A', 'Juan Pérez', 2000, 1);

   UPDATE Empleados 
   SET salario = salario * 1.10 
   WHERE dni = '12345678A';
   ```

3. **Consultas Básicas (DQL)**
   *Enunciado*: Lista los nombres de los empleados que ganan más de 2500€, ordenados alfabéticamente.
   *Resolución*: 
   ```sql
   SELECT nombre 
   FROM Empleados 
   WHERE salario > 2500 
   ORDER BY nombre ASC;
   ```

---
> [!IMPORTANT]
> Nunca olvides incluir las cláusulas `PRIMARY KEY` y `FOREIGN KEY` en el DDL para garantizar la integridad referencial de los datos.
