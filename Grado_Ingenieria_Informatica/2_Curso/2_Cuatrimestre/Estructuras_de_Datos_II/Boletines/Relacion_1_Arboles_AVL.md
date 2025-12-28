# ED II - Relación 1: Árboles Ávidos y Balanceados (AVL) (Oficial UHU)

## 🧠 ¿Por qué complicarse con AVL?
Un Árbol Binario de Búsqueda (BST) normal puede volverse una lista si metes los datos ordenados, y entonces buscar es lentísimo ($O(n)$). Los AVL se mantienen "bajitos" y balanceados para que buscar sea siempre $O(\log n)$.

*   **Factor de Equilibrio (FE)**: $FE = \text{altura(derecha)} - \text{altura(izquierda)}$. Solo puede ser -1, 0 o 1.
*   **Rotaciones**: El "baile" que hace el árbol para arreglarse. Simple (izquierda o derecha) y Dobles (izq-der o der-izq).

## 📝 Ejercicios "de pintar"
1.  **Inserción en AVL**: Inserta los números {10, 20, 30} en un AVL.
    *   *Paso 1*: Metes el 10.
    *   *Paso 2*: Metes el 20 a la derecha.
    *   *Paso 3*: Metes el 30 a la derecha del 20. Ahora el root (10) tiene un $FE=2$. ¡Descompensado!
    *   *Rotación*: Hacemos una rotación simple a la izquierda sobre el 10. El 20 sube a ser el jefe. El 10 se queda a su izquierda. Perfecto.
2.  **Rotación Doble**: ¿Cuándo ocurre?
    *   *Organic Tip*: Cuando el árbol hace un zig-zag (forma de "C" o de "S"). Primero rotas el hijo para ponerlo en línea y luego rotas el abuelo.
3.  **Borrado**: Es lo más difícil. Al borrar puedes descompensar una rama lejana. En los exámenes de la UHU suelen pedir inserciones, pero ojo con el borrado por si acaso.
