package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "facturas")
public class Factura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String numero;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@NotNull
	@Valid
	private Cliente cliente;
	
	@OneToMany // (mappedBy = "factura")
	private Set<LineaFactura> lineas;
}
