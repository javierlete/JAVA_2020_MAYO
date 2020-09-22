package com.ipartek.formacion.mf0227.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		if(usuario == null || usuario.trim().length() == 0) {
			request.setAttribute("errorUsuario", "El usuario no puede estar vacío");
		}
		
		if(password == null || password.trim().length() == 0) {
			request.setAttribute("errorPassword", "La contraseña no puede estar vacía");
		}
		
		if("administrador".equals(usuario) && "123456".equals(password)) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("admin/index.html");
		} else {
			request.setAttribute("error", "El usuario o la contraseña son incorrectos");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
