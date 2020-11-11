package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "lineas_facturas")
public class LineaFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Integer cantidad;
	
	@ManyToOne
	@NotNull
	private Factura factura;
	@ManyToOne
	@NotNull
	private Producto producto;
}
