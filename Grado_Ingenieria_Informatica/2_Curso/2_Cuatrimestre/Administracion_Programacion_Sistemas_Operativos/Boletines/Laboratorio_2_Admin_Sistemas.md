# APSO - Laboratorio 2: Administración de Usuarios y Servicios en Linux

Este laboratorio cubre las tareas críticas de un administrador de sistemas para garantizar un entorno multiusuario seguro y funcional.

## 1. Gestión de Usuarios y Grupos
- **`useradd` / `usermod`**: Creación y modificación de cuentas.
- **`/etc/passwd`**: Almacena información de cuentas (ID, Home, Shell).
- **`/etc/shadow`**: Almacena hashes de contraseñas de forma segura.
- **`visudo`**: Herramienta para editar `/etc/sudoers`, permitiendo delegación de privilegios de forma controlada.

## 2. Gestión de Servicios (systemd)
- **`systemctl start/stop/restart`**: Control manual de demonios.
- **`systemctl enable/disable`**: Persistencia tras el reinicio.
- **`systemctl status`**: Diagnóstico de fallos en servicios.

## 📝 Caso Práctico: Despliegue de Servidor Web Seguro
Configure un servidor Apache que solo sea accesible vía SSH mediante un túnel o firewall.
1. Instrucción de instalación: `sudo apt install apache2`.
2. Firewall (ufw): `sudo ufw allow 'Apache'`.
3. Verificación de estado: `sudo systemctl is-active apache2`.

## 3. Monitorización del Sistema
- **`top` / `htop`**: Uso de CPU y memoria por proceso.
- **`df -h`**: Espacio disponible en sistemas de archivos.
- **`journalctl`**: Revisión de los logs del sistema para auditoría y resolución de problemas.

---
*Administración de Sistemas - ETSI Universidad de Huelva.*
