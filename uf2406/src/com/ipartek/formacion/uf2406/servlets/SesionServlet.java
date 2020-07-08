package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sesion")
public class SesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // Para poder recibir caracteres internacionales de los formularios
		response.setContentType("text/html");  // Para devolver HTML en lugar de texto plano
		
		PrintWriter out = response.getWriter(); // Canal de salida a navegador
		
		HttpSession session = request.getSession(); // Obtener el objeto de sesión o crear uno nuevo si no existía (gestiona automáticamente la cookie JSESSIONID)
		
		String producto = request.getParameter("producto"); // Obtenemos del formulario del campo name="producto"
		
		if(producto != null && producto.trim().length() != 0) { // Si se ha recibido y está rellenado
			session.setAttribute("producto", producto); // Guardamos en sesión con la clave "producto" el texto del producto
		}
		
		producto = (String) session.getAttribute("producto"); // Obtenemos el valor del producto de sesión
		
		out.println("<h1>Producto: " + producto + "</h1>");
		
		out.println("<a href='sesion.html'>Volver al formulario</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
