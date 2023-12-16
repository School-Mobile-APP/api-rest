package com.schoolapi.api.entities;

//Representa la tabla etnia
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="sg_etnias",schema="catalogo")

public class Etnia implements Serializable { 
	public long getEtnPk() {
		return etnPk;
	}
	public void setEtnPk(long etnPk) {
		this.etnPk = etnPk;
	}
	public String getEtnCodigo() {
		return etnCodigo;
	}
	public void setEtnCodigo(String etnCodigo) {
		this.etnCodigo = etnCodigo;
	}
	public String getEtnNombre() {
		return etnNombre;
	}
	public void setEtnNombre(String etnNombre) {
		this.etnNombre = etnNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long etnPk;
	@Column(name = "etn_codigo", length = 4)
	private String etnCodigo;
	@Column(name = "etn_nombre", length = 255)
	private String etnNombre;
}
