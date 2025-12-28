# APSO - Relación 3: Gestión de Memoria y Archivos Proyectados (Oficial UHU)

## 🧠 Memoria Compartida y mmap
En esta relación vemos cómo los procesos pueden "hablar" entre sí usando una zona de memoria común o cómo tratar un archivo como si fuera un array en RAM.

*   **`shm_open` y `ftruncate`**: Para crear un segmento de memoria compartida y darle tamaño.
*   **`mmap`**: La función estrella. Mapea un archivo o un objeto de memoria al espacio de direcciones del proceso.
    - *Ventaja*: Mucho más rápido que hacer `read` y `write` constantes, porque el SO se encarga de todo de forma transparente.
*   **Sincronización**: Si dos procesos escriben en el mismo `mmap`, necesitas **Semáforos con nombre** (`sem_open`) para no corromper los datos.

## 📝 Ejercicios de la ETSI
1.  **Copiar un archivo con mmap**: Haz un programa que copie "origen.txt" a "destino.txt" usando memoria proyectada.
    *   *Resolución*: 
        1. `open` ambos archivos. 
        2. `mmap` del origen (modo lectura). 
        3. `mmap` del destino (modo escritura).
        4. `memcpy(ptr_destino, ptr_origen, tamaño)`.
        5. `munmap` y cerrar. ¡Mucho más elegante que un bucle de `read`!
2.  **Productores-Consumidores con SHM**: Usa un buffer circular en memoria compartida.
    *   *Tip*: No olvides que el puntero devuelto por `mmap` es local al proceso, pero apunta a una zona física compartida.
3.  **Borrando huellas**: No olvides usar `shm_unlink`. Si no, la memoria compartida se queda en el sistema ocupando espacio hasta que reinicies.
