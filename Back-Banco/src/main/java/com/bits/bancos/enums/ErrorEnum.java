package com.bits.bancos.enums;

import org.springframework.http.HttpStatus;

public enum ErrorEnum {
    TECHNICAL("001","Ocurri� un error inesperado",HttpStatus.INTERNAL_SERVER_ERROR),
	ERROR_CLIENTE_EXISTE("002", "Nombre o Telefono ya se encuentra registrados",HttpStatus.NOT_ACCEPTABLE),
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

