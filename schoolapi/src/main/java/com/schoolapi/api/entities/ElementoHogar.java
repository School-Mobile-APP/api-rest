package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_elementos_hogar",schema="catalogo")
//@IdClass(value = PersonaElementoHogarPk.class)
public class ElementoHogar implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="eho_pk")
	private Long ehoPk;
	@Column(name="eho_nombre")
	private String ehoNombre;
	public Long getEhoPk() {
		return ehoPk;
	}
	public void setEhoPk(Long ehoPk) {
		this.ehoPk = ehoPk;
	}
	public String getEhoNombre() {
		return ehoNombre;
	}
	public void setEhoNombre(String ehoNombre) {
		this.ehoNombre = ehoNombre;
	}

}
