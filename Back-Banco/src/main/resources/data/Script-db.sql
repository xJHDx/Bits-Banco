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
	telefono_cliente bigint(30) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS  `cuenta`(
	id_cuenta int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_cliente int,
	numero_cuenta bigint(100) NOT NULL,
	saldo_cuenta bigint(30) NOT NULL,
    CONSTRAINT `cliente_ibfk` FOREIGN KEY (id_cliente) REFERENCES `cliente`(id_cliente)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS  `movimiento`(
	id_movimiento int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	id_cuenta int,
	tipo_movimiento varchar(100)NOT NULL,
	fecha_movimiento DATE,
	valor_movimiento bigint(100),
	CONSTRAINT `cuenta_ibfk` FOREIGN KEY (id_cuenta) REFERENCES `cuenta`(id_cuenta)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--  Insert Info

INSERT INTO cliente (nombre_cliente,direccion_cliente,telefono_cliente)
	VALUES ('Johnson','Ibague',3102616444);

INSERT INTO dbBitsBancario.cuenta (id_cliente,numero_cuenta,saldo_cuenta)
	VALUES (1,101,500000);

INSERT INTO dbBitsBancario.cuenta (id_cliente,numero_cuenta,saldo_cuenta)
	VALUES (1,102,600000);

INSERT INTO dbBitsBancario.movimiento (id_cuenta,tipo_movimiento,fecha_movimiento,valor_movimiento)
	VALUES (1,'CREDITO','2022-07-23',0);
