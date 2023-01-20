package com.ficha.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sg_est_canales_atencion")
public class SgEstCanalesAtencion implements Serializable {
	  private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eca_pk", nullable = false)
    private Long ecaPk;

    @Column(name = "eca_anio_lectivo_fk", length = 8)
    private Integer ecaAnioLectivoFk;

    public Long getEcaPk() {
		return ecaPk;
	}

	public void setEcaPk(Long ecaPk) {
		this.ecaPk = ecaPk;
	}

	public Integer getEcaAnioLectivoFk() {
		return ecaAnioLectivoFk;
	}

	public void setEcaAnioLectivoFk(Integer ecaAnioLectivoFk) {
		this.ecaAnioLectivoFk = ecaAnioLectivoFk;
	}

	public Integer getEcaEstudianteFk() {
		return ecaEstudianteFk;
	}

	public void setEcaEstudianteFk(Integer ecaEstudianteFk) {
		this.ecaEstudianteFk = ecaEstudianteFk;
	}

	public Integer getEcaCanalFk() {
		return ecaCanalFk;
	}

	public void setEcaCanalFk(Integer ecaCanalFk) {
		this.ecaCanalFk = ecaCanalFk;
	}

	public LocalDateTime getEcaUltModFecha() {
		return ecaUltModFecha;
	}

	public void setEcaUltModFecha(LocalDateTime ecaUltModFecha) {
		this.ecaUltModFecha = ecaUltModFecha;
	}

	public String getEcaUltModUsuario() {
		return ecaUltModUsuario;
	}

	public void setEcaUltModUsuario(String ecaUltModUsuario) {
		this.ecaUltModUsuario = ecaUltModUsuario;
	}

	public Integer getEcaVersion() {
		return ecaVersion;
	}

	public void setEcaVersion(Integer ecaVersion) {
		this.ecaVersion = ecaVersion;
	}

	@Column(name = "eca_estudiante_fk", length = 8)
    private Integer ecaEstudianteFk;

    @Column(name = "eca_canal_fk", length = 8)
    private Integer ecaCanalFk;


    @Column(name = "eca_ult_mod_fecha")
    private LocalDateTime ecaUltModFecha;

    @Size(max = 45)
    @Column(name = "eca_ult_mod_usuario", length = 45)
    private String ecaUltModUsuario;

    @Column(name = "eca_version")
    @Version
    private Integer ecaVersion;

}
