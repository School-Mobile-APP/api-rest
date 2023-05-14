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
@Table(name = "sg_convivencia_familiar",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConvivenciaFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cof_pk")
	private long cofPk;
	@Column(name = "cof_codigo", length = 4)
	private String cofCodigo;
	@Column(name = "cof_nombre", length = 255)
	private String cofNombre;
}
