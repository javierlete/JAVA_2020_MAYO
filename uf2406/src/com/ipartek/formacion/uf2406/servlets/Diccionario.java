package com.ipartek.formacion.uf2406.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/diccionario")
public class Diccionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		TreeMap<String, String> diccionario = new TreeMap<>();
		
		diccionario.put("Casa", "Home");
		diccionario.put("Persona", "Person");
		diccionario.put("Coche", "Car");
		
		out.println(diccionario.get("Persona"));
		
		for(java.util.Map.Entry<String, String> par: diccionario.entrySet()) {
			out.print(par.getKey());
			out.print(",");
			out.println(par.getValue());
		}
		
		request.setAttribute("diccionario", diccionario);
		
		request.getRequestDispatcher("diccionario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
