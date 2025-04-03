CREATE TABLE line
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE category
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(50) UNIQUE NOT NULL,
    line_id INT                NOT NULL,
    FOREIGN KEY (line_id) REFERENCES line (id)
);

CREATE TABLE product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(50) UNIQUE NOT NULL,
    category_id INT                NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category (id)
);