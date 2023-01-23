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
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sg_tipo_vivienda",schema="catalogo", uniqueConstraints = {
    @UniqueConstraint(name = "tiv_codigo_uk", columnNames = {"tiv_codigo"})
    ,
    @UniqueConstraint(name = "tiv_nombre_uk", columnNames = {"tiv_nombre"})})


public class SgTipoVivienda implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tiv_pk")
    private Long tivPk;
    
    @Size(max = 4)
    @Column(name = "tiv_codigo", length = 4)
    private String tivCodigo;

    @Size(max = 255)
    @Column(name = "tiv_nombre", length = 255)
    private String tivNombre;
    
    @Size(max = 255)
    @Column(name = "tiv_nombre_busqueda", length = 255)
    private String tivNombreBusqueda;

    @Column(name = "tiv_habilitado")
    private Boolean tivHabilitado;
    
    @Column(name = "tiv_ult_mod_fecha")
    private LocalDateTime tivUltModFecha;

    @Size(max = 45)
    @Column(name = "tiv_ult_mod_usuario", length = 45)
    private String tivUltModUsuario;

    @Column(name = "tiv_version")
    @Version
    private Integer tivVersion;

	public Long getTivPk() {
		return tivPk;
	}

	public void setTivPk(Long tivPk) {
		this.tivPk = tivPk;
	}

	public String getTivCodigo() {
		return tivCodigo;
	}

	public void setTivCodigo(String tivCodigo) {
		this.tivCodigo = tivCodigo;
	}

	public String getTivNombre() {
		return tivNombre;
	}

	public void setTivNombre(String tivNombre) {
		this.tivNombre = tivNombre;
	}

	public String getTivNombreBusqueda() {
		return tivNombreBusqueda;
	}

	public void setTivNombreBusqueda(String tivNombreBusqueda) {
		this.tivNombreBusqueda = tivNombreBusqueda;
	}

	public Boolean getTivHabilitado() {
		return tivHabilitado;
	}

	public void setTivHabilitado(Boolean tivHabilitado) {
		this.tivHabilitado = tivHabilitado;
	}

	public LocalDateTime getTivUltModFecha() {
		return tivUltModFecha;
	}

	public void setTivUltModFecha(LocalDateTime tivUltModFecha) {
		this.tivUltModFecha = tivUltModFecha;
	}

	public String getTivUltModUsuario() {
		return tivUltModUsuario;
	}

	public void setTivUltModUsuario(String tivUltModUsuario) {
		this.tivUltModUsuario = tivUltModUsuario;
	}

	public Integer getTivVersion() {
		return tivVersion;
	}

	public void setTivVersion(Integer tivVersion) {
		this.tivVersion = tivVersion;
	}
}
