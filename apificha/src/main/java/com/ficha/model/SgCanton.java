package com.ficha.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sg_cantones", uniqueConstraints = {
		@UniqueConstraint(name = "can_codigo_nombre_uk", columnNames = { "can_codigo", "can_nombre" }) }
		,schema="catalogo")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "canPk", scope = SgCanton.class)
public class SgCanton implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "can_pk", nullable = false)
	private Long canPk;

	@Column(name = "can_municipio_fk")
	private Integer canMunicipio;

	@Size(max = 6)
	@Column(name = "can_codigo", length = 6)
	private String canCodigo;

	@Column(name = "can_habilitado")
	private Boolean canHabilitado;

	@Size(max = 255)
	@Column(name = "can_nombre", length = 255)
	private String canNombre;

	@Size(max = 255)
	@Column(name = "can_nombre_busqueda", length = 255)
	private String canNombreBusqueda;

	@Column(name = "can_ult_mod_fecha")
	private LocalDateTime canUltModFecha;

	@Size(max = 45)
	@Column(name = "can_ult_mod_usuario", length = 45)
	private String canUltModUsuario;

	@Column(name = "can_version")
	@Version
	private Integer canVersion;

	public SgCanton() {
	}

	public Long getCanPk() {
		return canPk;
	}

	public void setCanPk(Long canPk) {
		this.canPk = canPk;
	}

	public Integer getCanMunicipio() {
		return canMunicipio;
	}

	public void setCanMunicipio(Integer canMunicipio) {
		this.canMunicipio = canMunicipio;
	}

	public String getCanCodigo() {
		return canCodigo;
	}

	public void setCanCodigo(String canCodigo) {
		this.canCodigo = canCodigo;
	}

	public Boolean getCanHabilitado() {
		return canHabilitado;
	}

	public void setCanHabilitado(Boolean canHabilitado) {
		this.canHabilitado = canHabilitado;
	}

	public String getCanNombre() {
		return canNombre;
	}

	public void setCanNombre(String canNombre) {
		this.canNombre = canNombre;
	}

	public String getCanNombreBusqueda() {
		return canNombreBusqueda;
	}

	public void setCanNombreBusqueda(String canNombreBusqueda) {
		this.canNombreBusqueda = canNombreBusqueda;
	}

	public LocalDateTime getCanUltModFecha() {
		return canUltModFecha;
	}

	public void setCanUltModFecha(LocalDateTime canUltModFecha) {
		this.canUltModFecha = canUltModFecha;
	}

	public String getCanUltModUsuario() {
		return canUltModUsuario;
	}

	public void setCanUltModUsuario(String canUltModUsuario) {
		this.canUltModUsuario = canUltModUsuario;
	}

	public Integer getCanVersion() {
		return canVersion;
	}

	public void setCanVersion(Integer canVersion) {
		this.canVersion = canVersion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (canPk != null ? canPk.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SgCanton)) {
			return false;
		}
		SgCanton other = (SgCanton) object;
		if ((this.canPk == null && other.canPk != null) || (this.canPk != null && !this.canPk.equals(other.canPk))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SigesCanton{" + "canPk=" + canPk + '}';
	}

}
