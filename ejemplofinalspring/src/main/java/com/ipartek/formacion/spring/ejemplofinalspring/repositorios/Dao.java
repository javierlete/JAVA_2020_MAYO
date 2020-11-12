package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

public interface Dao<T> {
	Iterable<T> buscarTodos();
	T buscarPorId(Long id);
	
	void insertar(T objeto);
	void modificar(T objeto);
	void borrar(T objeto);
}
