package com.schoolapi.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_personas", schema = "centros_educativos")
public class PersonaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long perPk;
	@Column(name = "per_primer_nombre")
	private String perPrimerNombre;
	@Column(name = "per_segundo_nombre")
	private String perSegundoNombre;
	@Column(name = "per_primer_apellido")
	private String perPrimerApellido;
	@Column(name = "per_segundo_apellido")
	private String perSegundoApellido;
	@Column(name = "per_nie")
	private Integer perNie;
	@Column(name = "per_dui")
	private String perDui;
	@Column(name = "per_fecha_nacimiento")
	private LocalDate perFechaNacimiento;
	@OneToOne
	@JoinColumn(name = "per_nacionalidad_fk")
	private Nacionalidad nacionalidad;
	@Column(name = "per_retornada")
	private Boolean perRetornada;
	@Column(name = "per_partida_nacimiento_posee")
	private Boolean perPartidaNacimientoPosee;
	@OneToOne
	@JoinColumn(name = "per_sexo_fk")
	private Sexo sexo;
	@OneToOne
	@JoinColumn(name = "per_etnia_fk")
	private Etnia etnia;
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sg_personas_discapacidades", schema = "centros_educativos", joinColumns = @JoinColumn(name = "per_pk"), inverseJoinColumns = @JoinColumn(name = "dis_pk"))
	private List<Discapacidad> perDiscapacidades;
	
	@Column(name = "per_tiene_diagnostico")
	private Boolean perTieneDiagnostico;

	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sg_personas_referencias_apoyo", schema = "centros_educativos", joinColumns = @JoinColumn(name = "per_pk"), inverseJoinColumns = @JoinColumn(name = "rea_pk"))
	private List<ReferenciasApoyo> perReferencias;
	

	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sg_personas_terapias", schema = "centros_educativos", joinColumns = @JoinColumn(name = "per_pk"), inverseJoinColumns = @JoinColumn(name = "ter_pk"))
	private List<Terapia> perTerapias;
	
	public List<Terapia> getPerTerapias() {
		return perTerapias;
	}

	public void setPerTerapias(List<Terapia> perTerapias) {
		this.perTerapias = perTerapias;
	}

	public Estudiante getPerEstudiante() {
		return perEstudiante;
	}

	public void setPerEstudiante(Estudiante perEstudiante) {
		this.perEstudiante = perEstudiante;
	}

	public List<ElementoHogar> getPerElementosHogar() {
		return perElementosHogar;
	}

	public void setPerElementosHogar(List<ElementoHogar> perElementosHogar) {
		this.perElementosHogar = perElementosHogar;
	}

	@Column(name = "per_email")
	private String perEmail;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "telPersona", orphanRemoval = true)
	private List<Telefono> perTelefonos;

	@OneToOne
	@JoinColumn(name = "per_tipo_trabajo_fk")
	private TipoTrabajo perTipoTrabajo;
	@OneToOne
	@JoinColumn(name = "per_estado_civil_fk")
	private EstadoCivil perEstadoCivil;
	@Column(name = "per_convivencia_fam_fk")
	private Integer perConvivenciaFamFk;
	@Column(name = "per_embarazo")
	private Boolean perEmbarazo;
	@Column(name = "per_tiene_hijos")
	private Boolean perTieneHijos;
	@Column(name = "per_cantidad_hijos")
	private Integer perCantidadHijos;
	@Column(name="per_escolaridad_fk")
	private Integer perEscolaridadFk;
	 public Integer getPerEscolaridadFk() {
		return perEscolaridadFk;
	}

	public void setPerEscolaridadFk(Integer perEscolaridadFk) {
		this.perEscolaridadFk = perEscolaridadFk;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@OneToOne 
	 @JoinColumn(name="per_direccion_fk") 
	 private Direccion direccion;
	@Column(name = "per_tipo_vivienda_fk")
	private Long perTipoViviendaFk;

	@OneToOne(optional = false)
	@JoinColumn(name = "per_pk", updatable = false, insertable = false)
	private DatosResidenciales perDatosResidenciales;
	@JsonManagedReference
	@OneToOne(mappedBy = "estPersona")
	private Estudiante perEstudiante;
	@Fetch(FetchMode.SUBSELECT)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "sg_personas_elementos_hogar", schema = "centros_educativos", joinColumns = @JoinColumn(name = "per_pk"), inverseJoinColumns = @JoinColumn(name = "eho_pk"))
	private List<ElementoHogar> perElementosHogar;

	/*
	 * @OneToMany(fetch = FetchType.LAZY,mappedBy = "allPersona") private
	 * List<Allegado> perAllegados;
	 * 
	 * public List<Allegado> getPerAllegados() { return perAllegados; } public void
	 * setPerAllegados(List<Allegado> perAllegados) { this.perAllegados =
	 * perAllegados; }
	 */
	public DatosResidenciales getPerDatosResidenciales() {
		return perDatosResidenciales;
	}

	public void setPerDatosResidenciales(DatosResidenciales perDatosResidenciales) {
		this.perDatosResidenciales = perDatosResidenciales;
	}

	public DatosResidenciales getDatosResidenciales() {
		return perDatosResidenciales;
	}

	public void setDatosResidenciales(DatosResidenciales datosResidenciales) {
		this.perDatosResidenciales = datosResidenciales;
	}

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
	public Integer getPerNie() {
		return perNie;
	}

	public void setPerNie(Integer perNie) {
		this.perNie = perNie;
	}

	public String getPerDui() {
		return perDui;
	}

	public void setPerDui(String perDui) {
		this.perDui = perDui;
	}

	public LocalDate getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(LocalDate perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Boolean getPerRetornada() {
		return perRetornada;
	}

	public void setPerRetornada(Boolean perRetornada) {
		this.perRetornada = perRetornada;
	}

	public Boolean getPerPartidaNacimientoPosee() {
		return perPartidaNacimientoPosee;
	}

	public void setPerPartidaNacimientoPosee(Boolean perPartidaNacimientoPosee) {
		this.perPartidaNacimientoPosee = perPartidaNacimientoPosee;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Etnia getEtnia() {
		return etnia;
	}

	public void setEtnia(Etnia etnia) {
		this.etnia = etnia;
	}

	public List<Discapacidad> getPerDiscapacidades() {
		return perDiscapacidades;
	}

	public void setPerDiscapacidades(List<Discapacidad> perDiscapacidades) {
		this.perDiscapacidades = perDiscapacidades;
	}

	public Boolean getPerTieneDiagnostico() {
		return perTieneDiagnostico;
	}

	public void setPerTieneDiagnostico(Boolean perTieneDiagnostico) {
		this.perTieneDiagnostico = perTieneDiagnostico;
	}

	public List<ReferenciasApoyo> getPerReferencias() {
		return perReferencias;
	}

	public void setPerReferencias(List<ReferenciasApoyo> perReferencias) {
		this.perReferencias = perReferencias;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public List<Telefono> getPerTelefonos() {
		return perTelefonos;
	}

	public void setPerTelefonos(List<Telefono> perTelefonos) {
		this.perTelefonos = perTelefonos;
	}

	public TipoTrabajo getPerTipoTrabajo() {
		return perTipoTrabajo;
	}

	public void setPerTipoTrabajo(TipoTrabajo perTipoTrabajo) {
		this.perTipoTrabajo = perTipoTrabajo;
	}

	public EstadoCivil getPerEstadoCivil() {
		return perEstadoCivil;
	}

	public void setPerEstadoCivil(EstadoCivil perEstadoCivil) {
		this.perEstadoCivil = perEstadoCivil;
	}

	public Integer getPerConvivenciaFamFk() {
		return perConvivenciaFamFk;
	}

	public void setPerConvivenciaFamFk(Integer perConvivenciaFamFk) {
		this.perConvivenciaFamFk = perConvivenciaFamFk;
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

	public Long getPerTipoViviendaFk() {
		return perTipoViviendaFk;
	}

	public void setPerTipoViviendaFk(Long perTipoViviendaFk) {
		this.perTipoViviendaFk = perTipoViviendaFk;
	}

	public Boolean getPerAccesoInternet() {
		return perAccesoInternet;
	}

	public void setPerAccesoInternet(Boolean perAccesoInternet) {
		this.perAccesoInternet = perAccesoInternet;
	}

	@Column(name = "per_acceso_internet")
	private Boolean perAccesoInternet;
}
