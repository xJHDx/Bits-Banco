-- JHD
SET NAMES utf8mb4;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

-- Validar y Crear Base  De Datos.
DROP DATABASE IF EXISTS `dbBitsBancario`;
CREATE DATABASE `dbBitsBancario`;


-- Seleccionar db para creacion he insercion de datos.
USE dbBitsBancario;

CREATE TABLE IF NOT EXISTS  `cliente`(
	id_cliente int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nombre_cliente varchar(100) NOT NULL,
	direccion_cliente varchar(100) NOT NULL,
	telefono_cliente bigint(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS  `cuenta`(
	id_cuenta int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	cliente_ibfk int NOT NULL,
	numero_cuenta bigint(100) NOT NULL,
	saldo_cuenta bigint(30) NOT NULL,
	INDEX (cliente_ibfk),
    CONSTRAINT `cliente_ibfk` FOREIGN KEY (cliente_ibfk) REFERENCES `cliente`(id_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS  `movimiento`(
	id_movimiento int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	cuenta_ibfk int NOT NULL,
	tipo_movimiento varchar(100)NOT NULL,
	fecha_movimiento DATE,
	valor_movimiento bigint(100),
	INDEX (cuenta_ibfk),
    CONSTRAINT `cuenta_ibfk` FOREIGN KEY (cuenta_ibfk) REFERENCES `cuenta`(id_cuenta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--  Info
INSERT INTO  `cliente`(id_cliente,nombre_cliente,direccion_cliente,telefono_cliente)
	VALUES (1,'johnson','Ibague',310261644);


INSERT INTO `cuenta`(cliente_ibfk,numero_cuenta,saldo_cuenta)
	VALUES (1,101,500000);


INSERT INTO  `movimiento` (cuenta_ibfk,tipo_movimiento,fecha_movimiento,valor_movimiento)
	VALUES (1,'debito','2022-07-22',500000);
