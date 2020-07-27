package com.ipartek.formacion.ejemplomvc.accesodatos;

import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

public class DaoFabrica {
	private String daoSeleccionado = "map";
	
	//SINGLETON
	private DaoFabrica() {}
	
	private static DaoFabrica instancia = new DaoFabrica();
	
	public static DaoFabrica getInstancia() {
		return instancia;
	}
	//FIN SINGLETON
	
	public Dao<Usuario> getDaoUsuario() {
		switch(daoSeleccionado) {
		case "map": return UsuarioMapDao.getInstancia();
		//case "mysql": return UsuarioMySqlDao.getInstancia();
		default: throw new AccesoDatosException("No dispongo de ese dao");
		}
	}
}
