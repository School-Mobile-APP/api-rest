package com.schoolapi.api.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_matriculas",schema="centros_educativos")
public class Matricula implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="mat_pk")
	private Long matPk;
	@Column(name="mat_estado")
	private String matEstado;
	@Column(name="mat_fecha_registro")
	private Date matFechaRegistro;
}
