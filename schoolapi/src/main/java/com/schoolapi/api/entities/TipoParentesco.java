package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//Representa la tabla tipos parentesco
@Entity
@Table(name="sg_tipos_parentesco",schema="catalogo")
public class TipoParentesco implements Serializable{

	public long getTpaPk() {
		return tpaPk;
	}
	public void setTpaPk(long tpaPk) {
		this.tpaPk = tpaPk;
	}
	public String getTpaCodigo() {
		return tpaCodigo;
	}
	public void setTpaCodigo(String tpaCodigo) {
		this.tpaCodigo = tpaCodigo;
	}
	public String getTpaNombre() {
		return tpaNombre;
	}
	public void setTpaNombre(String tpaNombre) {
		this.tpaNombre = tpaNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long tpaPk;
	@Column(name = "tpa_codigo", length = 4)
	private String tpaCodigo;
	@Column(name = "tpa_nombre", length = 255)
	private String tpaNombre;
}
