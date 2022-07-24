package com.bits.bancos.repository;

import com.bits.bancos.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {

    CuentaEntity findByIdCuenta(long idCuenta);

    CuentaEntity findByNumeroCuenta( long numeroCuenta);

}
