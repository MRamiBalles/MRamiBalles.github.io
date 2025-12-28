# EC - Relación 2: Programación en Ensamblador MIPS (Oficial UHU)

## 🧠 Contexto Teórico
Manejo avanzado de la arquitectura MIPS para programación de bajo nivel.

*   **Pila de Llamadas (`Stack`)**: Crece hacia abajo. Se usa `$sp` (Stack Pointer).
*   **Prólogo y Epílogo**: Guardar registros salvados ($s0..s7$) y la dirección de retorno ($ra$) al entrar en una función.
*   **Paso de Argumentos**: Registros `$a0-$a3`. Resultados en `$v0-$v1`.

## 📝 Ejercicios de la Relación
1.  **Función Recursiva**: Implementa el cálculo del factorial en ensamblador MIPS.
    *   *Resolución:*
        ```assembly
        fact:
            subu $sp, $sp, 8
            sw $ra, 4($sp)
            sw $a0, 0($sp)
            slti $t0, $a0, 1
            beq $t0, $zero, L1
            li $v0, 1
            addiu $sp, $sp, 8
            jr $ra
        L1: subu $a0, $a0, 1
            jal fact
            lw $a0, 0($sp)
            lw $ra, 4($sp)
            addiu $sp, $sp, 8
            mul $v0, $a0, $v0
            jr $ra
        ```
2.  **Manejo de Cadenas**: Escribe un bucle que cuente la longitud de un string acabado en null.
    *   *Resolución:* `lb $t0, 0($s0)` (lee byte), `beq $t0, $zero, Fin`, `addi $s0, $s0, 1`, `addi $v0, $v0, 1`.
3.  **Directivas**: ¿Para qué sirven `.data` y `.text`?
    *   *Resolución:* `.data` define la sección de datos (variables globales, constantes). `.text` contiene el código del programa.
