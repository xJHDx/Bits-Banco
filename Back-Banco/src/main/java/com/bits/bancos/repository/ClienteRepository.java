package com.bits.bancos.repository;

import com.bits.bancos.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    ClienteEntity findByNombreClienteOrTelefonoCliente(String nombreCliente, long telefonoCliente);

}
