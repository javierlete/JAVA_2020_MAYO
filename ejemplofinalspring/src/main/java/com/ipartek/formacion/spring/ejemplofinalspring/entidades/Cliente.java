package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Length(min = 3, max = 255)
	private String nombre;
	@Length(max = 255)
	private String apellidos;
	@NotNull
	@Length(min = 9, max = 9)
	@Column(columnDefinition = "CHAR(9)")
	@Pattern(regexp = "[A-Z\\d]\\d{7}[A-Z\\d]")
	private String cif;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;
}
