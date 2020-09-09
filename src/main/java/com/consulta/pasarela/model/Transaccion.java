package com.consulta.pasarela.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "transaccion")
@Getter
@Setter
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "idTransaccion")
    private String idTransaccion;

    @Column(name = "numeroCuentaPasarela")
    private String numeroCuentaPasarela;


    public Transaccion(String idTransaccion, String numeroCuentaPasarela) {
        this.idTransaccion = idTransaccion;
        this.numeroCuentaPasarela = numeroCuentaPasarela;
    }
}
