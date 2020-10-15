package com.ipartek.formacion.spring.ejemplospringdaojdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.ejemplospringdaojdbc.entities.Autor;
import com.ipartek.formacion.spring.ejemplospringdaojdbc.repositories.Repositorio;

@SpringBootApplication
public class EjemplospringdaojdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringdaojdbcApplication.class, args);
	}
	
	@Autowired
	Repositorio<Autor> autoresRepository;
	
	@Override
	public void run(String... args) throws Exception {
		listado();
		
		System.out.println(autoresRepository.getById(1L));
		
		autoresRepository.insert(new Autor(null, "Nuevo", "Nuevez"));
		
		listado();
		
		Autor autor = autoresRepository.getById(3L);
		
		autor.setNombre("Modificado");
		autor.setApellidos("Modificadez");
		
		autoresRepository.update(autor);
		
		listado();
		
		autoresRepository.delete(3L);
		
		listado();
	}

	private void listado() {
		for(Autor autor: autoresRepository.getAll()) {
			System.out.println(autor);
		}
	}

}
