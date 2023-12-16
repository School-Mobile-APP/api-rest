package com.schoolapi.api.entities;

//Representa la tabla estudiante
import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
	@JsonBackReference
	@JoinColumn(name="est_persona", updatable = false)
    @OneToOne(optional = false)
	private Persona estPersona;
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sg_alertas", schema = "alertas", joinColumns = @JoinColumn(name = "ale_estudiante_fk"), inverseJoinColumns = @JoinColumn(name = "ale_pk"))
    private List<Alerta> alertas;
	public List<Alerta> getAlertas() {
		return alertas;
	}
	public void setAlertas(List<Alerta> alertas) {
		this.alertas = alertas;
	}
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
	public Boolean getEstSintonizaCanal10() {
		return estSintonizaCanal10;
	}
	public void setEstSintonizaCanal10(Boolean estSintonizaCanal10) {
		this.estSintonizaCanal10 = estSintonizaCanal10;
	}
	
	public Persona getEstPersona() {
		return estPersona;
	}
	public void setEstPersona(Persona estPersona) {
		this.estPersona = estPersona;
	}
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
	@JoinTable(name = "sg_est_canales_atencion", schema = "centros_educativos", joinColumns = @JoinColumn(name = "eca_estudiante_fk"), inverseJoinColumns = @JoinColumn(name = "eca_canal_fk"))
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
