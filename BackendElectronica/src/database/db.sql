CREATE DATABASE dbelectronica;


USE dbelectronica;

CREATE TABLE Usuario (
    id      INT             AUTO_INCREMENT PRIMARY KEY,
    correo  VARCHAR(100)    NOT NULL,
    pass    VARCHAR(100)    NOT NULL
);


CREATE TABLE Productos (
    id          INT             AUTO_INCREMENT PRIMARY KEY,
    Nombre      VARCHAR(100)    NOT NULL,
    Precio      DECIMAL(10, 2)  NOT NULL,
    Cantidad    INT             NOT NULL,
    Descripcion TEXT
);


CREATE TABLE Cliente (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    Nombre      VARCHAR(100)    NOT NULL,
    Apellido    VARCHAR(100)    NOT NULL,
    DNI         VARCHAR(20)     NOT NULL,
    Celular     VARCHAR(20)     NOT NULL,
    Correo      VARCHAR(100)    NOT NULL
);

CREATE TABLE Tarjeta (
    id                      INT AUTO_INCREMENT  PRIMARY KEY,
    agregarNuevaTarjeta     BOOLEAN             NOT NULL,
    numeroTarjeta           VARCHAR(20)         NOT NULL,
    fecha                   INT                 NOT NULL,
    anio                    INT                 NOT NULL,
    CCV                     VARCHAR(5)          NOT NULL
);