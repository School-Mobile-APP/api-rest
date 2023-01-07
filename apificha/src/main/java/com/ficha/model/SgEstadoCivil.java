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
import java.util.Objects;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sg_estados_civil", uniqueConstraints = {
    @UniqueConstraint(name = "eci_codigo_uk", columnNames = {"eci_codigo"})
    ,
    @UniqueConstraint(name = "eci_nombre_uk", columnNames = {"eci_nombre"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "eciPk", scope = SgEstadoCivil.class)
public class SgEstadoCivil implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "eci_pk", nullable = false)
    private Long eciPk;

    @Size(max = 4)
    @Column(name = "eci_codigo", length = 4)
    private String eciCodigo;

    @Size(max = 255)
    @Column(name = "eci_nombre", length = 255)
    private String eciNombre;

    @Size(max = 255)
    @Column(name = "eci_nombre_busqueda", length = 255)
    private String eciNombreBusqueda;

    @Column(name = "eci_habilitado")
    private Boolean eciHabilitado;

    @Column(name = "eci_ult_mod_fecha")
    private LocalDateTime eciUltModFecha;

    @Size(max = 45)
    @Column(name = "eci_ult_mod_usuario", length = 45)
    private String eciUltModUsuario;

    @Column(name = "eci_version")
    @Version
    private Integer eciVersion;

    public SgEstadoCivil() {
    }

    public Long getEciPk() {
        return eciPk;
    }

    public void setEciPk(Long eciPk) {
        this.eciPk = eciPk;
    }

    public String getEciCodigo() {
        return eciCodigo;
    }

    public void setEciCodigo(String eciCodigo) {
        this.eciCodigo = eciCodigo;
    }

    public String getEciNombre() {
        return eciNombre;
    }

    public void setEciNombre(String eciNombre) {
        this.eciNombre = eciNombre;
    }

    public String getEciNombreBusqueda() {
        return eciNombreBusqueda;
    }

    public void setEciNombreBusqueda(String eciNombreBusqueda) {
        this.eciNombreBusqueda = eciNombreBusqueda;
    }

    public Boolean getEciHabilitado() {
        return eciHabilitado;
    }

    public void setEciHabilitado(Boolean eciHabilitado) {
        this.eciHabilitado = eciHabilitado;
    }

    public LocalDateTime getEciUltModFecha() {
        return eciUltModFecha;
    }

    public void setEciUltModFecha(LocalDateTime eciUltModFecha) {
        this.eciUltModFecha = eciUltModFecha;
    }

    public String getEciUltModUsuario() {
        return eciUltModUsuario;
    }

    public void setEciUltModUsuario(String eciUltModUsuario) {
        this.eciUltModUsuario = eciUltModUsuario;
    }

    public Integer getEciVersion() {
        return eciVersion;
    }

    public void setEciVersion(Integer eciVersion) {
        this.eciVersion = eciVersion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.eciPk);
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
        final SgEstadoCivil other = (SgEstadoCivil) obj;
        if (!Objects.equals(this.eciPk, other.eciPk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SigesEstadoCivil[ eciPk=" + eciPk + " ]";
    }

}