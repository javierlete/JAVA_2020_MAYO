package com.ipartek.formacion.uf2406.ejercicio2.controladores;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.ejercicio2.modelos.Producto;

@WebServlet("/listadoproductos")
public class ListadoProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		TreeMap<Long, Producto> productos = (TreeMap<Long, Producto>) request.getSession().getAttribute("productos"); //getServletContext().getAttribute("productos");
		
		if(productos == null) {
			productos = new TreeMap<>();
			
			productos.put(111L, new Producto(111L, "motores", "34347"));
			productos.put(222L, new Producto(222L, "escoba", "760"));
			productos.put(333L, new Producto(333L, "lapiz", "123"));
			productos.put(444L, new Producto(444L, "goma", "224"));
			productos.put(555L, new Producto(555L, "papel", "322"));
			
			//getServletContext().setAttribute("productos", productos);
			request.getSession().setAttribute("productos", productos);
		}
		
		response.sendRedirect("listadoproductos.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
