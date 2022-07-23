package com.bits.bancos.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta")
    private Long idCuenta;
    private long numeroCuenta;
    private long saldoCuenta;



    @OneToMany(targetEntity = MovimientoEntity.class)
    @JoinColumn(name="id_movimiento")
    private List<MovimientoEntity> movimientos;





}
