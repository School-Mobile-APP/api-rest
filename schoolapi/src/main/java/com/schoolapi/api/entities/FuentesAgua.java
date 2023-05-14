package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
