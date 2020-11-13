package com.ipartek.formacion.spring.ejemplofinalspring.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(min = 3, max = 255)
	private String nombre;
	@Size(max = 255)
	private String apellidos;
	@NotBlank
	@Size(min = 9, max = 9)
	@Column(columnDefinition = "CHAR(9)")
	@Pattern(regexp = "[A-Z\\d]\\d{7}[A-Z\\d]", message = "El CIF del cliente debe tener un formato adecuado y es obligatorio. Por ejemplo: B12345678 ó X1234567A ó 12345678A")
	private String cif;
	
	@OneToMany(mappedBy = "cliente")
	private List<Factura> facturas;
}
