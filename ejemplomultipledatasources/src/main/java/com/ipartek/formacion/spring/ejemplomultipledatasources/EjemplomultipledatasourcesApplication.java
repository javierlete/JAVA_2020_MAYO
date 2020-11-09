package com.ipartek.formacion.spring.ejemplomultipledatasources;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemplomultipledatasourcesApplication implements CommandLineRunner {
	public final static String MODEL_PACKAGE = "com.ipartek.formacion.spring.ejemplomultipledatasources.modelos";
	
	public static void main(String[] args) {
		SpringApplication.run(EjemplomultipledatasourcesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//importacion.save(new Producto(null, "Importacion", BigDecimal.ZERO));
		//exportacion.save(new Producto(null, "Exportacion", BigDecimal.ONE));
	}

}
