package com.bits.bancos.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBodyReporte {

    private String nombreCliente;
    private long telefonoCliente;
    private List<CuentasAsociadas> cuentasAsociadas;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CuentasAsociadas{

        private long numeroCuenta;
        private long saldoCuenta;
        private long totalDebitos;
        private long totalCreditos;
        private List<Movimientos> movimientos;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Movimientos{

            private String tipoMovimiento;

            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Bogota")
            private Date fechaMovimiento;
            private long valorMovimiento;
        }

    }


}
