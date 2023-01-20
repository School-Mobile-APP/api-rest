package com.ficha.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.Size;

public class SgFichaPasoTres implements Serializable {
	private static final long serialVersionUID = 1L;
	@Size(max = 255)
	@Column(name = "dir_caserio_texto", length = 255)
	private String dirCaserioTexto;
	
	@Size(max = 100)
	@Column(name = "dir_departamento")
	private Long dirDepartamento;

	@Column(name = "dir_municipio")
	private Long dirMunicipio;

	@Size(max = 500)
	@Column(name = "dir_direccion")
	private String dirDireccion;

	@Column(name = "dir_zona")
	private Long dirZona;
	@Column(name = "dir_canton")
	private Long dirCanton;
	@Column(name="per_tipo_vivienda_fk")
	private Long perTipoViviendaFk;
	@Column(name="per_pk")
	private Long perPk;
	
	public Long getPerPk() {
		return perPk;
	}

	public void setPerPk(Long perPk) {
		this.perPk = perPk;
	}

	public Long getPerTipoViviendaFk() {
		return perTipoViviendaFk;
	}

	public void setPerTipoViviendaFk(Long perTipoViviendaFk) {
		this.perTipoViviendaFk = perTipoViviendaFk;
	}

	public Long getDirCanton() {
		return dirCanton;
	}

	public void setDirCanton(Long dirCanton) {
		this.dirCanton = dirCanton;
	}

	public String getDirCaserioTexto() {
		return dirCaserioTexto;
	}

	public void setDirCaserioTexto(String dirCaserioTexto) {
		this.dirCaserioTexto = dirCaserioTexto;
	}

	public Long getDirDepartamento() {
		return dirDepartamento;
	}

	public void setDirDepartamento(Long dirDepartamento) {
		this.dirDepartamento = dirDepartamento;
	}

	public Long getDirMunicipio() {
		return dirMunicipio;
	}

	public void setDirMunicipio(Long dirMunicipio) {
		this.dirMunicipio = dirMunicipio;
	}

	public String getDirDireccion() {
		return dirDireccion;
	}

	public void setDirDireccion(String dirDireccion) {
		this.dirDireccion = dirDireccion;
	}

	public Long getDirZona() {
		return dirZona;
	}

	public void setDirZona(Long dirZona) {
		this.dirZona = dirZona;
	}
}
