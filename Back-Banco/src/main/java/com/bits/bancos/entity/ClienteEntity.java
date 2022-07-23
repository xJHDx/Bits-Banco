package com.bits.bancos.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    private String nombreCliente;
    private String direccionCliente;
    private long telefonoCliente;

    @OneToMany(targetEntity = CuentaEntity.class)
    @JoinColumn(name="id_cliente")
    private List<CuentaEntity> cuentas;

}
