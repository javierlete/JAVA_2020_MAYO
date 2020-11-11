package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "facturas")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String numeroFactura;
	@NotNull
	private LocalDate fecha;
	
	@ManyToOne
	@NotNull
	private Cliente cliente;
	
	@OneToMany(mappedBy = "factura")
	@NotNull
	private Set<LineaFactura> lineas;
}
