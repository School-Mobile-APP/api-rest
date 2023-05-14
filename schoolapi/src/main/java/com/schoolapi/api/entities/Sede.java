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
}
