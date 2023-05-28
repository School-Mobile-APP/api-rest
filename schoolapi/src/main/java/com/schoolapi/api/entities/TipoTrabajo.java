package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_tipos_trabajo",schema="catalogo")
public class TipoTrabajo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long ttrPk;
	@Column(name = "ttr_codigo", length = 4)
	private String ttrCodigo;
	@Column(name = "ttr_nombre", length = 255)
	private String ttrNombre;
	public long getTtrPk() {
		return ttrPk;
	}
	public void setTtrPk(long ttrPk) {
		this.ttrPk = ttrPk;
	}
	public String getTtrCodigo() {
		return ttrCodigo;
	}
	public void setTtrCodigo(String ttrCodigo) {
		this.ttrCodigo = ttrCodigo;
	}
	public String getTtrNombre() {
		return ttrNombre;
	}
	public void setTtrNombre(String ttrNombre) {
		this.ttrNombre = ttrNombre;
	}
}
