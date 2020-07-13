package com.ipartek.formacion.tiendavirtual.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String producto = request.getParameter("producto");

		System.out.println(producto);

		List<String> carrito = (List<String>) request.getSession().getAttribute("carrito");

		if (carrito == null) {
			carrito = new ArrayList<String>();

			request.getSession().setAttribute("carrito", carrito);
		}

		if (producto != null) {
			carrito.add(producto);
		}

		response.sendRedirect("carrito.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
