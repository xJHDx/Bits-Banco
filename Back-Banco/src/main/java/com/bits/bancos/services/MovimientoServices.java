package com.bits.bancos.services;

import com.bits.bancos.entity.ClienteEntity;
import com.bits.bancos.entity.CuentaEntity;
import com.bits.bancos.entity.MovimientoEntity;
import com.bits.bancos.enums.ErrorEnum;
import com.bits.bancos.exceptions.ApiException;
import com.bits.bancos.models.RequestBodyReporte;
import com.bits.bancos.models.ResponseBodyReporte;
import com.bits.bancos.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoServices {

    @Autowired
    MovimientoRepository movimientoRepository;

    @Autowired
    CuentaServices cuentaServices;

    @Autowired
    ClienteServices clienteServices;

    String pattern = "yyyy/MM/dd";

    public List<MovimientoEntity> consultarMovimientos(){
        return movimientoRepository.findAll();
    }

    public ResponseBodyReporte generarReporteRangoFechasIdCliente(RequestBodyReporte requestBodyReporte){
        DateFormat df = new SimpleDateFormat(pattern);

        ClienteEntity cliente = clienteServices.consultaCliente(requestBodyReporte.getIdCliente());
        List<CuentaEntity> cuentas = cuentaServices.consultaCuentaCliente(requestBodyReporte.getIdCliente());

        List<ResponseBodyReporte.CuentasAsociadas> cuentasAsociadas = new ArrayList<>();
        for(CuentaEntity cuenta: cuentas){
            ResponseBodyReporte.CuentasAsociadas cuentaAsociada = new ResponseBodyReporte.CuentasAsociadas();

            cuentaAsociada.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaAsociada.setSaldoCuenta(cuenta.getSaldoCuenta());

            List<ResponseBodyReporte.CuentasAsociadas.Movimientos> movimientos = new ArrayList<>();
            for(MovimientoEntity movimiento : movimientoRepository.BetweenDate(cuenta.getIdCuenta(),df.format(requestBodyReporte.getFechaInicio()),df.format(requestBodyReporte.getFechaFin())) ){
                ResponseBodyReporte.CuentasAsociadas.Movimientos movimientoAsociado = new ResponseBodyReporte.CuentasAsociadas.Movimientos();
                movimientoAsociado.setTipoMovimiento(movimiento.getTipoMovimiento());
                movimientoAsociado.setFechaMovimiento(movimiento.getFechaMovimiento());
                movimientoAsociado.setValorMovimiento(movimiento.getValorMovimiento());
                movimientos.add(movimientoAsociado);
            }
            cuentaAsociada.setTotalCreditos(1);
            cuentaAsociada.setTotalDebitos(1);
            cuentaAsociada.setMovimientos(movimientos);
            cuentasAsociadas.add(cuentaAsociada);
        }

        return ResponseBodyReporte.builder()
                .nombreCliente(cliente.getNombreCliente())
                .telefonoCliente(cliente.getTelefonoCliente())
                .cuentasAsociadas(cuentasAsociadas)
                .build();
        // Total de Debito y Credito
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
