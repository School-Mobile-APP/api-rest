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
@Table(name="sg_canales_atencion",schema="catalogo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CanalAtencion implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "can_pk")
	private long canPk;
	@Column(name = "can_codigo", length = 4)
	private String canCodigo;
	@Column(name = "can_nombre", length = 255)
	private String canNombre;

}
