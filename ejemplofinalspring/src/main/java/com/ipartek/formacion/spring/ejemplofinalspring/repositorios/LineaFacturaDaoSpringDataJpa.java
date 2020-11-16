package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.LineaFactura;

@Repository
public class LineaFacturaDaoSpringDataJpa implements Dao<LineaFactura> {

	@Autowired
	private LineaFacturaRepository repo;
	
	@Override
	public Iterable<LineaFactura> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public LineaFactura buscarPorId(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void insertar(LineaFactura factura) {
		repo.save(factura);
	}

	@Override
	public void modificar(LineaFactura factura) {
		repo.save(factura);
	}

	@Override
	public void borrar(LineaFactura factura) {
		repo.delete(factura);
	}

}
