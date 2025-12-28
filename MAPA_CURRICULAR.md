# Mapa Curricular: Itinerario de Conocimiento (ETSI UHU)

Este diagrama visualiza la progresión lógica de los conocimientos a lo largo del grado, destacando las dependencias críticas entre materias.

```mermaid
graph TD
    %% Primer Año
    subgraph Year1 [1º CURSO: Fundamentación]
        M1[Matemáticas I: Análisis] --> M2[Matemáticas II: Álgebra]
        M1 --> M3[Matemáticas III: Estadística]
        FC[Fundamentos de Computadores] --> EC[Estructura de Computadores]
        FP[Fundamentos de Programación] --> MP[Metodología de Programación]
        FP --> FAA[Análisis de Algoritmos]
    end

    %% Segundo Año
    subgraph Year2 [2º CURSO: Ingeniería de Sistemas]
        EC --> AC[Arquitectura de Computadores]
        MP --> ED[Estructuras de Datos II]
        MP --> PFIS[Ingeniería del Software]
        DESO[Sistemas Operativos I] --> APSO[Sistemas Operativos II]
        FRC[Redes de Computadores] --> IRC[Interconexión de Redes]
        BD[Bases de Datos] --> DDSI[Diseño de Sistemas]
    end

    %% Tercer/Cuarto Año
    subgraph Year3and4 [ESPECIALIZACIÓN]
        ED --> IA[Inteligencia Artificial]
        PFIS --> CS[Calidad del Software]
        IRC --> SEC[Seguridad de la Información]
        APSO --> STR[Sistemas de Tiempo Real]
        FAA --> MAC[Modelos de Computación]
        IA --> AA[Aprendizaje Automático]
    end

    %% TFG
    Year3and4 --> TFG[Trabajo Fin de Grado]

    style Year1 fill:#f9f,stroke:#333,stroke-width:2px
    style Year2 fill:#bbf,stroke:#333,stroke-width:2px
    style Year3and4 fill:#bfb,stroke:#333,stroke-width:2px
    style TFG fill:#fbb,stroke:#333,stroke-width:4px
```

## 🚩 Hitos Críticos (Dependencias)
1. **El Núcleo de Programación**: FP $\to$ MP $\to$ ED II. Perder el hilo en cualquiera de estas asignaturas compromete todo el desarrollo de software posterior.
2. **La Pila de Sistemas**: FC $\to$ EC $\to$ AC. Define tu capacidad de entender el rendimiento real del hardware.
3. **La Red de Seguridad**: FRC $\to$ IRC $\to$ Seguridad. El camino hacia el PenTesting clínico.

---
*Gráfico de Dependencias - Ingeniería Informática UHU.*
