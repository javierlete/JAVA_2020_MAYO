package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;

@Repository
public class ProductoDaoSpringDataJpa implements Dao<Producto> {

	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Iterable<Producto> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Producto buscarPorId(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void insertar(Producto producto) {
		repo.save(producto);
	}

	@Override
	public void modificar(Producto producto) {
		repo.save(producto);
	}

	@Override
	public void borrar(Producto producto) {
		repo.delete(producto);
	}

}
