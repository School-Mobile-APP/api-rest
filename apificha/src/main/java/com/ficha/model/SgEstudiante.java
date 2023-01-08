package com.ficha.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

@Entity
@Table(name = "sg_estudiantes")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "estPk", scope = SgEstudiante.class)
public class SgEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_pk")
    private Long estPk;

    @Column(name = "est_dis_km_centro")
    private Double estDisKmCentro;

    @Size(max = 255)
    @Column(name = "est_fac_riesgo", length = 255)
    private String estFacRiesgo;

    @Column(name = "est_embarazo")
    private Boolean estEmbarazo;

    @Column(name = "est_medio_transporte_fk")
    private Integer estMedioTransporte;

    @Column(name = "est_dependencia_economica_fk")
    private Integer estDependenciaEconomica;

    @Column(name = "est_habilitado")
    private Boolean estHabilitado;

    @Column(name = "est_realizo_servicio_social")
    private Boolean estRealizoServicioSocial;

    @Column(name = "est_fecha_servicio_social")
    private LocalDate estFechaServicioSocial;

    @Column(name = "est_cantidad_horas_servicio_social")
    private Integer estCantidadHorasServicioSocial;

    @Column(name = "est_descripcion_servicio_social")
    private String estDescripcionServicioSocial;

    @Column(name = "est_ult_mod_fecha")
    private LocalDateTime estUltModFecha;

    @Size(max = 45)
    @Column(name = "est_ult_mod_usuario")
    private String estUltModUsuario;

    @Column(name = "est_version")
    @Version
    private Integer estVersion;

    @Column(name = "est_persona", updatable = false)
    private Integer estPersona;

    //Generada con trigger
    @Column(name = "est_ultima_matricula_fk", insertable = false, updatable = false)
    private Integer estUltimaMatricula;
    
    @Column(name = "est_ultima_encuesta_fk")
    private Long estUltimaEncuesta;

    //Generada con trigger
    @Column(name = "est_ultima_sede_fk", insertable = false, updatable = false)
    private Long estUltimaSedePk;

    //Generada con trigger
    @Column(name = "est_ultima_seccion_fk", insertable = false, updatable = false)
    private Long estUltimaSeccionPk;
    
    @Column(name = "est_sintoniza_canal_10")
    private Boolean estSintonizaCanal10;
    
    @Column(name = "est_sintoniza_franja_educativa")
    private Boolean estSintonizaFranjaEducativa;
    
    //El boolean esDeTramite es true solo cuando el guardado de estudiante se hace desde 
    //registrofichaescolaridad, se utiliza para dejar afuera ciertas validaciones
    @Transient
    private Boolean estEsDeTramite;

    public SgEstudiante() {
        this.estHabilitado = Boolean.TRUE;
        this.estRealizoServicioSocial = Boolean.FALSE;
    }

    public SgEstudiante(Long estPk, Integer estVersion) {
        this.estPk = estPk;
        this.estVersion = estVersion;
    }

    public Long getEstPk() {
        return estPk;
    }

    public void setEstPk(Long estPk) {
        this.estPk = estPk;
    }

    public Double getEstDisKmCentro() {
        return estDisKmCentro;
    }

    public void setEstDisKmCentro(Double estDisKmCentro) {
        this.estDisKmCentro = estDisKmCentro;
    }

    public String getEstFacRiesgo() {
        return estFacRiesgo;
    }

    public void setEstFacRiesgo(String estFacRiesgo) {
        this.estFacRiesgo = estFacRiesgo;
    }

    public Boolean getEstEmbarazo() {
        return estEmbarazo;
    }

    public void setEstEmbarazo(Boolean estEmbarazo) {
        this.estEmbarazo = estEmbarazo;
    }

    public Integer getEstMedioTransporte() {
        return estMedioTransporte;
    }

    public void setEstMedioTransporte(Integer estMedioTransporte) {
        this.estMedioTransporte = estMedioTransporte;
    }

    public Boolean getEstHabilitado() {
        return estHabilitado;
    }

    public void setEstHabilitado(Boolean estHabilitado) {
        this.estHabilitado = estHabilitado;
    }

    public LocalDateTime getEstUltModFecha() {
        return estUltModFecha;
    }

    public void setEstUltModFecha(LocalDateTime estUltModFecha) {
        this.estUltModFecha = estUltModFecha;
    }

    public String getEstUltModUsuario() {
        return estUltModUsuario;
    }

    public void setEstUltModUsuario(String estUltModUsuario) {
        this.estUltModUsuario = estUltModUsuario;
    }

    public Integer getEstVersion() {
        return estVersion;
    }

    public void setEstVersion(Integer estVersion) {
        this.estVersion = estVersion;
    }

    public Integer getEstPersona() {
        return estPersona;
    }

    public void setEstPersona(Integer estPersona) {
        this.estPersona = estPersona;
    }

    public Integer getEstDependenciaEconomica() {
        return estDependenciaEconomica;
    }

    public void setEstDependenciaEconomica(Integer estDependenciaEconomica) {
        this.estDependenciaEconomica = estDependenciaEconomica;
    }


    public Integer getEstUltimaMatricula() {
        return estUltimaMatricula;
    }

    public void setEstUltimaMatricula(Integer estUltimaMatricula) {
        this.estUltimaMatricula = estUltimaMatricula;
    }

    public Long getEstUltimaSedePk() {
        return estUltimaSedePk;
    }

    public void setEstUltimaSedePk(Long estUltimaSedePk) {
        this.estUltimaSedePk = estUltimaSedePk;
    }

    public Long getEstUltimaSeccionPk() {
        return estUltimaSeccionPk;
    }

    public void setEstUltimaSeccionPk(Long estUltimaSeccionPk) {
        this.estUltimaSeccionPk = estUltimaSeccionPk;
    }

    public Boolean getEstRealizoServicioSocial() {
        return estRealizoServicioSocial;
    }

    public void setEstRealizoServicioSocial(Boolean estRealizoServicioSocial) {
        this.estRealizoServicioSocial = estRealizoServicioSocial;
    }

    public LocalDate getEstFechaServicioSocial() {
        return estFechaServicioSocial;
    }

    public void setEstFechaServicioSocial(LocalDate estFechaServicioSocial) {
        this.estFechaServicioSocial = estFechaServicioSocial;
    }

    public Integer getEstCantidadHorasServicioSocial() {
        return estCantidadHorasServicioSocial;
    }

    public void setEstCantidadHorasServicioSocial(Integer estCantidadHorasServicioSocial) {
        this.estCantidadHorasServicioSocial = estCantidadHorasServicioSocial;
    }

    public String getEstDescripcionServicioSocial() {
        return estDescripcionServicioSocial;
    }

    public void setEstDescripcionServicioSocial(String estDescripcionServicioSocial) {
        this.estDescripcionServicioSocial = estDescripcionServicioSocial;
    }

    public Long getEstUltimaEncuesta() {
        return estUltimaEncuesta;
    }

    public void setEstUltimaEncuesta(Long estUltimaEncuesta) {
        this.estUltimaEncuesta = estUltimaEncuesta;
    }

    public Boolean getEstEsDeTramite() {
        return estEsDeTramite;
    }

    public void setEstEsDeTramite(Boolean estEsDeTramite) {
        this.estEsDeTramite = estEsDeTramite;
    }

    public Boolean getEstSintonizaCanal10() {
        return estSintonizaCanal10;
    }

    public void setEstSintonizaCanal10(Boolean estSintonizaCanal10) {
        this.estSintonizaCanal10 = estSintonizaCanal10;
    }

    public Boolean getEstSintonizaFranjaEducativa() {
        return estSintonizaFranjaEducativa;
    }

    public void setEstSintonizaFranjaEducativa(Boolean estSintonizaFranjaEducativa) {
        this.estSintonizaFranjaEducativa = estSintonizaFranjaEducativa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estPk != null ? estPk.hashCode() : 0);
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
        final SgEstudiante other = (SgEstudiante) obj;
        if (!Objects.equals(this.estPk, other.estPk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SgEstudiante[ estPk=" + estPk + " ]";
    }

}
