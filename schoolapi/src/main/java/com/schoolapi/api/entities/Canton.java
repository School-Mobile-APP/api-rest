package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sg_cantones", schema = "catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Canton implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long canPk;
	@Column (name="can_nombre")
	private String canNombre;
	@Column (name="can_codigo")
	private String canCodigo;
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
