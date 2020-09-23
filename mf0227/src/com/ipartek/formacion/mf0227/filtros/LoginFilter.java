package com.ipartek.formacion.mf0227.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Filtro de autorización de acceso a la carpeta <b><code>/admin</code></b>
 * @author JavierLete
 *
 */
@WebFilter("/admin/*")
public class LoginFilter implements Filter {

	/**
	 * Sólo permite el acceso a usuario <code>administrador</code> a la carpeta <code>/admin</code>
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request; // La request recibida es genérica y no específica para HTTP
		HttpSession session = req.getSession();
		
		String usuario = (String)session.getAttribute("usuario");
		
		if("administrador".equals(usuario)) {
			// Si el usuario está autorizado, permitimos el paso de la petición a su destino
			chain.doFilter(request, response);
		} else {
			// Si el usuario no está autorizado, creamos un objeto de error,
			req.setAttribute("error", "Necesitas estar logueado como administrador para entrar en la parte de administración");
			// y le hacemos un forward a la página principal para que se vuelva a loguear
			req.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { }
	
	public void destroy() {	}

}
