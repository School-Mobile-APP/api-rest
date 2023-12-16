package com.schoolapi.api.entities;

//Representa la tabla estado civil
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_estados_civil",schema="catalogo")
public class EstadoCivil implements Serializable{ 
	public long getEciPk() {
		return eciPk;
	}
	public void setEciPk(long eciPk) {
		this.eciPk = eciPk;
	}
	public String getEciCodigo() {
		return eciCodigo;
	}
	public void setEciCodigo(String eciCodigo) {
		this.eciCodigo = eciCodigo;
	}
	public String getEciNombre() {
		return eciNombre;
	}
	public void setEciNombre(String eciNombre) {
		this.eciNombre = eciNombre;
	}
	private static final long serialVersionUID = 1L; 
	@Id
	private long eciPk;
	@Column(name = "eci_codigo", length = 4)
	private String eciCodigo;
	@Column(name = "eci_nombre", length = 255)
	private String eciNombre;
}
