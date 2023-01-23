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
@Table(name="sg_multi_modalidades",schema="catalogo")
public class SgMultiModalidad implements Serializable{
	  private static final long serialVersionUID = 1L;
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "mul_pk", nullable = false)
	    private Long mulPk;
		
	    @Size(max = 4)
	    @Column(name = "mul_codigo", length = 4)
	    private String mulCodigo;
	    
	    @Size(max = 255)
	    @Column(name = "mul_nombre", length = 255)
	    private String mulNombre;

	    @Size(max = 255)
	    @Column(name = "mul_nombre_busqueda", length = 255)
	    private String mulNombreBusqueda;

	    @Column(name = "mul_habilitado")
	    private Boolean mulHabilitado;

	    @Column(name = "mul_ult_mod_fecha")
	    private LocalDateTime mulUltModFecha;

	    @Size(max = 45)
	    @Column(name = "mul_ult_mod_usuario", length = 45)
	    private String mulUltModUsuario;

	    @Column(name = "mul_version")
	    @Version
	    private Integer mulVersion;

		public Long getMulPk() {
			return mulPk;
		}

		public void setMulPk(Long mulPk) {
			this.mulPk = mulPk;
		}

		public String getMulCodigo() {
			return mulCodigo;
		}

		public void setMulCodigo(String mulCodigo) {
			this.mulCodigo = mulCodigo;
		}

		public String getMulNombre() {
			return mulNombre;
		}

		public void setMulNombre(String mulNombre) {
			this.mulNombre = mulNombre;
		}

		public String getMulNombreBusqueda() {
			return mulNombreBusqueda;
		}

		public void setMulNombreBusqueda(String mulNombreBusqueda) {
			this.mulNombreBusqueda = mulNombreBusqueda;
		}

		public Boolean getMulHabilitado() {
			return mulHabilitado;
		}

		public void setMulHabilitado(Boolean mulHabilitado) {
			this.mulHabilitado = mulHabilitado;
		}

		public LocalDateTime getMulUltModFecha() {
			return mulUltModFecha;
		}

		public void setMulUltModFecha(LocalDateTime mulUltModFecha) {
			this.mulUltModFecha = mulUltModFecha;
		}

		public String getMulUltModUsuario() {
			return mulUltModUsuario;
		}

		public void setMulUltModUsuario(String mulUltModUsuario) {
			this.mulUltModUsuario = mulUltModUsuario;
		}

		public Integer getMulVersion() {
			return mulVersion;
		}

		public void setMulVersion(Integer mulVersion) {
			this.mulVersion = mulVersion;
		}

}
