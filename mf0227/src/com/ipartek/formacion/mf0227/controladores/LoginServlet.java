package com.ipartek.formacion.mf0227.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0227.modelo.Login;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		Login login = new Login(null, usuario, password);
	
		if("administrador".equals(usuario) && "123456".equals(password)) {
			request.getSession().setAttribute("usuario", usuario);
			response.sendRedirect("admin/index.html");
		} else {
			request.setAttribute("login", login);
			request.setAttribute("error", "Las credenciales introducidas son incorrectas");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
