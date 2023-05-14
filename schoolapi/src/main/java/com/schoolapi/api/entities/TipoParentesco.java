package com.schoolapi.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class TipoParentesco implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private long tpaPk;
	@Column(name = "tpa_codigo", length = 4)
	private String tpaCodigo;
	@Column(name = "tpa_nombre", length = 255)
	private String tpaNombre;
}
