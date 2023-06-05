package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_direcciones", schema = "centros_educativos")
public class Direccion implements Serializable{ 
	private static final long serialVersionUID = 1L;
	@Id
	private long dirPk;
	@Column (name="dir_direccion")
	private String dirDireccion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dir_municipio")
	private Municipio municipio;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dir_departamento")
	private Departamento departamento;
	@Column(name="dir_caserio_texto")
	private String dirCaserioTexto;
	public long getDirPk() {
		return dirPk;
	}
	public void setDirPk(long dirPk) {
		this.dirPk = dirPk;
	}
	public String getDirDireccion() {
		return dirDireccion;
	}
	public void setDirDireccion(String dirDireccion) {
		this.dirDireccion = dirDireccion;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public String getDirCaserioTexto() {
		return dirCaserioTexto;
	}
	public void setDirCaserioTexto(String dirCaserioTexto) {
		this.dirCaserioTexto = dirCaserioTexto;
	}
	public Canton getCanton() {
		return canton;
	}
	public void setCanton(Canton canton) {
		this.canton = canton;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dir_canton")
	private Canton canton;
}
