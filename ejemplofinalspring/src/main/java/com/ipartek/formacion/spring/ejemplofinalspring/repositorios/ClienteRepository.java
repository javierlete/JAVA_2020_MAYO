package com.ipartek.formacion.spring.ejemplofinalspring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.spring.ejemplofinalspring.entidades.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
