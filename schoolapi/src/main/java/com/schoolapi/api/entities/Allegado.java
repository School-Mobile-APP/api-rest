package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_allegados", schema = "centros_educativos")
public class Allegado implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long allPk;
	@Column(name = "all_referente")
	private Boolean allReferente;
	@Column(name = "all_contacto_emergencia")
	private Boolean allContactoEmergencia;

	@Column(name = "all_dependiente")
	private Boolean allDependiente;

	@Column(name = "all_persona")
	private Long allPersona;

	@Column(name = "all_es_familiar")
	private Boolean allEsFamiliar;
	@OneToOne(optional=false)
	@JoinColumn(name="all_persona_ref")
	private Persona allPersonaReferenciada;
	@Column(name="all_tipo_parentesco")
	private Long allTipoParentesco;

	public Long getAllTipoParentesco() {
		return allTipoParentesco;
	}
	public void setAllTipoParentesco(Long allTipoParentesco) {
		this.allTipoParentesco = allTipoParentesco;
	}
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="all_tipo_parentesco") private TipoParentesco
	 * tipoParentesco;
	 */
	public long getAllPk() {
		return allPk;
	}
	public void setAllPk(long allPk) {
		this.allPk = allPk;
	}
	public Boolean getAllReferente() {
		return allReferente;
	}
	public void setAllReferente(Boolean allReferente) {
		this.allReferente = allReferente;
	}
	public Boolean getAllContactoEmergencia() {
		return allContactoEmergencia;
	}
	public Long getAllPersona() {
		return allPersona;
	}
	public void setAllPersona(Long allPersona) {
		this.allPersona = allPersona;
	}
	public void setAllContactoEmergencia(Boolean allContactoEmergencia) {
		this.allContactoEmergencia = allContactoEmergencia;
	}
	public Boolean getAllDependiente() {
		return allDependiente;
	}
	public void setAllDependiente(Boolean allDependiente) {
		this.allDependiente = allDependiente;
	}
	public Persona getAllPersonaReferenciada() {
		return allPersonaReferenciada;
	}
	public void setAllPersonaReferenciada(Persona allPersonaReferenciada) {
		this.allPersonaReferenciada = allPersonaReferenciada;
	}
	public Boolean getAllEsFamiliar() {
		return allEsFamiliar;
	}
	public void setAllEsFamiliar(Boolean allEsFamiliar) {
		this.allEsFamiliar = allEsFamiliar;
	}

	/*
	 * public TipoParentesco getTipoParentesco() { return tipoParentesco; } public
	 * void setTipoParentesco(TipoParentesco tipoParentesco) { this.tipoParentesco =
	 * tipoParentesco; }
	 */
	public Boolean getAllViveConAllegado() {
		return allViveConAllegado;
	}
	public void setAllViveConAllegado(Boolean allViveConAllegado) {
		this.allViveConAllegado = allViveConAllegado;
	}
	@Column(name = "all_vive_con_allegado")
    private Boolean allViveConAllegado;
}
