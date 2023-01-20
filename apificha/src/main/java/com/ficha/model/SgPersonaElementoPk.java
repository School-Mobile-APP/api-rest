package com.ficha.model;
import java.util.Objects;
import java.io.Serializable;
import javax.persistence.IdClass;

@IdClass(value = SgPersonaElementoPk.class)
public class SgPersonaElementoPk implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long per_pk;
    private Long eho_pk;
}