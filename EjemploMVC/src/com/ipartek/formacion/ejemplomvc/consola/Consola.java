package com.ipartek.formacion.ejemplomvc.consola;

import com.ipartek.formacion.ejemplomvc.accesodatos.Dao;
import com.ipartek.formacion.ejemplomvc.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

public class Consola {

	public static void main(String[] args) {
		Dao<Usuario> dao = DaoFabrica.getInstancia().getDaoUsuario();
		
		Iterable<Usuario> usuarios = dao.obtenerTodos();
		
		for(Usuario usuario: usuarios) {
			System.out.println(usuario);
		}
		
		Usuario primero = dao.obtenerPorId(1L);
		
		System.out.println(primero.getEmail());
	}
}
