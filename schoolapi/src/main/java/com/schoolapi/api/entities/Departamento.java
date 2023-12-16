package com.schoolapi.api.entities;

//Representa la tabla departamentos
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_departamentos", schema = "catalogo")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "dep_pk")
	private long depPk;
	@Column(name = "dep_codigo", length = 4)
	private String depCodigo;
	@Column(name = "dep_nombre", length = 255)
	private String depNombre;
	public long getDepPk() {
		return depPk;
	}
	public void setDepPk(long depPk) {
		this.depPk = depPk;
	}
	public String getDepCodigo() {
		return depCodigo;
	}
	public void setDepCodigo(String depCodigo) {
		this.depCodigo = depCodigo;
	}
	public String getDepNombre() {
		return depNombre;
	}
	public void setDepNombre(String depNombre) {
		this.depNombre = depNombre;
	}
}
