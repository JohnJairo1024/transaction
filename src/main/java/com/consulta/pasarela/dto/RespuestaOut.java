package com.consulta.pasarela.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RespuestaOut {

    private String codigo;
    private String mensajeError;
    private Resultado resultado;

}
