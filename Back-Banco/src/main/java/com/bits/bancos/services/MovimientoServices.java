package com.bits.bancos.services;

import com.bits.bancos.entity.ClienteEntity;
import com.bits.bancos.entity.CuentaEntity;
import com.bits.bancos.entity.MovimientoEntity;
import com.bits.bancos.enums.ErrorEnum;
import com.bits.bancos.exceptions.ApiException;
import com.bits.bancos.models.RequestBodyReporte;
import com.bits.bancos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoServices {

    @Autowired
    MovimientoRepository movimientoRepository;

    @Autowired
    CuentaServices cuentaServices;

    public List<MovimientoEntity> consultarMovimientos(){
        return movimientoRepository.findAll();
    }

    public ClienteEntity generarReporteRangoFechasIdCliente(RequestBodyReporte requestBodyReporte){
        return null;
    }

    public MovimientoEntity registrarMovimiento(MovimientoEntity movimientoEntity){

        CuentaEntity cuenta = cuentaServices.consultaCuenta(movimientoEntity.getCuenta());

        if(movimientoEntity.getTipoMovimiento().equals("CREDITO")){
            if( movimientoEntity.getValorMovimiento() <= cuenta.getSaldoCuenta()){
                cuenta.setSaldoCuenta( cuenta.getSaldoCuenta() - movimientoEntity.getValorMovimiento());
                movimientoEntity.setValorMovimiento(-movimientoEntity.getValorMovimiento());
            }else {
                throw new ApiException(ErrorEnum.ERROR_MAXIMO_SALDO,"Valor maximo No permitido");
            }
        }else if(movimientoEntity.getTipoMovimiento().equals("DEBITO")){
            cuenta.setSaldoCuenta(movimientoEntity.getValorMovimiento() + cuenta.getSaldoCuenta());
        }else{
            throw new ApiException(ErrorEnum.ERROR_TIPO_MOVIMIENTO,"Tipo de movimiento no valido");
        }
        cuentaServices.actualizarCuenta(cuenta);
        return movimientoRepository.save(movimientoEntity);
    }

}
