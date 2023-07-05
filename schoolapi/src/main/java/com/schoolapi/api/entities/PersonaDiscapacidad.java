package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_personas_discapacidades",schema="centros_educativos")
@IdClass(value = PersonaDiscapacidadPk.class)
public class PersonaDiscapacidad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	@Id
	private Long dis_pk;
	public Long getPer_pk() {
		return per_pk;
	}
	public void setPer_pk(Long per_pk) {
		this.per_pk = per_pk;
	}
	public Long getDis_pk() {
		return dis_pk;
	}
	public void setDis_pk(Long dis_pk) {
		this.dis_pk = dis_pk;
	}
}
