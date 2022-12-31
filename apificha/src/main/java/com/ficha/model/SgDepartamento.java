package com.ficha.model;
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
import java.util.List;
import java.util.Objects;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sg_departamentos", uniqueConstraints = {
		@UniqueConstraint(name = "dep_codigo_uk", columnNames = { "dep_codigo" }),
		@UniqueConstraint(name = "dep_nombre_uk", columnNames = { "dep_nombre" }) })
public class SgDepartamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "dep_pk", nullable = false)
	private Long depPk;

	@OneToMany(mappedBy = "munDepartamento", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SgMunicipio> depMunicipios;

	@Size(max = 4)
	@Column(name = "dep_codigo", length = 4)
	private String depCodigo;

	@Size(max = 255)
	@Column(name = "dep_nombre", length = 255)
	private String depNombre;

	@Size(max = 255)
	@Column(name = "dep_nombre_busqueda", length = 255)
	private String depNombreBusqueda;

	@Column(name = "dep_habilitado")
	private Boolean depHabilitado;

	@Column(name = "dep_ult_mod_fecha")
	private LocalDateTime depUltModFecha;

	@Size(max = 45)
	@Column(name = "dep_ult_mod_usuario", length = 45)
	private String depUltModUsuario;

	@Column(name = "dep_version")
	@Version
	private Integer depVersion;

	public SgDepartamento() {
	}

	public Long getDepPk() {
		return depPk;
	}

	public void setDepPk(Long depPk) {
		this.depPk = depPk;
	}

	public String getDepCodigo() {
		return depCodigo;
	}

	public void setDepCodigo(String depCodigo) {
		this.depCodigo = depCodigo;
	}

	public String getDepNombre() {
		return depNombre;
	}

	public void setDepNombre(String depNombre) {
		this.depNombre = depNombre;
	}

	public String getDepNombreBusqueda() {
		return depNombreBusqueda;
	}

	public void setDepNombreBusqueda(String depNombreBusqueda) {
		this.depNombreBusqueda = depNombreBusqueda;
	}

	public Boolean getDepHabilitado() {
		return depHabilitado;
	}

	public void setDepHabilitado(Boolean depHabilitado) {
		this.depHabilitado = depHabilitado;
	}

	public LocalDateTime getDepUltModFecha() {
		return depUltModFecha;
	}

	public void setDepUltModFecha(LocalDateTime depUltModFecha) {
		this.depUltModFecha = depUltModFecha;
	}

	public String getDepUltModUsuario() {
		return depUltModUsuario;
	}

	public void setDepUltModUsuario(String depUltModUsuario) {
		this.depUltModUsuario = depUltModUsuario;
	}

	public Integer getDepVersion() {
		return depVersion;
	}

	public void setDepVersion(Integer depVersion) {
		this.depVersion = depVersion;
	}

	public List<SgMunicipio> getDepMunicipios() {
		return depMunicipios;
	}

	public void setDepMunicipios(List<SgMunicipio> depMunicipios) {
		this.depMunicipios = depMunicipios;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 11 * hash + Objects.hashCode(this.depPk);
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
		final SgDepartamento other = (SgDepartamento) obj;
		if (!Objects.equals(this.depPk, other.depPk)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SigesDepartamento{" + "depPk=" + depPk + '}';
	}

	public SgDepartamento(Long depPk) {
		this.depPk = depPk;
	}
}
