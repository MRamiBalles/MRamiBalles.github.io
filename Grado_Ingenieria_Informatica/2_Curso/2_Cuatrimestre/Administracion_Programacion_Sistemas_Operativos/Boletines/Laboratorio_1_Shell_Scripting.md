# APSO - Laboratorio 1: Automatización con Shell Scripting (Bash)

La administración eficiente de sistemas Unix/Linux se basa en la capacidad de automatizar tareas repetitivas mediante el uso de scripts de terminal.

## 1. Fundamentos de Bash Scripting
- **Shebang**: `#!/bin/bash` especifica el intérprete.
- **Variables**: No debe haber espacios en la asignación (`VAR=10`).
- **Paso de Parámetros**: `$1, $2, \dots$ | $#` (nº parámetros) | `$*` (todos).

## 2. Estructuras de Control
- **Condicionales**: `if [ condición ]; then ... fi`.
  - Operadores: `-eq` (equal), `-ne` (not equal), `-d` (is directory), `-f` (is file).
- **Bucles**: `for i in {1..10}; do ... done` o `while [ cond ]; do ... done`.

## 📝 Ejercicio Técnico: Script de Backup Inteligente
Desarrolle un script que reciba un directorio como parámetro, comprima su contenido en un archivo `.tar.gz` cuyo nombre incluya la fecha actual, y lo mueva a `/var/backups`.
```bash
#!/bin/bash
if [ -z "$1" ] || [ ! -d "$1" ]; then
    echo "Uso: $0 <directorio_origen>"
    exit 1
fi
FECHA=$(date +%Y%m%d)
BASE=$(basename "$1")
DESTINO="/var/backups/${BASE}_${FECHA}.tar.gz"
tar -czf "$DESTINO" "$1"
if [ $? -eq 0 ]; then
    echo "Backup completado con éxito en $DESTINO"
else
    echo "Error al realizar el backup"
fi
```

## 3. Gestión de Permisos
- **chmod**: `+x` permite la ejecución del script.
- **crontab**: Formato `min hora dia mes sem comando` para programar la ejecución periódica del script.
