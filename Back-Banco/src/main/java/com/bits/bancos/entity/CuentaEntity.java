package com.bits.bancos.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta")
    private Long idCuenta;

    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name="cliente_ibfk")
    private ClienteEntity clienteIbfk;

    private Integer numeroCuenta;
    private Integer saldoCuenta;

}
