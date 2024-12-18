DROP DATABASE IF EXISTS taskflow;
CREATE DATABASE IF NOT EXISTS taskflow;

USE taskflow;

DROP TABLE IF EXISTS USUARIO;
CREATE TABLE IF NOT EXISTS USUARIO(
    NOMBRE_USUARIO VARCHAR(30) NOT NULL PRIMARY KEY,
    NOMBRE_PREFERIDO VARCHAR(30) NOT NULL,
    CONTRASENIA VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS TAREA;
CREATE TABLE IF NOT EXISTS TAREA(
    ID_TAREA INT AUTO_INCREMENT PRIMARY KEY,
    NOMBRE_TAREA VARCHAR(30) NOT NULL,
    DESCRIPCION VARCHAR(200) NOT NULL,
    FECHA_HORA_CREACION DATETIME NOT NULL,
    FECHA_CULMINACION DATE NOT NULL,
    ESTA_COMPLETADA BOOLEAN NOT NULL,
    NOM_USR VARCHAR(30) NOT NULL,
    FOREIGN KEY(NOM_USR) REFERENCES USUARIO(NOMBRE_USUARIO)
);
