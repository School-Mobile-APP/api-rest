package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.IdClass;

@IdClass(value= PersonaTerapiaPk.class)
public class PersonaTerapiaPk implements Serializable{
	private static final long serialVersionUID = 1L;
    private Long per_pk;
    private Long ter_pk;
}
