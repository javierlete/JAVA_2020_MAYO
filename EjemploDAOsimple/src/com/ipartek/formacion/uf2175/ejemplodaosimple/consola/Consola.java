package com.ipartek.formacion.uf2175.ejemplodaosimple.consola;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.uf2175.ejemplodaosimple.accesodatos.ProductoDao;
import com.ipartek.formacion.uf2175.ejemplodaosimple.modelos.Producto;

public class Consola {

	public static void main(String[] args) throws SQLException {
		Producto producto = ProductoDao.obtenerPorId(3L);

		System.out.println(producto);

		producto.setNombre("Modificado");
		producto.setPrecio(new BigDecimal("4321.21"));

		ProductoDao.modificar(producto);

		ProductoDao.insertar(new Producto(null, "Nuevo", new BigDecimal("1234.23"), null));

		ProductoDao.borrar(4L);
		
		ArrayList<Producto> productos = ProductoDao.obtenerTodos();

		for (Producto p : productos) {
			System.out.println(p);
		}
	}

}
