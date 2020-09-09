package com.consulta.pasarela;

import com.consulta.pasarela.model.Transaccion;
import com.consulta.pasarela.repository.TransaccionRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PasarelaApplication {


    @Autowired
    private TransaccionRepository transaccionRepository;

    public static void main(String[] args) {
        SpringApplication.run(PasarelaApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {

            // Transaccion
            transaccionRepository.save(new Transaccion("TRX12351313", "ACH-3463"));
        };
    }


}
