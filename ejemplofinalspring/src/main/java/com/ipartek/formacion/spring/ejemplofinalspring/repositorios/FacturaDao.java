package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;

public interface FacturaDao extends Dao<Factura> {
	Iterable<Factura> buscarTodosProfundo();
}
