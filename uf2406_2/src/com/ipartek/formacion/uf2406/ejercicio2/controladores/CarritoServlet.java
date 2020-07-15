package com.ipartek.formacion.uf2406.ejercicio2.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.ejercicio2.modelos.Producto;

@WebServlet("/carrito")
public class CarritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		TreeMap<Long, Producto> productos = (TreeMap<Long, Producto>) request.getSession().getAttribute("productos"); //getServletContext().getAttribute("productos");
		List<Producto> carrito = new ArrayList<>();
		
		Long id = 222L;
		Integer cantidad = 3;
		
		productos.get(id).setCantidad(cantidad);
		
		carrito.add(productos.get(id));
		
		id = 111L;
		cantidad = 2;
		
		productos.get(id).setCantidad(cantidad);
		
		carrito.add(productos.get(id));
		
		request.getSession().setAttribute("carrito", carrito);
		
		response.sendRedirect("carrito.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
