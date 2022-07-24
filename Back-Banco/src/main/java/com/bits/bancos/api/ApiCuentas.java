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
@RequestMapping("/cuenta")
public class ApiCuentas {

    @Autowired
    CuentaServices cuentaServices;

    @Value("${spring.application.version}")
    private String version;

    @GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity(version, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> consultar(@RequestParam String id){
        if (id.equals("todos")) {
            return new ResponseEntity<>(cuentaServices.consultarCuentas(),HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(cuentaServices.consultaCuenta(Long.parseLong(id)),HttpStatus.ACCEPTED);
        }
    }

    @PostMapping()
    public ResponseEntity<?> crearCuenta(@RequestBody CuentaEntity cuentaEntity){
        return new ResponseEntity<>(cuentaServices.nuevaCuenta(cuentaEntity),HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarCuenta(@RequestBody CuentaEntity cuentaEntity){
        return new ResponseEntity<>(cuentaServices.actualizarCuenta(cuentaEntity),HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> eliminarCuenta(@RequestParam long id){
        return new ResponseEntity<>(cuentaServices.eliminarCuenta(id),HttpStatus.OK);
    }
}
