package com.ficha.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sg_personas_terapias")
public class SgPersonaTerapia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "per_pk")
    private Long perPk;
    @Id
    @Column(name = "ter_pk")
    private Integer perTerPk;


    public SgPersonaTerapia() {
    }


    public Long getPerPk() {
		return perPk;
	}


	public void setPerPk(Long perPk) {
		this.perPk = perPk;
	}

	public Integer getPerTerPk() {
		return perTerPk;
	}


	public void setPerTerPk(Integer perTerPk) {
		this.perTerPk = perTerPk;
	}


	@Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SgProfesion[ proPk=" + perPk + " ]";
    }

}