package com.bits.bancos.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cuenta")
public class CuentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta", nullable = false)
    private Long id_cuenta;

    @ManyToOne(targetEntity = ClienteEntity.class)
    @JoinColumn(name="id_cliente")
    private Long id_cliente;

    private Integer numero_cuenta;
    private Integer saldo_cuenta;

}
