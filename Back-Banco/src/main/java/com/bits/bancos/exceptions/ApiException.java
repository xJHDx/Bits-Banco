package com.bits.bancos.exceptions;


import com.bits.bancos.enums.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiException extends RuntimeException{

	 private ErrorEnum error;
     private String message;

}

