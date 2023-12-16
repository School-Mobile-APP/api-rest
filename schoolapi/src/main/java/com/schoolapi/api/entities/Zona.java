package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Representa zonas
@Entity
@Table(name="sg_zonas",schema="catalogo")
public class Zona implements Serializable{
	public long getZonPk() {
		return zonPk;
	}
	public void setZonPk(long zonPk) {
		this.zonPk = zonPk;
	}
	public String getZonCodigo() {
		return zonCodigo;
	}
	public void setZonCodigo(String zonCodigo) {
		this.zonCodigo = zonCodigo;
	}
	public String getZonNombre() {
		return zonNombre;
	}
	public void setZonNombre(String zonNombre) {
		this.zonNombre = zonNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long zonPk;
	@Column(name = "zon_codigo", length = 4)
	private String zonCodigo;
	@Column(name = "zon_nombre", length = 255)
	private String zonNombre;
}
