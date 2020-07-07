package com.ipartek.formacion.ejercicios.calculadoraweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Extraer toda la información recibida que necesitamos
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op = request.getParameter("op");
		
		Double i1 = Double.parseDouble(op1);
		Double i2 = Double.parseDouble(op2);
		
		Double res = null;
		
		switch(op) {
		case "+": res = i1 + i2; break;
		case "-": res = i1 - i2; break;
		case "x": res = i1 * i2; break;
		case "/": res = i1 / i2; break;
		}
		
		DecimalFormat df = new DecimalFormat( "#0.00" );
		
		PrintWriter out = response.getWriter();
		
		if(res != null) {
			out.println(op1 + op + op2 + "=" + df.format(res));
		} else {
			out.println("No se ha podido realizar la operación " + op);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
