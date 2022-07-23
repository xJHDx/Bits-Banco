package com.bits.bancos.api;



import com.bits.bancos.entity.ClienteEntity;
import com.bits.bancos.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente/")
public class ApiClientes {

    @Autowired
    ClienteServices clienteServices;

    @Value("${spring.application.version}")
    private String version;

    @GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity(version, HttpStatus.OK);
    }


    // creation
    @PostMapping("crear")
    public ResponseEntity<?> crearCliente(@RequestBody ClienteEntity clienteEntity){
        return new ResponseEntity<>(clienteServices.nuevoCliente(clienteEntity),HttpStatus.CREATED);
    }
    // modification
    // Consulta
    @GetMapping("todos")
    public ResponseEntity<?> consultaTodos(){return new ResponseEntity<>(clienteServices.consultarClientes(),HttpStatus.ACCEPTED); }
    // Elimination

}
