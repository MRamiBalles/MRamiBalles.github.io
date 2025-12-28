# Matemáticas I - Relación 1: Fundamentos de Análisis Real y Números Complejos

El análisis matemático en una variable constituye el pilar sobre el cual se asienta el modelado de sistemas físicos y señales dinámicas en ingeniería.

## 1. El Sistema de los Números Reales ($\mathbb{R}$)
Los números reales se asientan sobre axiomas de cuerpo ordenado y completo (Axioma del Supremo), permitiendo la base del cálculo infinitesimal.

## 2. Números Complejos ($\mathbb{C}$)
Extensión algebraica que permite la resolución de ecuaciones sin raíces reales mediante la unidad imaginaria $i^2 = -1$.
- **Representaciones**: 
  - Binómica: $z = a + bi$
  - Polar/Exponencial: $z = r e^{i\theta} = r(\cos \theta + i \sin \theta)$
- **Fórmula de Euler**: $e^{ix} = \cos x + i \sin x$. Crucial para el análisis espectral y la transformada de Fourier.

## 📝 Ejercicio de Operatoria Compleja
Halle las raíces cúbicas del número complejo $z = 1 + i$.
*Resolución*:
1. Paso a forma polar: $r = \sqrt{1^2 + 1^2} = \sqrt{2}$; $\theta = \arctan(1/1) = \pi/4$.
2. Aplicación de la fórmula de De Moivre: $w_k = \sqrt[3]{\sqrt{2}} e^{i(\frac{\pi/4 + 2k\pi}{3})}$ para $k=0, 1, 2$.
- $w_0 = \sqrt[6]{2} e^{i(\pi/12)}$
- $w_1 = \sqrt[6]{2} e^{i(3\pi/4)}$
- $w_2 = \sqrt[6]{2} e^{i(17\pi/12)}$

## 3. Límites y Continuidad
- **Definición $\epsilon-\delta$**: Formalización del concepto de aproximación en un punto.
- **Teorema de Bolzano**: Garantiza la existencia de raíces en funciones continuas con cambio de signo en un intervalo cerrado.
