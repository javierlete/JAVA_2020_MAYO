package com.ipartek.formacion.ejemplomvc.listeners;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

/**
 * Application Lifecycle Listener implementation class InicioAplicacionListener
 *
 */
@WebListener
public class InicioAplicacionListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		// NO lo utilizamos, pero es obligatorio tenerlo para cumplir con el
		// ServletContextListener
	}

	public void contextInitialized(ServletContextEvent sce) {
		Map<Long, Usuario> usuarios = new TreeMap<>();

		usuarios.put(1L, new Usuario(1L, "javier@email.net", "contrajavier"));
		usuarios.put(2L, new Usuario(2L, "lete@email.net", "contralete"));

		sce.getServletContext().setAttribute("usuariosmap", usuarios);
		sce.getServletContext().setAttribute("usuarios", usuarios.values());
	}

}
