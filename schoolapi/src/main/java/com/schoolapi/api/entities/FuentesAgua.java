package com.schoolapi.api.entities;

//Representa la tabla fuentes abastecimiento agua
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_fuentes_abastecimiento_agua",schema="catalogo")
public class FuentesAgua implements Serializable {
	public long getFaaPk() {
		return faaPk;
	}
	public void setFaaPk(long faaPk) {
		this.faaPk = faaPk;
	}
	public String getFaaCodigo() {
		return faaCodigo;
	}
	public void setFaaCodigo(String faaCodigo) {
		this.faaCodigo = faaCodigo;
	}
	public String getFaaNombre() {
		return faaNombre;
	}
	public void setFaaNombre(String faaNombre) {
		this.faaNombre = faaNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faa_pk")
	private long faaPk;
	@Column(name = "faa_codigo", length = 4)
	private String faaCodigo;
	@Column(name = "faa_nombre", length = 255)
	private String faaNombre;
}
