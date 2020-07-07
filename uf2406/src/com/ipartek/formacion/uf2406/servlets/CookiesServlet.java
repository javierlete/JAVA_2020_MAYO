package com.ipartek.formacion.uf2406.servlets;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		Cookie[] cookies = request.getCookies();

		PrintWriter out = response.getWriter();

		out.println("<ul>");
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				out.println("<li>");
				out.append(cookie.getName());
				out.append(" = ");
				out.append(cookie.getValue());
				out.println("</li>");
			}
		}
		out.println("</ul>");
		out.println("<a href='cookies.html'>Introducir una nueva cookie</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie = new Cookie(request.getParameter("clave"), request.getParameter("valor"));

		cookie.setMaxAge(60*5); //Caducidad en 5 minutos
		//Para borrar una cookie, enviarla con un setMaxAge(0)
		
		response.addCookie(cookie);

		response.sendRedirect("cookies");
	}
}
