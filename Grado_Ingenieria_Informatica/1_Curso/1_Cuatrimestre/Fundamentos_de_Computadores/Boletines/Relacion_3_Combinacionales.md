# FC - Relación 3: Circuitos Combinacionales (Oficial UHU)

## 🧠 Contexto Teórico
Circuitos donde la salida depende exclusivamente de las entradas actuales.

*   **Mapas de Karnaugh**: Método gráfico de simplificación.
*   **Módulos MSI**: Multiplexores (selector), Decodificadores (activador), Sumadores.

## 📝 Ejercicios de la Relación
1.  **Simplificación K-Map**: Simplifica $F(A,B,C,D) = \sum m(0,2,8,10,5,7,13,15)$.
    *   *Resolución:* Agrupamos los 4 unos de las esquinas ($\overline{B}\overline{D}$) y los 4 del centro ($BD$). Resultado: $F = \overline{B}\overline{D} + BD = B \odot D$ (XNOR).
2.  **Diseño con Multiplexores**: Implementa una XOR de 2 entradas usando un MUX 4:1.
    *   *Resolución:* Entradas de selección $A, B$. Entradas de datos: $I_0=0, I_1=1, I_2=1, I_3=0$.
3.  **Análisis de sumador**: ¿Cuál es el resultado de un sumador de 4 bits si sumamos $1011 + 0101$?
    *   *Resolución:* $1011 (11) + 0101 (5) = 10000 (16)$. El resultado es $0000$ con acarreo de salida $C_{out}=1$.
