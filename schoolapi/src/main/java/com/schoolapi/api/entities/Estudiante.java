package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_estudiantes",schema="centros_educativos")
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="est_pk")
	private Long estPk;
	@OneToOne
	@JoinColumn(name="est_persona")
	private Persona persona;
	@OneToOne
	@JoinColumn(name="est_ultima_matricula_fk")
	private Matricula matricula;
}
