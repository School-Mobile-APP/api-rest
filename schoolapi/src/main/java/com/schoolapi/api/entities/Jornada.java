package com.schoolapi.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="sg_jornadas_laborales",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Jornada implements Serializable{ 
	private static final long serialVersionUID = 1L; 
	@Id
	private long jlaPk;
	@Column(name = "jla_codigo", length = 4)
	private String jlaCodigo;
	@Column(name = "jla_nombre", length = 255)
	private String jlaNombre;
}
