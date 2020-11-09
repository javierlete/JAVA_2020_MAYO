package com.ipartek.formacion.spring.ejemplohibernatespringdata.repositorios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.spring.ejemplohibernatespringdata.entidades.Producto;

@Repository
@Primary
public class ProductoRepositoryImpl implements ProductoRepository {
	private TreeMap<Long, Producto> productos = new TreeMap<>();

	public ProductoRepositoryImpl() {
//		productos.put(1L, new Producto(1L, "Memoria1", new BigDecimal("1111")));
//		productos.put(2L, new Producto(2L, "Memoria2", new BigDecimal("2112")));
//		productos.put(3L, new Producto(3L, "Memoria3", new BigDecimal("3113")));
//		productos.put(4L, new Producto(4L, "Memoria4", new BigDecimal("114")));
	}

	@Override
	public <S extends Producto> S save(S entity) {
		if (entity.getId() == null) {
			Long id = productos.size() > 0 ? productos.lastKey() + 1L : 0L;
			entity.setId(id);
		}
		
		productos.put(entity.getId(), entity);
		
		return entity;
	}

	@Override
	public <S extends Producto> Iterable<S> saveAll(Iterable<S> entities) {
		for (Producto producto : entities) {
			save(producto);
		}
		return entities;
	}

	@Override
	public Optional<Producto> findById(Long id) {
		return Optional.of(productos.get(id));
	}

	@Override
	public boolean existsById(Long id) {
		return productos.containsKey(id);
	}

	@Override
	public Iterable<Producto> findAll() {
		return productos.values();
	}

	@Override
	public Iterable<Producto> findAllById(Iterable<Long> ids) {
		ArrayList<Producto> respuesta = new ArrayList<>();

		for (Long id : ids) {
			respuesta.add(productos.get(id));
		}

		return respuesta;
	}

	@Override
	public long count() {
		return productos.size();
	}

	@Override
	public void deleteById(Long id) {
		productos.remove(id);
	}

	@Override
	public void delete(Producto entity) {
		productos.remove(entity.getId(), entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Producto> entities) {
		for (Producto producto : entities) {
			productos.remove(producto.getId());
		}
	}

	@Override
	public void deleteAll() {
		productos.clear();
	}

	@Override
	public List<Producto> findByNombre(String nombre) {
		ArrayList<Producto> respuesta = new ArrayList<>();

		for (Producto producto : productos.values()) {
			if (producto.getNombre().equals(nombre)) {
				respuesta.add(producto);
			}
		}

		return respuesta;
	}

	@Override
	public List<Producto> findByPrecioBetween(BigDecimal desde, BigDecimal hasta) {
		ArrayList<Producto> respuesta = new ArrayList<>();

		for (Producto producto : productos.values()) {
			if (producto.getPrecio().compareTo(desde) > 0 && producto.getPrecio().compareTo(hasta) < 0) {
				respuesta.add(producto);
			}
		}

		return respuesta;
	}

	@Override
	public List<Producto> findByNombreIgualPrecio() {
		ArrayList<Producto> respuesta = new ArrayList<>();

		for (Producto producto : productos.values()) {
			if (producto.getNombre().equals(producto.getPrecio().toString())) {
				respuesta.add(producto);
			}
		}

		return respuesta;
	}

}
