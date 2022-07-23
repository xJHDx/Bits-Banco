package com.bits.bancos.services;

import com.bits.bancos.entity.MovimientoEntity;
import com.bits.bancos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServices {

    @Autowired
    MovimientoRepository movimientoRepository;

    public List<MovimientoEntity> consultarMovimientos(){
        return movimientoRepository.findAll();
    }

}
