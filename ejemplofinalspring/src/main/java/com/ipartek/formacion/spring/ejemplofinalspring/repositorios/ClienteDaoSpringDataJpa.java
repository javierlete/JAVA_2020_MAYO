package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Cliente;

@Repository
public class ClienteDaoSpringDataJpa implements Dao<Cliente> {

	@Autowired
	private ClienteRepository repo;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void insertar(Cliente cliente) {
		repo.save(cliente);
	}

	@Override
	public void modificar(Cliente cliente) {
		repo.save(cliente);
	}

	@Override
	public void borrar(Cliente cliente) {
		repo.delete(cliente);
	}

}
