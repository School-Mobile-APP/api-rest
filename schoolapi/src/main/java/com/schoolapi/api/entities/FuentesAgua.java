package com.schoolapi.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sg_fuentes_abastecimiento_agua",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuentesAgua implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faa_pk")
	private long faaPk;
	@Column(name = "faa_codigo", length = 4)
	private String faaCodigo;
	@Column(name = "faa_nombre", length = 255)
	private String faaNombre;
}
