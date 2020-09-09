package com.consulta.pasarela.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payload {

    private String estado;
    private String codigoRespuestaRedPagos;
    private String mensajeErrorRedPagos;
    private String fechaTransaccion;

}
