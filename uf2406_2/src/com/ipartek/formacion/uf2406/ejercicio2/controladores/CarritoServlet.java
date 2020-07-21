package com.ipartek.formacion.uf2406.ejercicio2.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.ejercicio2.modelos.Producto;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		TreeMap<Long, Producto> productos = (TreeMap<Long, Producto>) request.getSession().getAttribute("productos"); // getServletContext().getAttribute("productos");
		List<Producto> carrito = new ArrayList<>();

		Enumeration<String> nombres = request.getParameterNames();

		String nombre, valor;
		long id;
		int cantidad;
		Producto producto;
		BigDecimal total = BigDecimal.ZERO;
		
		while (nombres.hasMoreElements()) {
			nombre = nombres.nextElement();
			valor = request.getParameter(nombre);

			if (valor != null) {
				try {
					id = Long.parseLong(nombre);
					cantidad = Integer.parseInt(valor);

					if (cantidad > 0) {

						producto = new Producto(productos.get(id).getNumero(), productos.get(id).getNombre(),
								productos.get(id).getPrecio());
						producto.setCantidad(cantidad);
						carrito.add(producto);
						total = total.add(producto.getTotal());
					}
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
			}
		}

		request.getSession().setAttribute("carrito", carrito);
		request.getSession().setAttribute("total", total);

		response.sendRedirect("carrito.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
