# APSO - Relación 2: Hilos (Threads) y Sincronización (Oficial UHU)

## 🧠 Hilos vs Procesos
Si un proceso es una casa, los hilos son las personas que viven dentro. Comparten la nevera (memoria global), pero cada uno tiene su propia cama (pila/stack). En Linux usamos la librería `pthread`.

*   **`pthread_create`**: Para lanzar un hilo.
*   **`pthread_join`**: Para esperar a que un hilo termine (como el `wait` de procesos).
*   **Sección Crítica**: Trozo de código donde varios hilos tocan lo mismo a la vez. ¡Peligro de condiciones de carrera!

## 📝 Ejercicios de Sincronización
1.  **El problema del Contador**: 10 hilos incrementan una variable global 1000 veces cada uno.
    *   *Problema*: Al final no sale 10.000, sale menos porque se pisan unos a otros.
    *   *Solución*: **Mutex**. Ponemos un "cerrojo" antes de entrar a la sección crítica.
        ```c
        pthread_mutex_lock(&cerrojo);
        contador++;
        pthread_mutex_unlock(&cerrojo);
        ```
2.  **Productores y Consumidores**: Unos ponen datos en un buffer y otros los sacan.
    *   *Herramienta*: **Semáforos** (`sem_t`). 
    *   `sem_wait(&lleno)`: Si no hay nada, me espero.
    *   `sem_post(&vacio)`: He sacado algo, aviso de que hay un hueco más.
3.  **Deadlocks (Interbloqueos)**: Cuando el Hilo A espera al Hilo B y el B al A.
    *   *Consejo UHU*: Intenta siempre pedir los mutex en el mismo orden en todos los hilos para evitar que se queden "congelados".
