package com.ipartek.formacion.ejemplomvc.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

@WebServlet("/admin/usuario")
public class AdminUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null) {
			@SuppressWarnings("unchecked")
			Map<Long, Usuario> usuarios = (Map<Long, Usuario>) getServletContext().getAttribute("usuariosmap");
			
			Usuario usuario = usuarios.get(Long.parseLong(id));
			
			request.setAttribute("usuario", usuario);
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		@SuppressWarnings("unchecked")
		TreeMap<Long, Usuario> usuarios = (TreeMap<Long, Usuario>) getServletContext().getAttribute("usuariosmap");
		
		Usuario usuario;
		Long id;
		
		if(sid.length() == 0) { // Si no recibo ningún ID, es que quiero añadir el usuario
			id = usuarios.lastKey() + 1L;
		} else {
			id = Long.parseLong(sid);
		}
		
		usuario = new Usuario(id, email, password);
		usuarios.put(usuario.getId(), usuario);
		
		response.sendRedirect("index");
	}

}

















