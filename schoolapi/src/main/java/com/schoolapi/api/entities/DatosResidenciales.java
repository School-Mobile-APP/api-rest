package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class DatosResidenciales implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "per_pk")
	private Long perPk;
	
	@Column(name = "per_tiene_servicio_energia_electrica_residencial")
	private Boolean perTieneServicioEnergiaElectricaResidencial;

	@Column(name = "per_tiene_conexion_internet_residencial")
	private Boolean perTieneConexionInternetResidencial;
	
	@Column(name = "per_fuente_abastecimiento_agua_residencial")
	private Long perFuenteAbastecimientoAguaResidencial;
	
	@Column(name="per_tiene_servicio_basura")
	private Boolean peTieneServicioBasura;


}
