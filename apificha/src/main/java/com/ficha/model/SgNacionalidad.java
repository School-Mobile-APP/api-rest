package com.ficha.model;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import java.util.Objects;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;
import javax.validation.constraints.Size;
@Entity
@Table(name = "sg_nacionalidades", uniqueConstraints = {
    @UniqueConstraint(name = "nac_codigo_uk", columnNames = {"nac_codigo"})
    ,
    @UniqueConstraint(name = "nac_nombre_uk", columnNames = {"nac_nombre"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "nacPk", scope = SgNacionalidad.class)
public class SgNacionalidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nac_pk", nullable = false)
    private Long nacPk;

    @Size(max = 45)
    @Column(name = "nac_codigo", length = 45)
    private String nacCodigo;

    @Size(max = 255)
    @Column(name = "nac_nombre", length = 255)
    private String nacNombre;

    @Size(max = 255)
    @Column(name = "nac_nombre_busqueda", length = 255)
    private String nacNombreBusqueda;

    @Column(name = "nac_habilitado")
    private Boolean nacHabilitado;

    @Column(name = "nac_ult_mod_fecha")
    private LocalDateTime nacUltModFecha;

    @Size(max = 45)
    @Column(name = "nac_ult_mod_usuario", length = 45)
    private String nacUltModUsuario;

    @Column(name = "nac_version")
    @Version
    private Integer nacVersion;

    public SgNacionalidad() {
    }

    public Long getNacPk() {
        return nacPk;
    }

    public void setNacPk(Long nacPk) {
        this.nacPk = nacPk;
    }

    public String getNacCodigo() {
        return nacCodigo;
    }

    public void setNacCodigo(String nacCodigo) {
        this.nacCodigo = nacCodigo;
    }

    public String getNacNombre() {
        return nacNombre;
    }

    public void setNacNombre(String nacNombre) {
        this.nacNombre = nacNombre;
    }

    public String getNacNombreBusqueda() {
        return nacNombreBusqueda;
    }

    public void setNacNombreBusqueda(String nacNombreBusqueda) {
        this.nacNombreBusqueda = nacNombreBusqueda;
    }

    public Boolean getNacHabilitado() {
        return nacHabilitado;
    }

    public void setNacHabilitado(Boolean nacHabilitado) {
        this.nacHabilitado = nacHabilitado;
    }

    public LocalDateTime getNacUltModFecha() {
        return nacUltModFecha;
    }

    public void setNacUltModFecha(LocalDateTime nacUltModFecha) {
        this.nacUltModFecha = nacUltModFecha;
    }

    public String getNacUltModUsuario() {
        return nacUltModUsuario;
    }

    public void setNacUltModUsuario(String nacUltModUsuario) {
        this.nacUltModUsuario = nacUltModUsuario;
    }

    public Integer getNacVersion() {
        return nacVersion;
    }

    public void setNacVersion(Integer nacVersion) {
        this.nacVersion = nacVersion;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.nacPk);
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
        final SgNacionalidad other = (SgNacionalidad) obj;
        if (!Objects.equals(this.nacPk, other.nacPk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SgNacionalidad{" + "nacPk=" + nacPk + ", nacCodigo=" + nacCodigo + ", nacNombre=" + nacNombre + ", nacNombreBusqueda=" + nacNombreBusqueda + ", nacHabilitado=" + nacHabilitado + ", nacUltModFecha=" + nacUltModFecha + ", nacUltModUsuario=" + nacUltModUsuario + ", nacVersion=" + nacVersion + '}';
    }
    
}