/*Populate tables*/
INSERT INTO users (id, role, nick, name, surname, email, password, create_at) VALUES (1, 'admin', 'fmateo', 'Francisco', 'Mateo Ariza', 'contacto@fmateo.es', '1234', '2017-08-28');
INSERT INTO users (id, role, nick, name, surname, email, password, create_at) VALUES (2, 'guest', 'egutierrez', 'Elena', 'Gutierrez Cajal', 'egutierrez@fmateo.es', '1234', '2017-08-28');
INSERT INTO users (id, role, nick, name, surname, email, password, create_at) VALUES (3, 'guest', 'cperez', 'Cristina', 'perez', 'cperez@fmateo.es', '1234', '2017-08-28');

INSERT INTO suppliers (id, name, country) VALUES (1, 'supplier DE', 'Germany');
INSERT INTO suppliers (id, name, country) VALUES (2, 'supplier SP', 'Spain');
INSERT INTO suppliers (id, name, country) VALUES (3, 'supplier FR', 'France');
INSERT INTO suppliers (id, name, country) VALUES (4, 'supplier IT', 'Italy');

INSERT INTO products (id, item_code, description, price, state, comments , creator_id, create_at) VALUES (1, 001, 'Adorno mesa LED, cabaña en el bosque rojo, blanco', 17.99, 'active', '', 1, '2017-08-28');
INSERT INTO products (id, item_code, description, price, state, comments , creator_id, create_at) VALUES (2, 002, 'Armario con 3 puertas, blanco', 90, 'active', '', 1, '2017-08-28');

INSERT INTO products_suppliers (product_id, supplier_id) VALUES (1, 1);
INSERT INTO products_suppliers (product_id, supplier_id) VALUES (1, 3);
INSERT INTO products_suppliers (product_id, supplier_id) VALUES (1, 4);
INSERT INTO products_suppliers (product_id, supplier_id) VALUES (2, 2);
INSERT INTO products_suppliers (product_id, supplier_id) VALUES (2, 3);