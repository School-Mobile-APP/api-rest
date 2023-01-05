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
@Table(name = "sg_profesiones", uniqueConstraints = {
    @UniqueConstraint(name = "pro_codigo_uk", columnNames = {"pro_codigo"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "proPk", scope = SgProfesion.class)
public class SgProfesion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pro_pk")
    private Long proPk;

    @Size(max = 4)
    @Column(name = "pro_codigo", length = 4)
    private String proCodigo;

    @Size(max = 255)
    @Column(name = "pro_nombre", length = 255)
    private String proNombre;

    @Size(max = 255)
    @Column(name = "pro_nombre_busqueda", length = 255)
    private String proNombreBusqueda;

    @Column(name = "pro_habilitado")
    private Boolean proHabilitado;

    @Column(name = "pro_ult_mod_fecha")
    private LocalDateTime proUltModFecha;

    @Size(max = 45)
    @Column(name = "pro_ult_mod_usuario", length = 45)
    private String proUltModUsuario;

    @Column(name = "pro_version")
    @Version
    private Integer proVersion;

    public SgProfesion() {
    }
    public Long getProPk() {
        return proPk;
    }

    public void setProPk(Long proPk) {
        this.proPk = proPk;
    }

    public String getProCodigo() {
        return proCodigo;
    }

    public void setProCodigo(String proCodigo) {
        this.proCodigo = proCodigo;
    }

    public String getProNombre() {
        return proNombre;
    }

    public void setProNombre(String proNombre) {
        this.proNombre = proNombre;
    }

    public String getProNombreBusqueda() {
        return proNombreBusqueda;
    }

    public void setProNombreBusqueda(String proNombreBusqueda) {
        this.proNombreBusqueda = proNombreBusqueda;
    }

    public Boolean getProHabilitado() {
        return proHabilitado;
    }

    public void setProHabilitado(Boolean proHabilitado) {
        this.proHabilitado = proHabilitado;
    }

    public LocalDateTime getProUltModFecha() {
        return proUltModFecha;
    }

    public void setProUltModFecha(LocalDateTime proUltModFecha) {
        this.proUltModFecha = proUltModFecha;
    }

    public String getProUltModUsuario() {
        return proUltModUsuario;
    }

    public void setProUltModUsuario(String proUltModUsuario) {
        this.proUltModUsuario = proUltModUsuario;
    }

    public Integer getProVersion() {
        return proVersion;
    }

    public void setProVersion(Integer proVersion) {
        this.proVersion = proVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proPk != null ? proPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgProfesion)) {
            return false;
        }
        SgProfesion other = (SgProfesion) object;
        if ((this.proPk == null && other.proPk != null) || (this.proPk != null && !this.proPk.equals(other.proPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SgProfesion[ proPk=" + proPk + " ]";
    }

}
