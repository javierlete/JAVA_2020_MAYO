package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
