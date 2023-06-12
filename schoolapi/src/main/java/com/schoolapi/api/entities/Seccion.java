package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_secciones",schema="centros_educativos")
public class Seccion implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="sec_pk")
	private Long secPk;
	@Column(name="sec_nombre")
	private String secNombre;
	@OneToOne  
	@JoinColumn(name="sec_jornada_fk") 
	private Jornada jornada;
	public Long getSecPk() {
		return secPk;
	}
	public void setSecPk(Long secPk) {
		this.secPk = secPk;
	}
	public String getSecNombre() {
		return secNombre;
	}
	public void setSecNombre(String secNombre) {
		this.secNombre = secNombre;
	}
	public Jornada getJornada() {
		return jornada;
	}
	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}
	
	
}
