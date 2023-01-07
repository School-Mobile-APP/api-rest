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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import com.ficha.model.*;
@Entity
@Table(name = "sg_personas_discapacidades", uniqueConstraints = {
    @UniqueConstraint(name = "per_dis_codigo_uk", columnNames = {"per_dis_codigo"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "perdisPk", scope = SgPersonaDiscapacidad.class)
public class SgPersonaDiscapacidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "per_dis_pk")
    private Long perdisPk;
    
    @JoinColumn(name = "esc_discapacidad", referencedColumnName = "dis_pk")
    @ManyToOne
    private SgDiscapacidad escDispacacidad;


    public SgPersonaDiscapacidad() {
    }
    
    public Long getPerDisPk() {
        return perdisPk;
    }

    public void setPerDisPk(Long perdisPk) {
        this.perdisPk = perdisPk;
    }


    public String getDis() {
        return escDispacacidad;
    }

    public void setDis(String disPk) {
        this.escDispacacidad = disPk;
    }


    @Override
    public String toString() {
        return "sv.gob.mined.siges.persistencia.entidades.SgProfesion[ proPk=" + perdisPk + " ]";
    }

}