package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_telefonos",schema="centros_educativos")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "tel_pk")
	private Long telPk;

	@Column(name = "tel_telefono", length = 15)
	private String telTelefono;

	@Column(name = "tel_persona")
	private Integer telPersona;
}
