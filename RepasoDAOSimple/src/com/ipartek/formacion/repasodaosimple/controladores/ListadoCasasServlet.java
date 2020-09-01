package com.ipartek.formacion.repasodaosimple.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.repasodaosimple.modelos.Casa;

@WebServlet("/listado")
public class ListadoCasasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Cualquier petición por URL o <form> o <form method="get"> llega a doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Casa> casas = new ArrayList<>();
		
		casas.add(new Casa(1L, "Bizkaia", "48000", "Gran Vía", "5B", "3", "Izquierda"));
		casas.add(new Casa(2L, "Araba", "28000", "Autonomía", "20", "Bajo", "3ª"));
		
		request.setAttribute("casas", casas);
		
		//Es importante fijarse en que sólo el objeto requestDispatcher no hace nada
		//Es necesario utilizar un forward para reenviar la petición al index.jsp
		
		//Si sólo hiciéramos request.getRequestDispatcher("index.jsp"); obtendríamos una página en blanco sin ningún error
		request.getRequestDispatcher("WEB-INF/vistas/index.jsp").forward(request, response);
	}

	// Peticiones que llegan de <form method="post">
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
