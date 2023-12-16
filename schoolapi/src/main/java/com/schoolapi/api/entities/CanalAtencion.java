package com.schoolapi.api.entities;
//representa la tabla canales atencion
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="sg_canales_atencion",schema="catalogo")
public class CanalAtencion implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "can_pk")
	private long canPk;
	@Column(name = "can_codigo", length = 4)
	private String canCodigo;
	@Column(name = "can_nombre", length = 255)
	private String canNombre;
	public long getCanPk() {
		return canPk;
	}
	public void setCanPk(long canPk) {
		this.canPk = canPk;
	}
	public String getCanCodigo() {
		return canCodigo;
	}
	public void setCanCodigo(String canCodigo) {
		this.canCodigo = canCodigo;
	}
	public String getCanNombre() {
		return canNombre;
	}
	public void setCanNombre(String canNombre) {
		this.canNombre = canNombre;
	}

}
