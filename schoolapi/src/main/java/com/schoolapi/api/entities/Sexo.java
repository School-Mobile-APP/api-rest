package com.schoolapi.api.entities;

//Representa la tabla sexo
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_sexos",schema="catalogo")

public class Sexo implements Serializable{
	public long getSexPk() {
		return sexPk;
	}
	public void setSexPk(long sexPk) {
		this.sexPk = sexPk;
	}
	public String getSexCodigo() {
		return sexCodigo;
	}
	public void setSexCodigo(String sexCodigo) {
		this.sexCodigo = sexCodigo;
	}
	public String getSexNombre() {
		return sexNombre;
	}
	public void setSexNombre(String sexNombre) {
		this.sexNombre = sexNombre;
	}
	private static final long serialVersionUID = 1L;
	@Id
	private long sexPk;
	@Column(name = "sex_codigo", length = 4)
	private String sexCodigo;
	@Column(name = "sex_nombre", length = 255)
	private String sexNombre;
}
