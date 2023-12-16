package com.schoolapi.api.entities;

//Representa la tabla modalidades
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_modalidades",schema="centros_educativos")
public class ModalidadEducativa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long modPk;
	@Column(name="mod_nombre")
	private String modNombre;
	public Long getModPk() {
		return modPk;
	}
	public void setModPk(Long modPk) {
		this.modPk = modPk;
	}
	public String getModNombre() {
		return modNombre;
	}
	public void setModNombre(String modNombre) {
		this.modNombre = modNombre;
	}

}
