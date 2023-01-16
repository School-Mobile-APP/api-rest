package com.ficha.model;
import java.util.Objects;
import java.io.Serializable;
import javax.persistence.IdClass;

@IdClass(value= SgPersonaReferenciaPK.class)
public class SgPersonaReferenciaPK implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long per_pk;
    private Long rea_pk;
}