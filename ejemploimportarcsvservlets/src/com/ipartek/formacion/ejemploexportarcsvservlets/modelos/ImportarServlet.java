package com.ipartek.formacion.ejemploexportarcsvservlets.modelos;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/csv")
@MultipartConfig // Necesario para recibir contenido de un enctype="multipart/form-data"
public class ImportarServlet extends HttpServlet {
	private static final boolean NO_AUTO_COMMIT = false;

	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:mysql://localhost:3306/gestiondocente";
	private static final String USUARIO = "debian-sys-maint";
	private static final String PASSWORD = "o8lAkaNtX91xMUcV";

	private static final String SQL_INSERT = "INSERT INTO alumno (codigo, nombre, apellidos, email, telefono, dni) VALUES (?,?,?,?,?,?)";

//	https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part filePart = request.getPart("ficherocsv"); // Retrieves <input type="file" name="file">
//	    String fichero = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		InputStream contenido = filePart.getInputStream();

//	    byte[] buffer = new byte[contenido.available()];
//	    contenido.read(buffer);
//	 
//	    File targetFile = new File(getServletContext().getRealPath("/") + "/WEB-INF/uploads/" + fichero);
//	    try (OutputStream outStream = new FileOutputStream(targetFile)) {
//			outStream.write(buffer);
//		}

//	    PrintWriter out = response.getWriter();
//		out.println(fichero);

		Alumno alumno;

		List<Alumno> alumnos = new ArrayList<>();

		try (Scanner s = new Scanner(contenido)) {
			s.nextLine();

			String linea;
			while (s.hasNext()) {
				linea = s.nextLine();
//				out.println(linea);

				String[] datos = linea.split(";");

				alumno = new Alumno();

				alumno.setCodigo(Long.parseLong(datos[0]));
				alumno.setNombre(datos[1].replaceAll("\"", ""));
				alumno.setApellidos(datos[2].replaceAll("\"", ""));
				alumno.setEmail(datos[3].replaceAll("\"", ""));

//				out.println(alumno);

				alumnos.add(alumno);
			}
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}

		try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {
			try (PreparedStatement ps = con.prepareStatement(SQL_INSERT)) {

				con.setAutoCommit(NO_AUTO_COMMIT); // Inicia la transacción

				for (Alumno a : alumnos) {
					ps.setObject(1, null);
					// ps.setLong(1, a.getCodigo());
					ps.setString(2, a.getNombre());
					ps.setString(3, a.getApellidos());
					ps.setString(4, a.getEmail());
					ps.setLong(5, 0L);
					ps.setString(6, a.getCodigo().toString());

					ps.executeUpdate();
				}

				con.commit(); // Confirma la transacción
			} catch (SQLException e) {
				con.rollback(); // Deshace la transacción
				throw new ServletException(e);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}
}
