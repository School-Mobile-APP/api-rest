package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_convivencia_familiar",schema="catalogo")
public class ConvivenciaFamiliar implements Serializable {
	public long getCofPk() {
		return cofPk;
	}
	public void setCofPk(long cofPk) {
		this.cofPk = cofPk;
	}
	public String getCofCodigo() {
		return cofCodigo;
	}
	public void setCofCodigo(String cofCodigo) {
		this.cofCodigo = cofCodigo;
	}
	public String getCofNombre() {
		return cofNombre;
	}
	public void setCofNombre(String cofNombre) {
		this.cofNombre = cofNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cof_pk")
	private long cofPk;
	@Column(name = "cof_codigo", length = 4)
	private String cofCodigo;
	@Column(name = "cof_nombre", length = 255)
	private String cofNombre;
}
