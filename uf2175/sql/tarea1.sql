CREATE SCHEMA tarea1;
USE tarea1;
CREATE TABLE videojuegos (
	id INT NOT NULL,
    nombre VARCHAR(45) NOT NULL,
    compania_id INT NOT NULL,
    consola VARCHAR(20) NOT NULL,
    genero VARCHAR(20) NULL
);

CREATE TABLE companias (
	id INT NOT NULL,
    nombre VARCHAR(45) NOT NULL
);
