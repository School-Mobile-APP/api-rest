package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
//Representa la tabla personas terapias
@Entity
@Table(name = "sg_personas_terapias",schema="centros_educativos")
@IdClass(value = PersonaTerapiaPk.class)
public class PersonaTerapia implements Serializable {
	public Long getPer_pk() {
		return per_pk;
	}
	public void setPer_pk(Long per_pk) {
		this.per_pk = per_pk;
	}
	public Long getTer_pk() {
		return ter_pk;
	}
	public void setTer_pk(Long ter_pk) {
		this.ter_pk = ter_pk;
	}
	private static final long serialVersionUID = 1L;
	@Id
    private Long per_pk;
    @Id
    private Long ter_pk;
}
