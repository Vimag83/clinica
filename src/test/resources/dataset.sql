insert into cuenta(correo, password) values('pepito@email.com', '123');
insert into cuenta(correo, password) values('juanita@email.com', '234');
insert into cuenta(correo, password) values('paquito@email.com', '345');
insert into cuenta(correo, password) values('hugito@email.com', '456');
insert into cuenta(correo, password) values('luisito@email.com', '567');
insert into cuenta(correo, password) values('medico11@email.com', '111');
insert into cuenta(correo, password) values('medico12@email.com', '121');
insert into cuenta(correo, password) values('medico13@email.com', '131');
insert into cuenta(correo, password) values('medico14@email.com', '141');
insert into cuenta(correo, password) values('medico15@email.com', '151');



INSERT INTO usuario (documento_identificacion, nombre, url_foto, telefono, estado_usuario, codigo, ciudad_codigo)
                    VALUES ('12345678', 'Pepito Perez', 'url_foto', '121212', 1, 1, 1);
/*INSERT INTO usuario (documento_identificacion, nombre, url_foto, telefono, estado_usuario, ciudad_codigo, codigo)
                    VALUES ('23456789', 'Juanita Lopez', '232323', 'url_foto', 0, 3, 2);
INSERT INTO usuario (documento_identificacion, nombre, url_foto, telefono, estado_usuario, ciudad_codigo, codigo)
                    VALUES ('34567890', 'Paquito Gallego', '3433434', 'url_foto', 1, 3, 2);
INSERT INTO usuario (documento_identificacion, nombre, url_foto, telefono, estado_usuario, ciudad_codigo, codigo)
                    VALUES ('45678901', 'Huguito Zuluaga', '454545', 'url_foto', 1, 4, 2);
INSERT INTO usuario (documento_identificacion, nombre, url_foto, telefono, estado_usuario, ciudad_codigo, codigo)
                    VALUES ('56789012', 'Luisito Comunica', '565656', 'url_foto', 0, 5, 1);
*/


insert into paciente(fecha_Nacimiento, alergias, eps, tipo_sangre, codigo)
                    values('1991-01-01', 'Sin alergias', 1, 2, 1);
insert into paciente(fecha_Nacimiento, alergias, eps, tipo_sangre, codigo)
                    values('1992-12-28', 'Sin alergias', 2,2,2);
/*insert into paciente(fecha_Nacimiento, alergias, eps, tipo_sangre, codigo) values('34567890', 0, 'Paquito Gallego', '3433434', 'url_foto', 'Renitis cronica ', 1, '1993-03-01', 1, 3);
insert into paciente values('45678901', 0, 'Huguito Zuluaga', '454545', 'url_foto', 'Alergico a la Ampicilina', 0, '1994-04-28', 1, 4);
insert into paciente values('56789012', 0, 'Luisito Comunica', '565656', 'url_foto', 'Sin alergias', 1, '1995-05-01', 1, 5);
*/

insert into cita(estado_cita, fecha_cita, fecha_creacion, motivo_consulta, medico_codigo, paciente_codigo)
                values(1, '2023-10-05 09:00:00', '2023-10-01 09:00:00', 'SIDA', 1, 1);
insert into cita(estado_cita, fecha_cita, fecha_creacion, motivo_consulta, medico_codigo, paciente_codigo)
                values(0, '2023-10-05 09:00:00', '2023-10-01 09:00:00', 'gripa', 2, 1);
/*insert into cita values (3, '2023-10-07 11:15:00.000000', '2023-10-03', 103, 1003, 0, '2023-10-03 10:00:00.000000', 'Examen de sangre', 2003);
insert into cita values (4, '2023-10-08 16:00:00.000000', '2023-10-04', 104, 1004, 1, '2023-10-04 15:20:00.000000', 'Dolor de espalda', 2004);
insert into cita values (5, '2023-10-09 10:45:00.000000', '2023-10-05', 105, 1005, 1, '2023-10-05 10:00:00.000000', 'Consulta general', 2005);
*/

INSERT INTO medico (descanso,	especialidad,	codigo) VALUES (12, 2, 4);
INSERT INTO medico (descanso,	especialidad,	codigo) VALUES (13, 1, 5);
INSERT INTO medico (descanso,	especialidad,	codigo) VALUES (10, 2, 6);
/*INSERT INTO medico VALUES (13, '11234569', 3, 3, 'Disponibilidad del médico', 2);
INSERT INTO medico VALUES (14, '11234570', 4, 3, 'Disponibilidad del médico', 3);
INSERT INTO medico VALUES (15, '11234571', 5, 6, 'Disponibilidad del médico', 1);*/

INSERT INTO mensaje (codigo,	contenido,	fecha,	mensaje,	cuenta_codigo,	pqrs_codigo_pqrs
) VALUES (1, 'Hola Como estas', '2023-10-05', 'Mensaje de ejemplo 1', 1, 1 );
INSERT INTO mensaje (codigo, contenido, fecha, mensaje, cuenta_codigo, pqrs_codigo_pqrs)
VALUES (2, 'Saludos desde SQL', '2023-10-06', 'Mensaje de ejemplo 2', 2, 2);
INSERT INTO mensaje (codigo, contenido, fecha, mensaje, cuenta_codigo, pqrs_codigo_pqrs)
VALUES (3, 'SQL es genial', '2023-10-07', 'Mensaje de ejemplo 3', 3, 3);
INSERT INTO mensaje (codigo, contenido, fecha, mensaje, cuenta_codigo, pqrs_codigo_pqrs)
VALUES (4, 'Probando mensajes', '2023-10-08', 'Mensaje de ejemplo 4', 4, 4);
INSERT INTO mensaje (codigo, contenido, fecha, mensaje, cuenta_codigo, pqrs_codigo_pqrs)
VALUES (5, 'Último mensaje', '2023-10-09', 'Mensaje de ejemplo 5', 5, 5);

INSERT INTO ciudad (codigo, nombre) VALUES (1, 'Armenia');
INSERT INTO ciudad (codigo, nombre) VALUES (2, 'Manizales');
INSERT INTO ciudad (codigo, nombre) VALUES (3, 'Bogota');
INSERT INTO ciudad (codigo, nombre) VALUES (4, 'Medellin');
INSERT INTO ciudad (codigo, nombre) VALUES (5, 'Pereira');











INSERT INTO formula_medica (codigo_formula,	formula,	orden_medica_codigo_orden) VALUES (1, 'Descripción de la fórmula', 1);
INSERT INTO formula_medica (codigo_formula,	formula,	orden_medica_codigo_orden) VALUES (2, 'Descripción de la fórmula 2', 2);
INSERT INTO formula_medica (codigo_formula,	formula,	orden_medica_codigo_orden) VALUES (3, 'Descripción de la fórmula 3', 3);
INSERT INTO formula_medica (codigo_formula,	formula,	orden_medica_codigo_orden) VALUES (4, 'Descripción de la fórmula 4', 4);
INSERT INTO formula_medica (codigo_formula,	formula,	orden_medica_codigo_orden) VALUES (5, 'Descripción de la fórmula 5', 5);

INSERT INTO horario (codigo, dia, fin, inicio, medico_codigo)
VALUES (1 '2023-10-19', '2023-10-19 08:00:00', '2023-10-19 07:00:00', 1);
INSERT INTO horario  (codigo, dia, fin, inicio, medico_codigo)
VALUES (2 '2023-10-20', '2023-10-20 08:30:00', '2023-10-20 07:30:00', 2);
INSERT INTO horario  (codigo, dia, fin, inicio, medico_codigo)
VALUES (3 '2023-10-21', '2023-10-21 09:00:00', '2023-10-21 08:00:00', 3);

INSERT INTO horario  (codigo, dia, fin, inicio, medico_codigo)
VALUES (4 '2023-10-22', '2023-10-22 09:30:00', '2023-10-22 08:30:00', 4);

INSERT INTO horario (codigo, dia, fin, inicio, medico_codigo)
VALUES (5 '2023-10-23', '2023-10-23 10:00:00', '2023-10-23 09:00:00', 5);


INSERT INTO orden_medica (codigo_orden, descripcion, atencion_codigo) VALUES (1, 'Descripción de la orden', 1, );
INSERT INTO orden_medica VALUES (2, 'Descripción de la orden', 2, );
INSERT INTO orden_medica VALUES (3, 'Descripción de la orden', 3, );
INSERT INTO orden_medica VALUES (4, 'Descripción de la orden', 4, );
INSERT INTO orden_medica VALUES (5, 'Descripción de la orden', 5, );



INSERT INTO Pqrs (codigo_pqrs, estado, fecha_creacion, motivo, tipo, cita_codigo_cita) VALUES (1, 1, '2023-10-05', 'Retardo', 'Queja', 1);
INSERT INTO Pqrs VALUES (2, 1, '2023-10-06', 'Retardo', 'Queja', 2);
INSERT INTO Pqrs VALUES (3, 0, '2023-10-07', 'Retardo y demora', 'Reclamo', 3);
INSERT INTO Pqrs VALUES (4, 3, '2023-10-08', 'mala atencion', 'Queja', 4);
INSERT INTO Pqrs VALUES (5, 2, '2023-10-09', 'porque no incrementan horario', 'Pregunta', 5);
