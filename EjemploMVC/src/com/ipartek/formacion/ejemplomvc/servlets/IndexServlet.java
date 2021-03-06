package com.ipartek.formacion.ejemplomvc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplomvc.accesodatos.Dao;
import com.ipartek.formacion.ejemplomvc.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoFabrica fabrica = DaoFabrica.getInstancia();
		Dao<Usuario> dao = fabrica.getDaoUsuario();
		Iterable<Usuario> usuarios = dao.obtenerTodos();
		
		request.setAttribute("usuarios", usuarios); // DaoFabrica.getInstancia().getDaoUsuario().obtenerTodos());
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
