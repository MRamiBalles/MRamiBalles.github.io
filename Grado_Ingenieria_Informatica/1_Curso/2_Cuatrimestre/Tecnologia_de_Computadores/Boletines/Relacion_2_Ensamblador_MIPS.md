# TC - Relación 2: Repertorio de Instrucciones MIPS (Oficial UHU)

## 🧠 Contexto Teórico
El lenguaje ensamblador es el puente entre el software de alto nivel (C) y el hardware.

*   **MIPS**: Arquitectura RISC (instrucciones simples y de tamaño fijo).
*   **Registros**: `$s0-$s7` (salvados), `$t0-$t9` (temporales), `$zero` (constante 0).
*   **Formatos**:
    1.  **R**: Registro (ej. `add`).
    2.  **I**: Inmediato (ej. `addi`, `lw`, `sw`, `beq`).
    3.  **J**: Salto (ej. `j`).

## 📝 Ejercicios de la Relación
1.  **Traducción de Aritmética**: Pasa a MIPS: `f = (g + h) - (i + j);` (Variables en $s0..s4$).
    *   *Resolución:*
        ```assembly
        add $t0, $s1, $s2  # temp0 = g + h
        add $t1, $s3, $s4  # temp1 = i + j
        sub $s0, $t0, $t1  # f = temp0 - temp1
        ```
2.  **Acceso a Memoria**: Traduce `A[12] = h + A[8];` (Base de A en $s3, h en $s2).
    *   *Resolución:*
        ```assembly
        lw $t0, 32($s3)   # t0 = A[8] (8*4 bytes de offset)
        add $t0, $s2, $t0 # t0 = h + A[8]
        sw $t0, 48($s3)   # A[12] = t0 (12*4 bytes de offset)
        ```
3.  **Saltos Condicionales**: Traduce `if (i == j) f = g + h; else f = g - h;`.
    *   *Resolución:*
        ```assembly
        bne $s3, $s4, Else
        add $s0, $s1, $s2
        j Exit
        Else: sub $s0, $s1, $s2
        Exit:
        ```
