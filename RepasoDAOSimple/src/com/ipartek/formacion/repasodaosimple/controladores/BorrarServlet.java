package com.ipartek.formacion.repasodaosimple.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.repasodaosimple.dao.CasaDaoMySQL;
import com.ipartek.formacion.repasodaosimple.modelos.Alerta;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recibir información de pantalla
		String sId = request.getParameter("id");
		
		// 2. Empaquetar la información en objetos
		Long id = Long.parseLong(sId);
		
		// 3. Llamada a lógica de negocio o capa de acceso a datos en este caso
		HttpSession session = request.getSession();
		
		try {
			CasaDaoMySQL.borrar(id);
			
			session.setAttribute("alerta",
					new Alerta("success", "Se ha borrado correctamente el registro"));
		} catch (Exception e) {
			session.setAttribute("alerta",
					new Alerta("danger", "No se ha podido borrar el registro"));
		}
		
		// 4. Redirección a nueva pantalla
		
		//Envía al navegador un cambio de URL, que provoca que el propio navegador pida la URL
		response.sendRedirect("listado");
		//A diferencia del request.getRequestDispatcher("listado").forward(request, response) que NO modifica la URL del navegador
		//request.getRequestDispatcher("listado").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
