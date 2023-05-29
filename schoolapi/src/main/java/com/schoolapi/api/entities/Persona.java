package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_personas",schema="centros_educativos")
public class Persona implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long perPk;
	@Column(name="per_primer_nombre")
	private String perPrimerNombre;
	@Column(name="per_segundo_nombre")
	private String perSegundoNombre;
	@Column (name="per_primer_apellido")
	private String perPrimerApellido;
	@Column (name="per_segundo_apellido")
	private String perSegundoApellido;
	@Column (name="per_email")
	private String perEmail;
	@OneToOne
	@JoinColumn(name="per_etnia_fk")
	private Etnia etnia;
	@OneToOne
	@JoinColumn(name="per_estado_civil_fk")
	private EstadoCivil estadoCivil;
	@OneToOne
	@JoinColumn(name="per_sexo_fk")
	private Sexo sexo;
	@Column(name="per_cantidad_hijos")
	private Integer perCantidadHijos;
	@Column (name="per_dui")
	private String perDui;
	@OneToOne
	@JoinColumn(name="per_nacionalidad_fk")
	private Nacionalidad nacionalidad;
	@OneToOne
	@JoinColumn(name="per_direccion_fk")
	private Direccion direccion;
	@Column(name="per_partida_nacimiento_presenta")
	private Boolean perPartidaNacimientoPresenta;
	@OneToOne
	@JoinColumn(name="per_tipo_trabajo_fk")
	private TipoTrabajo tipoTrabajo;
	
	
}
