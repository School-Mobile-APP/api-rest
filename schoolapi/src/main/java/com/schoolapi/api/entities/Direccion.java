package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sg_direcciones", schema = "catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion implements Serializable{ 
	private static final long serialVersionUID = 1L;
	@Id
	private long dirPk;
	@Column (name="dir_direccion")
	private String dirDireccion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dir_municipio")
	private Municipio municipio;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dir_departamento")
	private Departamento departamento;
	@Column(name="dir_caserio_texto")
	private String dirCaserioTexto;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dir_canton")
	private Canton canton;
}
