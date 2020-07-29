package com.ipartek.formacion.uf2175.ejemplodaosimple.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2175.ejemplodaosimple.accesodatos.ProductoDao;
import com.ipartek.formacion.uf2175.ejemplodaosimple.modelos.Producto;

@WebServlet("/insertarproducto")
public class InsertarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("producto.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			String foto = request.getParameter("foto");

			Producto producto = new Producto(null, nombre, new BigDecimal(precio), foto);

			ProductoDao.insertar(producto);
			
			response.sendRedirect("productoslistado");
		} catch (SQLException e) {
			response.getWriter().println("Error al obtener los productos");
			e.printStackTrace(response.getWriter());
		} catch (ClassNotFoundException e) {
			response.getWriter().println("No se ha encontrado la clase de driver de base de datos");
			e.printStackTrace(response.getWriter());
		}
	}
}
