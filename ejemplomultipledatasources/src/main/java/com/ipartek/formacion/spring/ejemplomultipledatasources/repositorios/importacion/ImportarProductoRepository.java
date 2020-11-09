package com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.importacion;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.ejemplomultipledatasources.modelos.Producto;

public interface ImportarProductoRepository extends CrudRepository<Producto, Long> {

}
