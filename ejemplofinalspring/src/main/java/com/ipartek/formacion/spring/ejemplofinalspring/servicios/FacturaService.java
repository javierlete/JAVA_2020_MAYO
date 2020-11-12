package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;

public interface FacturaService {
	void crearNuevaFactura(Factura factura);
	Iterable<Factura> obtenerFacturas();
}
