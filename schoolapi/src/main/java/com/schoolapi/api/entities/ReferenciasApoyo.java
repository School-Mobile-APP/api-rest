package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sg_referencias_apoyo",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReferenciasApoyo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private long reaPk;
	@Column(name = "rea_codigo", length = 4)
	private String reaCodigo;
	@Column(name = "rea_Nombre", length = 255)
	private String reaNombre;
}
