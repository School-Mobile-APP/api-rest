package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Canton implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long canPk;
	@Column (name="can_nombre")
	private String canNombre;
	@Column (name="can_codigo")
	private String canCodigo;

}
