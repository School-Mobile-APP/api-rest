package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_allegados", schema = "centros_educativos")
public class Allegado implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long allPk;
	@Column(name = "all_referente")
	private Boolean allReferente;
	@Column(name = "all_contacto_emergencia")
	private Boolean allContactoEmergencia;

	@Column(name = "all_dependiente")
	private Boolean allDependiente;

	@Column(name = "all_persona_ref")
	private Integer allPersonaReferenciada;

	@Column(name = "all_es_familiar")
	private Boolean allEsFamiliar;

	@Column(name = "all_persona")
	private Long allPersona;

	@OneToOne
	@JoinColumn(name="all_tipo_parentesco")
	private TipoParentesco tipoParentesco;
	@Column(name = "all_vive_con_allegado")
    private Boolean allViveConAllegado;
}
