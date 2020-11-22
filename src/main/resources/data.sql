
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
INSERT INTO categories (name_category) VALUES ('Servicios');

INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('MSI LED', 1250.00, 500, 7);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Silla AKRacing Nitro Negra', 900.00, 450000, 2);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Samsung Galaxy S7', 1400.00, 50, 3);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Skull Candy V9', 250.00, 10000, 4);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Sony N10', 750.00, 50000, 5);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('ASUS TUF GAMING', 3500.00, 4000, 6);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('IPhone 7', 1550.00, 100, 3);
INSERT INTO products (name_product, price_product, quantity_product, id_category) VALUES ('Delivery', 5, 100000, 9);

INSERT INTO interest (name_interest) VALUES ('Simple');
INSERT INTO interest (name_interest) VALUES ('Nominal');
INSERT INTO interest (name_interest) VALUES ('Efectivo');


INSERT INTO rate (name_rate, days_rate) VALUES ('Mensual', 30);
INSERT INTO rate (name_rate, days_rate) VALUES ('Bimestral', 60);
INSERT INTO rate (name_rate, days_rate) VALUES ('Trimestral', 90);
INSERT INTO rate (name_rate, days_rate) VALUES ('Cuatrimestral', 120);
INSERT INTO rate (name_rate, days_rate) VALUES ('Semestral', 180);
INSERT INTO rate (name_rate, days_rate) VALUES ('Anual', 360);

INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Diaria', 1);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Quincenal', 15);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Mensual', 30);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Bimestral', 60);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Trimestral', 90);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Cuatrimestral', 120);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Semestral', 180);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('Anual', 360);
INSERT INTO capitalization (name_capitalization, days_capitalization) VALUES ('N. A.', 0);

INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (5000,1245, 3755, 'Carmen Loayza', 964884845, 12, 9, 1, 6);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (8000,2690, 5310, 'Jose Alonso', 977884845, 7, 6, 2, 2);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (10000,1990,8010, 'Joseph Rueda', 964854245, 5,9, 3, 3);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (4500,4500,  0, 'Yeizon Esteijam', 969984845, 8, 3, 2, 4);
INSERT INTO clients (credit_client, credito_disponible,debt_cliente, name_client, number_client, rate_client, id_capitalization, id_interest, id_rate) VALUES (4200,4200,  0, 'Marcos Ronceros', 964784845, 10, 9, 3, 5);

INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (1,'2020-10-10','2020-10-10 21:34:18',11.4,1);
INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (0,'2020-10-10 18:41:38.98','2020-10-10 18:41:38',0,2);
INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (0,'2020-10-10 18:42:17.98','2020-10-10 18:42:17',0,3);

INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (0,'2020-10-17','2020-10-17 18:13:25',0,1);
INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (0,'2020-10-25','2020-10-25 14:28:33',0,1);
INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (0,'2020-11-12 15:30:33','2020-11-12 15:30:33',0,3);
INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (0,'2020-10-30 12:20:43','2020-11-30 12:20:43',0,2);
INSERT INTO sell (estado_compra,fecha_compra,fechayhora, interes,id_client) VALUES (0,'2020-10-10 12:20:43','2020-10-10 12:20:43',0,5);

INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'Silla AKRacing Nitro Negra',900,2,1);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'ASUS TUF GAMING',3500,6,2);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (2,'Delivery',5,9,2);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'Skull Candy V9',250,4,3);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'Sony N10',750,5,3);

INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (2,'Skull Candy V9',250,4,4);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'Sony N10',750,5,4);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (2,'MSI LED',1250,7,5);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'Delivery',5,9,5);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (2,'ASUS TUF GAMING',3500,6,6);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (2,'Delivery',5,9,6);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'IPhone 7',1550,3,7);
INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'Skull Candy V9',250,4,7);

INSERT INTO product_selled (cantidad, name_product, price_product, id_category,sell_id) VALUES (1,'Skull Candy V9',250,4,8);


INSERT INTO payments (amount_payment, description_payment, fecha_pago, id) VALUES (911.40,'Pago completo','2020-11-17 21:08:29.377',1);




