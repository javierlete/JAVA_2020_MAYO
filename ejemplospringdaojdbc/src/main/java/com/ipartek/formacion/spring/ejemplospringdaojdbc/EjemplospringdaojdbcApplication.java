package com.ipartek.formacion.spring.ejemplospringdaojdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.ejemplospringdaojdbc.entities.Autor;
import com.ipartek.formacion.spring.ejemplospringdaojdbc.repositories.AutoresRepository;

@SpringBootApplication
public class EjemplospringdaojdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringdaojdbcApplication.class, args);
	}
	
	@Autowired
	AutoresRepository autoresRepository;
	
	@Override
	public void run(String... args) throws Exception {
		List<Autor> autores = autoresRepository.getAll();
		
		for(Autor autor: autores) {
			System.out.println(autor);
		}
	}

}
