package com.bits.bancos.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "movimiento")
public class MovimientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long idMovimiento;

    @Column(name = "id_cuenta")
    private long cuenta;

    private String tipoMovimiento;
    private Date fechaMovimiento;
    private long valorMovimiento;



}
