package com.schoolapi.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sg_estados_civil",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstadoCivil implements Serializable{ 
	private static final long serialVersionUID = 1L; 
	@Id
	private long eciPk;
	@Column(name = "eci_codigo", length = 4)
	private String eciCodigo;
	@Column(name = "eci_nombre", length = 255)
	private String eciNombre;
}
