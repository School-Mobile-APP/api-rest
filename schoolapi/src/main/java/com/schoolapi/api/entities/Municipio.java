package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="sg_municipios",schema="catalogo")

public class Municipio implements Serializable {
 
	public long getMunPk() {
		return munPk;
	}
	public void setMunPk(long munPk) {
		this.munPk = munPk;
	}
	public String getMunCodigo() {
		return munCodigo;
	}
	public void setMunCodigo(String munCodigo) {
		this.munCodigo = munCodigo;
	}
	public String getMunNombre() {
		return munNombre;
	}
	public void setMunNombre(String munNombre) {
		this.munNombre = munNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long munPk;
	@Column(name = "mun_codigo", length = 4)
	private String munCodigo;
	@Column(name = "mun_nombre", length = 255)
	private String munNombre;

}
