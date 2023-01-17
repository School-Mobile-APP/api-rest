package com.ficha.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sg_personas_terapias")
@IdClass(value = SgPersonaTerapiaPk.class)
public class SgPersonaTerapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long per_pk;
    @Id
    private Long ter_pk;

    public SgPersonaTerapia() {
    }

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