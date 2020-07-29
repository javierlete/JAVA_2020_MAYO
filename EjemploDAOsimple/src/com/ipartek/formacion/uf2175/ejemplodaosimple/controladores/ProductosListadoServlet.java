package com.ipartek.formacion.uf2175.ejemplodaosimple.controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2175.ejemplodaosimple.accesodatos.ProductoDao;
import com.ipartek.formacion.uf2175.ejemplodaosimple.modelos.Producto;

@WebServlet("/productoslistado")
public class ProductosListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Producto> productos = null;
		
		try {
			productos = ProductoDao.obtenerTodos();
		} catch (SQLException e) {
			response.getWriter().println("Error al obtener los productos");
			e.printStackTrace(response.getWriter());
			return;
		} catch (ClassNotFoundException e) {
			response.getWriter().println("No se ha encontrado la clase de driver de base de datos");
			e.printStackTrace(response.getWriter());
		}
		
		request.setAttribute("productos", productos);
		
		request.getRequestDispatcher("productoslistado.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
