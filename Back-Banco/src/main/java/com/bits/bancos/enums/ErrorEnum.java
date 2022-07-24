package com.bits.bancos.enums;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {
    TECHNICAL("001","Ocurri� un error inesperado",HttpStatus.INTERNAL_SERVER_ERROR),
	CLIENTE_EXISTE("002", "Nombre o Telefono ya se encuentra registrados",HttpStatus.NOT_ACCEPTABLE),
	EXISTO_ELIMINAR("003", "El Registro a sido Eliminado Exitosamente",HttpStatus.OK),
	ERROR_NO_EXISTE("004", "El registro no se encuentra en la base de datos",HttpStatus.NOT_ACCEPTABLE),
	CUENTA_EXISTE("002", "La cuenta ya tiene un cliente asociado",HttpStatus.NOT_ACCEPTABLE),
	ERROR_NO_EXISTE_CLIENTE("005", "el Cliente no se encuentra en la base de datos",HttpStatus.NOT_ACCEPTABLE),
	ERROR_TIPO_MOVIMIENTO("006", "El Tipo de Movimiento debe ser DEBITO o CREDITO",HttpStatus.NOT_ACCEPTABLE),
	ERROR_MAXIMO_SALDO("007", "El valor de movimiento supera el salgo actual",HttpStatus.NOT_ACCEPTABLE)
	;
	
	private String code;
	private String description;
	private HttpStatus httpCode;
	
	private ErrorEnum(String code, String description,HttpStatus httpCode) {
		this.code=code;
		this.description = description;
		this.httpCode = httpCode;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public HttpStatus getHttpCode() {
		return httpCode;
	}
	

}

