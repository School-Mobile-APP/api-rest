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
@Table(name = "sg_convivencia_familiar")
public class SgConvivenciaFamiliar implements Serializable{
	private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "cof_pk", nullable = false)
	    private Long cofPk;

	    @Size(max = 4)
	    @Column(name = "cof_codigo", length = 4)
	    private String cofCodigo;
	    
	    @Column(name = "cof_habilitado")
	    private Boolean cofHabilitado;
	    @Size(max = 255)
	    @Column(name = "cof_nombre", length = 255)
	    private String cofNombre;

	    @Size(max = 255)
	    @Column(name = "cof_nombre_busqueda", length = 255)
	    private String cofNombreBusqueda;

	    @Column(name = "cof_ult_mod_fecha")
	    private LocalDateTime cofUltModFecha;

	    @Size(max = 45)
	    @Column(name = "cof_ult_mod_usuario", length = 45)
	    private String cofUltModUsuario;

	    @Column(name = "cof_version")
	    @Version
	    private Integer cofVersion;

		public Long getCofPk() {
			return cofPk;
		}

		public void setCofPk(Long cofPk) {
			this.cofPk = cofPk;
		}

		public String getCofCodigo() {
			return cofCodigo;
		}

		public void setCofCodigo(String cofCodigo) {
			this.cofCodigo = cofCodigo;
		}

		public Boolean getCofHabilitado() {
			return cofHabilitado;
		}

		public void setCofHabilitado(Boolean cofHabilitado) {
			this.cofHabilitado = cofHabilitado;
		}

		public String getCofNombre() {
			return cofNombre;
		}

		public void setCofNombre(String cofNombre) {
			this.cofNombre = cofNombre;
		}

		public String getCofNombreBusqueda() {
			return cofNombreBusqueda;
		}

		public void setCofNombreBusqueda(String cofNombreBusqueda) {
			this.cofNombreBusqueda = cofNombreBusqueda;
		}

		public LocalDateTime getCofUltModFecha() {
			return cofUltModFecha;
		}

		public void setCofUltModFecha(LocalDateTime cofUltModFecha) {
			this.cofUltModFecha = cofUltModFecha;
		}

		public String getCofUltModUsuario() {
			return cofUltModUsuario;
		}

		public void setCofUltModUsuario(String cofUltModUsuario) {
			this.cofUltModUsuario = cofUltModUsuario;
		}

		public Integer getCofVersion() {
			return cofVersion;
		}

		public void setCofVersion(Integer cofVersion) {
			this.cofVersion = cofVersion;
		}
}
