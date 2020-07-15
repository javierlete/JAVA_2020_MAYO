package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/parametrosmultiples")
public class ParametrosMultiplesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Enumeration<String> nombres = request.getParameterNames();
		
		String nombre, valor;
		
		while(nombres.hasMoreElements()) {
			nombre = nombres.nextElement();
			valor = request.getParameter(nombre);
			
			out.print(nombre);
			out.print(":");
			out.println(valor);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
