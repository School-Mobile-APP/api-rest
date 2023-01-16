package com.ficha.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sg_personas_referencias_apoyo")
@IdClass(value = SgPersonaReferenciaPK.class)
public class SgPersonaReferencia implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	@Id
	private Long rea_pk;
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

    public SgPersonaReferencia() {
    }
}