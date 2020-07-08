package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	private static final int UN_DIA = 60 * 60 * 24;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html"); // Establecemos la respuesta como HTML para el navegador

		PrintWriter out = response.getWriter(); // Establecemos un canal de salida hacia el navegador

		String usuario = null;

		usuario = getCookie(request, "usuario"); // Obtenemos el valor de la cookie cuya clave es "usuario"

		// Mandamos las siguientes líneas al navegador
		out.println("<h1>");
		out.println("Hola " + (usuario != null ? usuario : "DESCONOCIDO"));
		out.println("</h1>");
	}

	private String getCookie(HttpServletRequest request, String clave) throws UnsupportedEncodingException {
		Cookie[] cookies = request.getCookies(); // Obtenemos la colección de cookies recibidas desde el navegador

		if (cookies != null) { // Comprobamos si realmente había una colección
			for (Cookie cookie : cookies) { // Por cada cookie dentro de las cookies
				if (clave.equals(cookie.getName())) { // comprobamos si el nombre del la cookie es igual que la clave que nos han dado como argumento
					return URLDecoder.decode(cookie.getValue(), "UTF-8"); // Decodificamos el valor de la cookie y lo devolvemos si la hemos encontrado
				}
			}
		}

		return null; // En el caso de que no haya colección, o no se encuentre la clave, devolvemos null para indicar que no se ha encontrado
	}

	// <form ... method="post" ...
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // Recibe los parámetros con codificación UTF-8
		
		response.setContentType("text/html"); // Establece la respuesta a HTML
		
		String usuario = request.getParameter("usuario"); // Obtenemos un valor de la petición (por URL o por
															// formulario)
		// <input name="usuario" ...
		// http://.../...?usuario=valor
		// Si no existe, vale null

		if (usuario != null && usuario.trim().length() != 0) { // Compruebo si se ha recibido el parámetro Y tiene algo de contenido
			String valor = URLEncoder.encode(usuario, "UTF-8"); // Codificamos el dato para poder meterlo en una cookie tenga el contenido que tenga
			
			System.out.println(valor); // Visualizamos en la consola del servidor el dato a modo de depuración
			
			Cookie cookie = new Cookie("usuario", valor); // Construimos una cookie con name="usuario" y value=usuario
			cookie.setMaxAge(UN_DIA); // Establecemos la caducidad de la cookie en un día a partir de crearse

			response.addCookie(cookie); // Añadimos la cookie a la respuesta que se envía al navegador

		} else {
			usuario = getCookie(request, "usuario"); // Buscamos una cookie con el nombre "usuario"
		}
		
		usuario = usuario != null ? usuario : "DESCONOCIDO"; // En el caso de que no haya NI parámetro NI cookie, ponemos el texto "DESCONOCIDO" por defecto
		
		response.getWriter().println(usuario); // Mostramos el valor seleccionado (parámetro, cookie, o valor por defecto)
		response.getWriter().println("<a href='cookie'>Mostrar usuario</a>");
		response.getWriter().println("<a href='cookie.html'>Introducir nuevo usuario</a>");

		// response.sendRedirect("cookie"); // Pedimos al navegador que vaya a la URL
		// relativa "cookie"
		// Si la llamada se hace desde http://localhost:8080/uf2406/cookie
		
		
		/*
		 * Para trabajar con Cookies y preferencias en general el proceso de aplicación es el siguiente:
		 * - Si el usuario ha indicado algún PARÁMETRO, esa es la preferencia que se debe aplicar
		 * - Si el usuario NO ha indicado ningún parámetro, pero hay una COOKIE, esa es la preferencia que se debe aplicar
		 * - Si NO hay cookie NI parámetro, entonces VALOR POR DEFECTO
		 */
	}

}
