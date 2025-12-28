# BD - Relación 6: Normalización (Oficial UHU)

## 🧠 Contexto Teórico
La normalización busca evitar la redundancia y las anomalías de actualización descomponiendo las tablas.

*   **Dependencia Funcional (DF)**: $X \to Y$ si para cada valor de $X$ hay un único valor de $Y$.
*   **1FN**: Atributos atómicos (sin listas en una celda).
*   **2FN**: 1FN + ningún atributo depende de una *parte* de la clave primaria (dependencia completa).
*   **3FN**: 2FN + ningún atributo depende transactivamente de la clave primaria.
*   **BCNF (Boyce-Codd)**: Para toda DF $X \to Y$, $X$ debe ser superclave.

## 📝 Ejercicios de la Relación
1.  **Cierre de un conjunto**: Dados $F = \{A \to B, B \to C\}$, halla el cierre de $A$ ($A^+$).
    *   *Resolución:* $A \to A$ (reflexivo), $A \to B$, $B \to C \implies A \to C$. Por tanto, $A^+ = \{A, B, C\}$. A es clave.
2.  **Identificación de anomalías**: ¿Qué pasa en una tabla `Curso(id_profe, nombre_profe, despacho)`?
    *   *Resolución:* Redundancia. Si un profesor da 5 cursos, su despacho se repite 5 veces. Anomalía de borrado: si borras el último curso, pierdes el dato del despacho del profesor.
3.  **Paso a 3FN**: Normaliza `Cuenta(DNI, Nombre_Titular, Num_Cuenta, Saldo)`.
    *   *Resolución:* $DNI \to \text{Nombre}$ y $Num\_Cuenta \to \text{Saldo}$. El DNI no determina el saldo. Descomponemos: `Titular(DNI, Nombre)` y `Cuenta(Num_Cuenta, DNI_Titular, Saldo)`.
