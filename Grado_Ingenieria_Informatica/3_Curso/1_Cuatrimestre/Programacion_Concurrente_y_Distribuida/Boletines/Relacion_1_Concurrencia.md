# PCD - Relación 1: Concurrencia y Sincronización (Oficial UHU)

La Programación Concurrente permite la ejecución simultánea de múltiples flujos de control dentro de un mismo espacio de direcciones o en sistemas distribuidos. El desafío fundamental radica en la coordinación y sincronización de dichos flujos para evitar condiciones de carrera y garantizar la consistencia de los datos.

## 1. Abstracciones de Sincronización
- **Semáforos (Dijkstra)**: Variable entera con operaciones atómicas `wait()` ($P$) y `signal()` ($V$). Permiten la exclusión mutua y la señalización entre procesos.
- **Monitores (Hoare/Hansen)**: Abstracción de alto nivel que encapsula variables compartidas y procedimientos de acceso exclusivo, junto con variables de condición para la sincronización.

## 2. Java Concurrency: Entorno de Implementación
En la UHU se utiliza Java por su modelo nativo de hilos y monitores.
- **`synchronized`**: Garantiza la exclusión mutua en métodos o bloques de código.
- **`wait()` / `notifyAll()`**: Mecanismos de comunicación entre hilos para la gestión de condiciones lógicas.
- **`java.util.concurrent`**: Librería avanzada que incluye semáforos, barreras y pools de hilos.

## 3. El Problema de la Exclusión Mutua
Garantiza que en un instante dado, un único hilo accede a la **Sección Crítica**. La violación de este principio conduce a estados de inconsistencia no deterministas.

## 📝 Ejercicio Técnico: Lectores y Escritores
Considere un recurso compartido accedido por múltiples hilos lectores (concurrentes) y escritores (exclusivos).
- **Problema**: Diseñar un monitor que priorice a los escritores para evitar la inanición (*starvation*) si el flujo de lectores es ininterrumpido.

*Metodología de Resolución*:
```java
public class RecursoCompartido {
    private int lectores = 0;
    private int escritoresEsperando = 0;
    private boolean escribiendo = false;

    public synchronized void entraLector() throws InterruptedException {
        while (escribiendo || escritoresEsperando > 0) wait();
        lectores++;
    }

    public synchronized void saleLector() {
        lectores--;
        if (lectores == 0) notifyAll();
    }

    public synchronized void entraEscritor() throws InterruptedException {
        escritoresEsperando++;
        while (lectores > 0 || escribiendo) wait();
        escritoresEsperando--;
        escribiendo = true;
    }

    public synchronized void saleEscritor() {
        escribiendo = false;
        notifyAll();
    }
}
```

## 4. Inanición y Deadlock
- **Deadlock (Interbloqueo)**: Conjunto de procesos bloqueados permanentemente esperando recursos poseídos por otros procesos del mismo conjunto. Requiere cuatro condiciones simultáneas: exclusión mutua, retención y espera, no expropiación y espera circular (Condiciones de Coffman).
