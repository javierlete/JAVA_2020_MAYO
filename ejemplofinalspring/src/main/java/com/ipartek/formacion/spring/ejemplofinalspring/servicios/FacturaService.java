package com.ipartek.formacion.spring.ejemplofinalspring.servicios;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;
import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;

public interface FacturaService {
	void crearNuevaFactura(Factura factura);
	Iterable<Factura> obtenerFacturas();
	Factura obtenerFacturaPorId(Long id);
	void modificarFactura(Factura factura);
	Iterable<Producto> obtenerProductos();
	void borrarFactura(Long id);
}
