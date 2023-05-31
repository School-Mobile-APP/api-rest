package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ServicioEducativo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="sdu_pk")
	private Long sduPk;
	

}
