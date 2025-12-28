# Física - Teoría y Problemas: Electromagnetismo y Circuitos de CA

Esta unidad establece las bases de la teoría electromagnética clásica y su aplicación en el análisis de circuitos de corriente alterna, fundamentales para la ingeniería de hardware y comunicaciones.

## 1. Ecuaciones de Maxwell (Forma Integral)
Las leyes de Maxwell unifican los fenómenos eléctricos y magnéticos:
1. **Ley de Gauss (Electricidad)**: Relaciona el flujo eléctrico con la carga neta.
2. **Ley de Gauss (Magnetismo)**: Establece la inexistencia de monopolos magnéticos.
3. **Ley de Faraday-Lenz**: Describe la inducción de fuerza electromotriz (FEM) por variaciones de flujo magnético.
4. **Ley de Ampère-Maxwell**: Relaciona el campo magnético con las corrientes eléctricas y los campos eléctricos variables.

## 2. Circuitos de Corriente Alterna (CA)
En un sistema de CA, las magnitudes varían de forma senoidal. Se utiliza el formalismo de **Fasores** para simplificar el análisis.
- **Impedancia ($Z$)**: Generalización de la resistencia en CA. $Z = R + jX$, donde $X$ es la reactancia.
  - Reactancia Inductiva: $X_L = \omega L$
  - Reactancia Capacitiva: $X_C = 1/(\omega C)$
- **Resonancia**: Ocurre cuando $X_L = X_C$, minimizando la impedancia total en un circuito RLC serie.

## 📝 Problema de Examen: Análisis de Circuito RLC
Dado un circuito RLC serie con $R = 10 \Omega, L = 0.5 H, C = 10 \mu F$ alimentado por una fuente de $V = 230V$ a $50Hz$:
- **a)** Calcule la impedancia total del sistema.
- **b)** Determine la corriente máxima y el desfase entre tensión e intensidad.
- **c)** Halle la frecuencia de resonancia del circuito.

*Resolución*: 
- $\omega = 2\pi f = 100\pi \approx 314.16 \, rad/s$.
- $X_L = 314.16 \cdot 0.5 = 157.08 \Omega$.
- $X_C = 1/(314.16 \cdot 10 \cdot 10^{-6}) = 318.31 \Omega$.
- $Z = \sqrt{R^2 + (X_L - X_C)^2} = \sqrt{10^2 + (157.08 - 318.31)^2} \approx 161.54 \Omega$.
- Frecuencia de resonancia $f_0 = 1 / (2\pi \sqrt{LC}) \approx 71.18 \, Hz$.
