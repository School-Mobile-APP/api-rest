package com.schoolapi.api.entities;

//Representa la tabla multi modalidades
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_multi_modalidades",schema="catalogo")
public class Modalidad implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long mulPk;
	@Column(name = "mul_codigo", length = 4)
	private String mulCodigo;
	@Column(name = "mul_Nombre", length = 255)
	private String mulNombre;
	public long getMulPk() {
		return mulPk;
	}
	public void setMulPk(long mulPk) {
		this.mulPk = mulPk;
	}
	public String getMulCodigo() {
		return mulCodigo;
	}
	public void setMulCodigo(String mulCodigo) {
		this.mulCodigo = mulCodigo;
	}
	public String getMulNombre() {
		return mulNombre;
	}
	public void setMulNombre(String mulNombre) {
		this.mulNombre = mulNombre;
	}
}
