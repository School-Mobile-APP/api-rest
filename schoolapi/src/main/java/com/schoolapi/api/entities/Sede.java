package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="sg_sedes",schema="centros_educativos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sede implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long sedPk;
	@Column (name="sed_nombre")
	private String sedNombre;
	@Column (name="sed_codigo")
	private String sedCodigo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sed_direccion_fk")
	private Direccion direccion;
}
