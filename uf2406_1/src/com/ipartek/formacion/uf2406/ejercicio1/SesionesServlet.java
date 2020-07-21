package com.ipartek.formacion.uf2406.ejercicio1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sesiones")
public class SesionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String nombre = request.getParameter("nombre");
		Date fecha = new Date(); //new Date(session.getCreationTime());
		String navegador = request.getHeader("User-Agent");
		
		session.setAttribute("nombre", nombre);
		session.setAttribute("fecha", fecha);
		session.setAttribute("navegador", navegador);
		
		out.println("Datos de sesión:");
		
		Enumeration<String> nombres = session.getAttributeNames();
		
		String name;
		
		while(nombres.hasMoreElements()){
			name = nombres.nextElement();
			out.println("Dato de sesión " + name + " = " + session.getAttribute(name));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
