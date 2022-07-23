package com.bits.bancos.services;

import com.bits.bancos.entity.CuentaEntity;
import com.bits.bancos.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaServices {

    @Autowired
    CuentaRepository cuentaRepository;

    public List<CuentaEntity> consultarCuentas(){
        return cuentaRepository.findAll();
    }



}
