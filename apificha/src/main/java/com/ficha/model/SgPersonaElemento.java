package com.ficha.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sg_personas_elementos_hogar")
@IdClass(value = SgPersonaElementoPk.class)
public class SgPersonaElemento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	@Id
	private Long eho_pk;
	public Long getPer_pk() {
		return per_pk;
	}
	public void setPer_pk(Long per_pk) {
		this.per_pk = per_pk;
	}
	public Long getEho_pk() {
		return eho_pk;
	}
	public void setEho_pk(Long eho_pk) {
		this.eho_pk = eho_pk;
	}
}
