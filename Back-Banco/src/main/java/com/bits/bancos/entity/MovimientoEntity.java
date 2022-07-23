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
    @Column(name = "id_movimiento", nullable = false)
    private Long idMovimiento;

    @ManyToOne(targetEntity = CuentaEntity.class)
    @JoinColumn(name="cuenta_ibfk")
    private CuentaEntity cuentaIbfk;

    private String tipoMovimiento;
    private Date fechaMovimiento;
    private Integer valorMovimiento;
}
