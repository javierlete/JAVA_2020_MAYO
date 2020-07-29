package com.ipartek.formacion.uf2175.ejemplodaosimple.controladores;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.formacion.uf2175.ejemplodaosimple.accesodatos.ProductoDao;
import com.ipartek.formacion.uf2175.ejemplodaosimple.modelos.Producto;

@WebServlet("/insertarproducto")
@MultipartConfig
public class InsertarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("producto.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");

			String nombre = request.getParameter("nombre");
			String precio = request.getParameter("precio");
			// String foto = request.getParameter("foto");

			// GUARDAR FOTO EN DIRECTORIO DE PRODUCTOSIMGS
			Part filePart = request.getPart("foto"); // <input type="file" name="foto">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			
			String foto = fileName;
			
			InputStream fileContent = filePart.getInputStream();
			
			File targetFile = new File(getServletContext().getRealPath("/productosimgs/") + foto);
			
			// JAVA < 7
//			OutputStream outStream = new FileOutputStream(targetFile);
//			 
//		    byte[] buffer = new byte[8 * 1024];
//		    int bytesRead;
//		    while ((bytesRead = fileContent.read(buffer)) != -1) {
//		        outStream.write(buffer, 0, bytesRead);
//		    }
//		    
//		    outStream.close();
		    
		    // JAVA >= 7
			java.nio.file.Files.copy(fileContent, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			
			fileContent.close();
			
			// FIN GUARDAR FOTO

			
			Producto producto = new Producto(null, nombre, new BigDecimal(precio), foto);

			ProductoDao.insertar(producto);

			response.sendRedirect("productoslistado");
		} catch (SQLException e) {
			response.getWriter().println("Error al obtener los productos");
			e.printStackTrace(response.getWriter());
		} catch (ClassNotFoundException e) {
			response.getWriter().println("No se ha encontrado la clase de driver de base de datos");
			e.printStackTrace(response.getWriter());
		}
	}
}
