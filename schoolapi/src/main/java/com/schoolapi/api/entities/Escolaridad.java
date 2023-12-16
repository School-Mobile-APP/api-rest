package com.schoolapi.api.entities;

//Representa la tabla escolaridades
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_escolaridades",schema="catalogo")
public class Escolaridad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="esc_pk")
	private Long escPk;
	@Column(name="esc_nombre")
	private String escNombre;
	public Long getEscPk() {
		return escPk;
	}
	public void setEscPk(Long escPk) {
		this.escPk = escPk;
	}
	public String getEscNombre() {
		return escNombre;
	}
	public void setEscNombre(String escNombre) {
		this.escNombre = escNombre;
	}

}
