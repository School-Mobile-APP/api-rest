package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Representa la tabla terapias
@Entity
@Table(name="sg_terapias",schema="catalogo")
public class Terapia implements Serializable{

	public long getTerPk() {
		return terPk;
	}
	public void setTerPk(long terPk) {
		this.terPk = terPk;
	}
	public String getTerCodigo() {
		return terCodigo;
	}
	public void setTerCodigo(String terCodigo) {
		this.terCodigo = terCodigo;
	}
	public String getTerNombre() {
		return terNombre;
	}
	public void setTerNombre(String terNombre) {
		this.terNombre = terNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long terPk;
	@Column(name = "ter_codigo", length = 4)
	private String terCodigo;
	@Column(name = "ter_nombre", length = 255)
	private String terNombre;
}
