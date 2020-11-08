
INSERT INTO role (name_role) VALUES ('ROLE_ADMIN');
INSERT INTO role (name_role) VALUES ('ROLE_ASISTENTE');
INSERT INTO role (name_role) VALUES ('ROLE_ESTUDIANTE');

INSERT INTO account (correo_account, dni_account, last_name_account, name_account, password_account, id_role) VALUES ('admin@gmail.com', 12345678, 'Del Sistema', 'Admin','$2a$10$Ml1yMr8NB9/v99OSnOx2Guz93rGEIhUDVT73etTZhsIMrIw0aJlo2' , 1);
INSERT INTO account (correo_account, dni_account, last_name_account, name_account, password_account, id_role) VALUES ('web@gmail.com', 98765432, 'Del Sistema', 'Estudiante','$2a$10$2wTzbbs2VCM6LRQ7e2gnb.HW/rBAmO391DGnEgd.f9O/pJTQD60g2' , 3);
           
INSERT INTO categories (name_category) VALUES ('Sillas de oficina');
INSERT INTO categories (name_category) VALUES ('Sillas gamer');
INSERT INTO categories (name_category) VALUES ('Celulares');
INSERT INTO categories (name_category) VALUES ('Audifonos');
INSERT INTO categories (name_category) VALUES ('TVs');
INSERT INTO categories (name_category) VALUES ('Laptops');
INSERT INTO categories (name_category) VALUES ('Monitores');
INSERT INTO categories (name_category) VALUES ('Mouses');

INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Silla DXT Carbon', 800.00, 500000, 1);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Silla AKRacing Nitro Negra', 900.00, 450000, 2);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Samsung Galaxy S7', 200.00, 50, 3);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Skull Candy V9', 250.00, 10000, 4);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Sony N10', 750.00, 50000, 5);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('ASUS TUF GAMING', 3500.00, 4000, 6);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('MSI LED', 1250.00, 500, 7);


INSERT INTO interest (name_interest) VALUES ('Simple');
INSERT INTO interest (name_interest) VALUES ('Compuesto');
INSERT INTO interest (name_interest) VALUES ('Efectivo');

INSERT INTO rate (name_rate, days_rate) VALUES ('Quincenal', 15);
INSERT INTO rate (name_rate, days_rate) VALUES ('Mensual', 30);
INSERT INTO rate (name_rate, days_rate) VALUES ('Bimestral', 60);
INSERT INTO rate (name_rate, days_rate) VALUES ('Trimestral', 90);
INSERT INTO rate (name_rate, days_rate) VALUES ('Cuatrimestral', 120);
INSERT INTO rate (name_rate, days_rate) VALUES ('Semestral', 180);
INSERT INTO rate (name_rate, days_rate) VALUES ('Anual', 360);

INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Diaria', 1);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Semanal', 7);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Quincenal', 15);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Mensual', 30);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Bimestral', 60);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Trimestral', 90);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Cuatrimestral', 120);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Semestral', 180);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Anual', 360);

INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (5000,5000,  0, 'Carmen Loayza', 964884845, 25, 1, 1, 1);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (8000,8000,  0, 'Jose Alonso', 977884845, 7, 1, 1, 1);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (10000,10000,0, 'Joseph Rueda', 964854245, 5, 1, 1, 1);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (4500,4500,  0, 'Yeizon Esteijam', 969984845, 8, 1, 1, 1);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (4200,4200,  0, 'Marcos Ronceros', 964784845, 10, 1, 1, 1);


