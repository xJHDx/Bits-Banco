package com.bits.bancos.enums;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {
    TECHNICAL("001","Ocurri� un error inesperado",HttpStatus.INTERNAL_SERVER_ERROR),
	ERROR_CLIENTE_EXISTE("002", "Nombre o Telefono ya se encuentra registrados",HttpStatus.NOT_ACCEPTABLE),
	EXISTO_ELIMINAR("003", "El Registro a sido Eliminado Exitosamente",HttpStatus.OK),
	ERROR_CLIENTE_NO_EXISTE("004", "El cliente no se encuentra en la base de datos",HttpStatus.OK)
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

