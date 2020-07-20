package com.ipartek.formacion.uf2406.ejercicio3.accesodatos;

import java.util.List;

public interface Dao<T> {
	List<T> obtenerTodos();
	void insertar(T t);
}
