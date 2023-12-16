package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.IdClass;
//Utilizado para representar claves primarias compuestas en la tabla persona referencia
@IdClass(value= PersonaReferenciaPk.class)
public class PersonaReferenciaPk implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long per_pk;
    private Long rea_pk;
}
