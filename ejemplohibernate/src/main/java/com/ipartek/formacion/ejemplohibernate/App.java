package com.ipartek.formacion.ejemplohibernate;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ipartek.formacion.ejemplohibernate.entidades.Producto;

public class App {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.ejemplohibernate.entidades");

	public static void main(String[] args) {
		insertar();

		obtenerPorId();
		
		modificarObjetoPedidoAJPA();
		
		modificarObjetoNuevo();
		
		borrar();
		
		obtenerTodos();
	}

	private static void borrar() {
		EntityManager em = iniciarTransaccion();
		
		em.createQuery("delete from Producto p where p.id=:id").setParameter("id", 1L).executeUpdate();
		
		cerrarTransaccion(em);
	}

	private static void modificarObjetoNuevo() {
		EntityManager em = iniciarTransaccion();
		
		Producto producto = new Producto(2L, "Modificado2", new BigDecimal("1234"));
		
		em.merge(producto);
		
		cerrarTransaccion(em);
	}

	private static void cerrarTransaccion(EntityManager em) {
		em.getTransaction().commit();
		
		em.close();
	}

	private static EntityManager iniciarTransaccion() {
		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();
		return em;
	}

	private static void modificarObjetoPedidoAJPA() {
		EntityManager em = iniciarTransaccion();
		
		Producto producto = em.find(Producto.class, 1L);
		
		producto.setNombre("Modificado");
		
		//em.persist(producto);
		
		cerrarTransaccion(em);
	}

	private static void obtenerPorId() {
		EntityManager em = iniciarTransaccion();
		
		Producto producto = em.find(Producto.class, 1L);
		
		System.out.println(producto);
		
		cerrarTransaccion(em);
	}

	private static void insertar() {
		EntityManager em = iniciarTransaccion();

		em.persist(new Producto(null, "Pipas", new BigDecimal("1")));
		em.persist(new Producto(null, "Portátil", new BigDecimal("1000")));

		cerrarTransaccion(em);
	}

	private static void obtenerTodos() {
		EntityManager em = iniciarTransaccion();

		List<Producto> productos = em.createQuery("from Producto", Producto.class).getResultList();

		cerrarTransaccion(em);

		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
}
