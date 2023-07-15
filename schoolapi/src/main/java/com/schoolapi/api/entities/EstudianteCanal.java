package com.schoolapi.api.entities;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sg_est_canales_atencion",schema="centros_educativos")
public class EstudianteCanal implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eca_pk")
	private Long ecaPk;
	@Column(name="eca_estudiante_fk")
	private Long ecaEstudianteFk;
	@Column(name="eca_canal_fk")
	private Long ecaCanalFk;
	public Long getEcaPk() {
		return ecaPk;
	}
	public void setEcaPk(Long ecaPk) {
		this.ecaPk = ecaPk;
	}
	public Long getEcaEstudianteFk() {
		return ecaEstudianteFk;
	}
	public void setEcaEstudianteFk(Long ecaEstudianteFk) {
		this.ecaEstudianteFk = ecaEstudianteFk;
	}
	public Long getEcaCanalFk() {
		return ecaCanalFk;
	}
	public void setEcaCanalFk(Long ecaCanalFk) {
		this.ecaCanalFk = ecaCanalFk;
	}
	

}
