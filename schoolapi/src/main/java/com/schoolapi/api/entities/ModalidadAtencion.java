package com.schoolapi.api.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="sg_rel_mod_ed_mod_aten",schema="centros_educativos")
public class ModalidadAtencion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long reaPk;
	@OneToOne
	@JoinColumn(name = "rea_modalidad_educativa_fk")
	private ModalidadEducativa modalidadEducativa;
	public long getReaPk() {
		return reaPk;
	}
	public void setReaPk(long reaPk) {
		this.reaPk = reaPk;
	}
	public ModalidadEducativa getModalidadEducativa() {
		return modalidadEducativa;
	}
	public void setModalidadEducativa(ModalidadEducativa modalidadEducativa) {
		this.modalidadEducativa = modalidadEducativa;
	}
	
}
