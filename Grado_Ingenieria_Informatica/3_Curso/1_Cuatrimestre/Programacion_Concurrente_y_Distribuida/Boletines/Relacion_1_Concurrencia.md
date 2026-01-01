# PCD - Relación 1: Concurrencia y Sincronización (Oficial UHU)

La Programación Concurrente permite la ejecución simultánea de múltiples flujos de control dentro de un mismo espacio de direcciones o en sistemas distribuidos.

## 1. Abstracciones de Sincronización
- **Semáforos**: Abstracción de bajo nivel basada en contadores atómicos (`wait`/`signal`).
- **Monitores**: Abstracción de alto nivel que encapsula exclusión mutua y variables de condición.

## 📝 Ejercicio Técnico: Lectores-Escritores con Semáforos
**Problema**: Implementar la sincronización de lectores-escritores (prioridad lectores) usando semáforos en C/Java.

```c
sem_t mutex;    // Controla el acceso a la variable 'lectores'
sem_t rw_mutex; // Controla el acceso al recurso (escritura/lectura exclusiva)
int lectores = 0;

void lector() {
    sem_wait(&mutex);
    lectores++;
    if (lectores == 1) sem_wait(&rw_mutex); // El primer lector bloquea a escritores
    sem_post(&mutex);
    
    // --- LECTURA ---
    
    sem_wait(&mutex);
    lectores--;
    if (lectores == 0) sem_post(&rw_mutex); // El último lector desbloquea
    sem_post(&mutex);
}

void escritor() {
    sem_wait(&rw_mutex); // Bloqueo total
    // --- ESCRITURA ---
    sem_post(&rw_mutex);
}
```

## 📝 Ejercicio Técnico: Monitor en Java (Estructura de Examen)
En Java, los monitores se implementan con la keyword `synchronized` y los métodos `wait()` / `notifyAll()`.

**Regla de Oro**: Siempre use un `while` alrededor del `wait()` para re-comprobar la condición tras ser despertado (evitar activaciones espurias).

```java
public synchronized void entrar() throws InterruptedException {
    while (!condicion) {
        wait();
    }
    // Modificar estado
    notifyAll();
}
```

---
## 3. Condiciones de Deadlock (Coffman)
Para que ocurra un interbloqueo deben darse cuatro condiciones:
1. **Exclusión Mutua**: Al menos un recurso no es compartible.
2. **Retención y Espera**: Un proceso tiene un recurso y espera otro.
3. **No Expropiación**: Los recursos solo se liberan voluntariamente.
4. **Espera Circular**: Cadena de procesos donde cada uno espera al siguiente.
