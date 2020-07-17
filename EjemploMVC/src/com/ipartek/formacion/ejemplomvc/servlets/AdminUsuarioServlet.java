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
		Long id = null;
		
		if(sid.length() != 0) { // Si recibo un ID, es que quiero modificar un usuario existente
			id = Long.parseLong(sid);
		}
		
		usuario = new Usuario(id, email, password);

		for(Usuario u: usuarios.values()) {
			if(u.getEmail().equals(email) && u.getId() != id) {
				request.setAttribute("usuario", usuario);
				
				request.setAttribute("alertanivel", "danger");
				request.setAttribute("alertamensaje", "El email introducido ya existe");
				
				request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
				
				return;
			}
		}
		
		if(usuario.getId() == null) {
			usuario.setId(usuarios.lastKey() + 1L);
			
			request.setAttribute("alertamensaje", "El usuario se ha insertado correctamente");
		} else {
			request.setAttribute("alertamensaje", "El usuario se ha modificado correctamente");			
		}
		
		request.setAttribute("alertanivel", "success");
		
		usuarios.put(usuario.getId(), usuario);
		
		request.getRequestDispatcher("index").forward(request, response);
	}

}

















