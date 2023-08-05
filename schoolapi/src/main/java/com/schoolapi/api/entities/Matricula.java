package com.schoolapi.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_matriculas",schema="centros_educativos")
public class Matricula implements Serializable{
	public Long getMatPk() {
		return matPk;
	}
	public void setMatPk(Long matPk) {
		this.matPk = matPk;
	}
	public String getMatEstado() {
		return matEstado;
	}
	public void setMatEstado(String matEstado) {
		this.matEstado = matEstado;
	}
	public Date getMatFechaRegistro() {
		return matFechaRegistro;
	}
	public void setMatFechaRegistro(Date matFechaRegistro) {
		this.matFechaRegistro = matFechaRegistro;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="mat_pk")
	private Long matPk;
	@Column(name="mat_estado")
	private String matEstado;
	@Column(name="mat_fecha_registro")
	private Date matFechaRegistro;
	@Column(name="mat_fecha_hasta")
	private Date matFechaHasta; 
	public Date getMatFechaHasta() {
		return matFechaHasta;
	}
	public void setMatFechaHasta(Date matFechaHasta) {
		this.matFechaHasta = matFechaHasta;
	}
	public List<Seccion> getSeccion() {
		return seccion;
	}
	public void setSeccion(List<Seccion> seccion) {
		this.seccion = seccion;
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "secPk")
	private List<Seccion> seccion;
}
