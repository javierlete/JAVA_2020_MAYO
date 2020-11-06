package com.ipartek.formacion.spring.ejemplohibernatespringdata;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.ejemplohibernatespringdata.entidades.Producto;
import com.ipartek.formacion.spring.ejemplohibernatespringdata.repositorios.ProductoRepository;

@SpringBootApplication
public class EjemplohibernatespringdataApplication implements CommandLineRunner {
	@Autowired
	private ProductoRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(EjemplohibernatespringdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Producto(null, "Prueba1", new BigDecimal("1234")));
		repo.save(new Producto(null, "Prueba2", new BigDecimal("2342")));
		repo.save(new Producto(null, "Prueba3", new BigDecimal("344")));
		repo.save(new Producto(null, "2345", new BigDecimal("2345")));
		
		System.out.println(repo.findByNombre("Prueba2"));
		
		List<Producto> productosEntre1000Y3000 = repo.findByPrecioBetween(new BigDecimal("1000"), new BigDecimal("3000"));
		
		for(Producto producto: productosEntre1000Y3000) {
			System.out.println(producto);
		}
		
		Optional<Producto> producto = repo.findById(1L);
		
		System.out.println(producto);
		
		System.out.println(repo.findByNombreIgualPrecio());
	}

}
