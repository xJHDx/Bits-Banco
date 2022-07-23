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
    @Column(name = "id_movimiento", nullable = false)
    private Long id_movimiento;

    @ManyToOne(targetEntity = CuentaEntity.class)
    @JoinColumn(name="id_cuenta")
    private Long id_cuenta;
    private String tipo_movimiento;
    private Date fecha_movimiento;
    private Integer valor_movimiento;
}
