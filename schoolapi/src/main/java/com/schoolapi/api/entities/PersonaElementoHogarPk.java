package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.IdClass;

@IdClass(value = PersonaElementoHogarPk.class)
public class PersonaElementoHogarPk implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long per_pk;
    private Long eho_pk;
}
