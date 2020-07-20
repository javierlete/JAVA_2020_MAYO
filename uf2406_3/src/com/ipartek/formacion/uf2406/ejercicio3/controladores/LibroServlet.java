package com.ipartek.formacion.uf2406.ejercicio3.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2406.ejercicio3.accesodatos.Dao;
import com.ipartek.formacion.uf2406.ejercicio3.accesodatos.LibroListDao;
import com.ipartek.formacion.uf2406.ejercicio3.modelos.Libro;

@WebServlet("/libros")
public class LibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Dao<Libro> dao = LibroListDao.getInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> libros = dao.obtenerTodos();
		
		request.setAttribute("libros", libros);
		
		request.getRequestDispatcher("libros.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro libro = new Libro("3", "Libro3", "333", "30");
		
		if(libro.isCorrecto()) {
			dao.insertar(libro);
			response.sendRedirect("libros");
		} else {
			request.setAttribute("libro", libro);
			request.setAttribute("libros", dao.obtenerTodos());
			request.getRequestDispatcher("libros.jsp").forward(request, response);
		}
	}

}
