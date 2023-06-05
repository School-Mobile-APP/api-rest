package com.schoolapi.api.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="sg_datos_residenciales_personas",schema="centros_educativos")
public class DatosResidenciales implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "per_pk")
	private Long perPk;
	
	@Column(name = "per_tiene_servicio_energia_electrica_residencial")
	private Boolean perTieneServicioEnergiaElectricaResidencial;

	public Long getPerPk() {
		return perPk;
	}

	public void setPerPk(Long perPk) {
		this.perPk = perPk;
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

	public Long getPerFuenteAbastecimientoAguaResidencial() {
		return perFuenteAbastecimientoAguaResidencial;
	}

	public void setPerFuenteAbastecimientoAguaResidencial(Long perFuenteAbastecimientoAguaResidencial) {
		this.perFuenteAbastecimientoAguaResidencial = perFuenteAbastecimientoAguaResidencial;
	}

	public Boolean getPeTieneServicioBasura() {
		return peTieneServicioBasura;
	}

	public void setPeTieneServicioBasura(Boolean peTieneServicioBasura) {
		this.peTieneServicioBasura = peTieneServicioBasura;
	}

	@Column(name = "per_tiene_conexion_internet_residencial")
	private Boolean perTieneConexionInternetResidencial;
	
	@Column(name = "per_fuente_abastecimiento_agua_residencial")
	private Long perFuenteAbastecimientoAguaResidencial;
	
	@Column(name="per_tiene_servicio_basura")
	private Boolean peTieneServicioBasura;
}
