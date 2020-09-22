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

@WebFilter("/admin/*")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuario = (String)session.getAttribute("usuario");
		
		if("administrador".equals(usuario)) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("error", "Necesitas estar logueado como administrador para entrar en la parte de administración");
			req.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException { }
	
	public void destroy() {	}

}
