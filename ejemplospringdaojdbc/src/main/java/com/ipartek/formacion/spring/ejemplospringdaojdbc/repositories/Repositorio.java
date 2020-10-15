package com.ipartek.formacion.spring.ejemplospringdaojdbc.repositories;

import java.util.List;

import com.ipartek.formacion.spring.ejemplospringdaojdbc.entities.Autor;

public interface Repositorio<T> {

	List<T> getAll();

	Autor getById(Long id);

	void insert(T autor);

	void update(T autor);

	void delete(Long id);

}