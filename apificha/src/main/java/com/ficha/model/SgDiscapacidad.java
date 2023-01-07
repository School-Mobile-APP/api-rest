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
@Table(name = "sg_discapacidades", uniqueConstraints = {
    @UniqueConstraint(name = "dis_codigo_uk", columnNames = {"dis_codigo"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "disPk", scope = SgDiscapacidad.class)
public class SgDiscapacidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dis_pk")
    private Long disPk;

    @Size(max = 4)
    @Column(name = "dis_codigo", length = 4)
    private String disCodigo;

    @Size(max = 255)
    @Column(name = "dis_nombre", length = 255)
    private String disNombre;

    @Size(max = 255)
    @Column(name = "dis_nombre_busqueda", length = 255)
    private String disNombreBusqueda;

    @Size(max = 255)
    @Column(name = "dis_descripcion", length = 255)
    private String disDescripcion;
            
    @Size(max = 255)
    @Column(name = "dis_clasificacion", length = 255)
    private String disClasificacion;

    @Column(name = "dis_habilitado")
    private Boolean disHabilitado;

    @Column(name = "dis_ult_mod_fecha")
    private LocalDateTime disUltModFecha;

    @Size(max = 45)
    @Column(name = "dis_ult_mod_usuario", length = 45)
    private String disUltModUsuario;

    @Column(name = "dis_version")
    @Version
    private Integer disVersion;

    public SgDiscapacidad() {
    }

    public String getDisNombreBusqueda() {
        return disNombreBusqueda;
    }

    public void setDisNombreBusqueda(String disNombreBusqueda) {
        this.disNombreBusqueda = disNombreBusqueda;
    }

    public Long getDisPk() {
        return disPk;
    }

    public void setDisPk(Long disPk) {
        this.disPk = disPk;
    }

    public String getDisCodigo() {
        return disCodigo;
    }

    public void setDisCodigo(String disCodigo) {
        this.disCodigo = disCodigo;
    }

    public String getDisNombre() {
        return disNombre;
    }

    public void setDisNombre(String disNombre) {
        this.disNombre = disNombre;
    }

    public String getDisDescripcion() {
        return disDescripcion;
    }

    public void setDisDescripcion(String disDescripcion) {
        this.disDescripcion = disDescripcion;
    }

    public String getDisClasificacion() {
        return disClasificacion;
    }

    public void setDisClasificacion(String disClasificacion) {
        this.disClasificacion = disClasificacion;
    }

    public Boolean getDisHabilitado() {
        return disHabilitado;
    }

    public void setDisHabilitado(Boolean disHabilitado) {
        this.disHabilitado = disHabilitado;
    }

    public LocalDateTime getDisUltModFecha() {
        return disUltModFecha;
    }

    public void setDisUltModFecha(LocalDateTime disUltModFecha) {
        this.disUltModFecha = disUltModFecha;
    }

    public String getDisUltModUsuario() {
        return disUltModUsuario;
    }

    public void setDisUltModUsuario(String disUltModUsuario) {
        this.disUltModUsuario = disUltModUsuario;
    }

    public Integer getDisVersion() {
        return disVersion;
    }

    public void setDisVersion(Integer disVersion) {
        this.disVersion = disVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disPk != null ? disPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgDiscapacidad)) {
            return false;
        }
        SgDiscapacidad other = (SgDiscapacidad) object;
        if ((this.disPk == null && other.disPk != null) || (this.disPk != null && !this.disPk.equals(other.disPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SigesDiscapacidad[ disPk=" + disPk + " ]";
    }

}
