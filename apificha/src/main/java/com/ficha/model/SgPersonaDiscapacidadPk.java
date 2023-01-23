package com.ficha.model;
import java.io.Serializable;
import javax.persistence.IdClass;

@IdClass(value = SgPersonaDiscapacidadPk.class)
public class SgPersonaDiscapacidadPk implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long per_pk;
    private Long dis_pk;
}