package com.ficha.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "sg_personas_discapacidades")
@IdClass(value = SgPersonaDiscapacidadPk.class)
public class SgPersonaDiscapacidad implements Serializable{
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

	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	@Id
	private Long dis_pk;

	public SgPersonaDiscapacidad() {
	}
}