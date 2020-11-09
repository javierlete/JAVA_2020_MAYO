package com.ipartek.formacion.spring.ejemplomultipledatasources;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.ejemplomultipledatasources.modelos.Producto;
import com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.exportacion.ExportarProductoRepository;
import com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.importacion.ImportarProductoRepository;

@SpringBootApplication
public class EjemplomultipledatasourcesApplication implements CommandLineRunner {
	public final static String MODEL_PACKAGE = "com.ipartek.formacion.spring.ejemplomultipledatasources.modelos";
	public final static Properties JPA_PROPERTIES = new Properties() {
		private static final long serialVersionUID = -7687270585872239808L;

		{
			put("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
			put("hibernate.hbm2ddl.auto", "update");
			put("hibernate.ddl-auto", "update");
			put("show-sql", "true");
		}
	};
	
	@Autowired
	private ImportarProductoRepository importacion;
	@Autowired
    private ExportarProductoRepository exportacion;

	public static void main(String[] args) {
		SpringApplication.run(EjemplomultipledatasourcesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//importacion.save(new Producto(null, "Importacion", BigDecimal.ZERO));
		
		Iterable<Producto> productos = importacion.findAll();
		
		//exportacion.save(new Producto(null, "Exportacion", BigDecimal.ONE));
		
		exportacion.saveAll(productos);
	}

}
