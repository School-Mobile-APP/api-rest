package com.schoolapi.api.entities;
//Representa la tabla referencias apoyo
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "sg_referencias_apoyo",schema="catalogo")
public class ReferenciasApoyo implements Serializable{
	
	public long getReaPk() {
		return reaPk;
	}
	public void setReaPk(long reaPk) {
		this.reaPk = reaPk;
	}
	public String getReaCodigo() {
		return reaCodigo;
	}
	public void setReaCodigo(String reaCodigo) {
		this.reaCodigo = reaCodigo;
	}
	public String getReaNombre() {
		return reaNombre;
	}
	public void setReaNombre(String reaNombre) {
		this.reaNombre = reaNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long reaPk;
	@Column(name = "rea_codigo", length = 4)
	private String reaCodigo;
	@Column(name = "rea_Nombre", length = 255)
	private String reaNombre;
}
