package com.bits.bancos.repository;

import com.bits.bancos.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {
}
