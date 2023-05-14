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
@Table(name="sg_nacionalidades",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Nacionalidad implements Serializable{ 
	private static final long serialVersionUID = 1L;
	@Id
	private long nacPk;
	@Column(name = "nac_codigo", length = 4)
	private String nacCodigo;
	@Column(name = "nac_nombre", length = 255)
	private String nacNombre;
}
