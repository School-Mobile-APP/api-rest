
package com.ficha.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sg_direcciones",schema="catalogo")
public class SgDireccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "dir_pk")
	private Long dirPk;

	@Size(max = 500)
	@Column(name = "dir_direccion", length = 500)
	private String dirDireccion;

	@Column(name = "dir_departamento")
	private Long dirDepartamento;

	@Column(name = "dir_municipio")
	private Long dirMunicipio;

	@Column(name = "dir_canton")
	private Long dirCanton;

	@Column(name = "dir_caserio")
	private Long dirCaserio;
	@Size(max = 255)
	@Column(name = "dir_caserio_texto", length = 255)
	private String dirCaserioTexto;

	@Column(name = "dir_tipo_calle_fk")
	private Long dirTipoCalle;

	@Column(name = "dir_zona")
	private Long dirZona;

	@Column(name = "dir_latitud")
	private Double dirLatitud;

	@Column(name = "dir_longitud")
	private Double dirLongitud;

	@Column(name = "dir_ult_mod_fecha")
	private LocalDateTime dirUltModFecha;

	@Size(max = 45)
	@Column(name = "dir_ult_mod_usuario", length = 45)
	private String dirUltModUsuario;

	@Column(name = "dir_version")
	@Version
	private Integer dirVersion;

	public SgDireccion() {
	}

	public SgDireccion(Long perPk) {
		this.dirPk = perPk;
	}

	public Long getDirPk() {
		return dirPk;
	}

	public void setDirPk(Long dirPk) {
		this.dirPk = dirPk;
	}

	public String getDirDireccion() {
		return dirDireccion;
	}

	public void setDirDireccion(String dirDireccion) {
		this.dirDireccion = dirDireccion;
	}

	public Long getDirDepartamento() {
		return dirDepartamento;
	}

	public void setDirDepartamento(Long dirDepartamento) {
		this.dirDepartamento = dirDepartamento;
	}

	public Long getDirMunicipio() {
		return dirMunicipio;
	}

	public void setDirMunicipio(Long dirMunicipio) {
		this.dirMunicipio = dirMunicipio;
	}

	public Long getDirCanton() {
		return dirCanton;
	}

	public void setDirCanton(Long dirCanton) {
		this.dirCanton = dirCanton;
	}

	public Long getDirCaserio() {
		return dirCaserio;
	}

	public void setDirCaserio(Long dirCaserio) {
		this.dirCaserio = dirCaserio;
	}

	public Long getDirZona() {
		return dirZona;
	}

	public void setDirZona(Long dirZona) {
		this.dirZona = dirZona;
	}

	public Double getDirLatitud() {
		return dirLatitud;
	}

	public void setDirLatitud(Double dirLatitud) {
		this.dirLatitud = dirLatitud;
	}

	public Double getDirLongitud() {
		return dirLongitud;
	}

	public void setDirLongitud(Double dirLongitud) {
		this.dirLongitud = dirLongitud;
	}

	public LocalDateTime getDirUltModFecha() {
		return dirUltModFecha;
	}

	public void setDirUltModFecha(LocalDateTime dirUltModFecha) {
		this.dirUltModFecha = dirUltModFecha;
	}

	public String getDirUltModUsuario() {
		return dirUltModUsuario;
	}

	public void setDirUltModUsuario(String dirUltModUsuario) {
		this.dirUltModUsuario = dirUltModUsuario;
	}

	public Integer getDirVersion() {
		return dirVersion;
	}

	public void setDirVersion(Integer dirVersion) {
		this.dirVersion = dirVersion;
	}

	public String getDirCaserioTexto() {
		return dirCaserioTexto;
	}

	public void setDirCaserioTexto(String dirCaserioTexto) {
		this.dirCaserioTexto = dirCaserioTexto;
	}

	public Long getDirTipoCalle() {
		return dirTipoCalle;
	}

	public void setDirTipoCalle(Long dirTipoCalle) {
		this.dirTipoCalle = dirTipoCalle;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 11 * hash + Objects.hashCode(this.dirPk);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SgDireccion other = (SgDireccion) obj;
		if (!Objects.equals(this.dirPk, other.dirPk)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SgDireccion [dirPk=" + dirPk + ", dirDireccion=" + dirDireccion + ", dirDepartamento=" + dirDepartamento
				+ ", dirMunicipio=" + dirMunicipio + ", dirCanton=" + dirCanton + ", dirCaserio=" + dirCaserio
				+ ", dirCaserioTexto=" + dirCaserioTexto + ", dirTipoCalle=" + dirTipoCalle + ", dirZona=" + dirZona
				+ ", dirLatitud=" + dirLatitud + ", dirLongitud=" + dirLongitud + ", dirUltModFecha=" + dirUltModFecha
				+ ", dirUltModUsuario=" + dirUltModUsuario + ", dirVersion=" + dirVersion + "]";
	}


}
