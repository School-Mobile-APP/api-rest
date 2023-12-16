package com.schoolapi.api.entities;

//Representa la tabla escolaridad estudiante
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_escolaridad_estudiante",schema="centros_educativos")
public class EscolaridadEstudiante implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="esc_pk")
	private Long escPk;
	public Long getEscPk() {
		return escPk;
	}
	public void setEscPk(Long escPk) {
		this.escPk = escPk;
	}
}
