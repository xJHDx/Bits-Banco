package com.bits.bancos.services;

import com.bits.bancos.entity.ClienteEntity;
import com.bits.bancos.enums.ErrorEnum;
import com.bits.bancos.exceptions.ApiException;
import com.bits.bancos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    public List<ClienteEntity> consultarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteEntity nuevoCliente(ClienteEntity clienteEntity){
        ClienteEntity cliente =  clienteRepository.findByNombreClienteOrTelefonoCliente(clienteEntity.getNombreCliente(), clienteEntity.getTelefonoCliente());
        if(Objects.isNull(cliente)){
            return clienteRepository.save(clienteEntity);
        }else {
            throw new ApiException(ErrorEnum.ERROR_CLIENTE_EXISTE,"Nombre o Telefono ya se encuentra registrados");
        }
    }

}
