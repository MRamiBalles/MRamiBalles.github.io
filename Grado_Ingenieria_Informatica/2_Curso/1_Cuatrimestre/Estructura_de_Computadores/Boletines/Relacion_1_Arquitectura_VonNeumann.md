# Estructura de Computadores - Relación 1: Arquitectura de Von Neumann y Programación en Ensamblador

La Estructura de Computadores (EC) analiza la organización funcional de los componentes de un sistema de cómputo y la interfaz entre el hardware y el software (ISA).

## 1. El Modelo de Von Neumann
Se caracteriza por el almacenamiento conjunto de datos e instrucciones en una única memoria principal compartida. Componentes básicos:
- **CPU**: Unidad Central de Procesamiento (ALU + Unidad de Control).
- **Memoria Principal**: Almacén lineal de celdas direccionables.
- **Sistema de E/S**: Interfaz con el mundo exterior.
- **Buses**: Canales de comunicación (Datos, Direcciones y Control).

## 2. El Juego de Instrucciones (ISA)
Define el repertorio de operaciones que el procesador es capaz de ejecutar directamente.
- **Tipos de Arquitecturas**: RISC (procesadores de instrucciones reducidas, ej. MIPS, ARM) vs CISC (instrucciones complejas, ej. x86).
- **Registros**: Memoria de alta velocidad integrada en la CPU (ej. contador de programa PC, acumulador).

## 📝 Ejercicio Técnico: Programación en Ensamblador (MIPS)
Implemente un fragmento de código que calcule la suma de los primeros 10 números naturales.
```assembly
# Implementación en MIPS
    li   $t0, 10      # Contador
    li   $t1, 0       # Acumulador
loop:
    add  $t1, $t1, $t0
    addi $t0, $t0, -1
    bnez $t0, loop    # Repetir mientras t0 != 0
```

## 3. Ciclo de Instrucción
Proceso repetitivo de ejecución:
1. **Fetch**: Captación de la instrucción desde memoria (vía PC).
2. **Decode**: Interpretación de la operación y operandos.
3. **Execute**: Ejecución en la ALU o gestión de memoria/ES.
4. **Write-back**: Almacenamiento del resultado en registros o memoria.
