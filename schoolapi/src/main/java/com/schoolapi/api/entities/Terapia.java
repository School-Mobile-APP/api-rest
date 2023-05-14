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
@Table(name="sg_terapias",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Terapia implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long terPk;
	@Column(name = "ter_codigo", length = 4)
	private String terCodigo;
	@Column(name = "ter_nombre", length = 255)
	private String terNombre;
}
