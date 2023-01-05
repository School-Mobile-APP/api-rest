/*
 *  SIGES
 *  Desarrollado por Sofis Solutions
 */
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
@Table(name = "sg_sexos", uniqueConstraints = {
    @UniqueConstraint(name = "sex_codigo_uk", columnNames = {"sex_codigo"})
    ,
    @UniqueConstraint(name = "sex_nombre_uk", columnNames = {"sex_nombre"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "sexPk", scope = SgSexo.class)
public class SgSexo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sex_pk", nullable = false)
    private Long sexPk;

    @Size(max = 4)
    @Column(name = "sex_codigo", length = 4)
    private String sexCodigo;

    @Size(max = 255)
    @Column(name = "sex_nombre", length = 255)
    private String sexNombre;

    @Size(max = 255)
    @Column(name = "sex_nombre_busqueda", length = 255)
    private String sexNombreBusqueda;

    @Column(name = "sex_habilitado")
    private Boolean sexHabilitado;

    @Column(name = "sex_ult_mod_fecha")
    private LocalDateTime sexUltModFecha;

    @Size(max = 45)
    @Column(name = "sex_ult_mod_usuario", length = 45)
    private String sexUltModUsuario;

    @Column(name = "sex_version")
    @Version
    private Integer sexVersion;

    public SgSexo() {
    }
    public Long getSexPk() {
        return sexPk;
    }

    public void setSexPk(Long sexPk) {
        this.sexPk = sexPk;
    }

    public String getSexCodigo() {
        return sexCodigo;
    }

    public void setSexCodigo(String sexCodigo) {
        this.sexCodigo = sexCodigo;
    }

    public String getSexNombre() {
        return sexNombre;
    }

    public void setSexNombre(String sexNombre) {
        this.sexNombre = sexNombre;
    }

    public String getSexNombreBusqueda() {
        return sexNombreBusqueda;
    }

    public void setSexNombreBusqueda(String sexNombreBusqueda) {
        this.sexNombreBusqueda = sexNombreBusqueda;
    }

    public Boolean getSexHabilitado() {
        return sexHabilitado;
    }

    public void setSexHabilitado(Boolean sexHabilitado) {
        this.sexHabilitado = sexHabilitado;
    }

    public LocalDateTime getSexUltModFecha() {
        return sexUltModFecha;
    }

    public void setSexUltModFecha(LocalDateTime sexUltModFecha) {
        this.sexUltModFecha = sexUltModFecha;
    }

    public String getSexUltModUsuario() {
        return sexUltModUsuario;
    }

    public void setSexUltModUsuario(String sexUltModUsuario) {
        this.sexUltModUsuario = sexUltModUsuario;
    }

    public Integer getSexVersion() {
        return sexVersion;
    }

    public void setSexVersion(Integer sexVersion) {
        this.sexVersion = sexVersion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.sexPk);
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
        final SgSexo other = (SgSexo) obj;
        if (!Objects.equals(this.sexPk, other.sexPk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SigesSexo[ sexPk=" + sexPk + " ]";
    }

}
