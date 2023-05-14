package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="sg_municipios",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Municipio implements Serializable {
 
	private static final long serialVersionUID = 1L;
	@Id
	private long munPk;
	@Column(name = "mun_codigo", length = 4)
	private String munCodigo;
	@Column(name = "mun_nombre", length = 255)
	private String munNombre;

}
