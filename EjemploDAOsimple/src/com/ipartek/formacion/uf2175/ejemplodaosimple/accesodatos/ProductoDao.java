package com.ipartek.formacion.uf2175.ejemplodaosimple.accesodatos;

import java.sql.*;
import java.util.ArrayList;

import com.ipartek.formacion.uf2175.ejemplodaosimple.modelos.Producto;

public class ProductoDao {
	private final static String url = "jdbc:mysql://localhost:3306/tiendavirtual?serverTimezone=UTC";
	private final static String usuario = "debian-sys-maint";
	private final static String password = "o8lAkaNtX91xMUcV";
	
	private static Connection conectar() throws SQLException {
		return DriverManager.getConnection(url, usuario, password);
	}
	
	public static ArrayList<Producto> obtenerTodos() throws SQLException {
		ArrayList<Producto> productos = new ArrayList<>();
		
		Connection con = conectar();
		
		Statement s = con.createStatement();
		
		ResultSet rs = s.executeQuery("SELECT * FROM productos");
		
		while(rs.next()) {
			productos.add(new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), rs.getString("foto")));
		}
		
		rs.close();
		s.close();
		con.close();
		
		return productos;
	}
	
	public static Producto obtenerPorId(Long id) throws SQLException {
		Producto producto = null;
		
		Connection con = conectar();
		
		PreparedStatement ps = con.prepareStatement("SELECT * FROM productos WHERE id = ?");
		
		ps.setLong(1, id); // Rellena la PRIMERA (1) interrogación de la sentencia con el valor (id)
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			producto = new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"), rs.getString("foto"));
		}
		
		rs.close();
		ps.close();
		con.close();
		
		return producto;
	}
	
	public static void insertar(Producto producto) throws SQLException {
		Connection con = conectar();
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO productos (nombre, precio, foto) VALUES (?, ?, ?)");
		
		ps.setString(1, producto.getNombre());
		ps.setBigDecimal(2, producto.getPrecio());
		ps.setString(3,  producto.getFoto());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public static void modificar(Producto producto) throws SQLException {
		Connection con = conectar();
		
		PreparedStatement ps = con.prepareStatement("UPDATE productos SET nombre = ?, precio = ?, foto = ? WHERE id = ?");
		
		ps.setString(1, producto.getNombre());
		ps.setBigDecimal(2, producto.getPrecio());
		ps.setString(3, producto.getFoto());
		ps.setLong(4, producto.getId());
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
	
	public static void borrar(Long id) throws SQLException {
		Connection con = conectar();
		
		PreparedStatement ps = con.prepareStatement("DELETE FROM productos WHERE id = ?");
		
		ps.setLong(1, id);
		
		ps.executeUpdate();
		
		ps.close();
		con.close();
	}
}




















