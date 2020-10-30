package com.ipartek.formacion.ejemploexportarcsvservlets.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemploexportarcsvservlets.modelos.Alumno;

@WebServlet("/csv")
public class ExportarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:mysql://localhost:3306/gestiondocente";
	private static final String USUARIO = "debian-sys-maint";
	private static final String PASSWORD = "o8lAkaNtX91xMUcV";

	private static final String SQL = "SELECT codigo, nombre, apellidos, email FROM alumno";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Alumno> alumnos = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		try(Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(SQL);) {
			Alumno alumno;
			
			while(rs.next()) {
				alumno = new Alumno();
				
				alumno.setCodigo(rs.getLong("codigo"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setApellidos(rs.getString("apellidos"));
				alumno.setEmail(rs.getString("email"));
				
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
		Date ahora = new Date();

		String fichero = new SimpleDateFormat("yyyyMMdd'T'HHmmss").format(ahora);

		response.setHeader("content-disposition", "attachment;filename =" + fichero + ".csv");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("codigo;nombre;apellidos;email\n");
		
		for(Alumno alumno: alumnos) {
			sb.append(alumno.getCodigo());
			sb.append(";\"");
			sb.append(alumno.getNombre());
			sb.append("\";\"");
			sb.append(alumno.getApellidos());
			sb.append("\";\"");
			sb.append(alumno.getEmail());
			sb.append("\"\n");
		}
		
		response.getWriter().write(sb.toString());
	}
}
