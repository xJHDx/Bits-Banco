package com.bits.bancos.repository;

import com.bits.bancos.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
}
