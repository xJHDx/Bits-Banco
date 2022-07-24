package com.bits.bancos.repository;

import com.bits.bancos.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {

    @Query(value = "SELECT * FROM movimiento WHERE id_cuenta = :idCuenta AND fecha_movimiento BETWEEN :fechaInicio AND :fechaFin ", nativeQuery = true)
    List<MovimientoEntity> BetweenDate(@Param("idCuenta") long idCuenta,@Param("fechaInicio") String fechaInicio,@Param("fechaFin") String fechaFin );

}
