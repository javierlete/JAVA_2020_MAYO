package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "lineas_facturas")
public class LineaFactura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Integer cantidad;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@NotNull
//	private Factura factura;
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Producto producto;
}
