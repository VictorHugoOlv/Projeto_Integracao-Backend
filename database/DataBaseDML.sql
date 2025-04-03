INSERT INTO line (name)
VALUES ('Ares'),
       ('Cronos');

INSERT INTO category (name, line_id)
VALUES ('CronosOld', (SELECT id FROM line WHERE name = 'Cronos')),
       ('Cronos L', (SELECT id FROM line WHERE name = 'Cronos')),
       ('Cronos-NG', (SELECT id FROM line WHERE name = 'Cronos')),
       ('Ares TB', (SELECT id FROM line WHERE name = 'Ares')),
       ('Ares THS', (SELECT id FROM line WHERE name = 'Ares'));

INSERT INTO product (name, category_id)
VALUES ('Cronos 6001-A', (SELECT id FROM category WHERE name = 'CronosOld')),
       ('Cronos 6003', (SELECT id FROM category WHERE name = 'CronosOld')),
       ('Cronos 7023', (SELECT id FROM category WHERE name = 'CronosOld')),
       ('Cronos 6021L', (SELECT id FROM category WHERE name = 'Cronos L')),
       ('Cronos 7023L', (SELECT id FROM category WHERE name = 'Cronos L')),
       ('Cronos 6001-NG', (SELECT id FROM category WHERE name = 'Cronos-NG')),
       ('Cronos 6003-NG', (SELECT id FROM category WHERE name = 'Cronos-NG')),
       ('Cronos 6021-NG', (SELECT id FROM category WHERE name = 'Cronos-NG')),
       ('Cronos 6031-NG', (SELECT id FROM category WHERE name = 'Cronos-NG')),
       ('Cronos 7021-NG', (SELECT id FROM category WHERE name = 'Cronos-NG')),
       ('Cronos 7023-NG', (SELECT id FROM category WHERE name = 'Cronos-NG')),
       ('ARES 7021', (SELECT id FROM category WHERE name = 'Ares TB')),
       ('ARES 7031', (SELECT id FROM category WHERE name = 'Ares TB')),
       ('ARES 7023', (SELECT id FROM category WHERE name = 'Ares TB')),
       ('ARES 8023 15', (SELECT id FROM category WHERE name = 'Ares THS')),
       ('ARES 8023 200', (SELECT id FROM category WHERE name = 'Ares THS')),
       ('ARES 8023 2,5', (SELECT id FROM category WHERE name = 'Ares THS'));