package com.ficha.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sg_tipos_trabajo", uniqueConstraints = {
    @UniqueConstraint(name = "ttr_codigo_uk", columnNames = {"ttr_codigo"})
    ,
    @UniqueConstraint(name = "ttr_nombre_uk", columnNames = {"ttr_nombre"})})

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ttrPk", scope = SgTipoTrabajo.class)
public class SgTipoTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ttr_pk")
    private Long ttrPk;

    @Size(max = 4)
    @Column(name = "ttr_codigo", length = 4)
    private String ttrCodigo;

    @Size(max = 255)
    @Column(name = "ttr_nombre", length = 255)
    private String ttrNombre;

    @Size(max = 255)
    @Column(name = "ttr_nombre_busqueda", length = 255)
    private String ttrNombreBusqueda;

    @Column(name = "ttr_habilitado")
    private Boolean ttrHabilitado;

    @Column(name = "ttr_ult_mod_fecha")
    private LocalDateTime ttrUltModFecha;

    @Size(max = 45)
    @Column(name = "ttr_ult_mod_usuario", length = 45)
    private String ttrUltModUsuario;

    @Column(name = "ttr_version")
    @Version
    private Integer ttrVersion;

    public SgTipoTrabajo() {
    }

    public String getTtrNombreBusqueda() {
        return ttrNombreBusqueda;
    }

    public void setTtrNombreBusqueda(String ttrNombreBusqueda) {
        this.ttrNombreBusqueda = ttrNombreBusqueda;
    }

    public Long getTtrPk() {
        return ttrPk;
    }

    public void setTtrPk(Long ttrPk) {
        this.ttrPk = ttrPk;
    }

    public String getTtrCodigo() {
        return ttrCodigo;
    }

    public void setTtrCodigo(String ttrCodigo) {
        this.ttrCodigo = ttrCodigo;
    }

    public String getTtrNombre() {
        return ttrNombre;
    }

    public void setTtrNombre(String ttrNombre) {
        this.ttrNombre = ttrNombre;
    }

    public Boolean getTtrHabilitado() {
        return ttrHabilitado;
    }

    public void setTtrHabilitado(Boolean ttrHabilitado) {
        this.ttrHabilitado = ttrHabilitado;
    }

    public LocalDateTime getTtrUltModFecha() {
        return ttrUltModFecha;
    }

    public void setTtrUltModFecha(LocalDateTime ttrUltModFecha) {
        this.ttrUltModFecha = ttrUltModFecha;
    }

    public String getTtrUltModUsuario() {
        return ttrUltModUsuario;
    }

    public void setTtrUltModUsuario(String ttrUltModUsuario) {
        this.ttrUltModUsuario = ttrUltModUsuario;
    }

    public Integer getTtrVersion() {
        return ttrVersion;
    }

    public void setTtrVersion(Integer ttrVersion) {
        this.ttrVersion = ttrVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ttrPk != null ? ttrPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgTipoTrabajo)) {
            return false;
        }
        SgTipoTrabajo other = (SgTipoTrabajo) object;
        if ((this.ttrPk == null && other.ttrPk != null) || (this.ttrPk != null && !this.ttrPk.equals(other.ttrPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SigesTipoTrabajo[ ttrPk=" + ttrPk + " ]";
    }

}
