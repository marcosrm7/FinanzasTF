
INSERT INTO role (name_role)	VALUES ('ROLE_ADMIN');
INSERT INTO role (name_role)	VALUES ('ROLE_ASISTENTE');
INSERT INTO role (name_role)	VALUES ('ROLE_ESTUDIANTE');

INSERT INTO account ( correo_account, dni_account, last_name_account, name_account, password_account, id_role)
           VALUES ('admin@gmail.com', 12345678, 'Del Sistema', 'Admin','$2a$10$Ml1yMr8NB9/v99OSnOx2Guz93rGEIhUDVT73etTZhsIMrIw0aJlo2' , 1);
INSERT INTO account ( correo_account, dni_account, last_name_account, name_account, password_account, id_role)
           VALUES ('web@gmail.com', 98765432, 'Del Sistema', 'Estudiante','$2a$10$2wTzbbs2VCM6LRQ7e2gnb.HW/rBAmO391DGnEgd.f9O/pJTQD60g2' , 3);
           



