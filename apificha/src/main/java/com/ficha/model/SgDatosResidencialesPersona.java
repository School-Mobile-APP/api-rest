package com.ficha.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "sg_datos_residenciales_personas")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "perPk", scope = SgDatosResidencialesPersona.class)
public class SgDatosResidencialesPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "per_pk")
	private Long perPk;

	@Column(name = "per_cantidad_dormitorios_casa")
	private Integer perCantidadDormitoriosCasa;

	@Column(name = "per_tiene_servicio_energia_electrica_residencial")
	private Boolean perTieneServicioEnergiaElectricaResidencial;

	@Column(name = "per_tiene_conexion_internet_residencial")
	private Boolean perTieneConexionInternetResidencial;

	@Column(name = "per_compania_internet_residencial")
	private Long perCompaniaInternetResidencial;

	@Column(name = "per_tipo_servicio_sanitario_residencial")
	private Long perTipoServicioSanitarioResidencial;

	@Column(name = "per_tipo_servicio_sanitario_residencial_otro")
	private String perTipoServicioSanitarioResidencialOtro;

	@Column(name = "per_fuente_abastecimiento_agua_residencial")
	private Long perFuenteAbastecimientoAguaResidencial;

	@Column(name = "per_fuente_abastecimiento_agua_residencial_otra")
	private String perFuenteAbastecimientoAguaResidencialOtra;

	@Column(name = "per_material_piso_residencial")

	private Long perMaterialPisoResidencial;

	@Column(name = "per_material_piso_residencial_otro")
	private String perMaterialPisoResidencialOtro;
	
	@Column(name="per_tiene_servicio_basura")
	private Boolean peTieneServicioBasura;

	@Column(name = "per_version")
	@Version
	private Integer perVersion;

	public SgDatosResidencialesPersona() {

	}

	public SgDatosResidencialesPersona(Long perPk) {
		this.perPk = perPk;
	}

	public SgDatosResidencialesPersona(Long perPk, Integer perVersion) {
		this.perPk = perPk;
		this.perVersion = perVersion;
	}

	public Long getPerPk() {
		return perPk;
	}

	public void setPerPk(Long perPk) {
		this.perPk = perPk;
	}

	public Integer getPerVersion() {
		return perVersion;
	}

	public void setPerVersion(Integer perVersion) {
		this.perVersion = perVersion;
	}

	public Integer getPerCantidadDormitoriosCasa() {
		return perCantidadDormitoriosCasa;
	}

	public void setPerCantidadDormitoriosCasa(Integer perCantidadDormitoriosCasa) {
		this.perCantidadDormitoriosCasa = perCantidadDormitoriosCasa;
	}

	public Boolean getPerTieneServicioEnergiaElectricaResidencial() {
		return perTieneServicioEnergiaElectricaResidencial;
	}

	public void setPerTieneServicioEnergiaElectricaResidencial(Boolean perTieneServicioEnergiaElectricaResidencial) {
		this.perTieneServicioEnergiaElectricaResidencial = perTieneServicioEnergiaElectricaResidencial;
	}

	public Boolean getPerTieneConexionInternetResidencial() {
		return perTieneConexionInternetResidencial;
	}

	public void setPerTieneConexionInternetResidencial(Boolean perTieneConexionInternetResidencial) {
		this.perTieneConexionInternetResidencial = perTieneConexionInternetResidencial;
	}

	public Long getPerCompaniaInternetResidencial() {
		return perCompaniaInternetResidencial;
	}

	public void setPerCompaniaInternetResidencial(Long perCompaniaInternetResidencial) {
		this.perCompaniaInternetResidencial = perCompaniaInternetResidencial;
	}

	public Long getPerTipoServicioSanitarioResidencial() {
		return perTipoServicioSanitarioResidencial;
	}

	public void setPerTipoServicioSanitarioResidencial(Long perTipoServicioSanitarioResidencial) {
		this.perTipoServicioSanitarioResidencial = perTipoServicioSanitarioResidencial;
	}

	public String getPerTipoServicioSanitarioResidencialOtro() {
		return perTipoServicioSanitarioResidencialOtro;
	}

	public void setPerTipoServicioSanitarioResidencialOtro(String perTipoServicioSanitarioResidencialOtro) {
		this.perTipoServicioSanitarioResidencialOtro = perTipoServicioSanitarioResidencialOtro;
	}

	public String getPerFuenteAbastecimientoAguaResidencialOtra() {
		return perFuenteAbastecimientoAguaResidencialOtra;
	}

	public void setPerFuenteAbastecimientoAguaResidencialOtra(String perFuenteAbastecimientoAguaResidencialOtra) {
		this.perFuenteAbastecimientoAguaResidencialOtra = perFuenteAbastecimientoAguaResidencialOtra;
	}

	public Long getPerFuenteAbastecimientoAguaResidencial() {
		return perFuenteAbastecimientoAguaResidencial;
	}

	public void setPerFuenteAbastecimientoAguaResidencial(Long perFuenteAbastecimientoAguaResidencial) {
		this.perFuenteAbastecimientoAguaResidencial = perFuenteAbastecimientoAguaResidencial;
	}

	public Long getPerMaterialPisoResidencial() {
		return perMaterialPisoResidencial;
	}

	public void setPerMaterialPisoResidencial(Long perMaterialPisoResidencial) {
		this.perMaterialPisoResidencial = perMaterialPisoResidencial;
	}

	public Boolean getPeTieneServicioBasura() {
		return peTieneServicioBasura;
	}

	public void setPeTieneServicioBasura(Boolean peTieneServicioBasura) {
		this.peTieneServicioBasura = peTieneServicioBasura;
	}

	public String getPerMaterialPisoResidencialOtro() {
		return perMaterialPisoResidencialOtro;
	}

	public void setPerMaterialPisoResidencialOtro(String perMaterialPisoResidencialOtro) {
		this.perMaterialPisoResidencialOtro = perMaterialPisoResidencialOtro;
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
		final SgDatosResidencialesPersona other = (SgDatosResidencialesPersona) obj;
		if (!Objects.equals(this.perPk, other.perPk)) {
			return false;
		}
		return true;
	}

}
