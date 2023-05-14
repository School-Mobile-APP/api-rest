package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class Direccion implements Serializable{ 
	private static final long serialVersionUID = 1L;
	@Id
	private long dirPk;
	@Column (name="dir_nombre")
	private String dirNombre;
	@Column (name="dir_codigo")
	private String dirCodigo;
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
