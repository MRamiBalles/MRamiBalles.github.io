# SSI - Relación 1: Criptografía y Seguridad de Redes (Oficial UHU)

La seguridad de la información se fundamenta en los pilares de Confidencialidad, Integridad, Disponibilidad y No Repudio.

## 1. Criptografía Asimétrica (RSA)
Basada en la dificultad de factorización de números primos de gran magnitud.
- **Cifrado**: $C = M^e \pmod n$
- **Descifrado**: $M = C^d \pmod n$
- $n = p \cdot q$, donde $p$ y $q$ son primos.

## 2. Funciones Hash y Firmas Digitales
Garantizan la integridad y el no repudio. Una firma digital se genera cifrando el hash del mensaje con la clave privada del emisor.
- Algoritmos estándar: SHA-256, SHA-3.

## 📝 Ejercicio Técnico: Cifrado RSA
Dados $p = 3, q = 11$, calcule:
- **a)** El valor de $n$ y $\phi(n)$.
- **b)** Una clave pública exponente $e$ válida.
- **c)** La clave privada $d$ correspondiente.

*Resolución*:
- $n = 3 \cdot 11 = 33$.
- $\phi(n) = (3-1) \cdot (11-1) = 2 \cdot 10 = 20$.
- Elegimos $e = 3$ (ya que $mcd(3, 20) = 1$).
- Para calcular $d$: $3 \cdot d \equiv 1 \pmod{20} \Rightarrow d = 7$ (porque $3 \cdot 7 = 21 \equiv 1 \pmod{20}$).
- Clave Pública: $(3, 33)$. Clave Privada: $(7, 33)$.
