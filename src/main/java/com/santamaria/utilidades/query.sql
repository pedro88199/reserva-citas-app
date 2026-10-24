drop database posta_santa_maria_db;
create database posta_santa_maria_db;
use posta_santa_maria_db;

SELECT * FROM paciente;
SELECT * FROM doctor;
SELECT * FROM cita;
SELECT * FROM horario;

create table login
(
    id_usuario int auto_increment primary key,
    nombre     varchar(50) not null,
    contrasena varchar(50) not null
);

create table paciente
(
    id_paciente  int auto_increment primary key,
    nombre       varchar(50)  not null,
    apellido     varchar(50)  not null,
    edad         int          not null,
    direccion    varchar(255) not null,
    telefono     varchar(50)  not null,
    correo       varchar(50)  not null,
    especialidadDeseada VARCHAR(255) NOT NULL
);

create table horario
(
    id_horario int auto_increment primary key,
    dia        VARCHAR(255) NOT NULL,
    estado     VARCHAR(255) NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin    TIME NOT NULL
);

create table doctor
(
    id_doctor    int auto_increment primary key,
    nombre       varchar(50)  not null,
    apellido     varchar(50)  not null,
    edad         int          not null,
    direccion    varchar(255) not null,
    telefono     varchar(50)  not null,
    correo       varchar(50)  not null,
    especialidad VARCHAR(255) NOT NULL,
    id_horario   INT,
    FOREIGN KEY (id_horario) REFERENCES horario (id_horario)
);

create table cita
(
    id_cita     int auto_increment primary key,
    paciente_id INT,
    doctor_id   INT,
    fecha       DATE         NOT NULL,
    hora varchar(255) NOT NULL,
    estado      VARCHAR(255) NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES paciente (id_paciente),
    FOREIGN KEY (doctor_id) REFERENCES doctor (id_doctor)
);

INSERT INTO login (nombre, contrasena) VALUES ('admin', 'admin');

INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Juan', 'Perez', 25, 'Calle 1', '123456', 'juan@example.com', 'Medicina General');
INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Maria', 'Lopez', 20, 'Calle 2', '994435', 'maria@example.com', 'Pediatria');
INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Andres', 'Gomez', 30, 'Calle 3', '451123', 'andres@example.com', 'Oftalmologia');
INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Carlos', 'Garcia', 35, 'Calle 4', '537512', 'carlos@example.com', 'Cardiologia');
INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Marcos', 'De la Cruz', 25, 'Calle 2', '513275', 'marcos@example.com', 'Neurologia');
INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Maria', 'Lopez', 20, 'Calle 2', '994435', 'maria@example.com', 'Pediatria');
INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Lucia', 'Alcantara', 22, 'Calle 5', '994412', 'lucia@example.com', 'Ginecologia');
INSERT INTO paciente (nombre, apellido, edad, direccion, telefono, correo, especialidadDeseada) VALUES ('Paolo', 'Martinez', 30, 'Calle 1', '994235', 'paolo@example.com', 'Urologia');

INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Lunes', 'Disponible', '08:00:00', '12:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Martes', 'Disponible', '08:00:00', '12:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Miercoles', 'Disponible', '08:00:00', '12:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Jueves', 'Disponible', '08:00:00', '12:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Viernes', 'Disponible', '08:00:00', '12:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Sabado', 'Disponible', '08:00:00', '12:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Domingo', 'Disponible', '08:00:00', '12:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Lunes', 'Disponible', '14:00:00', '18:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Martes', 'Disponible', '14:00:00', '18:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Miercoles', 'Disponible', '14:00:00', '18:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Jueves', 'Disponible', '14:00:00', '18:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Viernes', 'Disponible', '14:00:00', '18:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Sabado', 'Disponible', '14:00:00', '18:00:00');
INSERT INTO horario (dia, estado, hora_inicio, hora_fin) VALUES ('Domingo', 'Disponible', '14:00:00', '18:00:00');

INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Pedro', 'Sanchez', 35, 'Calle 1', '123456', 'pedro@example.com', 'Cardiologia', 1);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Kiara', 'Cautivo', 35, 'Calle 4', '537512', 'kiara@example.com', 'Medicina General', 2);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Milagros', 'Leyva', 35, 'Calle 1', '123456', 'milagros@example.com', 'Neurologia', 3);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Andres', 'Fuentes', 30, 'Calle 3', '451123', 'andres@example.com', 'Oftalmologia', 4);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Monica', 'Espinoza', 20, 'Calle 2', '994435', 'monica@example.com', 'Pediatria', 5);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Miguel', 'Mamani', 35, 'Calle 4', '537512', 'migue@example.com', 'Oftalmologia', 8);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Ashley', 'Vargas', 28, 'Calle 4', '537512', 'ashley@example.com', 'Pediatria', 9);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Jose', 'LLosa', 35, 'Calle 4', '537512', 'jose@example.com', 'Neurologia', 10);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Luis', 'Garcia', 35, 'Calle 1', '123456', 'luis@example.com', 'Medicina General', 11);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Juana', 'Vergara', 30, 'Calle 2', '994432', 'juana@example.com', 'Cardiologia', 12);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Marleny', 'Sanchez', 35, 'Calle 2', '1231234', 'marleny@example.com', 'Ginecologia', 13);
INSERT INTO doctor (nombre, apellido, edad, direccion, telefono, correo, especialidad, id_horario) VALUES ('Jacobo', 'Cordova', 42, 'Calle 5', '1231223', 'jacobo@example.com', 'Urologia', 14);

INSERT INTO cita (paciente_id, doctor_id, fecha, hora, estado) VALUES (1, 2, '2021-06-01', '11:00', 'REALIZADA');
INSERT INTO cita (paciente_id, doctor_id, fecha, hora,  estado) VALUES (4, 1, '2024-08-04', '14:00', 'PENDIENTE');
INSERT INTO cita (paciente_id, doctor_id, fecha, hora, estado) VALUES (5, 3, '2024-08-01', '8:00', 'PENDIENTE');
INSERT INTO cita (paciente_id, doctor_id, fecha, hora, estado) VALUES (6, 5, '2021-06-06', '10:00', 'CANCELADA');