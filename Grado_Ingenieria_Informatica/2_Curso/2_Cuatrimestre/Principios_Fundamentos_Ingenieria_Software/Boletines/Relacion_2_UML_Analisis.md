# PFIS - Relación 2: Análisis con UML (Diagramas de Clase y Casos de Uso) (Oficial UHU)

## 🧠 UML: El lenguaje del Ingeniero
El UML es la herramienta fundamental para documentar la arquitectura de un sistema de software de forma independiente al lenguaje de programación.

*   **Casos de Uso**: Describen la funcionalidad del sistema desde el punto de vista del usuario.
    - **Actor**: Rol externo (Persona, Dispositivo o Sistema).
    - **Relaciones**: `<<include>>` (obligatorio) y `<<extend>>` (opcional/condicional).
*   **Diagramas de Clase**: Representan la estructura estática del sistema.
    - **Composición (Rombo Negro)**: Relación fuerte. El ciclo de vida de la parte depende del todo.
    - **Agregación (Rombo Blanco)**: Relación débil. Las partes pueden existir independientemente.

## 📝 Casos Prácticos de Modelado

### 1. El Sistema de un Cajero Automático
**Enunciado**: Modele los Casos de Uso para un cliente que saca dinero.
- **Actores**: Cliente, Banco (Sistema externo).
- **Casos de Uso**: Sacar Dinero, Validar PIN, Consultar Saldo.
- **Relaciones**: Sacar Dinero `<<include>>` Validar PIN. Imprimir Recibo `<<extend>>` Sacar Dinero.

### 2. Diferenciando Composición y Agregación (Pregunta de Examen)
**Enunciado**: Identifique el tipo de relación en los siguientes pares:
1. **Coche - Motor**: Composición (Normalmente). Si destruyes el coche para chatarra, el motor se considera parte de esa unidad, aunque mecánicamente se pueda extraer, en modelado OO suele ser composición.
2. **Biblioteca - Libro**: Agregación. Si la biblioteca cierra, los libros pueden donarse o moverse a otra. Siguen existiendo.
3. **Página Web - Botones**: Composición. Si borras la página, los botones desaparecen.

### 3. Multiplicidad y Atributos
**Enunciado**: Modele "Un Cliente puede realizar muchos Pedidos, pero un Pedido pertenece a un solo Cliente".
- **Clase Cliente**: `- id: int`, `+ realizarPedido()`.
- **Clase Pedido**: `- fecha: Date`.
- **Relación**: `Cliente (1) ---- (*) Pedido`.

---
> [!TIP]
> En los exámenes de la UHU, si dudáis entre agregación y composición, recordad: si al destruir el objeto "contenedor", el objeto "contenido" se queda huérfano y sin utilidad en el sistema, es **Composición**.
