package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<String> productos = (List<String>) getServletContext().getAttribute("productos");
		
		if(productos == null) {
			productos = new ArrayList<String>();
			
			productos.add("Patatas");
			productos.add("Manzanas");
			productos.add("Naranjas");
			
			getServletContext().setAttribute("productos", productos);
		}
		
		response.sendRedirect("principal.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
