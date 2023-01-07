package com.ficha.model;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "sg_referencias_apoyo", uniqueConstraints = {
    @UniqueConstraint(name = "rea_codigo_uk", columnNames = {"rea_codigo"}),
    @UniqueConstraint(name = "rea_nombre_uk", columnNames = {"rea_nombre"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "reaPk", scope = SgReferenciasApoyo.class)

public class SgReferenciasApoyo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rea_pk", nullable = false)
    private Long reaPk;

    @Size(max = 45)
    @Column(name = "rea_codigo", length = 45)
    private String reaCodigo;

    @Size(max = 255)
    @Column(name = "rea_nombre", length = 255)
    private String reaNombre;

    @Size(max = 255)
    @Column(name = "rea_nombre_busqueda", length = 255)
    private String reaNombreBusqueda;

    @Column(name = "rea_habilitado")
    private Boolean reaHabilitado;

    @Column(name = "rea_ult_mod_fecha")
    private LocalDateTime reaUltModFecha;

    @Size(max = 45)
    @Column(name = "rea_ult_mod_usuario", length = 45)
    private String reaUltModUsuario;

    @Column(name = "rea_version")
    @Version
    private Integer reaVersion;

    public SgReferenciasApoyo() {
    }

    public Long getReaPk() {
        return reaPk;
    }

    public void setReaPk(Long reaPk) {
        this.reaPk = reaPk;
    }

    public String getReaCodigo() {
        return reaCodigo;
    }

    public void setReaCodigo(String reaCodigo) {
        this.reaCodigo = reaCodigo;
    }

    public String getReaNombre() {
        return reaNombre;
    }

    public void setReaNombre(String reaNombre) {
        this.reaNombre = reaNombre;
    }

    public String getReaNombreBusqueda() {
        return reaNombreBusqueda;
    }

    public void setReaNombreBusqueda(String reaNombreBusqueda) {
        this.reaNombreBusqueda = reaNombreBusqueda;
    }

    public Boolean getReaHabilitado() {
        return reaHabilitado;
    }

    public void setReaHabilitado(Boolean reaHabilitado) {
        this.reaHabilitado = reaHabilitado;
    }

    public LocalDateTime getReaUltModFecha() {
        return reaUltModFecha;
    }

    public void setReaUltModFecha(LocalDateTime reaUltModFecha) {
        this.reaUltModFecha = reaUltModFecha;
    }

    public String getReaUltModUsuario() {
        return reaUltModUsuario;
    }

    public void setReaUltModUsuario(String reaUltModUsuario) {
        this.reaUltModUsuario = reaUltModUsuario;
    }

    public Integer getReaVersion() {
        return reaVersion;
    }

    public void setReaVersion(Integer reaVersion) {
        this.reaVersion = reaVersion;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.reaPk);
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
        final SgReferenciasApoyo other = (SgReferenciasApoyo) obj;
        if (!Objects.equals(this.reaPk, other.reaPk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SgReferenciasApoyo{" + "reaPk=" + reaPk + ", reaCodigo=" + reaCodigo + ", reaNombre=" + reaNombre + ", reaNombreBusqueda=" + reaNombreBusqueda + ", reaHabilitado=" + reaHabilitado + ", reaUltModFecha=" + reaUltModFecha + ", reaUltModUsuario=" + reaUltModUsuario + ", reaVersion=" + reaVersion + '}';
    }
    
    

}
