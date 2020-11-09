package com.ipartek.formacion.spring.ejemplomultipledatasources.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ipartek.formacion.spring.ejemplomultipledatasources.modelos.Producto;
import com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.exportacion.ExportarProductoRepository;
import com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.importacion.ImportarProductoRepository;

@Controller
public class MigracionController {
	@Autowired
	private ImportarProductoRepository importacion;
	@Autowired
    private ExportarProductoRepository exportacion;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/migrar")
	public String migracion() {
		Iterable<Producto> productos = importacion.findAll();
		exportacion.saveAll(productos);
		
		return "index";
	}
	
	@GetMapping("/{ruta}")
	public String generico(@PathVariable("ruta") String ruta) {
		return ruta;
	}
}
