package com.consulta.pasarela.services;

import com.consulta.pasarela.dto.Payload;
import com.consulta.pasarela.dto.RespuestaOut;
import com.consulta.pasarela.dto.Resultado;
import com.consulta.pasarela.dto.TransaccionInDTO;
import com.consulta.pasarela.model.Transaccion;
import com.consulta.pasarela.repository.TransaccionRepository;
import com.consulta.pasarela.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PasarelaService {


    @Autowired
    private TransaccionRepository transaccionRepository;

    public RespuestaOut consultarPasarela(TransaccionInDTO transaccion) {
        RespuestaOut respuestaOut = new RespuestaOut();

        //Entidad
        Transaccion transaccionEntidad = transaccionRepository.findByIdTransaccion(transaccion.getIdTransaccion());

        if (transaccionEntidad != null && !transaccionEntidad.getIdTransaccion().isEmpty()) {

            respuestaOut.setCodigo(Constantes.OK);
            respuestaOut.setMensajeError(null);
            Payload payload = new Payload();
            payload.setEstado(Constantes.APROBADA);
            payload.setCodigoRespuestaRedPagos(Constantes.OK01);
            payload.setMensajeErrorRedPagos(null);

            Date fechaTransaccionOk = new Date();
            DateFormat dateFormat = new SimpleDateFormat(Constantes.FECHA);
            String strDate = dateFormat.format(fechaTransaccionOk);
            payload.setFechaTransaccion(strDate);

            //Seteamos el resultado
            Resultado resultado = new Resultado();
            resultado.setPayload(payload);
            respuestaOut.setResultado(resultado);

            return respuestaOut;

        }

        respuestaOut.setCodigo(Constantes.ERROR);
        respuestaOut.setMensajeError(Constantes.ERRORNEGOCIO);


        Payload payload = new Payload();
        payload.setEstado(Constantes.INEXISTENTE);
        payload.setCodigoRespuestaRedPagos(Constantes.ERROR93);
        payload.setMensajeErrorRedPagos(Constantes.TRANSACCION_NO_EXISTE);

        Date fechaTransaccionError = new Date();
        DateFormat dateFormat = new SimpleDateFormat(Constantes.FECHA);
        String strDate = dateFormat.format(fechaTransaccionError);
        payload.setFechaTransaccion(strDate);

        //Seteamos el resultado
        Resultado resultado = new Resultado();
        resultado.setPayload(payload);
        respuestaOut.setResultado(resultado);

        return respuestaOut;
    }
}
