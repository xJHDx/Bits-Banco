package com.bits.bancos.api;

import com.bits.bancos.entity.MovimientoEntity;
import com.bits.bancos.models.RequestBodyReporte;
import com.bits.bancos.services.MovimientoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimiento")
@CrossOrigin(origins = "*")
public class ApiMovimiento {

    @Autowired
    MovimientoServices movimientoServices;

    @Value("${spring.application.version}")
    private String version;

    @GetMapping("version")
    public ResponseEntity<String> version() {
        return new ResponseEntity(version, HttpStatus.OK);
    }

    @PostMapping("/reporte")
    public ResponseEntity<?> reporteRangoFechasIdCliente(@RequestBody RequestBodyReporte requestBodyReporte){
        return new ResponseEntity<>(movimientoServices.generarReporteRangoFechasIdCliente(requestBodyReporte),HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crearMovimiento(@RequestBody MovimientoEntity movimientoEntity){
        return new ResponseEntity<>(movimientoServices.registrarMovimiento(movimientoEntity),HttpStatus.OK);
    }

}
