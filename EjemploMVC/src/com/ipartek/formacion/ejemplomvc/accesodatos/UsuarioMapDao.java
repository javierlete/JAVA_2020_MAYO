package com.ipartek.formacion.ejemplomvc.accesodatos;

import java.util.Map;
import java.util.TreeMap;

import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

class UsuarioMapDao implements Dao<Usuario> {
	private Map<Long, Usuario> usuarios = new TreeMap<>();
	
	// PATRÓN SINGLETON
	public static UsuarioMapDao getInstancia() { // Método que devuelve la única instancia del objeto que queremos
		return instancia;
	}
	
	private static UsuarioMapDao instancia = new UsuarioMapDao(); // Instancia estática para tener el objeto global que se quiere dar
	
	private UsuarioMapDao() { //Constructor privado para que no sea accesible desde otra clase
		usuarios.put(1L, new Usuario(1L, "javi@email.net", "contrajavi"));
		usuarios.put(2L, new Usuario(2L, "lete@email.net", "contralete"));
	}
	// FIN PATRÓN SINGLETON
	
	@Override
	public Iterable<Usuario> obtenerTodos() {
		return usuarios.values();
	}

	@Override
	public Usuario obtenerPorId(Long id) {
		return usuarios.get(id);
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		Long id = ((TreeMap<Long, Usuario>)usuarios).lastKey() + 1;
		usuario.setId(id);
		usuarios.put(id, usuario);
		
		return usuario;
	}

	@Override
	public void modificar(Usuario usuario) {
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void borrar(Usuario usuario) {
		borrar(usuario.getId());
	}

	@Override
	public void borrar(Long id) {
		usuarios.remove(id);
	}

}
