package com.ipartek.formacion.spring.ejemplohibernatespringdata.repositorios;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.ejemplohibernatespringdata.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	List<Producto> findByNombre(String nombre);
	List<Producto> findByPrecioBetween(BigDecimal desde, BigDecimal hasta);
	List<Producto> findByNombreIgualPrecio();
}
