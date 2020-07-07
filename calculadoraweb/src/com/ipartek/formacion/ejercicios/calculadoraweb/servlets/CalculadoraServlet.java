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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// Extraer toda la información recibida que necesitamos
		String op1 = request.getParameter("op1");
		String op2 = request.getParameter("op2");
		String op = request.getParameter("op");

		PrintWriter out = response.getWriter();

		Double res = null;
		
		if (op1 != null && op2 != null && op != null) {
			Double i1 = Double.parseDouble(op1);
			Double i2 = Double.parseDouble(op2);

			

			switch (op) {
			case "+":
				res = i1 + i2;
				break;
			case "-":
				res = i1 - i2;
				break;
			case "x":
				res = i1 * i2;
				break;
			case "/":
				res = i1 / i2;
				break;
			}

		}
		
		DecimalFormat df = new DecimalFormat("#0.00");

		out.println("<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Calculadora</title>\n"
				+ "<style>\n"
				+ "	input {\n"
				+ "		width: 4em;\n"
				+ "	}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body>\n"
				+ "<form action=\"calculadora\">\n"
				+ "		<input type=\"number\" step=\".01\" name=\"op1\" value=\"" + (op1 != null ? op1 : "") + "\" />\n"
				+ "		<select name=\"op\">\n"
				+ "			<option " + ("+".equals(op) ? "selected" : "") + ">+</option>\n"
				+ "			<option " + ("-".equals(op) ? "selected" : "") + ">-</option>\n" 
				+ "			<option " + ("x".equals(op) ? "selected" : "") + ">x</option>\n"
				+ "			<option " + ("/".equals(op) ? "selected" : "") + ">/</option>\n"
				+ "		</select>\n"
				+ "		<input type=\"number\" name=\"op2\" step=\".01\" value=\"" + (op2 != null ? op2 : "") + "\"  />\n"
				+ "		<button>=</button>\n" + (res != null ? df.format(res) : "") 
				+ "	</form>\n"
				+ "</body>\n"
				+ "</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
