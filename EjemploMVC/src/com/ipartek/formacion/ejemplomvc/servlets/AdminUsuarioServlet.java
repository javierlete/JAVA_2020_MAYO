package com.ipartek.formacion.ejemplomvc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplomvc.accesodatos.Dao;
import com.ipartek.formacion.ejemplomvc.accesodatos.UsuarioMapDao;
import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

@WebServlet("/admin/usuario")
public class AdminUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static Dao<Usuario> dao = UsuarioMapDao.getInstancia();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		if(id != null) {
			request.setAttribute("usuario", dao.obtenerPorId(Long.parseLong(id)));
		}
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario;
		Long id = null;
		
		if(sid.length() != 0) { // Si recibo un ID, es que quiero modificar un usuario existente
			id = Long.parseLong(sid);
		}
		
		usuario = new Usuario(id, email, password);

		for(Usuario u: dao.obtenerTodos()) {
			if(u.getEmail().equals(email) && u.getId() != id) {
				request.setAttribute("usuario", usuario);
				
				request.setAttribute("alertanivel", "danger");
				request.setAttribute("alertamensaje", "El email introducido ya existe");
				
				request.getRequestDispatcher("/WEB-INF/vistas/admin/usuario.jsp").forward(request, response);
				
				return;
			}
		}
		
		if(usuario.getId() == null) {
			usuario = dao.insertar(usuario);
			
			request.setAttribute("alertamensaje", "El usuario se ha insertado correctamente");
		} else {
			dao.modificar(usuario);
			
			request.setAttribute("alertamensaje", "El usuario se ha modificado correctamente");			
		}
		
		request.setAttribute("alertanivel", "success");
		
		request.getRequestDispatcher("index").forward(request, response);
	}

}

















