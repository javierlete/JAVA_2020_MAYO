package com.ipartek.formacion.mf0227.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0227.modelo.Login;

/**
 * Controlador de los datos de login para autenticación
 * 
 * Se accede a través de la url <b><code>/login<code></b>
 * 
 * Sólo admite peticiones POST
 * @author JavierLete
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recogemos los datos del formulario
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		// Creamos un objeto que los encapsula
		Login login = new Login(null, usuario, password); 
		// Este constructor acaba llamando a los setter y validando todo el objeto, incluyendo establecer todos los errores de cada campo
	
		// Analizamos los datos para reaccionar en consecuencia
		if("administrador".equals(usuario) && "123456".equals(password)) {
			// Si el usuario es correcto, lo almacenamos en sesión
			request.getSession().setAttribute("usuario", usuario);
			// y le redireccionamos directamente a la página de administración
			response.sendRedirect("admin/index.html");
		} else {
			// Si el usuario es incorrecto, le enviamos el objeto que representa toda la información visual,
			request.setAttribute("login", login);
			// enviamos el error para la alerta,
			request.setAttribute("error", "Las credenciales introducidas son incorrectas");
			// y hacemos un forward a la página de login (index.jsp)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
