package com.ficha.model;

import java.io.Serializable;

import javax.persistence.Column;

public class SgFichaPasoCuatro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "per_tiene_servicio_energia_electrica_residencial")
	private Boolean perTieneServicioEnergiaElectricaResidencial;
	@Column(name = "per_fuente_abastecimiento_agua_residencial")
	private Long perFuenteAbastecimientoAguaResidencial;
	@Column(name="per_tiene_servicio_basura")
	private Boolean peTieneServicioBasura;
	
	public Boolean getPerTieneServicioEnergiaElectricaResidencial() {
		return perTieneServicioEnergiaElectricaResidencial;
	}
	public void setPerTieneServicioEnergiaElectricaResidencial(Boolean perTieneServicioEnergiaElectricaResidencial) {
		this.perTieneServicioEnergiaElectricaResidencial = perTieneServicioEnergiaElectricaResidencial;
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

}
