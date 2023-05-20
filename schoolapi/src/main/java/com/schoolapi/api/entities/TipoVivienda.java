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
@Table(name = "sg_tipo_vivienda",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoVivienda implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long tivPk;
	@Column(name = "tiv_codigo", length = 4)
	private String tiv_codigo;
	@Column(name = "tiv_nombre", length = 255)
	private String tivNombre;
}
