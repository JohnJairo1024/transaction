package com.consulta.pasarela.repository;

import com.consulta.pasarela.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    Transaccion findByIdTransaccion (String id);

}
