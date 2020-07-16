package com.ipartek.formacion.ejemplomvc.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

@WebServlet("/admin/borrar")
public class AdminBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		Long id = Long.parseLong(sid);
		
		@SuppressWarnings("unchecked")
		Map<Long, Usuario> usuarios = (Map<Long, Usuario>) getServletContext().getAttribute("usuariosmap");
		
		// Java 8: no existe en versiones anteriores.
		//usuarios.removeIf( usuario -> usuario.getId() == elId );
		
		usuarios.remove(id);
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
