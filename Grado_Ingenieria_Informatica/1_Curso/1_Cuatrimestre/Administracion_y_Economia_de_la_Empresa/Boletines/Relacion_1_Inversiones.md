# AEE - Relación 1: Análisis de Inversiones (VAN y TIR)

El análisis de inversiones permite determinar la viabilidad financiera de proyectos a largo plazo mediante la actualización de flujos de caja.

## 🧠 Conceptos Clave
- **VAN (Valor Actual Neto)**: Diferencia entre el valor actualizado de los cobros y el valor actualizado de los pagos.
  - $VAN > 0$: Rentable.
  - $VAN < 0$: No rentable.
- **TIR (Tasa Interna de Rentabilidad)**: Tipo de actualización que hace que el VAN sea cero. Representa la rentabilidad interna del proyecto.
- **Payback (Plazo de Recuperación)**: Tiempo necesario para recuperar la inversión inicial.

## 📝 Ejercicio Resuelto: Decisión de Inversión
**Enunciado:** Un proyecto requiere una inversión inicial de 10.000€ y generará 6.000€ el primer año y 7.000€ el segundo. ¿Es rentable si el tipo de descuento es del 5%?

**Resolución:**
1. **Fórmula del VAN**:
   $VAN = -D_0 + \frac{C_1}{(1+k)^1} + \frac{C_2}{(1+k)^2}$
2. **Sustitución de datos**:
   $VAN = -10.000 + \frac{6.000}{1.05} + \frac{7.000}{(1.05)^2}$
3. **Cálculo**:
   $VAN = -10.000 + 5.714,29 + 6.349,21 = 2.063,50€$

**Conclusión:** Como el **VAN es positivo (2.063,50€)**, el proyecto es **efectuables/rentable** según el criterio del Valor Actual Neto.

---
> [!TIP]
> En los exámenes de la UHU, si los flujos de caja son constantes, puedes usar la fórmula de la renta acumulada para simplificar los cálculos del VAN.
