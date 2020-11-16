package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.Dao;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.FacturaDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaDao dao;
	@Autowired
	private Dao<Producto> daoProducto;
	
	@Override
	public void crearNuevaFactura(Factura factura) {
		log.trace("Se va a guardar la factura");
		dao.insertar(factura);
		log.trace("Factura guardada");
	}

	@Override
	public Iterable<Factura> obtenerFacturas() {
		Iterable<Factura> facturas;
		
		log.trace("Se va a consultar las facturas");
		facturas = dao.buscarTodos();
		log.trace("Se han recibido todas las facturas");
		
		return facturas;
	}

	@Override
	public Factura obtenerFacturaPorId(Long id) {
		log.trace("Se va a obtener una factura por su id: " + id);
		Factura factura = dao.buscarPorId(id);
		log.trace("Se ha obtenido la factura");
		
		return factura;
	}

	@Override
	public void modificarFactura(Factura factura) {
		log.trace("Se va a modificar la factura");
		dao.modificar(factura);
		log.trace("Factura modificada");
	}

	@Override
	public Iterable<Producto> obtenerProductos() {
		log.trace("Se va a buscar todos los productos");
		Iterable<Producto> productos = daoProducto.buscarTodos();
		log.trace("Productos obtenidos");
		
		return productos;
	}
}
