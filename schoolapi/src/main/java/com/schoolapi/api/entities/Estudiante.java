package com.schoolapi.api.entities;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_estudiantes",schema="centros_educativos")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long estPk;
	@Column(name="est_persona")
	private Integer estPersona;
	public Long getEstPk() {
		return estPk;
	}
	public void setEstPk(Long estPk) {
		this.estPk = estPk;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	/*
	 * public Seccion getSeccion() { return seccion; } public void
	 * setSeccion(Seccion seccion) { this.seccion = seccion; }
	 */
	public Boolean getEstSintonizaCanal10() {
		return estSintonizaCanal10;
	}
	public void setEstSintonizaCanal10(Boolean estSintonizaCanal10) {
		this.estSintonizaCanal10 = estSintonizaCanal10;
	}
	
	public Integer getEstPersona() {
		return estPersona;
	}
	public void setEstPersona(Integer estPersona) {
		this.estPersona = estPersona;
	}
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="est_persona") private Persona persona;
	 */
	@OneToOne
	@JoinColumn(name="est_ultima_matricula_fk")
	private Matricula matricula;
	
	@OneToOne  
	@JoinColumn(name="est_ultima_seccion_fk") 
	private Seccion seccion;
	public Seccion getSeccion() {
		return seccion;
	}
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	public Sede getSede() {
		return sede;
	}
	public void setSede(Sede sede) {
		this.sede = sede;
	}
	@OneToOne
	@JoinColumn(name="est_ultima_sede_fk") 
	private Sede sede;
	@Column(name="est_sintoniza_canal_10")
	private Boolean estSintonizaCanal10;
	@OneToOne
	@JoinColumn(name="est_rec_clases_multimodalidad_fk")
	private Modalidad modalidad;
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sg_est_canales_atencion", schema = "centros_educativos", joinColumns = @JoinColumn(name = "eca_estudiante_fk"), inverseJoinColumns = @JoinColumn(name = "eca_pk"))
	private List<CanalAtencion> estCanalesAtencion;
	public List<CanalAtencion> getEstCanalesAtencion() {
		return estCanalesAtencion;
	}
	public void setEstCanalesAtencion(List<CanalAtencion> estCanalesAtencion) {
		this.estCanalesAtencion = estCanalesAtencion;
	}
	public Modalidad getModalidad() {
		return modalidad;
	}
	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
}
