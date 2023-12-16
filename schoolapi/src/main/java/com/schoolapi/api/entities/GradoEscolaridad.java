package com.schoolapi.api.entities;

//Representa la tabla grados
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_grados",schema = "centros_educativos")
public class GradoEscolaridad implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private long graPk;
	@Column(name="gra_nombre")
	private String graNombre;
	public long getGraPk() {
		return graPk;
	}
	public void setGraPk(long gradPk) {
		this.graPk = gradPk;
	}
	public String getGraNombre() {
		return graNombre;
	}
	public void setGraNombre(String graNombre) {
		this.graNombre = graNombre;
	}
	public String getGraCodigo() {
		return graCodigo;
	}
	public void setGraCodigo(String graCodigo) {
		this.graCodigo = graCodigo;
	}
	@Column (name="gra_codigo")
	private String graCodigo;
	@OneToOne
	@JoinColumn(name = "gra_relacion_modalidad_fk")
	private ModalidadAtencion modalidad;
	public ModalidadAtencion getModalidad() {
		return modalidad;
	}
	public void setModalidad(ModalidadAtencion modalidad) {
		this.modalidad = modalidad;
	}
	

}
