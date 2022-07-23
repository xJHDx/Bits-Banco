package com.bits.bancos.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long idCuenta;

    @Column(name = "id_cliente")
    private long cliente;

    private long numeroCuenta;
    private long saldoCuenta;

    @OneToMany(targetEntity = MovimientoEntity.class)
    @JoinColumn(name="id_cuenta")
    private List<MovimientoEntity> movimientos;





}
