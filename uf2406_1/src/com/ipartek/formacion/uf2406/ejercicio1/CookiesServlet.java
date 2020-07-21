package com.ipartek.formacion.uf2406.ejercicio1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookies")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nombre = request.getParameter("nombre");
		String color = request.getParameter("color");
		
		response.addCookie(new Cookie("nombre", nombre));
		response.addCookie(new Cookie("color", color));
		
		out.println("Se ha guardado nombre = " + nombre + ", color = " + color);
		
		out.println("Cookies almacenadas:");
		
		for(Cookie cookie: request.getCookies()) {
			out.println("Se ha recibido " + cookie.getName() + " = " + cookie.getValue());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
