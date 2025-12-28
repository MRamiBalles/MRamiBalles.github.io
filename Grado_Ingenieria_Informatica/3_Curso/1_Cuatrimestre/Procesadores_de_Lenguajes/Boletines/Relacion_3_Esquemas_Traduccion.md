# PL - Relación 3: Esquemas de Traducción (ETDS) (Oficial UHU)

Un Esquema de Traducción Dirigida por la Sintaxis asocia fragmentos de código (acciones semánticas) a las reglas de una gramática para realizar tareas como la comprobación de tipos o la generación de código.

## 1. Atributos Semánticos
- **Sintetizados**: Su valor depende de los hijos del nodo en el árbol de análisis.
- **Heredados**: Su valor depende de los hermanos o del padre.

## 2. Gramáticas L-Atribuidas
Permiten la evaluación de atributos en una única pasada (de izquierda a derecha). Todos los atributos heredados de un símbolo dependen de los símbolos a su izquierda en la regla de producción.

## 📝 Ejercicio Técnico: Cálculo de Atributos
Dada la regla $L \to L_1, id$ con la acción `{ L.lista = L1.lista + [id.nombre] }`.
- **Tipo de Atributo**: Sintetizado (el padre $L$ obtiene su valor de $L_1$ e $id$).

## 3. Generación de Código Intermedio (GCI)
Representación independiente de la máquina (como el código de tres direcciones).
- **Ejemplo**: `a = b + c * d` se traduce en:
  - `t1 = c * d`
  - `t2 = b + t1`
  - `a = t2`

---
*Escuela Técnica Superior de Ingeniería - Universidad de Huelva.*
