package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_servicio_educativo",schema="centros_educativos")
public class ServicioEducativo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="sdu_pk")
	private Long sduPk;
	@OneToOne  
	@JoinColumn(name="sdu_grado_fk") 
	private GradoEscolaridad grado;
	@OneToOne
	@JoinColumn(name="sdu_sede_fk")
	private Sede sede;
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	public Long getSduPk() {
		return sduPk;
	}
	public void setSduPk(Long sduPk) {
		this.sduPk = sduPk;
	}
	public GradoEscolaridad getGrado() {
		return grado;
	}
	public void setGrado(GradoEscolaridad grado) {
		this.grado = grado;
	}
	

}
