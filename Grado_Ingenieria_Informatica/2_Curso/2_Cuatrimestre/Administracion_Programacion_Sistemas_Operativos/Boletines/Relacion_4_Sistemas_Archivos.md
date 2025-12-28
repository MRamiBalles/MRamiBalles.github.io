# APSO - Relación 4: Sistemas de Archivos e Inodos (Oficial UHU)

## 🧠 ¿Qué es un archivo para Linux?
Olvídate de las carpetas bonitas. Para el kernel, un archivo es un chorro de bytes identificado por un número: el **Inodo**.

*   **El Inodo (Index Node)**: Contiene toda la metadata (dueño, permisos, tamaño, fechas) y punteros a los bloques de datos. **OJO**: El nombre del archivo NO está en el inodo, está en el directorio.
*   **Superbloque**: Contiene info global del sistema de archivos (tamaño total, bloques libres, etc.).
*   **Enlaces (Links)**:
    - **Hard Link**: Otro nombre para el mismo inodo. Si borras el original, el archivo sigue vivo.
    - **Soft Link (Simbólico)**: Un acceso directo que apunta al nombre. Si borras el original, el link se rompe.

## 📝 Ejercicios de Estructura
1.  **Cálculo de tamaño máximo**: Un inodo tiene 12 punteros directos, 1 indirecto simple, 1 doble y 1 triple. Si el bloque es de 4KB y el puntero ocupa 4 bytes... ¿cuál es el archivo más grande que podemos tener?
    *   *Resolución*: 
        - Directos: $12 * 4KB = 48KB$.
        - Indirecto simple: $(4KB / 4B) * 4KB = 1024 * 4KB = 4MB$.
        - Indirecto doble: $1024^2 * 4KB = 4GB$.
        - Indirecto triple: $1024^3 * 4KB = 4TB$.
    *   *Resultado*: Unos 4TB (aprox). Esto cae siempre en el parcial.
2.  **Comandos Clave**: `ls -i` (ver inodo), `ln` (crear link), `df` (ver espacio libre).
3.  **Fragmentación**: Externa (huecos entre archivos) e Interna (espacio desperdiciado dentro del último bloque).
