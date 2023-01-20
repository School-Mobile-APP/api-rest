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
@Table(name="sg_canales_atencion")
public class SgCanalesAtencion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "can_pk", nullable = false)
    private Long canPk;
	
    @Size(max = 4)
    @Column(name = "can_codigo", length = 4)
    private String canCodigo;
    
    @Size(max = 255)
    @Column(name = "can_nombre", length = 255)
    private String canNombre;

    @Size(max = 255)
    @Column(name = "can_nombre_busqueda", length = 255)
    private String canNombreBusqueda;

    @Column(name = "can_habilitado")
    private Boolean canHabilitado;

    @Column(name = "can_ult_mod_fecha")
    private LocalDateTime canUltModFecha;

    @Size(max = 45)
    @Column(name = "can_ult_mod_usuario", length = 45)
    private String canUltModUsuario;

    @Column(name = "can_version")
    @Version
    private Integer canVersion;

	public Long getCanPk() {
		return canPk;
	}

	public void setCanPk(Long canPk) {
		this.canPk = canPk;
	}

	public String getCanCodigo() {
		return canCodigo;
	}

	public void setCanCodigo(String canCodigo) {
		this.canCodigo = canCodigo;
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

	public Boolean getCanHabilitado() {
		return canHabilitado;
	}

	public void setCanHabilitado(Boolean canHabilitado) {
		this.canHabilitado = canHabilitado;
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

}
