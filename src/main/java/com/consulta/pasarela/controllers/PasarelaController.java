package com.consulta.pasarela.controllers;


import com.consulta.pasarela.dto.RespuestaOut;
import com.consulta.pasarela.dto.TransaccionInDTO;
import com.consulta.pasarela.services.PasarelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment/api/v1")
public class PasarelaController {

    @Autowired
    private PasarelaService pasarelaService;

    @PostMapping(path = "/transaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RespuestaOut registrarPersonalCDA(@RequestBody TransaccionInDTO transaccion) {
        return pasarelaService.consultarPasarela(transaccion);
    }

}
