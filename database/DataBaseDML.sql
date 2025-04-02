-- DDL: Criando a tabela
CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    linha VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    produto VARCHAR(50) NOT NULL
);