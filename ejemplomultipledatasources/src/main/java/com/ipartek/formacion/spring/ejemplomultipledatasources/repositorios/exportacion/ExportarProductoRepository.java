package com.ipartek.formacion.spring.ejemplomultipledatasources.repositorios.exportacion;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.ejemplomultipledatasources.modelos.Producto;

public interface ExportarProductoRepository extends CrudRepository<Producto, Long> {

}
