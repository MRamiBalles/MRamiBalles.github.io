# DDSI - Relación 1: Programación en el Servidor (PL/SQL y Triggers) (Oficial UHU)

El diseño de sistemas de información modernos requiere delegar lógica de negocio al motor de base de datos para garantizar la integridad y el rendimiento.

## 1. Fundamentos de PL/SQL
PL/SQL es una extensión procedimental de SQL que permite el uso de variables, estructuras de control y manejo de excepciones.

```sql
DECLARE
    v_nombre VARCHAR2(50);
BEGIN
    SELECT nombre INTO v_nombre FROM alumnos WHERE id = 1;
    DBMS_OUTPUT.PUT_LINE('Alumno: ' || v_nombre);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No existe el alumno.');
END;
```

## 2. Triggers (Disparadores)
Son bloques de código que se ejecutan automáticamente ante un evento DML (`INSERT`, `UPDATE`, `DELETE`).

### 📝 Ejercicio Técnico: Trigger de Auditoría
**Enunciado**: Cree un trigger que guarde en una tabla `AUDITORIA_PRECIOS` el valor antiguo y el nuevo cada vez que se modifique el precio de un producto.

```sql
CREATE OR REPLACE TRIGGER trg_auditoria_precio
AFTER UPDATE OF precio ON productos
FOR EACH ROW
BEGIN
    INSERT INTO auditoria_precios (id_prod, precio_viejo, precio_nuevo, fecha)
    VALUES (:OLD.id_prod, :OLD.precio, :NEW.precio, SYSDATE);
END;
```

## 3. Procedimientos y Funciones Almacenadas
- **Procedimiento**: No devuelve un valor directamente (usa parámetros `OUT`).
- **Función**: Devuelve un valor (`RETURN`).

### 📝 Ejercicio Técnico: Función de Descuento
Cree una función que reciba el ID de un pedido y devuelva el total con un 10% de descuento si supera los 100€ o el total normal en caso contrario.

```sql
CREATE OR REPLACE FUNCTION calcular_total_dt(p_id_pedido NUMBER) 
RETURN NUMBER IS
    v_total NUMBER;
BEGIN
    SELECT SUM(precio * cantidad) INTO v_total 
    FROM lineas_pedido 
    WHERE id_pedido = p_id_pedido;
    
    IF v_total > 100 THEN
        RETURN v_total * 0.9;
    ELSE
        RETURN v_total;
    END IF;
END;
```

---
> [!IMPORTANT]
> **Integridad Referencial vs Triggers**: Use siempre claves foráneas para integridad básica. Use triggers solo para reglas de negocio complejas que SQL estándar no pueda expresar.
