# APSO - Relación 3: Memoria Compartida y Archivos Proyectados (Oficial UHU)

## 🧠 Comunicación entre procesos (IPC)
El uso de `mmap` y `shm_open` permite que procesos independientes compartan memoria física, siendo la forma más rápida de IPC.

## 📝 Caso Práctico: Comunicación Padre-Hijo vía Memoria Compartida

En este ejemplo, creamos un objeto de memoria compartida POSIX, lo proyectamos en el espacio de direcciones y lo usamos para que el padre pase un mensaje al hijo.

### Implementación en C (Librería `sys/mman.h` y `fcntl.h`)

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <unistd.h>
#include <sys/wait.h>

#define SHM_NAME "/mi_memoria_compartida"
#define SIZE 4096

int main() {
    int shm_fd;
    void *ptr;

    // 1. Crear el objeto de memoria compartida
    shm_fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, 0666);
    ftruncate(shm_fd, SIZE);

    // 2. Mapear el objeto en memoria
    ptr = mmap(0, SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);
    if (ptr == MAP_FAILED) {
        perror("Error en mmap");
        return -1;
    }

    pid_t pid = fork();

    if (pid == 0) { // Proceso HIJO
        sleep(1); // Esperar a que el padre escriba
        printf("[HIJO] Leyendo mensaje: %s\n", (char*)ptr);
        
        // Modificar contenido
        sprintf(ptr, "Hijo ha recibido la señal.");
        
        munmap(ptr, SIZE);
        close(shm_fd);
        exit(0);
    } else { // Proceso PADRE
        sprintf(ptr, "Hola hijo, soy tu padre.");
        printf("[PADRE] Mensaje escrito en SHM.\n");
        
        wait(NULL); // Esperar a que el hijo termine
        printf("[PADRE] Mensaje final en SHM: %s\n", (char*)ptr);

        // Limpieza total
        munmap(ptr, SIZE);
        close(shm_fd);
        shm_unlink(SHM_NAME); // ¡Fundamental para no dejar basura!
    }

    return 0;
}
```

---
> [!WARNING]
> Compila siempre con el flag `-lrt` (librería de tiempo real) en Linux:
> `gcc shm_example.c -o shm_example -lrt`
