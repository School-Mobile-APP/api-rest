package com.schoolapi.api.entities;

//Representa la llave compuesta de la tabla persona discapacidad
import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.IdClass;

@IdClass(value = PersonaDiscapacidadPk.class)
public class PersonaDiscapacidadPk implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long per_pk;
	@Id
	private Long dis_pk;
}
