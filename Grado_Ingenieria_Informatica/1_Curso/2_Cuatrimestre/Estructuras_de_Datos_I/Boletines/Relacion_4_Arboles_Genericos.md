# ED I - Relación 4: Árboles Genéricos y Bosques (Oficial UHU)

## 🧠 Contexto Teórico
Representación de jerarquías donde un nodo puede tener un número arbitrario de hijos.

*   **Representación Hijo Izquierdo - Hermano Derecho (HI-HD)**: Permite almacenar un árbol de grado $k$ usando solo dos punteros por nodo, como si fuera un árbol binario.
*   **Recorridos**: 
    *   **Preorden**: Raíz, luego sus hijos.
    *   **Postorden**: Hijos, luego raíz.
    *   *Nota*: El Inorden no está bien definido para árboles genéricos como tal.
*   **Bosques**: Conjunto de árboles.

## 📝 Ejercicios de la Relación
1.  **Conversión**: Dado un árbol genérico, dibuja su representación HI-HD equivalente.
    *   *Resolución:* Para cada nodo, su primer hijo va a la izquierda. Los demás hijos de ese mismo padre se enlazan secuencialmente a la derecha del primer hijo.
2.  **Grado de un Árbol**: Escribe un algoritmo para hallar el grado máximo (máximo número de hijos) de un árbol genérico.
    *   *Resolución:* Recorrer el árbol y para cada nodo, contar su número de hijos directos. Devolver el máximo encontrado.
3.  **Altura**: Calcula la altura de un árbol genérico.
    *   *Resolución:* La altura de un nodo es $h = 1 + \max(h_{hijos})$.
