package com.schoolapi.api.entities;
//Representa la llave compuesta de la tabla persona elemento hogar
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_personas_elementos_hogar",schema="centros_educativos")
@IdClass(value = PersonaElementoHogarPk.class)
public class PersonaElementoHogarPk implements Serializable {
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
	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	@Id
    private Long eho_pk;
}
