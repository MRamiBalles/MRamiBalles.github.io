# STR - Teoría 1: Conceptos de Tiempo Real y Ada (Oficial UHU)

## 🧠 ¿Qué es el Tiempo Real?
No es "ir muy rápido". Es ser **determinista**. Un sistema de tiempo real es aquel cuya corrección no solo depende del resultado lógico, sino del **momento** en que se entrega ese resultado.

*   **Hard Real-Time**: Si fallas el deadline, el sistema falla (ej. frenos de un coche, reactor nuclear).
*   **Soft Real-Time**: Si fallas el deadline, la calidad baja pero no es un desastre (ej. streaming de video).

## 🛠️ El lenguaje: Ada
En la ETSI usamos Ada porque es el lenguaje "robusto" por excelencia. Está diseñado para evitar errores tontos de punteros o tipos.

*   **Tipado Fuerte**: No puedes sumar un `Integer` con un `Float` sin convertirlo.
*   **Tareas (Tasks)**: El paralelismo está integrado en el lenguaje, no necesitas librerías externas.
*   **Rendezvous**: Es el mecanismo de sincronización entre tareas.

## 📝 Ejemplo de Código Ada (Estructura)
```ada
with Ada.Text_IO; use Ada.Text_IO;

procedure Hola_Mundo is
begin
   Put_Line("Hola desde STR en la ETSI!");
end Hola_Mundo;
```

*   **Organic Tip**: En el examen de STR suelen preguntar por el **Análisis de Planificabilidad (Rate Monotonic)**. Aprended bien la fórmula de Liu & Layland, ¡cae siempre!
