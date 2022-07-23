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

    public ClienteEntity consultaCliente(long id){
        if(Objects.isNull(clienteRepository.findByIdCliente(id))){
            throw new ApiException(ErrorEnum.ERROR_CLIENTE_NO_EXISTE,"No Existe Cliente");
        }
        return clienteRepository.findByIdCliente(id);
    }

    public ClienteEntity nuevoCliente(ClienteEntity clienteEntity){
        ClienteEntity cliente =  clienteRepository.findByNombreClienteOrTelefonoCliente(clienteEntity.getNombreCliente(), clienteEntity.getTelefonoCliente());
        if(Objects.isNull(cliente)){
            return clienteRepository.save(clienteEntity);
        }else {
            throw new ApiException(ErrorEnum.ERROR_CLIENTE_EXISTE,"Nombre o Telefono ya se encuentra registrados");
        }
    }

    public ClienteEntity actualizarCliente(ClienteEntity clienteEntity){
        ClienteEntity cliente = clienteRepository.findByIdCliente(clienteEntity.getIdCliente());
        if(!Objects.isNull(cliente)){
            cliente.setNombreCliente(clienteEntity.getNombreCliente());
            cliente.setDireccionCliente(clienteEntity.getDireccionCliente());
            cliente.setTelefonoCliente(clienteEntity.getTelefonoCliente());
            return clienteRepository.save(cliente);
        }else {
            throw new ApiException(ErrorEnum.ERROR_CLIENTE_NO_EXISTE,"No Existe Cliente");
        }
    }

    public ApiException eliminarCliente(long id){
        clienteRepository.deleteById(id);
        return new ApiException(ErrorEnum.EXISTO_ELIMINAR,"Se Elimino El Cliente");
    }

}
