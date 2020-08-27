CREATE DATABASE IF NOT EXISTS EmpleadoSolicitud;
USE EmpleadoSolicitud;
CREATE TABLE IF NOT EXISTS Empleado
(id int PRIMARY KEY AUTO_INCREMENT,
fecha_ingreso date,
nombre varchar(50),
salario int);

CREATE TABLE IF NOT EXISTS Solicitud
(id int PRIMARY KEY AUTO_INCREMENT,
codigo varchar(50),
descripcion varchar(50),
resumen varchar(50),
id_empleado int,
CONSTRAINT fk_empleado FOREIGN KEY (id_empleado) REFERENCES Empleado(id));

/*AGREGAR EMPLEADOS A LA TABLA "EMPLEADO"*/
INSERT INTO Empleado (fecha_ingreso,nombre,salario) VALUES ('2020-05-04','Jorge','1000000'),('2019-12-07','Cristian','5000000'),('2019-12-07','Jair','2500000');

/*AGREGAR SOLICITUDES A LA TABLA "SOLICITUD"*/
INSERT INTO Solicitud (codigo,descripcion,resumen,id_empleado) VALUES ('ABC','Peticion','Cambio de Horario',2),('DEF','Queja','Mala atencion',1),('GHI','Reclamo','Reclamo',3);

/*MOSTRAR DATOS DE LA TABLA "EMPLEADO"*/
select * from Empleado;

/*MOSTRAR DATOS DE LA TABLA "SOLICITUD"*/
select * from Solicitud;

/*BORRAR TABLAS*/
DROP TABLE IF EXISTS Empleado;
DROP TABLE IF EXISTS Solicitud;

/*MOSTRAR NOMBRE DEL EMPLEADO Y NO EL ID_EMPLEADO EN LA TABLA "SOLICITUD".*/
SELECT e.nombre AS nombre_empleado, s.codigo, s.descripcion, s.resumen FROM Empleado e join solicitud s ON s.id_empleado = e.id;