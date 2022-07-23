package com.bits.bancos.services;

import com.bits.bancos.entity.ClienteEntity;
import com.bits.bancos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteEntity> consultarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteEntity nuevoCliente(){

        System.out.println("continuar");

        return null;
    }

}
