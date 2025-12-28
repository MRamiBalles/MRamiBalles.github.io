# DESO - Relación 3: Sincronización de Procesos (Oficial UHU)

## 🧠 Contexto Teórico
Evitar que varios procesos accedan a un recurso compartido a la vez provocando inconsistencias (*Condición de Carrera*).

*   **Sección Crítica**: Trozo de código donde se accede al recurso compartido.
*   **Semáforos**: Variable entera protegida con dos operaciones:
    *   `wait(S)` o `P(S)`: Decrementa. Si $S < 0$, el proceso se bloquea.
    *   `signal(S)` o `V(S)`: Incrementa. Si había bloqueados, despierta a uno.
*   **Exclusión Mutua**: Garantizar que solo uno entra en la S.C.

## 📝 Ejercicios de la Relación
1.  **Productor-Consumidor**: Implementa la sincronización con un búfer de tamaño $N$.
    *   *Resolución:* Semáforos: `mutex=1` (exclusión), `vacios=N` (control huecos), `llenos=0` (control items).
        *   Productor: `wait(vacios); wait(mutex); ...; signal(mutex); signal(llenos);`
        *   Consumidor: `wait(llenos); wait(mutex); ...; signal(mutex); signal(vacios);`
2.  **El Barbero Durmiente**: Explica el problema y qué semáforos usarías.
    *   *Resolución:* El barbero duerme si no hay clientes. Si llega uno, lo despierta. Si hay más de $N$ esperando, el cliente se va.
3.  **Interbloqueo (Deadlock)**: ¿Cuáles son las 4 condiciones de Coffman?
    *   *Resolución:* Exclusión mutua, Retener y esperar, No expulsión, Espera circular.
