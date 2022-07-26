package com.bits.bancos.api;

import com.bits.bancos.entity.ClienteEntity;
import com.bits.bancos.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "*")
public class ApiClientes {

    @Autowired
    ClienteServices clienteServices;

    @Value("${spring.application.version}")
    private String version;

    @GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity(version, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> consultar(@RequestParam String id) {
        if (id.equals("todos")) {
            return new ResponseEntity<>(clienteServices.consultarClientes(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(clienteServices.consultaCliente(Long.parseLong(id)), HttpStatus.ACCEPTED);
        }
    }

    @PostMapping()
    public ResponseEntity<?> crearCliente(@RequestBody ClienteEntity clienteEntity) {
        return new ResponseEntity<>(clienteServices.nuevoCliente(clienteEntity), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarCliente(@RequestBody ClienteEntity clienteEntity) {
        return new ResponseEntity<>(clienteServices.actualizarCliente(clienteEntity), HttpStatus.ACCEPTED);
    }

    @DeleteMapping()
    public ResponseEntity<?> eliminarCliente(@RequestParam long id) {
        return new ResponseEntity<>(clienteServices.eliminarCliente(id), HttpStatus.OK);
    }

}
