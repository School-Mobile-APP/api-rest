package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_discapacidades",schema="catalogo")
public class Discapacidad implements Serializable{
	public long getDisPk() {
		return disPk;
	}
	public void setDisPk(long disPk) {
		this.disPk = disPk;
	}
	public String getDisCodigo() {
		return disCodigo;
	}
	public void setDisCodigo(String disCodigo) {
		this.disCodigo = disCodigo;
	}
	public String getDisNombre() {
		return disNombre;
	}
	public void setDisNombre(String disNombre) {
		this.disNombre = disNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	
	private long disPk;
	@Column(name = "dis_codigo", length = 4)
	private String disCodigo;
	@Column(name = "dis_nombre", length = 255)
	private String disNombre;
}
