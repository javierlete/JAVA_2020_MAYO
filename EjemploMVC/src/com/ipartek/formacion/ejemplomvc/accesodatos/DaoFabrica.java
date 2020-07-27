package com.ipartek.formacion.ejemplomvc.accesodatos;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

public class DaoFabrica {
	private String tipo;
	private String url;
	private String usuario;
	private String password;
	
	//SINGLETON
	private DaoFabrica() {
		Properties prop = new Properties();
		
		InputStream is = null;
		try {
			is = DaoFabrica.class.getClassLoader().getResourceAsStream("dao.properties");
			prop.load(is);
			
			tipo = prop.getProperty("dao.tipo");
			url = prop.getProperty("dao.url");
			usuario = prop.getProperty("dao.usuario");
			password = prop.getProperty("dao.password");
			
		} catch (IOException e) {
			throw new AccesoDatosException("No se ha podido leer el fichero de configuración", e);
		} finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					throw new AccesoDatosException("No se ha podido CERRAR el fichero de configuración", e);
				}
			}
		}
	}
	
	private static DaoFabrica instancia = new DaoFabrica();
	
	public static DaoFabrica getInstancia() {
		return instancia;
	}
	//FIN SINGLETON
	
	public Dao<Usuario> getDaoUsuario() {
		switch(tipo) {
		case "map": return UsuarioMapDao.getInstancia();
		//case "mysql": return UsuarioMySqlDao.getInstancia();
		default: throw new AccesoDatosException("No dispongo de ese dao");
		}
	}
}
