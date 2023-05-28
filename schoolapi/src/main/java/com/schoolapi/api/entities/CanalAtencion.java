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
