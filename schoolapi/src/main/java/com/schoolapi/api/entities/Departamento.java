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
@Table(name = "sg_departamentos", schema = "catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "dep_pk")
	private long depPk;
	@Column(name = "dep_codigo", length = 4)
	private String depCodigo;
	@Column(name = "dep_nombre", length = 255)
	private String depNombre;
}
