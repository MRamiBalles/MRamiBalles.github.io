# AC - Relación 4: Multiprocesadores y Coherencia de Caché (Oficial UHU)

## 🧠 El Problema de la Coherencia
Cuando tienes varios núcleos (CPUs) y cada uno tiene su propia caché L1, puede que la CPU 1 escriba un valor en una variable y la CPU 2 siga viendo el valor viejo. ¡Caos total!

*   **Protocolos de "Snooping" (Husmeo)**: Las cachés vigilan el bus para ver qué hacen las demás.
*   **Protocolo MSI (Modified, Shared, Invalid)**:
    - **Modified (M)**: La línea de caché es válida, ha sido modificada y es la única copia en el sistema.
    - **Shared (S)**: La línea es válida y puede estar en otras cachés. Es de solo lectura.
    - **Invalid (I)**: La línea no contiene datos válidos.

## 📝 Ejercicio de Seguimiento del Bus (Protocolo MSI)
**Enunciado**: Complete la tabla de estados para una secuencia de operaciones sobre el bloque A. Inicialmente, A no está en ninguna caché.

| Paso | Operación | Estado C1 | Estado C2 | Acción en Bus | Dato suministrado por |
| :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | CPU1 Read A | **S** | I | Bus Read | Memoria |
| 2 | CPU2 Read A | S | **S** | Bus Read | Memoria |
| 3 | CPU1 Write A| **M** | **I** | Bus Upgr / Inv | C1 |
| 4 | CPU2 Read A | **S** | **S** | Bus Read | C1 (Flush a Mem/C2) |
| 5 | CPU2 Write A| **I** | **M** | Bus Upgr / Inv | C2 |

### 🧠 Análisis Técnico
- **Paso 3**: C1 quiere escribir. Como ya la tenía en `Shared`, envía una señal de **Invalidación** al bus para que C2 pase a `Invalid`. C1 pasa a `Modified`.
- **Paso 4**: C2 quiere leer. Como C1 tiene el único valor correcto (estado `M`), C1 debe interceptar la lectura, escribir el dato en memoria (Flush) y pasar a `Shared`. Ahora C2 puede leerlo y pasar también a `Shared`.
- **Paso 5**: C2 escribe. Invalida la copia de C1.

---
> [!IMPORTANT]
> **Falsa Compartición (False Sharing)**: Ocurre cuando dos procesadores modifican variables distintas que mapean a la misma línea de caché. Provoca un tráfico de invalidación innecesario que degrada drásticamente el rendimiento.
