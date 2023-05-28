package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_nacionalidades",schema="catalogo")
public class Nacionalidad implements Serializable{ 
	public long getNacPk() {
		return nacPk;
	}
	public void setNacPk(long nacPk) {
		this.nacPk = nacPk;
	}
	public String getNacCodigo() {
		return nacCodigo;
	}
	public void setNacCodigo(String nacCodigo) {
		this.nacCodigo = nacCodigo;
	}
	public String getNacNombre() {
		return nacNombre;
	}
	public void setNacNombre(String nacNombre) {
		this.nacNombre = nacNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long nacPk;
	@Column(name = "nac_codigo", length = 4)
	private String nacCodigo;
	@Column(name = "nac_nombre", length = 255)
	private String nacNombre;
}
