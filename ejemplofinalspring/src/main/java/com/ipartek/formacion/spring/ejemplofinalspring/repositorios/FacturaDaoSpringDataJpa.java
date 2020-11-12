package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;

@Repository
public class FacturaDaoSpringDataJpa implements Dao<Factura>{

	@Autowired
	private FacturaRepository repo;
	
	@Override
	public Iterable<Factura> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Factura buscarPorId(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void insertar(Factura factura) {
		repo.save(factura);
	}

	@Override
	public void modificar(Factura factura) {
		repo.save(factura);
	}

	@Override
	public void borrar(Factura factura) {
		repo.delete(factura);
	}

}
