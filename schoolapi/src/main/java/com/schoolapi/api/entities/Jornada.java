package com.schoolapi.api.entities;
// Representa la tabla jornadas laborales
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="sg_jornadas_laborales",schema="catalogo")
public class Jornada implements Serializable{ 
	public long getJlaPk() {
		return jlaPk;
	}
	public void setJlaPk(long jlaPk) {
		this.jlaPk = jlaPk;
	}
	public String getJlaCodigo() {
		return jlaCodigo;
	}
	public void setJlaCodigo(String jlaCodigo) {
		this.jlaCodigo = jlaCodigo;
	}
	public String getJlaNombre() {
		return jlaNombre;
	}
	public void setJlaNombre(String jlaNombre) {
		this.jlaNombre = jlaNombre;
	}
	private static final long serialVersionUID = 1L; 
	@Id
	private long jlaPk;
	@Column(name = "jla_codigo", length = 4)
	private String jlaCodigo;
	@Column(name = "jla_nombre", length = 255)
	private String jlaNombre;
}
