package com.ipartek.formacion.ejemploexportarcsvservlets.modelos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

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
	private static final long serialVersionUID = 1L;
       
//	private static final String URL = "jdbc:mysql://localhost:3306/gestiondocente";
//	private static final String USUARIO = "debian-sys-maint";
//	private static final String PASSWORD = "o8lAkaNtX91xMUcV";
//
//	private static final String SQL = "SELECT codigo, nombre, apellidos, email FROM alumno";
	
//	https://stackoverflow.com/questions/2422468/how-to-upload-files-to-server-using-jsp-servlet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filePart = request.getPart("ficherocsv"); // Retrieves <input type="file" name="file">
	    String fichero = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream contenido = filePart.getInputStream();
	    
	    byte[] buffer = new byte[contenido.available()];
	    contenido.read(buffer);
	 
	    File targetFile = new File(getServletContext().getRealPath("/") + "/WEB-INF/uploads/" + fichero);
	    try (OutputStream outStream = new FileOutputStream(targetFile)) {
			outStream.write(buffer);
		}
	    
//	    response.getWriter().println(fichero);
//	    
//	    try (Scanner s = new Scanner(contenido)) {
//			String linea;
//			while( (linea = s.nextLine()) != null) {
//				response.getWriter().println(linea);
//			}
//		}
	}
}
