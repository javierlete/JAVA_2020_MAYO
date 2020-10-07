package com.ipartek.formacion.ejemplorest.apirest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	// GET http://localhost:8081/ejemplorest/api/muebles --> TODOS los muebles
	// GET http://localhost:8081/ejemplorest/api/muebles/3 --> Mueble cuyo id es el
	// 3
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String id = obtenerId(request); // /api/muebles/3 -> 3 /api/muebles -> null

		log.info("id = " + id); // log.log(Level.INFO, "id = " + id);

		if (id == null) {
			// TODOS
			ArrayList<Mueble> muebles = MuebleDAO.obtenerTodos();

			log.info(muebles.toString());

			String jsonMuebles = gson.toJson(muebles); // Objeto JAVA -> JSON

			response.getWriter().println(jsonMuebles);
		} else {
			// Mueble por id
			Mueble mueble = MuebleDAO.obtenerPorId(Long.parseLong(id));

			if (mueble != null) {
				log.info(mueble.toString());

				String jsonMueble = gson.toJson(mueble);

				response.getWriter().println(jsonMueble);
			} else {
				log.info("No se ha encontrado el mueble");

				response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
			}

		}
	}

	// POST http://localhost:8081/ejemplorest/api/muebles
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Mueble mueble = gson.fromJson(request.getReader(), Mueble.class); // JSON -> Objeto JAVA

		MuebleDAO.insertar(mueble);

		response.setStatus(HttpServletResponse.SC_CREATED); // 201
	}

	// PUT http://localhost:8081/ejemplorest/api/muebles/3
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Mueble mueble = gson.fromJson(request.getReader(), Mueble.class);

		MuebleDAO.modificar(mueble);
	}

	// DELETE http://localhost:8081/ejemplorest/api/muebles/3
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = obtenerId(request);

		MuebleDAO.borrar(Long.parseLong(id));

		response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204
	}

	// Patrón que se corresponde con /numero/texto y separa el número del texto y de las barras
	private static final Pattern p = Pattern.compile("^/(\\d+)/?(.*)$");

	// Devuelve el id pasado por URL, y si no hay, null P.e.: /api/muebles/5 -> 5
	private String obtenerId(HttpServletRequest request) {
		return buscarDatoUrl(request, 1);
	}

	// Devuelve la subruta detrás del id P.e.: /api/muebles/5/resenas -> resenas
	private String obtenerSubPath(HttpServletRequest request) {
		String subPath = buscarDatoUrl(request, 2);
		return subPath != null && subPath.trim().length() > 0 ? subPath : null;
	}

	private String buscarDatoUrl(HttpServletRequest request, int posicion) {
		String id = null;

		if (request.getPathInfo() != null) {
			Matcher m = p.matcher(request.getPathInfo());

			if (m.find()) {
				id = m.group(posicion);
			}
		}
		
		return id;
	}

	// Usamos OPTIONS en este caso para poder probar cosas desde Insomnia
	@Override
	protected void doOptions(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().println(obtenerId(request));

		response.getWriter().println(obtenerSubPath(request));
	}

}
