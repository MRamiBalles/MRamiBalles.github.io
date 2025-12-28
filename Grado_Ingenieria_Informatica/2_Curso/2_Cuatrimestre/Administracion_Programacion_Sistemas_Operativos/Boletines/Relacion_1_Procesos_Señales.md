# APSO - Relación 1: Gestión de Procesos y Señales (Oficial UHU)

## 🧠 Programación de Sistemas en C
En APSO dejamos de hacer programas "de consola" normales para hablar directamente con el Kernel de Linux.

*   **`fork()`**: Crea un clon exacto. Si devuelve 0, eres el hijo. Si devuelve > 0, eres el padre (y ese número es el PID de tu hijo).
*   **`exec()`**: Cambia el código del proceso actual por otro programa (ej. `ls`).
*   **Señales**: Interrupciones software. `SIGKILL` (matar), `SIGINT` (Ctrl+C), `SIGCHLD` (aviso de hijo terminado).

## 📝 Ejercicios "de código"
1.  **Creación de jerarquías**: Haz un programa que cree un abuelo, un padre y un nieto.
    *   *Estructura*:
        ```c
        if (fork() == 0) { // Soy el padre
            if (fork() == 0) { // Soy el nieto
                printf("Soy el nieto\n");
            } else {
                wait(NULL); // Espero al nieto
                printf("Soy el padre\n");
            }
        } else {
            wait(NULL); // Espero al padre
            printf("Soy el abuelo\n");
        }
        ```
2.  **Capturar Señales**: Haz que tu programa no muera al pulsar Ctrl+C.
    *   *Resolución*: Usamos `signal(SIGINT, mi_manejador)`. Dentro de `mi_manejador` imprimimos un mensaje como "¡Ja! No puedes matarme tan fácil".
3.  **Procesos Huérfanos**: ¿Qué pasa si el padre muere antes que el hijo?
    *   *Tip*: El hijo es adoptado por el proceso 1 (`init` o `systemd`). Esto se usa mucho para crear "Demonios" (procesos que corren en segundo plano).
