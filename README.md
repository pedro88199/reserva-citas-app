# Sistema de Reserva de Citas Médicas

Aplicación de escritorio en **Java (Swing)** con base de datos **MySQL** para administrar doctores, pacientes y citas de una posta médica ("Posta Santa María").

Proyecto académico desarrollado durante la carrera de Ingeniería de Software (UTP). **Estado: versión funcional parcial / en desarrollo.**

## Qué incluye

- **Login y registro de usuarios** contra la tabla `login` de MySQL.
- **Menú principal** con acceso a la administración de datos.
- **Administración de doctores**: listar, agregar y gestionar doctores con su especialidad y horario.
- **Administración de pacientes**: listar, agregar y gestionar pacientes con la especialidad que desean.
- **Citas agendadas**: vista de las citas registradas.
- **Asignación de citas con un algoritmo genético** (`com.santamaria.genetico`): cruza pacientes con doctores según la especialidad deseada y la disponibilidad horaria, y evoluciona una población de posibles asignaciones buscando la que cumple más coincidencias.

## Tecnologías

- Java 21
- Swing (interfaz gráfica, formularios de NetBeans / IntelliJ)
- MySQL 8 + JDBC (`mysql-connector-java 8.0.33`)
- Maven

## Estructura

```
src/main/java/com/santamaria/
├── genetico/      # Algoritmo genético (Algoritmo, Poblacion, Individuo)
├── modelos/       # Clases del dominio (Doctor, Paciente, Cita, Horario)
├── utilidades/    # Conexión a BD, login/registro, utilidades de fecha y query.sql
├── vistas/        # Pantallas Swing (Login, Menu_Principal, AdminDoctor, ...)
└── config/        # Parámetros del algoritmo genético
```

## Cómo ejecutarlo

1. Instala **JDK 21**, **Maven** y **MySQL**.
2. Crea la base de datos y los datos de ejemplo ejecutando el script:
   `src/main/java/com/santamaria/utilidades/query.sql`
   (el script empieza con `DROP DATABASE posta_santa_maria_db;`, así que borra esa base si ya existe).
3. Abre `src/main/java/com/santamaria/utilidades/Database.java` y pon tu usuario y contraseña de MySQL local (por defecto `root` y el valor `TU_CONTRASEÑA`).
4. Abre el proyecto en IntelliJ IDEA o NetBeans (Maven descargará las dependencias) y ejecuta la clase
   `com.santamaria.vistas.Login`.
5. Usuario de prueba creado por el script: `admin` / `admin`.

## Pendiente / mejoras

- La pantalla **Reporte** aún no está implementada.
- Mover la configuración de la base de datos a variables de entorno o un archivo de propiedades, en lugar de dejarla en el código.
- Guardar las contraseñas cifradas (hoy se guardan en texto plano).
- Corregir `exec.mainClass` en el `pom.xml` para poder ejecutar con `mvn exec:java`.
- Agregar pruebas automáticas.
