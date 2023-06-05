package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_secciones",schema="centros_educativos")
public class Seccion implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="sec_pk")
	private Long secPk;
	
}
