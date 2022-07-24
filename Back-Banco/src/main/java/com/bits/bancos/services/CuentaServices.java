package com.bits.bancos.services;

import com.bits.bancos.entity.CuentaEntity;
import com.bits.bancos.enums.ErrorEnum;
import com.bits.bancos.exceptions.ApiException;
import com.bits.bancos.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CuentaServices {

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    ClienteServices clienteServices;

    public List<CuentaEntity> consultarCuentas() {
        return cuentaRepository.findAll();
    }

    public CuentaEntity consultaCuenta(long id) {
        CuentaEntity cuenta = cuentaRepository.findByIdCuenta(id);
        if (Objects.isNull(cuenta)) {
            throw new ApiException(ErrorEnum.ERROR_NO_EXISTE, "No Existe Cuenta");
        }
        return cuenta;
    }

    public CuentaEntity nuevaCuenta(CuentaEntity cuentaEntity){
        CuentaEntity cuenta = cuentaRepository.findByNumeroCuenta(cuentaEntity.getNumeroCuenta());
        clienteServices.consultaCliente(cuentaEntity.getCliente());
        if(Objects.isNull(cuenta)){
            return cuentaRepository.save(cuentaEntity);
        }else {
            throw new ApiException(ErrorEnum.CUENTA_EXISTE,"Ya esta Registrada la cuenta con el cliente");
        }
    }

    public CuentaEntity actualizarCuenta(CuentaEntity cuentaEntity){
        CuentaEntity cuenta = cuentaRepository.findByIdCuenta(cuentaEntity.getIdCuenta());
        if(!Objects.isNull(cuenta)){

            if(cuentaEntity.getNumeroCuenta() != cuenta.getNumeroCuenta()){
                if(!Objects.isNull(cuentaRepository.findByNumeroCuenta(cuentaEntity.getNumeroCuenta()))){
                    throw new ApiException(ErrorEnum.CUENTA_EXISTE,"El Numero de Cuenta Existe Con otro Cliente");
                }else {
                    cuenta.setNumeroCuenta(cuentaEntity.getNumeroCuenta());
                }
            }
            clienteServices.consultaCliente(cuentaEntity.getCliente());
            cuenta.setCliente(cuentaEntity.getCliente());
            cuenta.setSaldoCuenta(cuentaEntity.getSaldoCuenta());
            return cuentaRepository.save(cuenta);
        }else {
            throw new ApiException(ErrorEnum.ERROR_NO_EXISTE,"No Existe Cuenta");
        }
    }

    public ApiException eliminarCuenta(long idCuenta){
        consultaCuenta(idCuenta);
        cuentaRepository.deleteById(idCuenta);
        throw new ApiException(ErrorEnum.EXISTO_ELIMINAR,"Se Elimino la Cuenta");
    }

}
