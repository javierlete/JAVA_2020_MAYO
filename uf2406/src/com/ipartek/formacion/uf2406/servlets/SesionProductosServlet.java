package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sesionproductos")
public class SesionProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // Para poder recibir caracteres internacionales de los formularios
		response.setContentType("text/html");  // Para devolver HTML en lugar de texto plano
		
		PrintWriter out = response.getWriter(); // Canal de salida a navegador
		
		HttpSession session = request.getSession(); // Obtener el objeto de sesión o crear uno nuevo si no existía (gestiona automáticamente la cookie JSESSIONID)
		
		@SuppressWarnings("unchecked")
		List<String> productos = (List<String>) session.getAttribute("productos"); // Recogemos la lista de productos de la sesión
		
		if(productos == null) { // Si no se había creado
			productos = new ArrayList<>(); // creamos una nueva lista
			session.setAttribute("productos", productos); // y la almacenamos en sesión
		}
		
		String producto = request.getParameter("producto"); // Obtenemos del formulario del campo name="producto"
		
		if(producto != null && producto.trim().length() != 0) { // Si se ha recibido y está rellenado
			productos.add(producto); // Añadimos a la lista de la sesión el producto
		}
		
		out.println("<ul>");
	
		for(String p: productos) {
			out.println("<li>" + p + "</li>");
		}
		
		out.println("</ul>");
		
		out.println("<a href='sesionproductos.html'>Volver al formulario</a>");
		out.println("<a href='sesioncerrar'>Cerrar sesión</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
