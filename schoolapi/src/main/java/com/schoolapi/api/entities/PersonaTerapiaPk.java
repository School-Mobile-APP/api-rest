package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.IdClass;
//Representa la llave compuesta de la tabla persona terapia
@IdClass(value= PersonaTerapiaPk.class)
public class PersonaTerapiaPk implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long per_pk;
    private Long ter_pk;
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
}
