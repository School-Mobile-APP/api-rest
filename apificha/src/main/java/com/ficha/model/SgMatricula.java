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
import javax.validation.constraints.Size;

@Entity
@Table(name = "sg_matriculas", uniqueConstraints = {
    @UniqueConstraint(name = "sg_matriculas_pkey", columnNames = {"mat_pk"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "matPk", scope = SgMatricula.class)
public class SgMatricula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mat_pk")
    private Long matPk;
    
    @Column(name = "mat_seccion_fk")
    private Integer matSeccion;
    
    @Size(max = 50)
    @Column(name = "mat_estado", length = 50)
    private String matEstado;


    public SgMatricula() {
    }

    public String getMatEstado() {
        return matEstado;
    }

    public void setMatEstado(String disNombreBusqueda) {
        this.matEstado = disNombreBusqueda;
    }

    public Long getMatPk() {
        return matPk;
    }
    public void setMatSeccion(Integer seccion) {
    	this.matSeccion=seccion;
    }
    public Integer getMatSeccion() {
    	return matSeccion;
    }
    public void setMatPk(Long disPk) {
        this.matPk = disPk;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matPk != null ? matPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgMatricula)) {
            return false;
        }
        SgMatricula other = (SgMatricula) object;
        if ((this.matPk == null && other.matPk != null) || (this.matPk != null && !this.matPk.equals(other.matPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SigesMatricula[ matPk=" + matPk + " ]";
    }

}
