package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/saludar")
public class SaludarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String nombre = request.getParameter("nombre");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html lang='es'><head><title>Saludo</title></head><body><h1>");
		out.println("Hola " + nombre);
		out.println("</h1><form action='saludar'><input name='nombre' placeholder='nombre' value='" + nombre + "' /><button>Aceptar</button></form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
