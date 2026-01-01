# APSO - Relación 1: Gestión de Procesos y Señales (Oficial UHU)

## 🧠 Programación de Sistemas en C
En APSO dejamos de hacer programas "de consola" normales para hablar directamente con el Kernel de Linux.

*   **`fork()`**: Crea un clon exacto. Si devuelve 0, eres el hijo. Si devuelve > 0, eres el padre (y ese número es el PID de tu hijo).
*   **`exec()`**: Cambia el código del proceso actual por otro programa (ej. `ls`).
*   **Señales**: Interrupciones software. `SIGKILL` (matar), `SIGINT` (Ctrl+C), `SIGCHLD` (aviso de hijo terminado).

## 📝 Ejercicios de Programación: Soluciones Técnicas

### 1. Jerarquías de Procesos (Abuelo-Padre-Nieto)
**Objetivo**: Implementar una estructura de procesos lineal donde cada proceso espere estrictamente a su descendiente antes de finalizar.

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    pid_t pid_padre, pid_nieto;

    pid_padre = fork();

    if (pid_padre < 0) {
        perror("Error en fork padre");
        exit(1);
    }

    if (pid_padre == 0) { // Contexto del HIJO (será Padre del Nieto)
        pid_nieto = fork();

        if (pid_nieto < 0) {
            perror("Error en fork nieto");
            exit(1);
        }

        if (pid_nieto == 0) { // Contexto del NIETO
            printf("[NIETO] PID: %d, Mi padre es: %d\n", getpid(), getppid());
            sleep(1); // Simulación de carga
        } else { // Contexto del PADRE (esperando al nieto)
            wait(NULL); 
            printf("[PADRE] PID: %d, Mi padre (Abuelo) es: %d. Mi hijo (Nieto) ha terminado.\n", getpid(), getppid());
        }
    } else { // Contexto del ABUELO (proceso original)
        wait(NULL); // Espera al hijo
        printf("[ABUELO] PID: %d. Mi hijo (Padre) ha terminado. Jerarquía finalizada.\n", getpid());
    }

    return 0;
}
```

### 2. Manejo de Señales Interactivas (`SIGINT`)
**Objetivo**: Alterar el comportamiento por defecto de la señal de interrupción para evitar la terminación inmediata y ejecutar una rutina personalizada.

```c
#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>

void manejador_sigint(int sig) {
    printf("\n[SISTEMA] Capturada señal %d (SIGINT). El proceso continúa en ejecución.\n", sig);
    printf("Use 'kill -9 %d' desde otra terminal para forzar la salida.\n", getpid());
}

int main() {
    // Registro del manejador para SIGINT (Ctrl+C)
    if (signal(SIGINT, manejador_sigint) == SIG_ERR) {
        perror("Error al registrar el manejador");
        exit(1);
    }

    printf("Proceso persistente (PID: %d). Intente pulsar Ctrl+C...\n", getpid());

    while(1) {
        pause(); // Bloquea el proceso hasta recibir cualquier señal
    }

    return 0;
}
```

### 3. Simulación de Huerfanía y Adopción por `init`
**Objetivo**: Demostrar cómo un proceso hijo es reasignado al proceso raíz del sistema (`PID 1`) cuando su progenitor termina prematuramente.

```c
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    pid_t pid = fork();

    if (pid > 0) { // El Padre termina inmediatamente
        printf("[PADRE] Finalizando para dejar al hijo huérfano...\n");
        exit(0);
    } else if (pid == 0) { // El Hijo sobrevive
        printf("[HIJO] Mi padre inicial era: %d. Durmiendo 5s...\n", getppid());
        sleep(5);
        printf("[HIJO] Ahora mi padre (adoptivo) es: %d\n", getppid());
    }

    return 0;
}
```

---
> [!TIP]
> Al trabajar con jerarquías complejas, usa `ps -ejH` en la terminal de Linux para visualizar el árbol de procesos de forma jerárquica.
