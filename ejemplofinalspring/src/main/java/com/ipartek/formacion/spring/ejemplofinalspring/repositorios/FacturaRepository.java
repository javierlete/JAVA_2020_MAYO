package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long> {

}
