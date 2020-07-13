package com.ipartek.formacion.tiendavirtual.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/borrarproductocarrito")
public class BorrarProductoCarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String producto = request.getParameter("producto");
		
		List<String> carrito = (List<String>) request.getSession().getAttribute("carrito");
		
		if(carrito != null) {
			carrito.remove(producto);
		}
		
		response.sendRedirect("carrito");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
