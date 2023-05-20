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
@Table(name="sg_multi_modalidades",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Modalidad implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long mulPk;
	@Column(name = "mul_codigo", length = 4)
	private String mulCodigo;
	@Column(name = "mul_Nombre", length = 255)
	private String mulNombre;
}
