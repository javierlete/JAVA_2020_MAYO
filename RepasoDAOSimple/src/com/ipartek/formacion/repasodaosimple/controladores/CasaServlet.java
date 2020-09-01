package com.ipartek.formacion.repasodaosimple.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.repasodaosimple.dao.CasaDaoMySQL;
import com.ipartek.formacion.repasodaosimple.modelos.Casa;

@WebServlet("/casa")
public class CasaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/casa.jsp").forward(request, response);
	}

	// <form method="post">
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Recepción de datos formulario");
		
		// 1. Recoger la información de pantalla
		
		// request.getParameter("provincia") -> <input name="provincia">
		String provincia = request.getParameter("provincia");
		String codigoPostal = request.getParameter("codigopostal");
		String direccion = request.getParameter("direccion");
		String numero = request.getParameter("numero");
		String piso = request.getParameter("piso");
		String puerta = request.getParameter("puerta");
		
		// 2. Empaquetarla en un objeto
		
		Casa casa = new Casa(null, provincia, codigoPostal, direccion, numero, piso, puerta);
		
		// 3. Tomar decisiones con respecto a los datos recibidos
		
		CasaDaoMySQL.insertar(casa);
		
		// 3. Redireccionar a la siguiente vista
		
		request.getRequestDispatcher("listado").forward(request, response);
	}

}
