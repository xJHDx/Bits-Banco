package com.bits.bancos.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimiento/")
public class ApiMovimiento {

    @Value("${spring.application.version}")
    private String version;

    @GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity(version, HttpStatus.OK);
    }


    // registrar movimiento al cliente con respectiva cuenta,
    // el valor de registro no debe superar el saldo total. 

}
