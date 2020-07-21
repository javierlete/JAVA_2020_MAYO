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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Dao<Usuario> dao = UsuarioMapDao.getInstancia();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = null;
		
		for(Usuario u: dao.obtenerTodos()) {
			if(u.getEmail().equals(email)) {
				usuario = u;
				break;
			}
		}
		
		if(usuario != null && usuario.getPassword().equals(password)) {
			request.getSession().setAttribute("email", email);
			
			response.sendRedirect(request.getContextPath() + "/admin/index");
		} else {
			request.setAttribute("email", email);
			request.setAttribute("alertanivel", "danger");
			request.setAttribute("alertamensaje", "Usuario o contraseña incorrectos");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

}
