package com.ipartek.formacion.ejemplorest.apirest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.ejemplorest.accesodatos.MuebleDAO;
import com.ipartek.formacion.ejemplorest.modelos.Mueble;

@WebServlet("/api/muebles")
public class MuebleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");

		if (id == null) {
			response.getWriter().println(gson.toJson(MuebleDAO.obtenerTodos()));
		} else {
			response.getWriter().println(gson.toJson(MuebleDAO.obtenerPorId(Long.parseLong(id))));
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MuebleDAO.insertar(gson.fromJson(request.getReader(), Mueble.class));
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MuebleDAO.modificar(gson.fromJson(request.getReader(), Mueble.class));
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		MuebleDAO.borrar(Long.parseLong(id));
	}
}
