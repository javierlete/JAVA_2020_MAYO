package com.ipartek.formacion.tiendavirtual.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> productos = (List<String>) getServletContext().getAttribute("productos");
		
		if(productos == null) {
			productos = new ArrayList<String>();
			
			productos.add("Patatas");
			productos.add("Manzanas");
			productos.add("Naranjas");
			
			getServletContext().setAttribute("productos", productos);
		}
		
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
