package com.schoolapi.api.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_personas",schema="centros_educativos")
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long perPk;
	@Column(name="per_primer_nombre")
	private String perPrimerNombre;
	@Column(name="per_segundo_nombre")
	private String perSegundoNombre;
	@Column (name="per_primer_apellido")
	private String perPrimerApellido;
	@Column (name="per_segundo_apellido")
	private String perSegundoApellido;
	@Column (name="per_email")
	private String perEmail;
	@OneToOne
	@JoinColumn(name="per_etnia_fk")
	private Etnia etnia;
	@OneToOne
	@JoinColumn(name="per_estado_civil_fk")
	private EstadoCivil estadoCivil;
	@OneToOne
	@JoinColumn(name="per_sexo_fk")
	private Sexo sexo;
	@Column(name="per_cantidad_hijos")
	private Integer perCantidadHijos;
	@Column (name="per_dui")
	private String perDui;
	@OneToOne
	@JoinColumn(name="per_nacionalidad_fk")
	private Nacionalidad nacionalidad;
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="per_direccion_fk") private Direccion direccion;
	 */
	@Column(name="per_partida_nacimiento_presenta")
	private Boolean perPartidaNacimientoPresenta;
	@OneToOne
	@JoinColumn(name="per_tipo_trabajo_fk")
	private TipoTrabajo tipoTrabajo;
	@Column(name="per_fecha_nacimiento")
	private Date perFechaNacimiento;
	@Column (name="per_retornada")
	private Boolean perRetornada;
	@Column (name="per_tiene_diagnostico")
	private Boolean perTieneDiagnostico;
	@Column (name="per_embarazo")
	private Boolean perEmbarazo;
	@Column (name="per_tiene_hijos")
	private Boolean perTieneHijos;
	@Column (name="per_acceso_internet")
	private Boolean perAccesoInternet;
	public long getPerPk() {
		return perPk;
	}
	public void setPerPk(long perPk) {
		this.perPk = perPk;
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
	public String getPerEmail() {
		return perEmail;
	}
	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}
	public Etnia getEtnia() {
		return etnia;
	}
	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public Integer getPerCantidadHijos() {
		return perCantidadHijos;
	}
	public void setPerCantidadHijos(Integer perCantidadHijos) {
		this.perCantidadHijos = perCantidadHijos;
	}
	public String getPerDui() {
		return perDui;
	}
	public void setPerDui(String perDui) {
		this.perDui = perDui;
	}
	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Boolean getPerPartidaNacimientoPresenta() {
		return perPartidaNacimientoPresenta;
	}
	public void setPerPartidaNacimientoPresenta(Boolean perPartidaNacimientoPresenta) {
		this.perPartidaNacimientoPresenta = perPartidaNacimientoPresenta;
	}
	public TipoTrabajo getTipoTrabajo() {
		return tipoTrabajo;
	}
	public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}
	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}
	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}
	public Boolean getPerRetornada() {
		return perRetornada;
	}
	public void setPerRetornada(Boolean perRetornada) {
		this.perRetornada = perRetornada;
	}
	public Boolean getPerTieneDiagnostico() {
		return perTieneDiagnostico;
	}
	public void setPerTieneDiagnostico(Boolean perTieneDiagnostico) {
		this.perTieneDiagnostico = perTieneDiagnostico;
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
	public Boolean getPerAccesoInternet() {
		return perAccesoInternet;
	}
	public void setPerAccesoInternet(Boolean perAccesoInternet) {
		this.perAccesoInternet = perAccesoInternet;
	}
}
