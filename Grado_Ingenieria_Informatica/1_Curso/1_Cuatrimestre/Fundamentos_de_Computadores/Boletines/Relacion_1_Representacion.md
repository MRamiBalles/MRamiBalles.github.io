# Fundamentos de Computadores - Relación 1: Sistemas de Numeración y Representación

Esta unidad aborda los principios de la aritmética digital y los estándares de representación de datos en sistemas de cómputo modernos.

## Fundamentación Teórica

### Sistemas de Numeración Posicional
La representación de la información se sustenta en sistemas posicionales de base $b$. Las bases de mayor relevancia en ingeniería son:
- **Binario (Base 2)**: Fundamental para la lógica digital.
- **Octal (Base 8)** y **Hexadecimal (Base 16)**: Utilizados como representaciones compactas de cadenas binarias.

### Aritmética de Enteros con Signo: Complemento a 2
El sistema de Complemento a 2 ($C_2$) permite la unificación de las operaciones de suma y resta. Para un sistema de $n$ bits, la representación de un número negativo $N$ se obtiene mediante:
$N_{C2} = 2^n - |N|$

### Estándar IEEE 754 para Coma Flotante
Define el formato para la representación de números reales mediante tres componentes: bit de signo ($S$), exponente sesgado ($E$) y mantisa o parte fraccionaria ($M$).
$$Valor = (-1)^S \times 1.M \times 2^{E - Sesgo}$$

## Resolución de Problemas Seleccionados

1. **Conversión Estructural de Bases**
   *Problema*: Conversión del valor decimal $175$ a los sistemas binario y hexadecimal.
   *Metodología*: Aplicación de divisiones sucesivas por la base de destino.
   - Binario: $10101111_2$
   - Hexadecimal: $AF_{16}$

2. **Operaciones en Aritmética Binaria**
   *Problema*: Ejecución de la operación sustractiva $7 - 5$ en un registro de 8 bits mediante Complemento a 2.
   *Metodología*: 
   - $+7_{10} = 00000111_2$
   - $-5_{10} = C2(00000101_2) = 11111011_2$
   - Suma algebraica: $00000111_2 + 11111011_2 = (1)00000010_2$, resultando en $2_{10}$ tras el descarte del acarreo final.

3. **Interpretación del Estándar IEEE 754**
   *Problema*: Decodificación de la secuencia de bits `0 10000010 1010...0` (precisión simple).
   *Metodología*:
   - Signo: $0 \implies$ Positivo.
   - Exponente: $10000010_2 = 130 \implies 130 - 127 = 3$.
   - Mantisa: $1.101_2$.
   - Cálculo final: $1.101_2 \times 2^3 = 1101_2 = 13_{10}$.
