package com.bits.bancos.api;

import com.bits.bancos.services.CuentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta/")
public class ApiCuentas {

    @Autowired
    CuentaServices cuentaServices;

    @Value("${spring.application.version}")
    private String version;

    @GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity(version, HttpStatus.OK);
    }


    // creation al cliente especifico.
    // modification
    // Consulta
    @GetMapping("todos")
    public ResponseEntity<?> consultaTodos(){return new ResponseEntity<>(cuentaServices.consultarCuentas(),HttpStatus.ACCEPTED); }
    // Elimination

}
