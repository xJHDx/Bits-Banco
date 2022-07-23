package com.bits.bancos.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", nullable = false)
    private Long id_cliente;
    private String nombre_cliente;
    private String direccion_cliente;
    private Integer telefono_cliente;

}
