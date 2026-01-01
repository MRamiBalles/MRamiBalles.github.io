# APSO - Relación 2: Hilos (Threads) y Sincronización (Oficial UHU)

## 🧠 Hilos vs Procesos
Si un proceso es una casa, los hilos son las personas que viven dentro. Comparten la memoria global (segmento de datos), pero tienen su propio stack.

## 📝 Caso Práctico: El Problema del Productor-Consumidor
Este es el ejercicio estrella de los exámenes de APSO. Implementamos un buffer circular compartido donde unos hilos producen datos y otros los consumen, evitando condiciones de carrera y esperas activas.

### Implementación en C (Librería `pthread` y `semaphore.h`)

```c
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

#define TAM_BUFFER 5
#define PRODUCTORES 2
#define CONSUMIDORES 2

int buffer[TAM_BUFFER];
int in = 0;
int out = 0;

sem_t vacio;   // Controla huecos libres
sem_t lleno;   // Controla datos listos para leer
pthread_mutex_t cerrojo; // Exclusión mutua para tocar el buffer

void* productor(void* arg) {
    int id = *(int*)arg;
    for(int i = 0; i < 10; i++) {
        int dato = rand() % 100;
        
        sem_wait(&vacio); // Espero si el buffer está lleno
        pthread_mutex_lock(&cerrojo); // Bloqueo acceso al buffer
        
        buffer[in] = dato;
        printf("[P%d] Produciendo %d en pos %d\n", id, dato, in);
        in = (in + 1) % TAM_BUFFER;
        
        pthread_mutex_unlock(&cerrojo);
        sem_post(&lleno); // Aviso de que hay un dato nuevo
        sleep(rand() % 2);
    }
    return NULL;
}

void* consumidor(void* arg) {
    int id = *(int*)arg;
    for(int i = 0; i < 10; i++) {
        sem_wait(&lleno); // Espero si el buffer está vacío
        pthread_mutex_lock(&cerrojo);
        
        int dato = buffer[out];
        printf("[C%d] Consumiendo %d de pos %d\n", id, dato, out);
        out = (out + 1) % TAM_BUFFER;
        
        pthread_mutex_unlock(&cerrojo);
        sem_post(&vacio); // Aviso de que hay un hueco libre
        sleep(rand() % 3);
    }
    return NULL;
}

int main() {
    pthread_t h[PRODUCTORES + CONSUMIDORES];
    int ids[PRODUCTORES + CONSUMIDORES];

    sem_init(&vacio, 0, TAM_BUFFER);
    sem_init(&lleno, 0, 0);
    pthread_mutex_init(&cerrojo, NULL);

    for(int i = 0; i < PRODUCTORES; i++) {
        ids[i] = i;
        pthread_create(&h[i], NULL, productor, &ids[i]);
    }
    for(int i = 0; i < CONSUMIDORES; i++) {
        ids[PRODUCTORES+i] = i;
        pthread_create(&h[PRODUCTORES+i], NULL, consumidor, &ids[PRODUCTORES+i]);
    }

    for(int i = 0; i < PRODUCTORES + CONSUMIDORES; i++) pthread_join(h[i], NULL);

    sem_destroy(&vacio);
    sem_destroy(&lleno);
    pthread_mutex_destroy(&cerrojo);

    return 0;
}
```

---
> [!IMPORTANT]
> - **Mutex**: Garantiza que solo un hilo toque `in` o `out` a la vez.
> - **Semáforos**: Gestionan la sincronización de "espera" (no producir si está lleno, no consumir si está vacío).
