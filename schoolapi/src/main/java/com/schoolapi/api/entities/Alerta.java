package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_alertas",schema="alertas")
public class Alerta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ale_pk")
	private Long alePk;
	@Column(name="ale_variable")
	private String aleVariable;
	@Column(name="ale_riesgo")
	private String aleRiesgo;
	public Long getAlePk() {
		return alePk;
	}
	public void setAlePk(Long alePk) {
		this.alePk = alePk;
	}
	public String getAleVariable() {
		return aleVariable;
	}
	public void setAleVariable(String aleVariable) {
		this.aleVariable = aleVariable;
	}
	public String getAleRiesgo() {
		return aleRiesgo;
	}
	public void setAleRiesgo(String aleRiesgo) {
		this.aleRiesgo = aleRiesgo;
	}
	public Integer getAleEstudianteFk() {
		return aleEstudianteFk;
	}
	public void setAleEstudianteFk(Integer aleEstudiante) {
		this.aleEstudianteFk = aleEstudiante;
	}
	@Column(name="ale_estudiante_fk")
	private Integer aleEstudianteFk;
}
