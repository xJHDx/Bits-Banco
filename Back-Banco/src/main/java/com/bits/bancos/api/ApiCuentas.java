package com.bits.bancos.api;

import com.bits.bancos.entity.ClienteEntity;
import com.bits.bancos.entity.CuentaEntity;
import com.bits.bancos.services.CuentaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    // creation
    @PostMapping("crear")
    public ResponseEntity<?> crearCliente(@RequestBody CuentaEntity cuentaEntity){
        return new ResponseEntity<>(cuentaServices.nuevaCuenta(cuentaEntity),HttpStatus.CREATED);
    }
    // modification
    // Consulta
    @GetMapping("todos")
    public ResponseEntity<?> consultaTodos(){return new ResponseEntity<>(cuentaServices.consultarCuentas(),HttpStatus.ACCEPTED); }
    // Elimination

}