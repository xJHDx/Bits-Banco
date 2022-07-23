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
	telefono_cliente bigint(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS  `cuenta`(
	id_cuenta int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_cliente int NOT NULL,
	numero_cuenta bigint(100) NOT NULL,
	saldo_cuenta bigint(100) NOT NULL,
	INDEX (id_cliente),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS  `movimiento`(
	id_movimiento int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_cuenta int NOT NULL,
	tipo_movimiento varchar(100)NOT NULL,
	fecha_movimiento DATE,
	valor_movimiento bigint(100),
	INDEX (id_cuenta),
    FOREIGN KEY (id_cuenta) REFERENCES cuenta(id_cuenta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
