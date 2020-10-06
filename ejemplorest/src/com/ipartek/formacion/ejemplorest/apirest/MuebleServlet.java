package com.ipartek.formacion.ejemplorest.apirest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ipartek.formacion.ejemplorest.accesodatos.MuebleDAO;
import com.ipartek.formacion.ejemplorest.modelos.Mueble;

@WebServlet("/api/muebles/*")
public class MuebleServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger("REST_MUEBLES");

	private static final long serialVersionUID = 1L;

	private static final Gson gson = new Gson();

	// GET http://localhost:8081/ejemplorest/api/muebles   --> TODOS los muebles
	// GET http://localhost:8081/ejemplorest/api/muebles/3 --> Mueble cuyo id es el 3
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String id = obtenerId(request); // /api/muebles/3 -> 3   /api/muebles -> null

		log.info("id = " + id); //log.log(Level.INFO, "id = " + id);
		
		if (id == null) {
			// TODOS
			ArrayList<Mueble> muebles = MuebleDAO.obtenerTodos();
			
			log.info(muebles.toString());
			
			String jsonMuebles = gson.toJson(muebles); // Objeto JAVA -> JSON
			
			response.getWriter().println(jsonMuebles);
		} else {
			// Mueble por id
			Mueble mueble = MuebleDAO.obtenerPorId(Long.parseLong(id));
			
			log.info(mueble != null ? mueble.toString() : "No se ha encontrado el mueble");
			
			String jsonMueble = gson.toJson(mueble);
			
			response.getWriter().println(jsonMueble);
		}
	}

	// POST http://localhost:8081/ejemplorest/api/muebles
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Mueble mueble = gson.fromJson(request.getReader(), Mueble.class); // JSON -> Objeto JAVA
		
		MuebleDAO.insertar(mueble);
	}

	// PUT http://localhost:8081/ejemplorest/api/muebles/3
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Mueble mueble = gson.fromJson(request.getReader(), Mueble.class);
		
		MuebleDAO.modificar(mueble);
	}

	// DELETE http://localhost:8081/ejemplorest/api/muebles/3
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = obtenerId(request);
		
		MuebleDAO.borrar(Long.parseLong(id));
	}
	
	// Extraer del pathInfo el id, si no se encuentra null
	private String obtenerId(HttpServletRequest request) {
		String id = null;
		
		String pathInfo = request.getPathInfo();
		
		log.info(pathInfo);
		
		if(pathInfo != null && pathInfo.trim().length() != 0) {
			id = pathInfo.substring(1);
		}
		
		return id;
	}
}
