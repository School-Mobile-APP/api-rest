package com.schoolapi.api.entities;

//Representa la tabla sedes
import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="sg_sedes",schema="centros_educativos")
public class Sede implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long sedPk;
	@Column (name="sed_nombre")
	private String sedNombre;
	@Column (name="sed_codigo")
	private String sedCodigo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sed_direccion_fk")
	private Direccion direccion;
	public long getSedPk() {
		return sedPk;
	}
	public void setSedPk(long sedPk) {
		this.sedPk = sedPk;
	}
	public String getSedNombre() {
		return sedNombre;
	}
	public void setSedNombre(String sedNombre) {
		this.sedNombre = sedNombre;
	}
	public String getSedCodigo() {
		return sedCodigo;
	}
	public void setSedCodigo(String sedCodigo) {
		this.sedCodigo = sedCodigo;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}
