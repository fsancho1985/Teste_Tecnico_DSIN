package com.sancho.cabeleleila;

import com.sancho.cabeleleila.entity.Agendamento;
import com.sancho.cabeleleila.entity.Servico;
import com.sancho.cabeleleila.entity.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

@SpringBootApplication
public class CabeleleilaApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException, ParseException {
		SpringApplication.run(CabeleleilaApplication.class, args);
	}

}
