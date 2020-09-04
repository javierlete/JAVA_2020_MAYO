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
import com.ipartek.formacion.repasodaosimple.modelos.Casa;

@WebServlet("/casa")
public class CasaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Recoger la información de request
		String sId = request.getParameter("id");

		if (sId != null) {
			Casa casa = CasaDaoMySQL.obtenerPorId(Long.parseLong(sId));

			request.setAttribute("casa", casa);
		}

		request.getRequestDispatcher("/WEB-INF/vistas/casa.jsp").forward(request, response);
	}

	// <form method="post">
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cambiamos el código de caracteres para aceptar ñ's y otros caracteres no
		// americanos
		request.setCharacterEncoding("UTF-8");
		// response.getWriter().append("Recepción de datos formulario");

		// 1. Recoger la información de pantalla

		// request.getParameter("provincia") -> <input name="provincia">
		String provincia = request.getParameter("provincia");
		String codigoPostal = request.getParameter("codigopostal");
		String direccion = request.getParameter("direccion");
		String numero = request.getParameter("numero");
		String piso = request.getParameter("piso");
		String puerta = request.getParameter("puerta");

		String sId = request.getParameter("id");

		Long id = sId == null || sId.trim().length() == 0 ? null : Long.parseLong(sId);

		// 2. Empaquetarla en un objeto

		Casa casa = new Casa(id, provincia, codigoPostal, direccion, numero, piso, puerta);

		// 3. Tomar decisiones con respecto a los datos recibidos

		if(!casa.isCorrecto()) {
			request.setAttribute("alerta",
					new Alerta("danger", "La casa no es correcta"));
			
			request.setAttribute("casa", casa);
			
			request.getRequestDispatcher("/WEB-INF/vistas/casa.jsp").forward(request, response);
			
			return;
		}
		
		HttpSession session = request.getSession();
		
		if (id == null) {
			try {
				CasaDaoMySQL.insertar(casa);
				
				session.setAttribute("alerta",
						new Alerta("success", "Se ha añadido correctamente el registro"));
			} catch (Exception e) {
				session.setAttribute("alerta",
						new Alerta("danger", "No se ha podido insertar el registro"));
			}
		} else {
			try {
				CasaDaoMySQL.modificar(casa);
				
				session.setAttribute("alerta",
						new Alerta("success", "Se ha modificado correctamente el registro"));
			} catch (Exception e) {
				session.setAttribute("alerta",
						new Alerta("danger", "No se ha podido modificar el registro"));
			}
		}

		// 3. Redireccionar a la siguiente vista
		// Saltamos con redirect para evitar que en una recarga del listado, vuelva a
		// ejecutar la operación de modificación o borrado
		response.sendRedirect("listado");
	}

}
