
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