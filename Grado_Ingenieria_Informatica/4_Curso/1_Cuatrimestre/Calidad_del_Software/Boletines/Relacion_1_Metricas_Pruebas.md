# CS - Relación 1: Pruebas y Complejidad Ciclo-mática (Oficial UHU)

La calidad del software se cuantifica mediante métricas objetivas y la aplicación rigurosa de niveles de prueba.

## 1. Métricas de Complejidad
La **Complejidad Ciclo-mática ($V(G)$)** mide la complejidad lógica de un programa basándose en su grafo de flujo de control.
- Fórmula: $V(G) = E - N + 2P$
  - Donde $E$ es el número de aristas, $N$ el de nodos y $P$ el de componentes conexas.
- Un valor elevado indica mayor probabilidad de errores y mayor dificultad de mantenimiento.

## 2. Niveles de Prueba
- **Pruebas Unitarias**: Verificación de componentes individuales.
- **Pruebas de Integración**: Verificación de la interoperabilidad entre módulos.
- **Pruebas de Sistema**: Validación del producto completo frente a los requisitos.
- **Pruebas de Aceptación (UAT)**: Validación final por parte del usuario final.

## 📝 Ejercicio Técnico
Dado el siguiente fragmento de código:
```cpp
void procesarValores(int a, int b) {
    if (a > 10) {
        if (b < 5) {
            ejecutarAccion1();
        } else {
            ejecutarAccion2();
        }
    } else {
        ejecutarAccion3();
    }
}
```
- **a)** Dibuje el grafo de flujo de control.
- **b)** Calcule la complejidad ciclo-mática $V(G)$.
- **c)** Defina el conjunto mínimo de casos de prueba para garantizar una cobertura de decisiones del 100%.

*Resolución*: 
- El grafo presenta 4 nodos de decisión y 5 aristas. $V(G) = 6 - 5 + 2 = 3$.
- Casos de prueba:
  1. `a=11, b=4` (Ruta: 1, 2, 3)
  2. `a=11, b=6` (Ruta: 1, 2, 4)
  3. `a=9` (Ruta: 1, 5)
