package com.ficha.model;
import java.io.Serializable;
import javax.persistence.IdClass;

@IdClass(value= SgPersonaTerapiaPk.class)
public class SgPersonaTerapiaPk implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long per_pk;
    private Long ter_pk;
}