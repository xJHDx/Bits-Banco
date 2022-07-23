package com.bits.bancos.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "movimiento")
public class MovimientoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_movimiento")
    private Long idMovimiento;

    private String tipoMovimiento;
    private Date fechaMovimiento;
    private long valorMovimiento;



}
