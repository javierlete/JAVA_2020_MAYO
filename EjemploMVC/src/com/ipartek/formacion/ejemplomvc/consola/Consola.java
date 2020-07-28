package com.ipartek.formacion.ejemplomvc.consola;

import com.ipartek.formacion.ejemplomvc.accesodatos.Dao;
import com.ipartek.formacion.ejemplomvc.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

public class Consola {
	public static void main(String[] args) {
		mostrarEmailPrimero();
		insertarNuevoUsuario();
		mostrarUsuarios();
	}

	private static void insertarNuevoUsuario() {
		DaoFabrica fabrica = DaoFabrica.getInstancia();

		Dao<Usuario> dao = fabrica.getDaoUsuario();

		dao.insertar(new Usuario(5L, "NUEVO", "NUEVO"));

		System.out.println("Dentro");

		Iterable<Usuario> usuarios = dao.obtenerTodos();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}

		System.out.println("FIN DENTRO");
	}

	private static void mostrarEmailPrimero() {
		DaoFabrica fabrica = DaoFabrica.getInstancia();

		Dao<Usuario> dao = fabrica.getDaoUsuario();

		Usuario primero = dao.obtenerPorId(1L); // El objeto resultante de hacer dao.obtenerPorId(1L) se almacena en la
												// variable primero de tipo Usuario

		System.out.println(primero.getEmail());
	}

	private static void mostrarUsuarios() {
		DaoFabrica fabrica = DaoFabrica.getInstancia();

		Dao<Usuario> dao = fabrica.getDaoUsuario();

		Iterable<Usuario> usuarios = dao.obtenerTodos();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}
	}

	public static void mainOriginal(String[] args) {
		DaoFabrica fabrica = DaoFabrica.getInstancia();
		Dao<Usuario> dao = fabrica.getDaoUsuario();

		Iterable<Usuario> usuarios = dao.obtenerTodos();

		for (Usuario usuario : usuarios) {
			System.out.println(usuario);
		}

		Usuario primero = dao.obtenerPorId(1L);

		System.out.println(primero.getEmail());
	}
}
