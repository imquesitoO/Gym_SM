# Sistema de Gestión de Gimnasio

Este proyecto es un **Sistema de Gestión de Gimnasio** desarrollado en Java, diseñado para facilitar la administración de miembros del gimnasio, entrenadores y la programación de clases. Incluye acceso basado en roles para Administradores, Entrenadores y Estudiantes con membresías Free y Premium, cada uno con capacidades y menús únicos.

## Funcionalidades

### Administrador
- **Registrar, Buscar, Actualizar y Eliminar Estudiantes**: Gestiona una lista de estudiantes, categorizados en membresías Free y Premium.
- **Visualizar Entrenadores**: Permite ver los detalles de los entrenadores en el sistema.

### Entrenador
- **Visualizar Estudiantes Premium**: Los entrenadores pueden ver la lista de estudiantes con membresía Premium.

### Estudiantes
- **Membresía Free**:
  - **Iniciar Sesión** con un nombre de usuario y contraseña únicos.
  - **Reservar y Ver Turnos**: Acceder a los horarios disponibles para la membresía Free.

- **Membresía Premium**:
  - **Iniciar Sesión** con nombre de usuario y contraseña.
  - **Reservar y Ver Turnos**: Acceder a los horarios exclusivos de la membresía Premium.
  - **Ver Entrenadores Disponibles**: Opciones para ver y elegir entrenadores.

## Estructura del Proyecto

- **Main**: Controlador principal de la aplicación, donde se gestiona el flujo del sistema.
- **Administrador**: Clase que maneja las operaciones exclusivas para el administrador.
- **Entrenador**: Clase que representa a los entrenadores y sus operaciones.
- **Estudiante (Free y Premium)**: Clases que representan a los estudiantes con distintas membresías, con diferentes accesos y opciones.
- **Turnos (Free y Premium)**: Clases que manejan los horarios y reservas de clases.

## Requisitos
- **Java 8 o superior**
- **IDE**: Cualquier entorno de desarrollo compatible con Java (Eclipse, IntelliJ, NetBeans, etc.)

## Ejecución del Proyecto

1. Clonar este repositorio:
   ```bash
   git clone https://github.com/usuario/repo.git
