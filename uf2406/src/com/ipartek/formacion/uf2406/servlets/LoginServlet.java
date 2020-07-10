package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// CONTROLADOR de Login
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recoger información recibida
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// 2. Llamar a la lógica de negocio (validar en este caso)
		
		if(email == null || password == null) {
			// 4. Enviar a otra página
			//response.setStatus(Response.SC_BAD_REQUEST);
			response.sendRedirect("error.jsp");
			return;
		}
		
		if(!"javierlete@email.net".equals(email) || !"contra".equals(password)) {
			// 3. Preparar información para rellenar la página destino
			request.setAttribute("error", "El usuario o la password no son correctas");
			//response.sendRedirect("login.jsp");
			// 4. Enviar a otra página
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		// 3. Preparar información para rellenar la página destino
		request.getSession().setAttribute("email", email);
		// 4. Enviar a otra página
		response.sendRedirect("principal");
//		response.getWriter().println(email);
//		response.getWriter().println(password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
