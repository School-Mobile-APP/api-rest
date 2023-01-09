package com.ficha.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name = "sg_personas")
public class SgPersona implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "per_pk")
	private Long perPk;

	@Size(max = 100)
	@Column(name = "per_primer_nombre")
	private String perPrimerNombre;

	@Size(max = 100)
	@Column(name = "per_segundo_nombre")
	private String perSegundoNombre;

	@Size(max = 100)
	@Column(name = "per_tercer_nombre")
	private String perTercerNombre;

	@Size(max = 100)
	@Column(name = "per_primer_apellido")
	private String perPrimerApellido;

	@Size(max = 100)
	@Column(name = "per_segundo_apellido")
	private String perSegundoApellido;

	@Size(max = 100)
	@Column(name = "per_tercer_apellido")
	private String perTercerApellido;

	@Size(max = 100)
	@Column(name = "per_primer_nombre_busqueda")
	private String perPrimerNombreBusqueda;

	@Size(max = 100)
	@Column(name = "per_segundo_nombre_busqueda")
	private String perSegundoNombreBusqueda;

	@Size(max = 100)
	@Column(name = "per_tercer_nombre_busqueda")
	private String perTercerNombreBusqueda;

	@Size(max = 100)
	@Column(name = "per_primer_apellido_busqueda")
	private String perPrimerApellidoBusqueda;

	@Size(max = 100)
	@Column(name = "per_segundo_apellido_busqueda")
	private String perSegundoApellidoBusqueda;

	@Size(max = 100)
	@Column(name = "per_tercer_apellido_busqueda")
	private String perTercerApellidoBusqueda;

	@Size(max = 650)
	@Column(name = "per_nombre_busqueda", length = 650)
	private String perNombreBusqueda;

	@Column(name = "per_fecha_nacimiento")
	private LocalDate perFechaNacimiento;

	@Size(max = 100)
	@Column(name = "per_email")
	private String perEmail;

	@Column(name = "per_etnia_fk")
	private Long perEtnia;

	@Column(name = "per_estado_civil_fk")
	private Long perEstadoCivil;

	@Column(name = "per_sexo_fk")
	private Long perSexo;

	@Column(name = "per_tipo_sangre_fk")
	private Long perTipoSangre;

	@Column(name = "per_cantidad_hijos")
	private Integer perCantidadHijos;

	@Column(name = "per_habilitado")
	private Boolean perHabilitado;

	@Column(name = "per_ult_mod_fecha")
	private LocalDateTime perUltModFecha;

	@Size(max = 45)
	@Column(name = "per_ult_mod_usuario", length = 45)
	private String perUltModUsuario;

	@Column(name = "per_version")
	@Version
	private Integer perVersion;

	@Column(name = "per_direccion_fk")
	private Integer perDireccion;

	@Column(name = "per_dui", length = 20)
	@Size(max = 20)
	private String perDui;

	@Column(name = "per_cun")
	private Long perCun;

	@Column(name = "per_nie")
	private Long perNie;

	@Column(name = "per_nip", length = 50)
	@Size(max = 50)
	private String perNip;

	@Column(name = "per_nit", length = 20)
	@Size(max = 20)
	private String perNit;

	@Column(name = "per_inpep")
	private String perInpep;

	@Column(name = "per_isss")
	private String perIsss;

	@Column(name = "per_nup")
	private String perNup;

	@Column(name = "per_naturalizada")
	private Boolean perNaturalizada;

	@Column(name = "per_partida_nacimiento")
	private Long perPartidaNacimiento;

	@Column(name = "per_partida_nacimiento_anio")
	private Integer perPartidaNacimientoAnio;

	@Column(name = "per_partida_nacimiento_folio")
	private String perPartidaNacimientoFolio;

	@Column(name = "per_partida_nacimiento_libro")
	private String perPartidaNacimientoLibro;

	@Column(name = "per_partida_nacimiento_complemento")
	private String perPartidaNacimientoComplemento;

	@Column(name = "per_partida_nacimiento_presenta")
	private Boolean perPartidaNacimientoPresenta;

	@Column(name = "per_partida_departamento_fk")
	private Long perPartidaDepartamento;

	@Column(name = "per_partida_municipio_fk")
	private Long perPartidaMunicipio;

	@Column(name = "per_departamento_nacimiento_fk")
	private Long perDepartamentoNacimento;

	@Column(name = "per_municipio_nacimiento_fk")
	private Long perMunicipioNacimiento;

	@Column(name = "per_foto_fk")
	private Long perFoto;

	@Column(name = "per_partida_nacimiento_archivo")
	private Long perPartidaNacimientoArchivo;

	@Column(name = "per_nacionalidad_fk")
	private Long perNacionalidad;

	@Column(name = "per_profesion_fk")
	private Long perProfesion;

	@Column(name = "per_ocupacion_fk")
	private Long perOcupacion;

	@Column(name = "per_escolaridad_fk")
	private Long perEscolaridad;

	@Column(name = "per_lugar_trabajo", length = 255)
	private String perLugarTrabajo;

	@Column(name = "per_trabaja")
	private Boolean perTrabaja;

	@Column(name = "per_tipo_trabajo_fk")
	private Long perTipoTrabajo;

	@Column(name = "per_embarazo")
	private Boolean perEmbarazo;

	@Column(name = "per_fecha_parto")
	private LocalDate perFechaParto;

	@Column(name = "per_jornada_laboral", length = 20)
	private String perJornadaLaboral;

	@Column(name = "per_salario")
	private Double perSalario;

	@Column(name = "per_propiedad_vivienda", length = 40)
	private String perPropiedadVivienda;

	@Column(name = "per_servicios_basicos", length = 40)
	private String perServiciosBasicos;

	@Column(name = "per_acceso_internet")
	private Boolean perAccesoInternet;

	@Column(name = "per_recibe_remesas")
	private Boolean perRecibeRemesas;

	@Column(name = "per_familiares_emigrados")
	private Integer perFamiliaresEmigrados;

	@Column(name = "per_vive_con_cantidad")
	private Integer perViveConCantidad;

	@Size(max = 1000)
	@Column(name = "per_nombre_partida_nacimiento")
	private String perNombrePartidaNacimiento;

	@Column(name = "per_tiene_identificacion")
	private Boolean perTieneIdentificacion;

	@Column(name = "per_lucene_index_updated")
	private Boolean perLuceneIndexUpdated;

	@Column(name = "per_usuario_pk", updatable = false, insertable = false) // Generado por trigger
	private Long perUsuarioPk;

	@Column(name = "per_estado")
	private String perEstado;

	@Column(name = "per_fecha_fallecimiento")
	private LocalDate perFechaFallecimiento;

	@Column(name = "per_motivo_fallecimiento_fk")
	private Long perMotivoFallecimiento;

	@Column(name = "per_retornada")
	private Boolean perRetornada;

	@Column(name = "per_tiene_hijos")
	private Boolean perTieneHijos;

	@Column(name = "per_tiene_discapacidad")
	private Boolean perTieneDiscapacidades;

	@Column(name = "per_tiene_trastorno_aprendizaje")
	private Boolean perTieneTrastornoAprendizaje;

	@Column(name = "per_tiene_diagnostico")
	private Boolean perTieneDiagnostico;

	@Column(name = "per_dui_validado_rnpn")
	private Boolean perDuiValidadoRNPN;

	@Column(name = "per_dui_pendiente_validacion_rnpn")
	private Boolean perDuiPendienteValidacionRNPN;

	@Column(name = "per_cun_validado_rnpn")
	private Boolean perCunValidadoRNPN;

	@Column(name = "per_cun_pendiente_validacion_rnpn")
	private Boolean perCunPendienteValidacionRNPN;

	@Column(name = "per_partida_nac_validada_rnpn")
	private Boolean perPartidaNacValidadaRNPN;

	public Boolean getPerTieneWhatsapp() {
		return perTieneWhatsapp;
	}

	public void setPerTieneWhatsapp(Boolean perTieneWhatsapp) {
		this.perTieneWhatsapp = perTieneWhatsapp;
	}

	@Column(name = "per_partida_nac_pendiente_validacion_rnpn")
	private Boolean perPartidaNacPendienteValidacionRNPN;

	@Column(name = "per_tiene_whatsapp")
	private Boolean perTieneWhatsapp;

	public SgPersona() {
		this.perDuiValidadoRNPN = Boolean.FALSE;
		this.perHabilitado = Boolean.TRUE;
		this.perDireccion = 1;
		this.perPartidaNacimientoPresenta = Boolean.FALSE;
		this.perNaturalizada = Boolean.FALSE;
		this.perTrabaja = Boolean.FALSE;
		this.perEmbarazo = Boolean.FALSE;
		this.perTieneHijos = Boolean.FALSE;
		this.perTieneDiscapacidades = Boolean.FALSE;
		this.perTieneDiagnostico = Boolean.FALSE;
		this.perAccesoInternet = Boolean.FALSE;
		this.perRecibeRemesas = Boolean.FALSE;
		this.perTieneIdentificacion = Boolean.FALSE;
		this.perRetornada = Boolean.FALSE;
	}

	public SgPersona(Long perPk) {
		this.perPk = perPk;
	}

	public SgPersona(Long perPk, Integer perVersion) {
		this.perPk = perPk;
		this.perVersion = perVersion;
	}

	public Long getPerPk() {
		return perPk;
	}

	public void setPerPk(Long perPk) {
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

	public String getPerTercerNombre() {
		return perTercerNombre;
	}

	public void setPerTercerNombre(String perTercerNombre) {
		this.perTercerNombre = perTercerNombre;
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

	public String getPerTercerApellido() {
		return perTercerApellido;
	}

	public void setPerTercerApellido(String perTercerApellido) {
		this.perTercerApellido = perTercerApellido;
	}

	public LocalDate getPerFechaNacimiento() {
		return perFechaNacimiento;
	}

	public void setPerFechaNacimiento(LocalDate perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Long getPerEtnia() {
		return perEtnia;
	}

	public void setPerEtnia(Long perEtnia) {
		this.perEtnia = perEtnia;
	}

	public Long getPerEstadoCivil() {
		return perEstadoCivil;
	}

	public void setPerEstadoCivil(Long perEstadoCivil) {
		this.perEstadoCivil = perEstadoCivil;
	}

	public Long getPerSexo() {
		return perSexo;
	}

	public void setPerSexo(Long perSexo) {
		this.perSexo = perSexo;
	}

	public Long getPerTipoSangre() {
		return perTipoSangre;
	}

	public void setPerTipoSangre(Long perTipoSangre) {
		this.perTipoSangre = perTipoSangre;
	}

	public Integer getPerCantidadHijos() {
		return perCantidadHijos;
	}

	public void setPerCantidadHijos(Integer perCantidadHijos) {
		this.perCantidadHijos = perCantidadHijos;
	}

	public Boolean getPerHabilitado() {
		return perHabilitado;
	}

	public void setPerHabilitado(Boolean perHabilitado) {
		this.perHabilitado = perHabilitado;
	}

	public LocalDateTime getPerUltModFecha() {
		return perUltModFecha;
	}

	public void setPerUltModFecha(LocalDateTime perUltModFecha) {
		this.perUltModFecha = perUltModFecha;
	}

	public String getPerUltModUsuario() {
		return perUltModUsuario;
	}

	public void setPerUltModUsuario(String perUltModUsuario) {
		this.perUltModUsuario = perUltModUsuario;
	}

	public Integer getPerVersion() {
		return perVersion;
	}

	public void setPerVersion(Integer perVersion) {
		this.perVersion = perVersion;
	}

	public Integer getPerDireccion() {
		return perDireccion;
	}

	public void setPerDireccion(Integer perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerPrimerNombreBusqueda() {
		return perPrimerNombreBusqueda;
	}

	public void setPerPrimerNombreBusqueda(String perPrimerNombreBusqueda) {
		this.perPrimerNombreBusqueda = perPrimerNombreBusqueda;
	}

	public String getPerSegundoNombreBusqueda() {
		return perSegundoNombreBusqueda;
	}

	public void setPerSegundoNombreBusqueda(String perSegundoNombreBusqueda) {
		this.perSegundoNombreBusqueda = perSegundoNombreBusqueda;
	}

	public String getPerTercerNombreBusqueda() {
		return perTercerNombreBusqueda;
	}

	public void setPerTercerNombreBusqueda(String perTercerNombreBusqueda) {
		this.perTercerNombreBusqueda = perTercerNombreBusqueda;
	}

	public String getPerPrimerApellidoBusqueda() {
		return perPrimerApellidoBusqueda;
	}

	public void setPerPrimerApellidoBusqueda(String perPrimerApellidoBusqueda) {
		this.perPrimerApellidoBusqueda = perPrimerApellidoBusqueda;
	}

	public String getPerSegundoApellidoBusqueda() {
		return perSegundoApellidoBusqueda;
	}

	public void setPerSegundoApellidoBusqueda(String perSegundoApellidoBusqueda) {
		this.perSegundoApellidoBusqueda = perSegundoApellidoBusqueda;
	}

	public String getPerTercerApellidoBusqueda() {
		return perTercerApellidoBusqueda;
	}

	public void setPerTercerApellidoBusqueda(String perTercerApellidoBusqueda) {
		this.perTercerApellidoBusqueda = perTercerApellidoBusqueda;
	}

	public String getPerNombreBusqueda() {
		return perNombreBusqueda;
	}

	public void setPerNombreBusqueda(String perNombreBusqueda) {
		this.perNombreBusqueda = perNombreBusqueda;
	}

	public String getPerDui() {
		return perDui;
	}

	public void setPerDui(String perDui) {
		this.perDui = perDui;
	}

	public Long getPerCun() {
		return perCun;
	}

	public void setPerCun(Long perCun) {
		this.perCun = perCun;
	}

	public Long getPerNie() {
		return perNie;
	}

	public void setPerNie(Long perNie) {
		this.perNie = perNie;
	}

	public String getPerNip() {
		return perNip;
	}

	public void setPerNip(String perNip) {
		this.perNip = perNip;
	}

	public Long getPerPartidaNacimiento() {
		return perPartidaNacimiento;
	}

	public void setPerPartidaNacimiento(Long perPartidaNacimiento) {
		this.perPartidaNacimiento = perPartidaNacimiento;
	}

	public String getPerPartidaNacimientoFolio() {
		return perPartidaNacimientoFolio;
	}

	public void setPerPartidaNacimientoFolio(String perPartidaNacimientoFolio) {
		this.perPartidaNacimientoFolio = perPartidaNacimientoFolio;
	}

	public String getPerPartidaNacimientoLibro() {
		return perPartidaNacimientoLibro;
	}

	public void setPerPartidaNacimientoLibro(String perPartidaNacimientoLibro) {
		this.perPartidaNacimientoLibro = perPartidaNacimientoLibro;
	}

	public Long getPerDepartamentoNacimento() {
		return perDepartamentoNacimento;
	}

	public void setPerDepartamentoNacimento(Long perDepartamentoNacimento) {
		this.perDepartamentoNacimento = perDepartamentoNacimento;
	}

	public Long getPerMunicipioNacimiento() {
		return perMunicipioNacimiento;
	}

	public void setPerMunicipioNacimiento(Long perMunicipioNacimiento) {
		this.perMunicipioNacimiento = perMunicipioNacimiento;
	}

	public Boolean getPerPartidaNacimientoPresenta() {
		return perPartidaNacimientoPresenta;
	}

	public void setPerPartidaNacimientoPresenta(Boolean perPartidaNacimientoPresenta) {
		this.perPartidaNacimientoPresenta = perPartidaNacimientoPresenta;
	}

	public Long getPerFoto() {
		return perFoto;
	}

	public void setPerFoto(Long perFoto) {
		this.perFoto = perFoto;
	}

	public Long getPerNacionalidad() {
		return perNacionalidad;
	}

	public void setPerNacionalidad(Long perNacionalidad) {
		this.perNacionalidad = perNacionalidad;
	}

	public Long getPerProfesion() {
		return perProfesion;
	}

	public void setPerProfesion(Long perProfesion) {
		this.perProfesion = perProfesion;
	}

	public Long getPerEscolaridad() {
		return perEscolaridad;
	}

	public void setPerEscolaridad(Long perEscolaridad) {
		this.perEscolaridad = perEscolaridad;
	}

	public String getPerNit() {
		return perNit;
	}

	public void setPerNit(String perNit) {
		this.perNit = perNit;
	}

	public Boolean getPerNaturalizada() {
		return perNaturalizada;
	}

	public void setPerNaturalizada(Boolean perNaturalizada) {
		this.perNaturalizada = perNaturalizada;
	}

	public String getPerInpep() {
		return perInpep;
	}

	public void setPerInpep(String perInpep) {
		this.perInpep = perInpep;
	}

	public String getPerIsss() {
		return perIsss;
	}

	public void setPerIsss(String perIsss) {
		this.perIsss = perIsss;
	}

	public String getPerNup() {
		return perNup;
	}

	public void setPerNup(String perNup) {
		this.perNup = perNup;
	}

	public Long getPerOcupacion() {
		return perOcupacion;
	}

	public void setPerOcupacion(Long perOcupacion) {
		this.perOcupacion = perOcupacion;
	}

	public Boolean getPerEmbarazo() {
		return perEmbarazo;
	}

	public void setPerEmbarazo(Boolean perEmbarazo) {
		this.perEmbarazo = perEmbarazo;
	}

	public LocalDate getPerFechaParto() {
		return perFechaParto;
	}

	public void setPerFechaParto(LocalDate perFechaParto) {
		this.perFechaParto = perFechaParto;
	}

	public String getPerJornadaLaboral() {
		return perJornadaLaboral;
	}

	public void setPerJornadaLaboral(String perJornadaLaboral) {
		this.perJornadaLaboral = perJornadaLaboral;
	}

	public Double getPerSalario() {
		return perSalario;
	}

	public void setPerSalario(Double perSalario) {
		this.perSalario = perSalario;
	}

	public String getPerPropiedadVivienda() {
		return perPropiedadVivienda;
	}

	public void setPerPropiedadVivienda(String perPropiedadVivienda) {
		this.perPropiedadVivienda = perPropiedadVivienda;
	}

	public String getPerServiciosBasicos() {
		return perServiciosBasicos;
	}

	public void setPerServiciosBasicos(String perServiciosBasicos) {
		this.perServiciosBasicos = perServiciosBasicos;
	}

	public Boolean getPerAccesoInternet() {
		return perAccesoInternet;
	}

	public void setPerAccesoInternet(Boolean perAccesoInternet) {
		this.perAccesoInternet = perAccesoInternet;
	}

	public Boolean getPerRecibeRemesas() {
		return perRecibeRemesas;
	}

	public void setPerRecibeRemesas(Boolean perRecibeRemesas) {
		this.perRecibeRemesas = perRecibeRemesas;
	}

	public String getPerLugarTrabajo() {
		return perLugarTrabajo;
	}

	public void setPerLugarTrabajo(String perLugarTrabajo) {
		this.perLugarTrabajo = perLugarTrabajo;
	}

	public Boolean getPerTrabaja() {
		return perTrabaja;
	}

	public void setPerTrabaja(Boolean perTrabaja) {
		this.perTrabaja = perTrabaja;
	}

	public Long getPerTipoTrabajo() {
		return perTipoTrabajo;
	}

	public void setPerTipoTrabajo(Long perTipoTrabajo) {
		this.perTipoTrabajo = perTipoTrabajo;
	}

	public Integer getPerFamiliaresEmigrados() {
		return perFamiliaresEmigrados;
	}

	public void setPerFamiliaresEmigrados(Integer perFamiliaresEmigrados) {
		this.perFamiliaresEmigrados = perFamiliaresEmigrados;
	}

	public String getPerNombrePartidaNacimiento() {
		return perNombrePartidaNacimiento;
	}

	public void setPerNombrePartidaNacimiento(String perNombrePartidaNacimiento) {
		this.perNombrePartidaNacimiento = perNombrePartidaNacimiento;
	}

	public String getPerPartidaNacimientoComplemento() {
		return perPartidaNacimientoComplemento;
	}

	public void setPerPartidaNacimientoComplemento(String perPartidaNacimientoComplemento) {
		this.perPartidaNacimientoComplemento = perPartidaNacimientoComplemento;
	}

	public Integer getPerPartidaNacimientoAnio() {
		return perPartidaNacimientoAnio;
	}

	public void setPerPartidaNacimientoAnio(Integer perPartidaNacimientoAnio) {
		this.perPartidaNacimientoAnio = perPartidaNacimientoAnio;
	}

	public Long getPerPartidaNacimientoArchivo() {
		return perPartidaNacimientoArchivo;
	}

	public void setPerPartidaNacimientoArchivo(Long perPartidaNacimientoArchivo) {
		this.perPartidaNacimientoArchivo = perPartidaNacimientoArchivo;
	}

	public Long getPerPartidaDepartamento() {
		return perPartidaDepartamento;
	}

	public void setPerPartidaDepartamento(Long perPartidaDepartamento) {
		this.perPartidaDepartamento = perPartidaDepartamento;
	}

	public Long getPerPartidaMunicipio() {
		return perPartidaMunicipio;
	}

	public void setPerPartidaMunicipio(Long perPartidaMunicipio) {
		this.perPartidaMunicipio = perPartidaMunicipio;
	}

	public Boolean getPerLuceneIndexUpdated() {
		return perLuceneIndexUpdated;
	}

	public void setPerLuceneIndexUpdated(Boolean perLuceneIndexUpdated) {
		this.perLuceneIndexUpdated = perLuceneIndexUpdated;
	}

	public Boolean getPerTieneIdentificacion() {
		return perTieneIdentificacion;
	}

	public void setPerTieneIdentificacion(Boolean perTieneIdentificacion) {
		this.perTieneIdentificacion = perTieneIdentificacion;
	}

	public Long getPerUsuarioPk() {
		return perUsuarioPk;
	}

	public void setPerUsuarioPk(Long perUsuarioPk) {
		this.perUsuarioPk = perUsuarioPk;
	}

	public String getPerEstado() {
		return perEstado;
	}

	public void setPerEstado(String perEstado) {
		this.perEstado = perEstado;
	}

	public LocalDate getPerFechaFallecimiento() {
		return perFechaFallecimiento;
	}

	public void setPerFechaFallecimiento(LocalDate perFechaFallecimiento) {
		this.perFechaFallecimiento = perFechaFallecimiento;
	}

	public Long getPerMotivoFallecimiento() {
		return perMotivoFallecimiento;
	}

	public void setPerMotivoFallecimiento(Long perMotivoFallecimiento) {
		this.perMotivoFallecimiento = perMotivoFallecimiento;
	}

	public Boolean getPerRetornada() {
		return perRetornada;
	}

	public void setPerRetornada(Boolean perRetornada) {
		this.perRetornada = perRetornada;
	}

	public Integer getPerViveConCantidad() {
		return perViveConCantidad;
	}

	public void setPerViveConCantidad(Integer perViveConCantidad) {
		this.perViveConCantidad = perViveConCantidad;
	}

	public Boolean getPerTieneHijos() {
		return perTieneHijos;
	}

	public void setPerTieneHijos(Boolean perTieneHijos) {
		this.perTieneHijos = perTieneHijos;
	}

	public Boolean getPerTieneDiscapacidades() {
		return perTieneDiscapacidades;
	}

	public void setPerTieneDiscapacidades(Boolean perTieneDiscapacidades) {
		this.perTieneDiscapacidades = perTieneDiscapacidades;
	}

	public Boolean getPerTieneDiagnostico() {
		return perTieneDiagnostico;
	}

	public void setPerTieneDiagnostico(Boolean perTieneDiagnostico) {
		this.perTieneDiagnostico = perTieneDiagnostico;
	}

	public Boolean getPerDuiValidadoRNPN() {
		return perDuiValidadoRNPN;
	}

	public void setPerDuiValidadoRNPN(Boolean perDuiValidadoRNPN) {
		this.perDuiValidadoRNPN = perDuiValidadoRNPN;
	}

	public Boolean getPerDuiPendienteValidacionRNPN() {
		return perDuiPendienteValidacionRNPN;
	}

	public void setPerDuiPendienteValidacionRNPN(Boolean perDuiPendienteValidacionRNPN) {
		this.perDuiPendienteValidacionRNPN = perDuiPendienteValidacionRNPN;
	}

	public Boolean getPerCunValidadoRNPN() {
		return perCunValidadoRNPN;
	}

	public void setPerCunValidadoRNPN(Boolean perCunValidadoRNPN) {
		this.perCunValidadoRNPN = perCunValidadoRNPN;
	}

	public Boolean getPerCunPendienteValidacionRNPN() {
		return perCunPendienteValidacionRNPN;
	}

	public void setPerCunPendienteValidacionRNPN(Boolean perCunPendienteValidacionRNPN) {
		this.perCunPendienteValidacionRNPN = perCunPendienteValidacionRNPN;
	}

	public Boolean getPerPartidaNacValidadaRNPN() {
		return perPartidaNacValidadaRNPN;
	}

	public void setPerPartidaNacValidadaRNPN(Boolean perPartidaNacValidadaRNPN) {
		this.perPartidaNacValidadaRNPN = perPartidaNacValidadaRNPN;
	}

	public Boolean getPerPartidaNacPendienteValidacionRNPN() {
		return perPartidaNacPendienteValidacionRNPN;
	}

	public void setPerPartidaNacPendienteValidacionRNPN(Boolean perPartidaNacPendienteValidacionRNPN) {
		this.perPartidaNacPendienteValidacionRNPN = perPartidaNacPendienteValidacionRNPN;
	}

	public Boolean getPerTieneTrastornoAprendizaje() {
		return perTieneTrastornoAprendizaje;
	}

	public void setPerTieneTrastornoAprendizaje(Boolean perTieneTrastornoAprendizaje) {
		this.perTieneTrastornoAprendizaje = perTieneTrastornoAprendizaje;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (perPk != null ? perPk.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SgPersona other = (SgPersona) obj;
		if (!Objects.equals(this.perPk, other.perPk)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SgPersona [perPk=" + perPk + ", perPrimerNombre=" + perPrimerNombre + ", perSegundoNombre="
				+ perSegundoNombre + ", perTercerNombre=" + perTercerNombre + ", perPrimerApellido=" + perPrimerApellido
				+ ", perSegundoApellido=" + perSegundoApellido + ", perTercerApellido=" + perTercerApellido
				+ ", perPrimerNombreBusqueda=" + perPrimerNombreBusqueda + ", perSegundoNombreBusqueda="
				+ perSegundoNombreBusqueda + ", perTercerNombreBusqueda=" + perTercerNombreBusqueda
				+ ", perPrimerApellidoBusqueda=" + perPrimerApellidoBusqueda + ", perSegundoApellidoBusqueda="
				+ perSegundoApellidoBusqueda + ", perTercerApellidoBusqueda=" + perTercerApellidoBusqueda
				+ ", perNombreBusqueda=" + perNombreBusqueda + ", perFechaNacimiento=" + perFechaNacimiento
				+ ", perEmail=" + perEmail + ", perEtnia=" + perEtnia + ", perEstadoCivil=" + perEstadoCivil
				+ ", perSexo=" + perSexo + ", perTipoSangre=" + perTipoSangre + ", perCantidadHijos=" + perCantidadHijos
				+ ", perHabilitado=" + perHabilitado + ", perUltModFecha=" + perUltModFecha + ", perUltModUsuario="
				+ perUltModUsuario + ", perVersion=" + perVersion + ", perDireccion=" + perDireccion + ", perDui="
				+ perDui + ", perCun=" + perCun + ", perNie=" + perNie + ", perNip=" + perNip + ", perNit=" + perNit
				+ ", perInpep=" + perInpep + ", perIsss=" + perIsss + ", perNup=" + perNup + ", perNaturalizada="
				+ perNaturalizada + ", perPartidaNacimiento=" + perPartidaNacimiento + ", perPartidaNacimientoAnio="
				+ perPartidaNacimientoAnio + ", perPartidaNacimientoFolio=" + perPartidaNacimientoFolio
				+ ", perPartidaNacimientoLibro=" + perPartidaNacimientoLibro + ", perPartidaNacimientoComplemento="
				+ perPartidaNacimientoComplemento + ", perPartidaNacimientoPresenta=" + perPartidaNacimientoPresenta
				+ ", perPartidaDepartamento=" + perPartidaDepartamento + ", perPartidaMunicipio=" + perPartidaMunicipio
				+ ", perDepartamentoNacimento=" + perDepartamentoNacimento + ", perMunicipioNacimiento="
				+ perMunicipioNacimiento + ", perFoto=" + perFoto + ", perPartidaNacimientoArchivo="
				+ perPartidaNacimientoArchivo + ", perNacionalidad=" + perNacionalidad + ", perProfesion="
				+ perProfesion + ", perOcupacion=" + perOcupacion + ", perEscolaridad=" + perEscolaridad
				+ ", perLugarTrabajo=" + perLugarTrabajo + ", perTrabaja=" + perTrabaja + ", perTipoTrabajo="
				+ perTipoTrabajo + ", perEmbarazo=" + perEmbarazo + ", perFechaParto=" + perFechaParto
				+ ", perJornadaLaboral=" + perJornadaLaboral + ", perSalario=" + perSalario + ", perPropiedadVivienda="
				+ perPropiedadVivienda + ", perServiciosBasicos=" + perServiciosBasicos + ", perAccesoInternet="
				+ perAccesoInternet + ", perRecibeRemesas=" + perRecibeRemesas + ", perFamiliaresEmigrados="
				+ perFamiliaresEmigrados + ", perViveConCantidad=" + perViveConCantidad
				+ ", perNombrePartidaNacimiento=" + perNombrePartidaNacimiento + ", perTieneIdentificacion="
				+ perTieneIdentificacion + ", perLuceneIndexUpdated=" + perLuceneIndexUpdated + ", perUsuarioPk="
				+ perUsuarioPk + ", perEstado=" + perEstado + ", perFechaFallecimiento=" + perFechaFallecimiento
				+ ", perMotivoFallecimiento=" + perMotivoFallecimiento + ", perRetornada=" + perRetornada
				+ ", perTieneHijos=" + perTieneHijos + ", perTieneDiscapacidades=" + perTieneDiscapacidades
				+ ", perTieneTrastornoAprendizaje=" + perTieneTrastornoAprendizaje + ", perTieneDiagnostico="
				+ perTieneDiagnostico + ", perDuiValidadoRNPN=" + perDuiValidadoRNPN
				+ ", perDuiPendienteValidacionRNPN=" + perDuiPendienteValidacionRNPN + ", perCunValidadoRNPN="
				+ perCunValidadoRNPN + ", perCunPendienteValidacionRNPN=" + perCunPendienteValidacionRNPN
				+ ", perPartidaNacValidadaRNPN=" + perPartidaNacValidadaRNPN + ", perPartidaNacPendienteValidacionRNPN="
				+ perPartidaNacPendienteValidacionRNPN + ", perTieneWhatsapp=" + perTieneWhatsapp + "]";
	}
}