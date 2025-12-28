# PFIS - Relación 3: Patrones de Diseño (Oficial UHU)

## 🧠 No inventes la rueda
Los Patrones de Diseño son soluciones probadas a problemas que ocurren una y otra vez en el software.

1.  **Singleton**: Asegura que una clase solo tiene una instancia (ej. la conexión a la Base de Datos o el Logger).
2.  **Factory Method**: Creas objetos sin especificar la clase exacta de lo que estás creando. "Dame un Guerrero" y el Factory decide si es un `Orco` o un `Humano`.
3.  **Observer (Observador)**: El patrón de las notificaciones. Un objeto cambia estado y avisa a todos sus suscriptores automáticamente. Muy usado en interfaces gráficas (GUI).
4.  **Strategy**: Permite cambiar el algoritmo en tiempo de ejecución. Ej: Un navegador que elige entre "Cálculo ruta corta" o "Cálculo ruta rápida".

## 📝 Ejercicios de Examen
1.  **Identificar el Patrón**: Te dan un diagrama de clases o un trozo de código y tienes que adivinar qué patrón es.
    *   *Tip*: Si ves una clase con constructor privado y un método `getInstance()`, es un `Singleton` de manual.
2.  **Implementar un Observer**:
    ```cpp
    class Sujeto {
        vector<Observador*> lista;
    public:
        void notificar() {
            for(auto o : lista) o->update();
        }
    };
    ```
3.  **Ventaja de los patrones**: Mejoran la reusabilidad y hacen que el código sea más fácil de mantener por otros ingenieros (lenguaje común).
