package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_tipo_vivienda",schema="catalogo")
public class TipoVivienda implements Serializable{
	public long getTivPk() {
		return tivPk;
	}
	public void setTivPk(long tivPk) {
		this.tivPk = tivPk;
	}
	public String getTiv_codigo() {
		return tiv_codigo;
	}
	public void setTiv_codigo(String tiv_codigo) {
		this.tiv_codigo = tiv_codigo;
	}
	public String getTivNombre() {
		return tivNombre;
	}
	public void setTivNombre(String tivNombre) {
		this.tivNombre = tivNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long tivPk;
	@Column(name = "tiv_codigo", length = 4)
	private String tiv_codigo;
	@Column(name = "tiv_nombre", length = 255)
	private String tivNombre;
}
