package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_personas_elementos_hogar",schema="centros_educativos")
@IdClass(value = PersonaElementoHogarPk.class)
public class ElementoHogar implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	@Id
	private Long eho_pk;

}
