package com.ipartek.formacion.ejemplomvc.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T t);
	void modificar(T t);
	void borrar(T t);
	void borrar(Long id);
}
