package com.schoolapi.api.entities;

//Representa la tabla personas referencias apoyo
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_personas_referencias_apoyo",schema="centros_educativos")
@IdClass(value = PersonaReferenciaPk.class)
public class PersonaReferencia implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	public Long getPer_pk() {
		return per_pk;
	}
	public void setPer_pk(Long per_pk) {
		this.per_pk = per_pk;
	}
	public Long getRea_pk() {
		return rea_pk;
	}
	public void setRea_pk(Long rea_pk) {
		this.rea_pk = rea_pk;
	}
	@Id
	private Long rea_pk;
}
