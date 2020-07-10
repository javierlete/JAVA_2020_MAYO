package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email == null || password == null) {
			//response.setStatus(Response.SC_BAD_REQUEST);
			response.sendRedirect("error.jsp");
			return;
		}
		
		if(!"javierlete@email.net".equals(email) || !"contra".equals(password)) {
			request.setAttribute("error", "El usuario o la password no son correctas");
			//response.sendRedirect("login.jsp");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("email", email);
		response.sendRedirect("principal.jsp");
//		response.getWriter().println(email);
//		response.getWriter().println(password);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
