package com.ficha.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Size;

public class SgFichaPasoDos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "per_dui", length = 20)
	@Size(max = 20)
	private String perDui;
	@Size(max = 100)
	@Column(name = "per_primer_nombre")
	private String perPrimerNombre;

	@Size(max = 100)
	@Column(name = "per_segundo_nombre")
	private String perSegundoNombre;
	@Size(max = 100)
	@Column(name = "per_primer_apellido")
	private String perPrimerApellido;

	@Size(max = 100)
	@Column(name = "per_segundo_apellido")
	private String perSegundoApellido;

	@Column(name = "per_fecha_nacimiento")
	private LocalDate perFechaNacimiento;

	@Column(name = "per_nacionalidad_fk")
	private Long perNacionalidad;

	@Column(name = "per_retornada")
	private Boolean perRetornada;

	@Column(name = "per_partida_nacimiento_presenta")
	private Boolean perPartidaNacimientoPresenta;

	@Column(name = "per_etnia_fk")
	private Long perEtnia;

	@Column(name = "per_tiene_diagnostico")
	private Boolean perTieneDiagnostico;

	@Size(max = 100)
	@Column(name = "per_email")
	private String perEmail;

	@Column(name = "per_tiene_whatsapp")
	private Boolean perTieneWhatsapp;

	@Column(name = "per_tipo_trabajo_fk")
	private Long perTipoTrabajo;

	@Column(name = "per_estado_civil_fk")
	private Long perEstadoCivil;

	// personas discapacidades falta
	// personas referencias apoyo
	// terapias
	// sgTelefonos ahi debemos insertar

	// Convivencia familiar necesitamos el endpoint y la clase

	@Column(name = "per_embarazo")
	private Boolean perEmbarazo;

	@Column(name = "per_tiene_hijos")
	private Boolean perTieneHijos;
	
	@Column(name = "per_cantidad_hijos")
	private Integer perCantidadHijos;
	
	public Long getPerTipoTrabajo() {
		return perTipoTrabajo;
	}

	public void setPerTipoTrabajo(Long perTipoTrabajo) {
		this.perTipoTrabajo = perTipoTrabajo;
	}

	public Long getPerEstadoCivil() {
		return perEstadoCivil;
	}

	public void setPerEstadoCivil(Long perEstadoCivil) {
		this.perEstadoCivil = perEstadoCivil;
	}

	public Boolean getPerEmbarazo() {
		return perEmbarazo;
	}

	public void setPerEmbarazo(Boolean perEmbarazo) {
		this.perEmbarazo = perEmbarazo;
	}

	public Boolean getPerTieneHijos() {
		return perTieneHijos;
	}

	public void setPerTieneHijos(Boolean perTieneHijos) {
		this.perTieneHijos = perTieneHijos;
	}

	public Integer getPerCantidadHijos() {
		return perCantidadHijos;
	}

	public void setPerCantidadHijos(Integer perCantidadHijos) {
		this.perCantidadHijos = perCantidadHijos;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Boolean getPerTieneWhatsapp() {
		return perTieneWhatsapp;
	}

	public void setPerTieneWhatsapp(Boolean perTieneWhatsapp) {
		this.perTieneWhatsapp = perTieneWhatsapp;
	}

	public Long getPerEtnia() {
		return perEtnia;
	}

	public void setPerEtnia(Long perEtnia) {
		this.perEtnia = perEtnia;
	}

	public Boolean getPerTieneDiagnostico() {
		return perTieneDiagnostico;
	}

	public void setPerTieneDiagnostico(Boolean perTieneDiagnostico) {
		this.perTieneDiagnostico = perTieneDiagnostico;
	}

	public Long getPerSexo() {
		return perSexo;
	}

	public void setPerSexo(Long perSexo) {
		this.perSexo = perSexo;
	}

	@Column(name = "per_sexo_fk")
	private Long perSexo;

	public LocalDate getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(LocalDate perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public Long getPerNacionalidad() {
		return perNacionalidad;
	}

	public void setPerNacionalidad(Long perNacionalidad) {
		this.perNacionalidad = perNacionalidad;
	}

	public Boolean getPerRetornada() {
		return perRetornada;
	}

	public void setPerRetornada(Boolean perRetornada) {
		this.perRetornada = perRetornada;
	}

	public Boolean getPerPartidaNacimientoPresenta() {
		return perPartidaNacimientoPresenta;
	}

	public void setPerPartidaNacimientoPresenta(Boolean perPartidaNacimientoPresenta) {
		this.perPartidaNacimientoPresenta = perPartidaNacimientoPresenta;
	}

	public String getPerDui() {
		return perDui;
	}

	public void setPerDui(String perDui) {
		this.perDui = perDui;
	}

	public String getPerPrimerNombre() {
		return perPrimerNombre;
	}

	public void setPerPrimerNombre(String perPrimerNombre) {
		this.perPrimerNombre = perPrimerNombre;
	}

	public String getPerSegundoNombre() {
		return perSegundoNombre;
	}

	public void setPerSegundoNombre(String perSegundoNombre) {
		this.perSegundoNombre = perSegundoNombre;
	}

	public String getPerPrimerApellido() {
		return perPrimerApellido;
	}

	public void setPerPrimerApellido(String perPrimerApellido) {
		this.perPrimerApellido = perPrimerApellido;
	}

	public String getPerSegundoApellido() {
		return perSegundoApellido;
	}

	public void setPerSegundoApellido(String perSegundoApellido) {
		this.perSegundoApellido = perSegundoApellido;
	}
}
