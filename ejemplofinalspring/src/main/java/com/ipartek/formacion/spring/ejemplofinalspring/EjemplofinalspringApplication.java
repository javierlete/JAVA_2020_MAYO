package com.ipartek.formacion.spring.ejemplofinalspring;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Cliente;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.LineaFactura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.Dao;

@SpringBootApplication
public class EjemplofinalspringApplication implements CommandLineRunner {

	@Autowired
	private Dao<Producto> productos;
	
	@Autowired
	private Dao<LineaFactura> lineaFacturas;
	
	@Autowired
	private Dao<Factura> facturas;
	
	@Autowired
	private Dao<Cliente> clientes;
	
	public static void main(String[] args) {
		SpringApplication.run(EjemplofinalspringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente javier = new Cliente(null, "Javier", "Lete", "12345678Z", null);
		
		Producto monitor = new Producto(null, "Monitor", new BigDecimal("123"));
		Producto raton = new Producto(null, "Ratón", new BigDecimal("12"));
		Producto teclado = new Producto(null, "Teclado", new BigDecimal("23"));
		
		productos.insertar(monitor);
		productos.insertar(raton);
		productos.insertar(teclado);
		
		Set<LineaFactura> lineas = new HashSet<>();
		
		lineas.add(new LineaFactura(null, 3, raton));
		lineas.add(new LineaFactura(null, 2, monitor));
		
		facturas.insertar(new Factura(null, "1234", LocalDate.now(), javier, lineas));
	}

}
