package com.ipartek.formacion.spring.ejemplospringdaojdbc.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplospringdaojdbc.entities.Autor;

@Repository
public class AutoresTreeMapRepository implements Repositorio<Autor> {
	private TreeMap<Long, Autor> autores = new TreeMap<>();
	
	public AutoresTreeMapRepository() {
		autores.put(1L, new Autor(1L, "Nombre1", "Apellido1"));
		autores.put(2L, new Autor(2L, "Nombre2", "Apellido2"));
	}
	
	@Override
	public List<Autor> getAll() {
		return new ArrayList<Autor>(autores.values());
	}

	@Override
	public Autor getById(Long id) {
		return autores.get(id);
	}

	@Override
	public void insert(Autor autor) {
		Long id = autores.lastKey() + 1;
		
		autor.setId(id);
		
		autores.put(id, autor);
	}

	@Override
	public void update(Autor autor) {
		autores.put(autor.getId(), autor);
	}

	@Override
	public void delete(Long id) {
		autores.remove(id);
	}

}
