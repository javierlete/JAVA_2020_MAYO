package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.repositorios.FacturaDao;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaDao dao;
	
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
}
