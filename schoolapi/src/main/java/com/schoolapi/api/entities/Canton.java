package com.schoolapi.api.entities;

//Representa la tala canton
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "sg_cantones", schema = "catalogo")
public class Canton implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long canPk;
	public Long getCanMunicipioFk() {
		return canMunicipioFk;
	}
	public void setCanMunicipioFk(Long canMunicipioFk) {
		this.canMunicipioFk = canMunicipioFk;
	}
	public void setCanPk(Long canPk) {
		this.canPk = canPk;
	}
	@Column (name="can_nombre")
	private String canNombre;
	@Column (name="can_codigo")
	private String canCodigo;
	@Column (name="can_municipio_fk")
	private Long canMunicipioFk;
	public long getCanPk() {
		return canPk;
	}
	public void setCanPk(long canPk) {
		this.canPk = canPk;
	}
	public String getCanNombre() {
		return canNombre;
	}
	public void setCanNombre(String canNombre) {
		this.canNombre = canNombre;
	}
	public String getCanCodigo() {
		return canCodigo;
	}
	public void setCanCodigo(String canCodigo) {
		this.canCodigo = canCodigo;
	}
	

}
