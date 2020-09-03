package com.ipartek.formacion.repasodaosimple.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.repasodaosimple.dao.CasaDaoArrayList;

@WebServlet("/listado")
public class ListadoCasasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Cualquier petición por URL o <form> o <form method="get"> llega a doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Guardamos en la variable casas de ámbito request todas las casas
		//Accederemos a ellas en la JSP a través de Expression Language usando ${casas}
		request.setAttribute("casas", CasaDaoArrayList.obtenerTodas());
		
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
