package com.schoolapi.api.entities;
//Representa la tabla ingresos familiares
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_ingresos_familiares",schema = "catalogo")
public class Ingresos implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long infPk;
	@Column(name="inf_nombre")
	private String infNombre;
	public long getInfPk() {
		return infPk;
	}
	public void setInfPk(long infPk) {
		this.infPk = infPk;
	}
	public String getInfNombre() {
		return infNombre;
	}
	public void setInfNombre(String infNombre) {
		this.infNombre = infNombre;
	}

}
